package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Micro;
import logico.Motherboard;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class FacturarComplejo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private JComboBox comboBox;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCancelar;
	private String tipo;
	private Componente selected = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FacturarComplejo dialog = new FacturarComplejo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("rawtypes")
	public FacturarComplejo() {
		setBounds(100, 100, 852, 503);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
			{
				JLabel lblTipoDeQueso = new JLabel("Tipo de Componente:");
				lblTipoDeQueso.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblTipoDeQueso);
			}
			{
				comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						load(comboBox.getSelectedIndex());
						
					}
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "MotherBoards", "Microprocesadores", "Memorias RAM", "Discos Duros"}));
				panel.add(comboBox);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(1, 1, 840, 361);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					String[] headers = {"Numero de serie","Marca","Modelo", "Cantidad", "Precio", "Tipo de Componente"};
					
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int ind = table.getSelectedRow();
							if (ind >= 0 ) {
								btnDelete.setEnabled(true);
								btnUpdate.setEnabled(true);
								String codigo = table.getValueAt(ind, 0).toString();
								 selected = Tienda.getInstance().ComponenteByCodigo(codigo);
							}
						}
					});
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);

				}
			}
		}
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDelete = new JButton("Eliminar");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected != null) {
							int option = JOptionPane.showConfirmDialog(null,
									"Estas seguro de querer eliminar el Companente",
									"Eliminar Componente", JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								Tienda.getInstance().eliminarComponente(selected);
								load(0);
							}
						}
					}
				});
				buttonPane.add(btnDelete);
			}
			
			{
				btnUpdate = new JButton("Modificar");
				btnUpdate.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ModificarComponente list = new ModificarComponente(selected);
						list.setModal(true);
						list.setVisible(true);
					}
				});
				
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		load(0);
	}

	public static void load(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				
				rows[0] = aux.getNumSerie();
				rows[1] = aux.getMarca();
				rows[2] = aux.getModelo();
				rows[3] = aux.getStock();
				rows[4] = aux.getPrecio();
				if(aux instanceof DiscoDuro ){
					rows[3] = "Disco Duro";	
				}
				if(aux instanceof MemoriaRam){
					rows[3] = "Memoria Ram";	
				}
				if(aux instanceof Micro ){
					rows[3] = "Microprocesador";
				}
				if(aux instanceof Motherboard ){
					rows[3] = "MotherBoard";
				}
				model.addRow(rows);
			  
			}
		}
		
		if(index == 1){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof Motherboard){
					rows[0] = aux.getNumSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getModelo();
					rows[3] = aux.getStock();
					rows[4] = aux.getPrecio();
					rows[5] = "MotherBoard";	
					model.addRow(rows);
				}
			}	
		}
		if(index == 2){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof Micro){
					rows[0] = aux.getNumSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getModelo();
					rows[3] = aux.getStock();
					rows[4] = aux.getPrecio();
					rows[5] = "Miroprocesador";	
					model.addRow(rows);
				}
			}	
		}
		if(index==3){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof MemoriaRam){
					rows[0] = aux.getNumSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getModelo();
					rows[3] = aux.getStock();
					rows[4] = aux.getPrecio();
					rows[5] = "Memoria Ram";	
					model.addRow(rows);
				}
			}	
		}
		if(index==4){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof DiscoDuro){
					rows[0] = aux.getNumSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getModelo();
					rows[3] = aux.getStock();
					rows[4] = aux.getPrecio();
					rows[5] = "Disco Duro";	
					model.addRow(rows);
				}
			}	
		}
	}

}

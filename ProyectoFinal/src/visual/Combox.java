package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Micro;
import logico.Motherboard;
import logico.Tienda;
import java.awt.Font;

public class Combox extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static DefaultTableModel model_1;


	private static Object rows[];
	private JComboBox<String> comboBox;
	private JButton btnCancelar;
	private Componente selected = null;
	private Componente selected_1 = null;
	private JButton btnAgregar;
	private JPanel pnlAgregar;
	private JTextPane textPnlAviso;
	private JSpinner spnAgregar;
	private JPanel pnlRemover;
	private JTextPane txtpnCuntosArtculosDeseas;
	private JSpinner spnRemover;
	private JButton btnCrear;
	private JButton btnRemover;
	private ArrayList <Componente> misComponentes = new ArrayList<Componente>();
	private ArrayList <Componente> temporal = new ArrayList<Componente>();

	private Combo combo= new Combo(misComponentes);
	private JButton btnAceptar;
	private JButton btnAceptar_1;
	private JTable table_1;
	private JSpinner spnTotal;
	private JLabel lblTotal;
	private JSpinner spnSubtotal;
	private JLabel lblSubtotal;
	private JLabel lblConDe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Combox dialog = new Combox();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Combox() {
		setBounds(100, 100, 1118, 682);
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
				comboBox = new JComboBox<String>();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						load(comboBox.getSelectedIndex());
						
					}
				});
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>", "MotherBoards", "Microprocesadores", "Memorias RAM", "Discos Duros"}));
				panel.add(comboBox);
			}
		}
		
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 13, 822, 218);
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
								btnAgregar.setEnabled(true);
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
		
			
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected.getStock() > 0) {
							pnlAgregar.setVisible(true);
							btnAgregar.setVisible(false);
							pnlAgregar.setBounds(296, 211, 229, 172);
							panel.setComponentZOrder(pnlAgregar, 0);
						}
						else {
							JOptionPane.showMessageDialog(null, "Stock Vac�o!!!", "AVISO", JOptionPane.INFORMATION_MESSAGE);

						}
						
					}
				});
				btnAgregar.setEnabled(false);
				btnAgregar.setBounds(286, 234, 97, 25);
				panel.add(btnAgregar);
			}
			{
				pnlAgregar = new JPanel();
				pnlAgregar.setLayout(null);
				pnlAgregar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cantidad...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlAgregar.setBackground(SystemColor.info);
				pnlAgregar.setBounds(834, 36, 229, 172);
				panel.add(pnlAgregar);
				{
					textPnlAviso = new JTextPane();
					textPnlAviso.setText("Cu\u00E1ntos art\u00EDculos deseas a\u00F1adir al combo?\r\n\r\nNo deben exceder la cantidad actual en existencia!");
					textPnlAviso.setEditable(false);
					textPnlAviso.setBackground(SystemColor.info);
					textPnlAviso.setBounds(12, 32, 179, 99);
					pnlAgregar.add(textPnlAviso);
				}
				{
					spnAgregar = new JSpinner();
					spnAgregar.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
					spnAgregar.setBounds(12, 131, 95, 22);
					pnlAgregar.add(spnAgregar);
				}
				
					btnAceptar = new JButton("Aceptar");
					btnAceptar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							int temp = Integer.valueOf((Integer)spnAgregar.getValue());

							if (temp <= selected.getStock()) {
								selected_1 = Tienda.getInstance().copiarComp(selected);
								
								boolean control = existencia(selected_1,temp);
								
								if (!control) {
									combo.getMisComponentes().add(selected_1);
									modCombo(selected_1.getNumSerie(),temp);
								}
		
								selected.setStock(selected.getStock() - temp);
								modTemporal(selected);
								
								pnlAgregar.setVisible(false);
								btnAgregar.setVisible(true);
								
								if (combo.getMisComponentes().size() > 0) {
									load2();
								}
								load(0);
								spnAgregar.setValue(0);
							}
							else {
								JOptionPane.showMessageDialog(null, "Excediste la cantidad existente", "AVISO", JOptionPane.INFORMATION_MESSAGE);

							selected_1 = Tienda.getInstance().copiarComp(selected);
							
							combo.getMisComponentes().add(selected_1);
							
							modCombo(selected_1.getNumSerie(),temp);

							
							pnlAgregar.setVisible(false);
							btnAgregar.setVisible(true);
							if (combo.getMisComponentes().size() > 0) {
								load2();

							}
							clean();
						}
						}
					});
					btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
					btnAceptar.setBounds(129, 143, 88, 22);
					pnlAgregar.add(btnAceptar);
				}
			
			{
				pnlRemover = new JPanel();
				pnlRemover.setLayout(null);
				pnlRemover.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cantidad...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlRemover.setBackground(SystemColor.info);
				pnlRemover.setBounds(834, 247, 229, 172);
				panel.add(pnlRemover);
				{
					txtpnCuntosArtculosDeseas = new JTextPane();
					txtpnCuntosArtculosDeseas.setText("Cu\u00E1ntos art\u00EDculos deseas remover del combo?\r\n\r\nNo deben exceder la cantidad actual en existencia!");
					txtpnCuntosArtculosDeseas.setEditable(false);
					txtpnCuntosArtculosDeseas.setBackground(SystemColor.info);
					txtpnCuntosArtculosDeseas.setBounds(12, 32, 179, 93);
					pnlRemover.add(txtpnCuntosArtculosDeseas);
				}
				{
					spnRemover = new JSpinner();
					spnRemover.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnRemover.setBounds(12, 131, 95, 22);
					pnlRemover.add(spnRemover);
				}
				{
					btnAceptar_1 = new JButton("Aceptar");
					btnAceptar_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					btnAceptar_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
					btnAceptar_1.setEnabled(false);
					btnAceptar_1.setBounds(129, 137, 88, 22);
					pnlRemover.add(btnAceptar_1);
				}
			}
			{
				btnRemover = new JButton("Remover");
				btnRemover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pnlRemover.setVisible(true);
						btnRemover.setVisible(false);
						pnlRemover.setBounds(296, 211, 229, 172);
						panel.setComponentZOrder(pnlRemover, 0);
						
					}
				});
				btnRemover.setEnabled(false);
				btnRemover.setBounds(417, 234, 97, 25);
				panel.add(btnRemover);
			}
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane_1.setBounds(0, 272, 822, 218);
				panel.add(scrollPane_1);
				{
					String[] headers = {"Numero de serie","Marca","Modelo", "Cantidad", "Precio", "Tipo de Componente"};

					table_1 = new JTable();
					table_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int ind = table_1.getSelectedRow();
							if (ind >= 0 ) {
								btnRemover.setEnabled(true);
								btnAgregar.setEnabled(false);
								String codigo = table_1.getValueAt(ind, 0).toString();
								selected_1 = Buscar(codigo);
							}
						}
					});
					table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane_1.setViewportView(table_1);

					model_1 = new DefaultTableModel();
					model_1.setColumnIdentifiers(headers);
					table_1.setModel(model_1);
				}
			}
			{
			{
				spnTotal = new JSpinner();
				spnTotal.setBounds(685, 503, 97, 22);
				panel.add(spnTotal);
			}
			{
				lblTotal = new JLabel("Total:");
				lblTotal.setBounds(647, 506, 56, 16);
				panel.add(lblTotal);
			}
			{
				spnSubtotal = new JSpinner();
				spnSubtotal.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
				spnSubtotal.setBounds(125, 503, 97, 22);
				panel.add(spnSubtotal);
			}
			{
				lblSubtotal = new JLabel("SubTotal:");
				lblSubtotal.setBounds(64, 506, 62, 16);
				panel.add(lblSubtotal);
			}
			{
				lblConDe = new JLabel("Con 10% de DESCUENTO ---------->");
				lblConDe.setHorizontalAlignment(SwingConstants.CENTER);
				lblConDe.setForeground(SystemColor.textHighlight);
				lblConDe.setBackground(SystemColor.info);
				lblConDe.setBounds(336, 506, 229, 16);
				panel.add(lblConDe);
			}
		}
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnCrear = new JButton("Crear");
					btnCrear.setEnabled(false);
					buttonPane.add(btnCrear);
				}
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		try {
			temporal = Tienda.getInstance().copiarArray();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		load(0);
		pnlAgregar.setVisible(false);
		pnlRemover.setVisible(false);
	}

	public void load(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0){
			for (Componente aux : temporal) {
				
				rows[0] = aux.getNumSerie();
				rows[1] = aux.getMarca();
				rows[2] = aux.getModelo();
				rows[3] = aux.getStock();
				rows[4] = aux.getPrecio();
				if(aux instanceof DiscoDuro ){
					rows[5] = "Disco Duro";	
				}
				if(aux instanceof MemoriaRam){
					rows[5] = "Memoria Ram";	
				}
				if(aux instanceof Micro ){
					rows[5] = "Microprocesador";
				}
				if(aux instanceof Motherboard ){
					rows[5] = "MotherBoard";
				}
				model.addRow(rows);
			  
			}
		}
		
		if(index == 1){
			for (Componente aux : temporal) {
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
			for (Componente aux : temporal) {
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
			for (Componente aux : temporal) {
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
			for (Componente aux :temporal) {
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
	
	public void load2(){
		model_1.setRowCount(0);
		rows = new Object[model_1.getColumnCount()];

		for (Componente aux :combo.getMisComponentes()) {

			rows[0] = aux.getNumSerie();
			rows[1] = aux.getMarca();
			rows[2] = aux.getModelo();
			rows[3] = aux.getStock();
			rows[4] = aux.getPrecio();
			if(aux instanceof DiscoDuro ){
				rows[5] = "Disco Duro";	
			}
			if(aux instanceof MemoriaRam){
				rows[5] = "Memoria Ram";	
			}
			if(aux instanceof Micro ){
				rows[5] = "Microprocesador";
			}
			if(aux instanceof Motherboard ){
				rows[5] = "MotherBoard";
			}
			model_1.addRow(rows);

		}
		 
	}
	

	public void modTemporal(Componente sel) {
		for (Componente componente : temporal) {
			if (componente.getNumSerie().equalsIgnoreCase(sel.getNumSerie())) {
				temporal.remove(componente);
				temporal.add(sel);

			}
		}
	}

	public void modCombo(String serial, int stock) {
		for (Componente componente : combo.getMisComponentes()) {
			if (componente.getNumSerie().equalsIgnoreCase(serial)) {
				componente.setStock(stock);
				spnSubtotal.setValue((Float.valueOf((Float) spnSubtotal.getValue())+componente.getPrecio()) * componente.getStock());
			}
		}
	}
	
	public boolean existencia(Componente aux, int temp) {
		
		for (Componente componente : combo.getMisComponentes()) {
			if (componente.getNumSerie().equalsIgnoreCase(aux.getNumSerie())) {
				componente.setStock(componente.getStock()+temp);
				spnSubtotal.setValue((Float.valueOf((Float) spnSubtotal.getValue())+componente.getPrecio()) * componente.getStock());
				return true;
			}
		}
		return false;
	}
	
	public void clean () {
		spnAgregar.setValue(1);
		btnAgregar.setEnabled(false);
	}
	
	public Componente Buscar(String numSerie) {

		for (Componente componente : combo.getMisComponentes()) {
			if (componente.getNumSerie().equalsIgnoreCase(numSerie)) {
				return componente;
			}
		}
		return null;
	}
	
	public void remover(Componente aux) {
		combo.getMisComponentes().remove(aux);
	}

}

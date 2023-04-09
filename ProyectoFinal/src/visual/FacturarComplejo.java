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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class FacturarComplejo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private JButton btnDelete;
	private JButton btnCancelar;
	private JButton btnLimpiar;
	private JButton btnFacturar;
	private JButton btnSetear;
	
	private String tipo;
	private Componente selected = null;
	private JTextField CedulatextField;
	private JTextField NombretextField;
	private JTextField TelefonotextField;
	private JTextField DirtextField;
	private JTextField SerietextField;
	private JTextField textField;
	private static ArrayList<Componente> componentesFactura = new ArrayList<Componente>();
	private static ArrayList<Componente> temporal = Tienda.getInstance().getMisComponentes();
	private  Componente selected_1 = null;
	private JSpinner Agregarspinner = null;
	
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
	public FacturarComplejo() {
		setBounds(100, 100, 1046, 503);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(1, 137, 1023, 241);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					String[] headers = {"Numero de serie","Tipo de Componente","Marca","Modelo", "Stock", "Precio", "Subtotal" };
					
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int ind = table.getSelectedRow();
							if (ind >= 0 ) {
								btnDelete.setEnabled(true);
								btnFacturar.setEnabled(true);
								btnLimpiar.setEnabled(true);
								btnSetear.setEnabled(true);
								String codigo = table.getValueAt(ind, 0).toString();
								
								selected = buscarComponenteBySerieFactura(codigo);
								
							}
						}
					});
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);

				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(29, 12, 995, 122);
				panel.add(panel_1);
				{
					JLabel lblCdula = new JLabel("Cédula:");
					lblCdula.setBounds(10, 11, 89, 14);
					panel_1.add(lblCdula);
				}
				{
					CedulatextField = new JTextField();
					CedulatextField.setColumns(10);
					CedulatextField.setBounds(76, 7, 216, 23);
					panel_1.add(CedulatextField);
				}
				{
					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.setBounds(355, 7, 89, 23);
					panel_1.add(btnBuscar);
				}
				{
					JLabel lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(10, 45, 79, 14);
					panel_1.add(lblNombre);
				}
				{
					NombretextField = new JTextField();
					NombretextField.setEditable(false);
					NombretextField.setColumns(10);
					NombretextField.setBounds(76, 37, 162, 23);
					panel_1.add(NombretextField);
				}
				{
					JLabel lblTelfono = new JLabel("Teléfono:");
					lblTelfono.setBounds(256, 42, 75, 14);
					panel_1.add(lblTelfono);
				}
				{
					TelefonotextField = new JTextField();
					TelefonotextField.setEditable(false);
					TelefonotextField.setColumns(10);
					TelefonotextField.setBounds(329, 41, 115, 23);
					panel_1.add(TelefonotextField);
				}
				{
					JLabel lblDireccin = new JLabel("Dirección:");
					lblDireccin.setBounds(10, 81, 89, 14);
					panel_1.add(lblDireccin);
				}
				{
					DirtextField = new JTextField();
					DirtextField.setEditable(false);
					DirtextField.setColumns(10);
					DirtextField.setBounds(86, 71, 357, 23);
					panel_1.add(DirtextField);
				}
				{
					JLabel lblNuemroDeSerie = new JLabel("Numero de serie:");
					lblNuemroDeSerie.setBounds(486, 45, 136, 14);
					panel_1.add(lblNuemroDeSerie);
				}
				{
					SerietextField = new JTextField();
					SerietextField.setColumns(10);
					SerietextField.setBounds(483, 73, 178, 23);
					panel_1.add(SerietextField);
				}
				{
					JButton btnAnadir = new JButton("Ingresar");
					btnAnadir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String serie = SerietextField.getText().toString();
							System.out.println(serie);
							Componente componente = buscarComponenteBySerie(serie);
							
							if(componente != null && componente.getStock()>0) {
								
								int diferencia = 1;//Integer.valueOf((Integer)Agregarspinner.getValue());
								selected_1 = copia(componente);
								selected_1.setStock(diferencia);
								componente.setStock(componente.getStock()-diferencia);
								reescribirComponete(componente);
								componentesFactura.add(selected_1);
								System.out.println(componente.getStock());
							} else {
								JOptionPane.showMessageDialog(null, "El Componente no existe o no esta disponible", "Error", JOptionPane.INFORMATION_MESSAGE);
							}
							
							load();
						}
						
					});
					btnAnadir.setBounds(673, 72, 104, 23);
					panel_1.add(btnAnadir);
				}
			}
			{
				JLabel lblTotal = new JLabel("Total:");
				lblTotal.setBounds(629, 394, 46, 14);
				panel.add(lblTotal);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBounds(676, 390, 115, 23);
				panel.add(textField);
			}
			{
				JLabel lblNuemroDeSerie = new JLabel("Cantidad por articulo:");
				lblNuemroDeSerie.setBounds(121, 394, 167, 14);
				panel.add(lblNuemroDeSerie);
			}
			
			Agregarspinner = new JSpinner();
			Agregarspinner.setValue(1);
			Agregarspinner.setBounds(279, 392, 46, 20);
			panel.add(Agregarspinner);
			{
				btnSetear = new JButton("set->");
				btnSetear.setEnabled(false);
				btnSetear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						selected.setStock(Integer.valueOf((Integer)Agregarspinner.getValue()));
						load();
						
					}
				});
				btnSetear.setBounds(337, 390, 72, 25);
				panel.add(btnSetear);
			}
		}
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDelete = new JButton("Eliminar");
				btnDelete.setEnabled(false);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected != null) {
							int option = JOptionPane.showConfirmDialog(null,
									"Estas seguro de querer eliminar el Companente de la factura?",
									"Eliminar Componente", JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								
								int diferencia = selected.getStock();
								Componente componente = buscarComponenteBySerie(selected.getNumSerie());
								componente.setStock(componente.getStock()+diferencia);
								reescribirComponete(componente);
								componentesFactura.remove(selected);
								
							}
							load();
						}
					}
				});
				{
					btnLimpiar = new JButton("Limpiar");
					btnLimpiar.setEnabled(false);
					btnLimpiar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
							ArrayList<Componente> aux = componentesFactura;
							for(Componente selected : aux) {
								int diferencia = selected.getStock();
								Componente componente = buscarComponenteBySerie(selected.getNumSerie());
								componente.setStock(componente.getStock()+diferencia);
								reescribirComponete(componente);
								componentesFactura.remove(selected);
								System.out.println("mmguevoooooooooooooooo");
							}
							componentesFactura.clear();
							load();
						}
					});
					{
						btnFacturar = new JButton("Facturar");
						btnFacturar.setEnabled(false);
						buttonPane.add(btnFacturar);
					}
					buttonPane.add(btnLimpiar);
				}
				buttonPane.add(btnDelete);
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
		
	}

	public static void load() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
			for (Componente aux : componentesFactura) {
				
				rows[0] = aux.getNumSerie();
				rows[2] = aux.getMarca();
				rows[3] = aux.getModelo();
				rows[4] = aux.getStock();
				rows[5] = aux.getPrecio();
				rows[6] = aux.getPrecio()*aux.getStock();
				if(aux instanceof DiscoDuro ){
					rows[1] = "Disco Duro";	
				}
				if(aux instanceof MemoriaRam){
					rows[1] = "Memoria Ram";	
				}
				if(aux instanceof Micro ){
					rows[1] = "Microprocesador";
				}
				if(aux instanceof Motherboard ){
					rows[1] = "MotherBoard";
				}
				model.addRow(rows);
			  
			}
			
		
		
	}	
	public Componente buscarComponenteBySerie(String serie) {
		Componente aux = null;
		for(Componente componentes : temporal) {
			if(componentes.getNumSerie().equalsIgnoreCase(serie)) {
				aux = componentes;
			}
		}
		return aux;
	}
	public Componente buscarComponenteBySerieFactura(String serie) {
		Componente aux = null;
		for(Componente componentes : componentesFactura) {
			if(componentes.getNumSerie().equalsIgnoreCase(serie)) {
				aux = componentes;
			}
		}
		return aux;
	}
	
	public Componente copia(Componente selec) {
		Componente aux = null;
		if(selec instanceof Motherboard){
			 
			aux = new Motherboard(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((Motherboard) selec).getSocket(), 
					((Motherboard) selec).getTipo(), ((Motherboard) selec).getConexiones());
		}
		if(selec instanceof DiscoDuro){
			 
			aux = new DiscoDuro(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((DiscoDuro) selec).getCapacidad(), 
					((DiscoDuro) selec).getTipoConexion());
		}
		if(selec instanceof Micro){
			 
			aux = new Micro(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((Micro) selec).getSocket(),
					((Micro) selec).getVelocidad());
		}
		if(selec instanceof MemoriaRam){
			 
			aux = new MemoriaRam(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((MemoriaRam) selec).getCapacidad(), 
					((MemoriaRam) selec).getTipo());
		}
		
		return aux;
	}
	
	
	
	
	public void reescribirComponete(Componente componente) {
		
		for(Componente componentes: temporal) {
			if(componentes == componente) {
				temporal.remove(componentes);
				temporal.add(componente);
			}
		}
		
		
	}
	
	
	
	
	
	
}



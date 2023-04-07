package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Micro;
import logico.Motherboard;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Facturar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JList<String> list_1;
	private JScrollPane scrollPane_1;
	private JTextField txtTotal;
	private DefaultListModel<String> misComponentes = new DefaultListModel<String>();
	private DefaultListModel<String>ventasComponentes = new DefaultListModel<String>();
	private int index;
	private int index2;
	private boolean control;
	private Cliente aux = null;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JButton btnFacturar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		
		setBounds(100, 100, 522, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 486, 122);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 11, 89, 14);
		panel.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(76, 7, 216, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnFacturar.setEnabled(true);
				
				aux = Tienda.getInstance().ClienteByCedula(txtCedula.getText());
				if(aux != null){
						txtNombre.setText(aux.getNombre()); 
						txtDireccion.setText(aux.getDireccion());
						txtTelefono.setText(aux.getCedula());
						control = true;
						
				}else {
					txtNombre.setEditable(true);
					txtTelefono.setEditable(true);
					txtDireccion.setEditable(true);
					control = false;
					
				  }
				}
				
			}
		);
		btnBuscar.setBounds(387, 0, 89, 23);
		panel.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 79, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
		
		});
		txtNombre.setEditable(false);
		txtNombre.setBounds(76, 37, 190, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(284, 45, 75, 14);
		panel.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(361, 42, 115, 23);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 81, 89, 14);
		panel.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(86, 71, 357, 23);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 139, 486, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane(list);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		for(Componente componente : Tienda.getInstance().getMisComponentes()) {
			float precio = componente.getPrecio();
			if(componente instanceof Motherboard) {
				misComponentes.addElement(Componente.getNumSerie()+" Motherboard "+precio+"$");
			}
			if(componente instanceof Micro) {
				misComponentes.addElement(Componente.getNumSerie()+" Motherboard "+precio+"$");
			}
			if(componente instanceof DiscoDuro) {
				misComponentes.addElement(Componente.getNumSerie()+" Motherboard "+precio+"$");
			}
			if(componente instanceof MemoriaRam) {
				misComponentes.addElement(Componente.getNumSerie()+" Motherboard "+precio+"$");
			}
		}
		
		
		
		list = new JList<String>();
		list.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				index = list.getSelectedIndex();
				if(index >= 0) {
					btnDerecha.setEnabled(true);
				}
			}
			
		});
		list.setModel(misComponentes);
		list.setVisibleRowCount(5);
		scrollPane.setViewportView(list);
	
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(299, 34, 177, 174);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		list_1 = new JList<String>();
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index2 = list_1.getSelectedIndex();
				
				if(index2 >= 0) {
					btnIzquierda.setEnabled(true);
				}
			}
			
		});
		scrollPane_1.setViewportView(list_1);
		list_1.setModel(ventasComponentes);
		list_1.setVisibleRowCount(5);
		
		
		btnDerecha = new JButton(">>");
		btnDerecha.setEnabled(false);
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoverElemento(list, list_1, index);
				 String Total = Float.toString(TotalCompra(list_1));
				txtTotal.setText(Total);
				
				
			}
		});
		btnDerecha.setBounds(200, 83, 89, 25);
		panel_1.add(btnDerecha);
		
		btnIzquierda = new JButton("<<");
		btnIzquierda.setEnabled(false);
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoverElemento(list_1, list, index2);
				String Total=Float.toString(TotalCompra(list_1));
				txtTotal.setText(Total);
				
				
			}
		});
		btnIzquierda.setBounds(200, 119, 89, 23);
		panel_1.add(btnIzquierda);
		
		JLabel lblQuesosDisponibles = new JLabel("Componentes Disponibles");
		lblQuesosDisponibles.setBounds(10, 11, 211, 14);
		panel_1.add(lblQuesosDisponibles);
		
		JLabel lblCarritoDeCompra = new JLabel("Carrito de Compra");
		lblCarritoDeCompra.setBounds(299, 9, 177, 14);
		panel_1.add(lblCarritoDeCompra);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 369, 46, 14);
		contentPanel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(354, 366, 130, 20);
		contentPanel.add(txtTotal);
		txtTotal.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFacturar = new JButton("Facturar");
				btnFacturar.setEnabled(false);
				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
							if(!control) {
								Cliente aux = new Cliente(txtCedula.getText(),txtNombre.getText(),txtDireccion.getText(),txtTelefono.getText());
								TiendaQueso.getInstance().registrarCliente(aux);
							}
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clear();
							String codigo = "Fa-"+TiendaQueso.getInstance().getMisfacturas().size();
							Factura nuevaFactura = new Factura(codigo,quesosFactura(list_1), aux);
							
							TiendaQueso.getInstance().agregarFactura(nuevaFactura);
							TiendaQueso.getInstance().SacarQuesosInventario(quesosFactura(list_1));
							txtTotal.setText("0");
							
							DefaultListModel<String> list1 = new DefaultListModel<String>();
							list_1.setModel(list1);
							list.setModel(misQuesosString);
							
					}
				});
				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clear() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtNombre.setEditable(false);;
		txtTelefono.setEditable(false);
		txtDireccion.setEditable(false);
	}
	public float TotalCompra(JList<String> list) {
		
		float total=0;
		for (int i = 0; i <list.getModel().getSize(); i++) {
			
		    String element = (String) list.getModel().getElementAt(i);
		    String codigo = "";
		    
		    for (Queso queso : TiendaQueso.getInstance().getMisQuesos()) {
		    	if(queso instanceof QuesoCilindricoH) {
		    		codigo = element.substring(0, 5);
		    	}
		    	else {
		    		codigo = element.substring(0, 4);
		    	}
		    	if(queso.getCodigo().equalsIgnoreCase(codigo)) {
		    		total+=queso.precioT();
		    	}
				
			}
		}
		
		
		return total;
	}
public ArrayList<Queso> quesosFactura(JList<String> list) {
		
		ArrayList<Queso> quesosk = new ArrayList<Queso>();
		for (int i = 0; i <list.getModel().getSize(); i++) {
			
		    String element = (String) list.getModel().getElementAt(i);
		    
		    String codigo = "";
		    for (Queso queso : TiendaQueso.getInstance().getMisQuesos()) {
		    	if(queso instanceof QuesoCilindricoH) {
		    		codigo = element.substring(0, 5);
		    	}
		    	else {
		    		codigo = element.substring(0, 4);
		    	}
		    	if(queso.getCodigo().equalsIgnoreCase(codigo)) {
		    		quesosk.add(queso);
		    	}
			}
		}
		
		
		return quesosk;
	}
	public void MoverElemento(JList<String> list, JList<String> list_1, int indice) {
	    DefaultListModel<String> lista1 = (DefaultListModel<String>) list.getModel();
	    DefaultListModel<String> lista2 = (DefaultListModel<String>) list_1.getModel();
	    
	    if (indice >= 0 && indice < lista1.size()) {
	        String elemento = lista1.getElementAt(indice);
	        lista2.addElement(elemento);
	        lista1.removeElementAt(indice);
	    }
	}
	
}

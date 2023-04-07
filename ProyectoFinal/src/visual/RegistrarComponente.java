package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Motherboard;
import logico.Micro;
import logico.Tienda;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;

public class RegistrarComponente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField textSerial;
	private JSpinner spnPrecio;
	private JSpinner spnCantidad;
	
	private JRadioButton rdbMicro;
	private JRadioButton rdbDiscoDuro;
	private JRadioButton rdbMotherBoard;
	private JRadioButton rdbMemoriaRam;
	
	private JPanel pnlMotherBoard;
	private JPanel pnlMicro;
	private JPanel pnlDiscoDuro;
	private JPanel pnlMemoriaRam;
	
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textSocket;
	private JComboBox cmboxConexiones;
	private JComboBox cmboxRam;

	
	private JTextField txtGb;
	private JSpinner spnCapacidad;
	
	private JSpinner spnVelocidad;
	private JTextField txtGhz;
	
	private JLabel lblTipoDeRam;
	private JLabel lblSocket;
	private JLabel lblConexiones;
	private JLabel lblCapacidad;
	private JLabel lblVelocidad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarComponente dialog = new RegistrarComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarComponente() {
		setBounds(100, 100, 421, 603);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 13, 391, 168);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblSerial = new JLabel("N\u00FAmero de Serie:");
			lblSerial.setBounds(12, 29, 132, 14);
			panel.add(lblSerial);
			
			textSerial = new JTextField();
			textSerial.setEditable(false);
			textSerial.setBounds(12, 44, 200, 20);
			panel.add(textSerial);
			textSerial.setColumns(10);
			
			JLabel lblPrecioBase = new JLabel("Precio Base:");
			lblPrecioBase.setBounds(12, 71, 72, 14);
			panel.add(lblPrecioBase);
			
			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
			spnPrecio.setBounds(12, 87, 200, 20);
			panel.add(spnPrecio);
			
			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setBounds(12, 119, 72, 14);
			panel.add(lblCantidad);
			
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(12, 135, 200, 20);
			panel.add(spnCantidad);
		}
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Componente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 184, 391, 118);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbMotherBoard = new JRadioButton("MotherBoard");
		rdbMotherBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMotherBoard.setSelected(true);
				rdbDiscoDuro.setSelected(false);
				rdbMicro.setSelected(false);
				rdbMemoriaRam.setSelected(false);
				
				pnlDiscoDuro.setVisible(false);
				pnlMicro.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				
			}
		});
		rdbMotherBoard.setBounds(7, 25, 118, 23);
		panel.add(rdbMotherBoard);
		
		rdbDiscoDuro = new JRadioButton("Disco Duro");
		rdbDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(true);
				rdbMicro.setSelected(false);
				rdbMemoriaRam.setSelected(false);
				rdbMotherBoard.setSelected(true);
				
				pnlDiscoDuro.setVisible(true);
				pnlMicro.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				pnlMotherBoard.setVisible(true);
				
				lblTipoDeRam.setVisible(false);
				cmboxRam.setVisible(false);
				lblSocket.setVisible(false);
				textSocket.setVisible(false);
				
				lblCapacidad.setVisible(true);
				spnCapacidad.setVisible(true);
				
				updateCodigo();
			}
		});
		rdbDiscoDuro.setBounds(202, 25, 109, 23);
		panel.add(rdbDiscoDuro);
		
		rdbMicro = new JRadioButton("Micro-Procesador");
		rdbMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(false);
				rdbMicro.setSelected(true);
				rdbMemoriaRam.setSelected(false);
				rdbMotherBoard.setSelected(false);
				
				pnlMotherBoard.setVisible(true);
				pnlDiscoDuro.setVisible(false);
				pnlMicro.setVisible(true);
				pnlMemoriaRam.setVisible(false);
				
				lblTipoDeRam.setVisible(false);
				cmboxRam.setVisible(false);
				lblConexiones.setVisible(false);
				cmboxConexiones.setVisible(false);
				updateCodigo();
			}
		});
		rdbMicro.setBounds(7, 69, 152, 23);
		panel.add(rdbMicro);
		
		rdbMemoriaRam = new JRadioButton("Memoria Ram");
		rdbMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(false);
				rdbMicro.setSelected(false);
				rdbMemoriaRam.setSelected(true);
				rdbMotherBoard.setSelected(false);
				
				pnlMotherBoard.setVisible(true);
				pnlDiscoDuro.setVisible(true);
				pnlMicro.setVisible(false);
				pnlMemoriaRam.setVisible(true);
				
				lblConexiones.setVisible(false);
				cmboxConexiones.setVisible(false);
				lblSocket.setVisible(false);
				textSocket.setVisible(false);
				updateCodigo();
			}
		});
		rdbMemoriaRam.setBounds(202, 69, 127, 23);
		panel.add(rdbMemoriaRam);
		
		pnlMotherBoard = new JPanel();
		pnlMotherBoard.setBounds(5, 304, 391, 209);
		contentPanel.add(pnlMotherBoard);
		pnlMotherBoard.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 13, 90, 14);
		pnlMotherBoard.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(12, 29, 151, 20);
		pnlMotherBoard.add(textMarca);
		textMarca.setText((String) null);
		textMarca.setColumns(10);
		
		lblTipoDeRam = new JLabel("Tipo De Ram:");
		lblTipoDeRam.setBounds(12, 82, 110, 14);
		pnlMotherBoard.add(lblTipoDeRam);
		
		cmboxRam = new JComboBox();
		cmboxRam.setBounds(12, 98, 151, 22);
		pnlMotherBoard.add(cmboxRam);
		cmboxRam.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "DDR", "DDR-2", "DDR-3", "DDR-4", "DDR-5"}));
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(251, 13, 110, 14);
		pnlMotherBoard.add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setBounds(251, 29, 128, 20);
		pnlMotherBoard.add(textModelo);
		textModelo.setText((String) null);
		textModelo.setColumns(10);
		
		lblSocket = new JLabel("Socket:");
		lblSocket.setBounds(251, 82, 110, 14);
		pnlMotherBoard.add(lblSocket);
		
		textSocket = new JTextField();
		textSocket.setBounds(251, 98, 128, 20);
		pnlMotherBoard.add(textSocket);
		textSocket.setText((String) null);
		textSocket.setColumns(10);
		
		lblConexiones = new JLabel("Conexiones:");
		lblConexiones.setBounds(148, 137, 110, 14);
		pnlMotherBoard.add(lblConexiones);
		
		cmboxConexiones = new JComboBox();
		cmboxConexiones.setBounds(148, 153, 124, 22);
		pnlMotherBoard.add(cmboxConexiones);
		cmboxConexiones.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "IDE", "SATA", "SATA-2", "SATA-3"}));
		
		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setLayout(null);
		pnlDiscoDuro.setBounds(5, 304, 391, 209);
		contentPanel.add(pnlDiscoDuro);
		
		lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(251, 82, 110, 14);
		pnlDiscoDuro.add(lblCapacidad);
		
		spnCapacidad = new JSpinner();
		spnCapacidad.setBounds(251, 98, 81, 20);
		pnlDiscoDuro.add(spnCapacidad);
		spnCapacidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		txtGb = new JTextField();
		txtGb.setBounds(330, 98, 29, 20);
		pnlDiscoDuro.add(txtGb);
		txtGb.setColumns(10);
		txtGb.setEditable(false);
		txtGb.setText("GB");
		
		pnlMicro = new JPanel();
		pnlMicro.setLayout(null);
		pnlMicro.setBounds(5, 304, 391, 209);
		contentPanel.add(pnlMicro);
		
		lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setBounds(12, 82, 110, 14);
		pnlMicro.add(lblVelocidad);
		
		spnVelocidad = new JSpinner();
		spnVelocidad.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnVelocidad.setBounds(12, 97, 81, 20);
		pnlMicro.add(spnVelocidad);
		
		txtGhz = new JTextField();
		txtGhz.setText("Ghz");
		txtGhz.setEditable(false);
		txtGhz.setColumns(10);
		txtGhz.setBounds(89, 97, 29, 20);
		pnlMicro.add(txtGhz);
		
		pnlMemoriaRam = new JPanel();
		pnlMemoriaRam.setBounds(5, 304, 391, 209);
		contentPanel.add(pnlMemoriaRam);
		pnlMemoriaRam.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Componente aux = null;
						String modelo = textModelo.getText();
						String marca = textMarca.getText();
						Float precio = Float.valueOf(spnPrecio.getValue().toString());
						int stock = Integer.valueOf((Integer) spnCantidad.getValue());
						String serial = textSerial.getText();
						
						if(rdbMotherBoard.isSelected()){
							String socket = textSocket.getText();
							String tipo = (String) cmboxRam.getSelectedItem();
							//String conexion = cmboxConexiones Pero no se puede seleccionar mas de una so, bobo.
							aux = new Motherboard(serial, 1, precio, modelo, marca, socket, tipo, null);
						}
						if(rdbDiscoDuro.isSelected()){
							int capacidad = Integer.valueOf((Integer) spnCapacidad.getValue()); 
							String conexion = (String)cmboxConexiones.getSelectedItem();
							aux = new DiscoDuro(serial, 1, precio, modelo, marca, capacidad, conexion);
						}
						if(rdbMicro.isSelected()){
							String socket = textSocket.getText();
							Float velocidad = Float.valueOf((Float) spnVelocidad.getValue());
							aux = new Micro(serial, 1, precio, modelo, marca, socket, velocidad);
						}
						if(rdbMemoriaRam.isSelected()){
							String tipo = (String) cmboxRam.getSelectedItem();
							int capacidad = Integer.valueOf((Integer) spnCapacidad.getValue()); 
							aux = new MemoriaRam(serial, 1, precio, modelo, marca, capacidad, tipo);
						}
						Tienda.getInstance().RegComponente(aux);
						JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						
						if (stock > 1) {
							regMasivo(aux,stock);
						}
						clean();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void updateCodigo() {
		String pre = "";
		if(rdbMotherBoard.isSelected()){
			pre = "MDR";
		}
		if(rdbMicro.isSelected()){
			pre = "MIC";	
		}
		if(rdbDiscoDuro.isSelected()){
			pre = "DIS";	
		}
		if(rdbMemoriaRam.isSelected()) {
			pre = "MER";
		}
		textSerial.setText(pre+"-"+Tienda.serial);
	}
	
	private void clean() {
		pnlMotherBoard.setVisible(true);
		rdbMotherBoard.setSelected(true);
		
		pnlMicro.setVisible(false);
		rdbMicro.setSelected(false);
		
		pnlDiscoDuro.setVisible(false);
		rdbDiscoDuro.setSelected(false);
		
		pnlMemoriaRam.setVisible(false);
		rdbMemoriaRam.setSelected(false);
		
		spnPrecio.setValue(new Float(0.0));
		spnCapacidad.setValue(new Integer(0));
		spnVelocidad.setValue(new Float(0.0));
		spnCantidad.setValue(new Integer(0));

		updateCodigo();
	}
	
	private void regMasivo(Componente aux, int cant) {
		for (int i=0; i<cant; i++) {
			updateCodigo();
			String serial = textSerial.getText();
			aux.setNumSerie(serial);
			Tienda.getInstance().RegComponente(aux);
		}
	}
}

package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Queso;
import logical.QuesoCilindrico;
import logical.QuesoCilindricoH;
import logical.QuesoEsferico;
import logical.TiendaQueso;

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

public class RegistrarComponente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textcodigo;
	private JSpinner spnPrecio;
	private JRadioButton rdbMicro;
	private JRadioButton rdbDiscoDuro;
	private JRadioButton rdbMotherBoard;
	private JSpinner spnRadio;
	private JSpinner spnRadioExt;
	private JPanel pnlQCilind;
	private JPanel pnlQEsf;
	private JPanel pnlQCilindH;
	private JSpinner spnRadioExtCH;
	private JSpinner spnRdioIntCH;
	private JSpinner spnLongCH;
	private JSpinner spnLongitud;

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
		setBounds(100, 100, 778, 609);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 13, 743, 152);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblSerial = new JLabel("N\u00FAmero de Serie:");
			lblSerial.setBounds(303, 13, 132, 14);
			panel.add(lblSerial);
			
			textcodigo = new JTextField();
			textcodigo.setEditable(false);
			textcodigo.setBounds(197, 29, 364, 20);
			panel.add(textcodigo);
			textcodigo.setColumns(10);
			
			JLabel lblPrecioBase = new JLabel("Precio Base:");
			lblPrecioBase.setBounds(316, 53, 72, 14);
			panel.add(lblPrecioBase);
			
			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
			spnPrecio.setBounds(284, 68, 161, 20);
			panel.add(spnPrecio);
			
			JLabel label = new JLabel("Precio Base:");
			label.setBounds(316, 101, 72, 14);
			panel.add(label);
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(284, 119, 161, 20);
			panel.add(spinner);
		}
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Componente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 169, 743, 60);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbMotherBoard = new JRadioButton("MotherBoard ");
		rdbMotherBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(false);
				rdbMicro.setSelected(false);
				rdbMotherBoard.setSelected(true);
				pnlQCilind.setVisible(false);
				pnlQEsf.setVisible(true);
				updateCodigo();
			}
		});
		rdbMotherBoard.setSelected(true);
		rdbMotherBoard.setBounds(7, 25, 118, 23);
		panel.add(rdbMotherBoard);
		
		rdbDiscoDuro = new JRadioButton("Disco Duro");
		rdbDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(true);
				rdbMotherBoard.setSelected(false);
				rdbMicro.setSelected(false);
				pnlQCilind.setVisible(true);
				pnlQEsf.setVisible(false);
				updateCodigo();
			}
		});
		rdbDiscoDuro.setBounds(202, 25, 109, 23);
		panel.add(rdbDiscoDuro);
		
		rdbMicro = new JRadioButton("Micro-Procesador");
		rdbMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMicro.setSelected(true);
				rdbDiscoDuro.setSelected(false);
				rdbMotherBoard.setSelected(false);
				pnlQCilindH.setVisible(true);
				pnlQEsf.setVisible(false);
				pnlQCilind.setVisible(false);
				updateCodigo();
			}
		});
		rdbMicro.setBounds(380, 25, 152, 23);
		panel.add(rdbMicro);
		
		JRadioButton rdbMemoriaRam = new JRadioButton("Memoria Ram");
		rdbMemoriaRam.setBounds(597, 24, 127, 23);
		panel.add(rdbMemoriaRam);
		
		pnlQEsf = new JPanel();
		pnlQEsf.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlQEsf.setBounds(364, 398, 384, 66);
		contentPanel.add(pnlQEsf);
		pnlQEsf.setLayout(null);
		
		JLabel lblRedio = new JLabel("Radio:");
		lblRedio.setBounds(10, 11, 46, 14);
		pnlQEsf.add(lblRedio);
		
		spnRadio = new JSpinner();
		spnRadio.setBounds(10, 35, 161, 20);
		pnlQEsf.add(spnRadio);
		
		pnlQCilind = new JPanel();
		pnlQCilind.setVisible(false);
		pnlQCilind.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlQCilind.setBounds(5, 241, 743, 144);
		contentPanel.add(pnlQCilind);
		pnlQCilind.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Radio Exterior:");
		lblNewLabel.setBounds(10, 11, 90, 14);
		pnlQCilind.add(lblNewLabel);
		
		spnRadioExt = new JSpinner();
		spnRadioExt.setBounds(10, 35, 161, 20);
		pnlQCilind.add(spnRadioExt);
		
		JLabel lblNewLabel_1 = new JLabel("Longitud:");
		lblNewLabel_1.setBounds(213, 11, 110, 14);
		pnlQCilind.add(lblNewLabel_1);
		
		spnLongitud = new JSpinner();
		spnLongitud.setBounds(213, 35, 161, 20);
		pnlQCilind.add(spnLongitud);
		
		pnlQCilindH = new JPanel();
		pnlQCilindH.setVisible(false);
		pnlQCilindH.setLayout(null);
		pnlQCilindH.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlQCilindH.setBounds(12, 457, 384, 66);
		contentPanel.add(pnlQCilindH);
		
		JLabel label = new JLabel("Radio Exterior:");
		label.setBounds(10, 11, 90, 14);
		pnlQCilindH.add(label);
		
		spnRadioExtCH = new JSpinner();
		spnRadioExtCH.setBounds(10, 35, 100, 20);
		pnlQCilindH.add(spnRadioExtCH);
		
		JLabel label_1 = new JLabel("Longitud:");
		label_1.setBounds(150, 11, 110, 14);
		pnlQCilindH.add(label_1);
		
		spnLongCH = new JSpinner();
		spnLongCH.setBounds(150, 35, 100, 20);
		pnlQCilindH.add(spnLongCH);
		
		JLabel lblRadioInterior = new JLabel("Radio Interior:");
		lblRadioInterior.setBounds(275, 11, 90, 14);
		pnlQCilindH.add(lblRadioInterior);
		
		spnRdioIntCH = new JSpinner();
		spnRdioIntCH.setBounds(275, 35, 100, 20);
		pnlQCilindH.add(spnRdioIntCH);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*Queso aux = null;
						String codigo = textcodigo.getText();

						float precio = Float.valueOf(spnPrecio.getValue().toString());
						float costo = Float.valueOf(spncosto.getValue().toString());
						if(rdbMotherBoard.isSelected()){
							int radio = Integer.valueOf(spnRadio.getValue().toString());
							aux = new QuesoEsferico(codigo, precio, costo, radio);						
						}
						if(rdbDiscoDuro.isSelected()){
							int radioE = Integer.valueOf(spnRadioExt.getValue().toString());
							float longitud = Float.valueOf(spnLongitud.getValue().toString());
							aux = new QuesoCilindrico(codigo, precio, costo, radioE, longitud);
						}
						if(rdbMicro.isSelected()){
							int radioECH = Integer.valueOf(spnRadioExtCH.getValue().toString());
							float longitudCH = Float.valueOf(spnLongCH.getValue().toString());
							float radioICH = Float.valueOf(spnRdioIntCH.getValue().toString());
							aux = new QuesoCilindricoH(codigo, precio, costo, radioECH, longitudCH, radioICH);
						}
						TiendaQueso.getInstance().insertarQueso(aux);
						JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clean();*/
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
	  updateCodigo();	
	}

	private void updateCodigo() {
		String pre = "";
		if(rdbMotherBoard.isSelected()){
			pre = "QE";
		}
		if(rdbMicro.isSelected()){
		   pre = "QCH";	
		}
		if(rdbDiscoDuro.isSelected()){
			   pre = "QC";	
		}
		textcodigo.setText(pre+"-"+TiendaQueso.codigo);
		
	}
	
	private void clean() {
		pnlQEsf.setVisible(true);
		pnlQCilindH.setVisible(false);
		pnlQCilind.setVisible(false);
		rdbMotherBoard.setSelected(true);
		rdbMicro.setSelected(false);
		rdbDiscoDuro.setSelected(false);
		spncosto.setValue(new Float(0.0));
		spnPrecio.setValue(new Float(0.0));
		spnRdioIntCH.setValue(new Float(0.0));
		spnRadio.setValue(new Integer(0));
		spnLongCH.setValue(new Float(0.0));
		spnRadioExtCH.setValue(new Integer(0));
		spnLongitud.setValue(new Float(0.0));
		spnRadioExt.setValue(new Integer(0));
		updateCodigo();
	}
}

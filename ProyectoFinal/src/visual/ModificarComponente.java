package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Componente;

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

public class ModificarComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textcodigo;
	private JSpinner spnPrecio;
	private JSpinner spncosto;
	private JSpinner spnRadio;
	private JSpinner spnRadioExt;
	private JPanel pnlQCilind;
	private JPanel pnlQEsf;
	private JPanel pnlQCilindH;
	private JSpinner spnRadioExtCH;
	private JSpinner spnRdioIntCH;
	private JSpinner spnLongCH;
	private static Componente selectedp = null;
	private JSpinner spnLongitud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarComponente  Modidialog = new ModificarComponente(selectedp);
			Modidialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			Modidialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarComponente(Componente Selected) {
		
		selectedp = Selected;
		
		System.out.println(selectedp.getCodigo());
		setBounds(100, 100, 415, 382);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 384, 152);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(10, 24, 53, 14);
			panel.add(lblCdigo);
			
			textcodigo = new JTextField();
			textcodigo.setEditable(false);
			textcodigo.setBounds(10, 49, 364, 20);
			panel.add(textcodigo);
			textcodigo.setColumns(10);
			
			JLabel lblPrecioBase = new JLabel("Precio Base:");
			lblPrecioBase.setBounds(10, 82, 72, 14);
			panel.add(lblPrecioBase);
			
			JLabel lblCostoUnitario = new JLabel("Costo Unitario:");
			lblCostoUnitario.setBounds(213, 82, 93, 14);
			panel.add(lblCostoUnitario);
			
			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
			spnPrecio.setBounds(10, 107, 161, 20);
			panel.add(spnPrecio);
			
			spncosto = new JSpinner();
			spncosto.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
			spncosto.setBounds(213, 107, 161, 20);
			panel.add(spncosto);
		}
		
		//----------------------------------------------------------------
		pnlQEsf = new JPanel();
		pnlQEsf.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlQEsf.setBounds(5, 229, 384, 66);
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
		pnlQCilind.setBounds(5, 229, 384, 66);
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
		pnlQCilindH.setBounds(5, 229, 384, 66);
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
				JButton okButton = new JButton("Modificar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String codigo = textcodigo.getText();
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						float costo = Float.valueOf(spncosto.getValue().toString());
						
						if(selectedp instanceof QuesoEsferico){
							int radio = Integer.valueOf(spnRadio.getValue().toString());
							((QuesoEsferico)selectedp).setCodigo(codigo);
							((QuesoEsferico)selectedp).setPrecioB(precio);
							((QuesoEsferico)selectedp).setPrecioU(costo);
							((QuesoEsferico)selectedp).setRadioE(radio);						
						}
						if(selectedp instanceof QuesoCilindrico){
							int radioE = Integer.valueOf(spnRadioExt.getValue().toString());
							int longitud = Integer.valueOf(spnLongitud.getValue().toString());
							((QuesoCilindrico)selectedp).setCodigo(codigo);
							((QuesoCilindrico)selectedp).setPrecioB(precio);
							((QuesoCilindrico)selectedp).setPrecioU(costo);
							((QuesoCilindrico)selectedp).setRadieExt(radioE);
							((QuesoCilindrico)selectedp).setLongitud(longitud);
						}
						if(selectedp instanceof QuesoCilindricoH){
							int radioECH = Integer.valueOf(spnRadioExtCH.getValue().toString());
							int longitudCH = Integer.valueOf(spnLongCH.getValue().toString());
							int radioICH = Integer.valueOf(spnRdioIntCH.getValue().toString());
							((QuesoCilindricoH)selectedp).setCodigo(codigo);
							((QuesoCilindricoH)selectedp).setPrecioB(precio);
							((QuesoCilindricoH)selectedp).setPrecioU(costo);
							((QuesoCilindricoH)selectedp).setRadieExt(radioECH);
							((QuesoCilindricoH)selectedp).setLongitud(longitudCH);
							((QuesoCilindricoH)selectedp).setRadioI(radioICH);
						}
						ListadoQueso.loadQuesos(0);
						JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						dispose();
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
	  load();
	}
	public void load() {
			if(selectedp instanceof QuesoEsferico) {
				
				pnlQCilind.setVisible(false);
				pnlQEsf.setVisible(true);
				textcodigo.setText(selectedp.getCodigo());
		        spnPrecio.setValue(selectedp.getPrecioB());
				spncosto.setValue(selectedp.getPrecioU());
				spnRadio.setValue(((QuesoEsferico)selectedp).getRadioE() );
				
			}
			if(selectedp instanceof QuesoCilindrico) {
					
					pnlQCilind.setVisible(true);
					pnlQEsf.setVisible(false);
					textcodigo.setText(selectedp.getCodigo());
			        spnPrecio.setValue(selectedp.getPrecioB());
					spncosto.setValue(selectedp.getPrecioU());
					spnRadioExt.setValue(((QuesoCilindrico)selectedp).getRadieExt());
					spnLongitud.setValue(((QuesoCilindrico)selectedp).getLongitud());
					
			}
			if(selectedp instanceof QuesoCilindricoH) {
					
					pnlQCilindH.setVisible(true);
					pnlQEsf.setVisible(false);
					pnlQCilind.setVisible(false);
					textcodigo.setText(selectedp.getCodigo());
			        spnPrecio.setValue(selectedp.getPrecioB());
					spncosto.setValue(selectedp.getPrecioU());
					spnRadioExtCH.setValue(((QuesoCilindricoH)selectedp).getRadieExt());
					spnLongCH.setValue(((QuesoCilindricoH)selectedp).getLongitud());
					spnRdioIntCH.setValue(((QuesoCilindricoH)selectedp).getRadioI());
			}
			
			
	}
	
	
	
}

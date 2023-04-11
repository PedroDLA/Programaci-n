package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnComponentes = new JMenu("Componentes");
		menuBar.add(mnComponentes);
		
		JMenuItem mntmRegComp = new JMenuItem("Registrar Componente");
		mntmRegComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarComponente regC = new RegistrarComponente();
				regC.setModal(true);
				regC.setVisible(true);
			}
		});
		mnComponentes.add(mntmRegComp);
		
		JMenuItem mntmListadoDeComp = new JMenuItem("Listado de Componentes");
		mntmListadoDeComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponentes list = new ListadoComponentes();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnComponentes.add(mntmListadoDeComp);
		
		JMenuItem mntmElaborarCombo = new JMenuItem("Elaborar Combo");
		mntmElaborarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combox combo = new Combox();
				combo.setModal(true);
				combo.setVisible(true);
			}
		});
		mnComponentes.add(mntmElaborarCombo);
		
		JMenuItem mntmListadoDeCombos = new JMenuItem("Listado de Combos");
		mntmListadoDeCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCombo combo = new ListadoCombo();
				combo.setModal(true);
				combo.setVisible(true);
			}
		});
		mnComponentes.add(mntmListadoDeCombos);
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturarComplejo factura = new FacturarComplejo();
				factura.setModal(true);
				factura.setVisible(true);
			}
		});
		mnVentas.add(mntmFacturar);
		
		JMenu mmAdministrador = new JMenu("Administrador");
		menuBar.add(mmAdministrador);
		
		JMenuItem mntmComponentesVendidos = new JMenuItem("Componentes Vendidos");
		mntmComponentesVendidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mmAdministrador.add(mntmComponentesVendidos);
		
		JMenuItem mntmListadoFacturas = new JMenuItem("Listado Facturas");
		mntmListadoFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFactura factura = new ListadoFactura();
				factura.setModal(true);
				factura.setVisible(true);
			}
		});
		
		JMenuItem mntmDetalleVentas = new JMenuItem("Detalle Ventas");
		mntmDetalleVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mmAdministrador.add(mntmDetalleVentas);
		mmAdministrador.add(mntmListadoFacturas);
		
		JMenuItem mntmListadoClientes = new JMenuItem("Listado Clientes");
		mntmListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCliente cliente = new ListadoCliente();
				cliente.setModal(true);
				cliente.setVisible(true);
			}
		});
		mmAdministrador.add(mntmListadoClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
	}

}

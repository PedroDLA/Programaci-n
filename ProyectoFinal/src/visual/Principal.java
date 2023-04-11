package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame {

	
	
	

	
	static Socket sfd = null;
	static DataInputStream EntradaSocket;
	static DataOutputStream SalidaSocket;
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
		
		JMenuItem mntmListadoClientes = new JMenuItem("Datos Generales");
		mntmListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosGenerales datos = new DatosGenerales();
				datos.setModal(true);
				datos.setVisible(true);
			}
		});
		mmAdministrador.add(mntmListadoClientes);
		
		JMenuItem mntmRegistrarUsuario = new JMenuItem("Registrar Usuario");
		mntmRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegUser reg = new RegUser();
				reg.setModal(true);
				reg.setVisible(true);
				
			}
		});
		mmAdministrador.add(mntmRegistrarUsuario);
		
		JMenuItem mntmListadoClientes_1 = new JMenuItem("Listado clientes");
		mntmListadoClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCliente list = new ListadoCliente();
				list.setModal(true);
				list.setVisible(true);
				
			}
		});
		mmAdministrador.add(mntmListadoClientes_1);
		
		JMenuItem mntmListadoFactura = new JMenuItem("Listado Factura");
		mntmListadoFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFactura list = new ListadoFactura();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mmAdministrador.add(mntmListadoFactura);
		
		JMenu mnRespaldar = new JMenu("Respaldar");
		menuBar.add(mnRespaldar);
		
		JMenuItem mntmRespaldar = new JMenuItem("Respaldar");
		mntmRespaldar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
			      sfd = new Socket("127.0.0.1",7000);
			       DataInputStream aux=new DataInputStream(new FileInputStream(new File("empresa.dat")));
			     // EntradaSocket = new DataInputStream(new FileInputStream(sfd.getInputStream()));
			      SalidaSocket = new DataOutputStream((sfd.getOutputStream()));
			      String ejemplo = new String("Esto es una prueba nueva");
			      int unByte;
			      try
			      {
			        //SalidaSocket.writeUTF(ejemplo);
			       // SalidaSocket.flush();
			    	  
			    	  while((unByte=aux.read()) != -1) {
			    		  SalidaSocket.write(unByte);
			          	SalidaSocket.flush();
			          	}
			      }
			      catch (IOException ioe)
			      {
			        System.out.println("Error: "+ioe);
			      }
			    }
			    catch (UnknownHostException uhe)
			    {
			      System.out.println("No se puede acceder al servidor.");
			      System.exit(1);
			    }
			    catch (IOException ioe)
			    {
			      System.out.println("Comunicaci�n rechazada.");
			      System.exit(1);
			    }
				
				
				
			}
			
		});
		mnRespaldar.add(mntmRespaldar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
	}

}

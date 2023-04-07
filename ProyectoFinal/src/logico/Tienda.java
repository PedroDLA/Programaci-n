package logico;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Componente>misComponentes;
	private ArrayList<Cliente>misClientes;
	private ArrayList<Factura>misFacturas;
	public static int serial = 1;
	public static Tienda tienda=null;
	
	private Tienda() {
		super();
		misComponentes = new ArrayList<>();
		misClientes = new ArrayList<>();
		misFacturas = new ArrayList<>();	
	}
	
	public static Tienda getInstance(){
		if(tienda==null){
			tienda = new Tienda();
		}
		return tienda;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}	
	
	public void RegComponente(Componente comp){
		misComponentes.add(comp);
		serial++;
	}
	public void RegistrarCliente(String nombre, String cedula, int numero ) {
		Cliente cliente = new Cliente(nombre, cedula, numero);
		misClientes.add(cliente);
	}
	
	public Cliente ClienteByCedula(String cedula) {

		for (Cliente cliente : misClientes) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				return cliente;
			}
		}

		return null;
	}
	
	public Componente ComponenteByCodigo(String codigo) {
		
		Componente prueba = null;
		for (Componente componente : misComponentes) {
			if (componente.getNumSerie().equalsIgnoreCase(codigo)) {
				System.out.println(componente.getNumSerie());
				prueba = componente;
			}
		}
		System.out.println("MMMMMMMMMMGGGGGGGGGGGGGG");
		return prueba;
	}

	public void eliminarComponente(Componente selected) {
		misComponentes.remove(selected);
	}
	
	
}

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
		misComponentes = new ArrayList<Componente>();
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
	
	public Componente ComponenteByCodigo(String numSerie) {

		Componente prueba = null;
		for (Componente componente : misComponentes) {
			if (componente.getNumSerie().equalsIgnoreCase(numSerie)) {
				prueba = componente;
			}
		}
		return prueba;
	}

	public void eliminarComponente(Componente selected) {
		misComponentes.remove(selected);
	}
	
	
	
	public Componente copiarComp (Componente selec) {
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
	
	public ArrayList<Componente> copiarArray () {
		ArrayList<Componente>aux2 = new ArrayList<Componente>();
		Componente aux = null;
		for (Componente selec : misComponentes) {
			
			if(selec instanceof Motherboard){
				aux = new Motherboard(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((Motherboard) selec).getSocket(), 
						((Motherboard) selec).getTipo(), ((Motherboard) selec).getConexiones());
				aux2.add(aux);
			}
			if(selec instanceof DiscoDuro){

				aux = new DiscoDuro(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((DiscoDuro) selec).getCapacidad(), 
						((DiscoDuro) selec).getTipoConexion());
				aux2.add(aux);
			}
			if(selec instanceof Micro){

				aux = new Micro(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((Micro) selec).getSocket(),
						((Micro) selec).getVelocidad());
				aux2.add(aux);
			}
			if(selec instanceof MemoriaRam){

				aux = new MemoriaRam(selec.getNumSerie(), selec.getStock(), selec.getPrecio(), selec.getModelo(), selec.getMarca(), ((MemoriaRam) selec).getCapacidad(), 
						((MemoriaRam) selec).getTipo());
				aux2.add(aux);
			}
		}

		return aux2;
	}
	
}

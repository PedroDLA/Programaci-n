package logico;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Componente>misComponentes;
	private ArrayList<Cliente>misClientes;
	private ArrayList<Factura>misFacturas;
	private ArrayList<Combo>misCombos;
	public static int serial = 1;
	public static Tienda tienda=null;
	
	private Tienda() {
		super();
		misComponentes = new ArrayList<Componente>();
		misClientes = new ArrayList<>();
		misFacturas = new ArrayList<>();	
		misCombos = new ArrayList<>();
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
	
	
	public Componente copiarComp (Componente selec) throws CloneNotSupportedException {
		Componente aux = (Componente) selec.clone();
		return aux;
	}
	
	
	public ArrayList<Componente> copiarArray () throws CloneNotSupportedException{
		
		ArrayList<Componente> copia = new ArrayList<Componente>(misComponentes.size());
		for (Componente comp : misComponentes) {
		    copia.add((Componente) comp.clone());
		}
		return copia;
	}

	public void registrarCliente(Cliente aux) {
		misClientes.add(aux);
	}

	public ArrayList<Combo> copiarArrayCombo() {
		ArrayList<Combo> copia = new ArrayList<Combo>(misCombos.size());
		for (Combo comb : misCombos) {
		    try {
				copia.add((Combo) comb.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return copia;
	}
	public Combo copiarCombo (Combo selec) throws CloneNotSupportedException {
		Combo aux = (Combo) selec.clone();
		return aux;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public void agregarFactura(Factura nuevaFactura) {
		misFacturas.add(nuevaFactura);
	}

	public void actualizarFacturas(ArrayList<Componente> temporal) {
	    for(Componente componentes : temporal) {
	        int index = misComponentes.indexOf(componentes);
	        System.out.println(index);
	        if (index >= 0) {
	        	System.out.println("-----------------------------------------------");
	            Componente comp = misComponentes.get(index);
	            System.out.println("-----------------------------------------------");
	            System.out.println(componentes.getStock());
	            System.out.println(comp.getStock()); 
	            comp.setStock(componentes.getStock());
	        }
	    }
	}
	
	public Combo CombobyCodigo(String serial) {
		for(Combo comb : misCombos) {
			if(comb.getCodigo().equalsIgnoreCase(serial)) {
				return comb;
			}
		}
		return null;
	}

	
	
	/*
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
	*/
	
}

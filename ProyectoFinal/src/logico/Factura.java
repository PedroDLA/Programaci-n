package logico;

import java.util.ArrayList;

public class Factura {
	private String codigo;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Combo>misCombos;
	private Cliente cliente;
	private String monto;
	
	public Factura(String codigo, ArrayList<Componente> misComponentes,ArrayList<Combo>misCombos, Cliente cliente, String monto) {
		super();
		this.codigo = codigo;
		this.misComponentes = misComponentes;
		this.cliente = cliente;
		this.misCombos = misCombos;
		this.monto = monto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}
}

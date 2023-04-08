package logico;

public abstract class Componente {
	protected  String numSerie;
	protected int stock;
	protected float precio;
	protected String modelo;
	protected String marca;
	protected int cantVenta;
	
	public Componente(String numSerie, int stock, float precio, String modelo, String marca) {
		super();
		this.numSerie = numSerie;
		this.stock = stock;
		this.precio = precio;
		this.modelo = modelo;
		this.marca = marca;
		this.cantVenta = 1;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantVenta() {
		return cantVenta;
	}

	public void setCantVenta(int cantVenta) {
		this.cantVenta = cantVenta;
	}
	
	
}

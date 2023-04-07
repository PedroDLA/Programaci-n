package logico;

public abstract class Componente {
	protected static String numSerie;
	protected int stock;
	protected float precio;
	protected String modelo;
	protected String marca;
	
	public Componente(String numSerie, int stock, float precio, String modelo, String marca) {
		super();
		this.numSerie = numSerie;
		this.stock = stock;
		this.precio = precio;
		this.modelo = modelo;
		this.marca = marca;
	}

	public static String getNumSerie() {
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

	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
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
	
	
}

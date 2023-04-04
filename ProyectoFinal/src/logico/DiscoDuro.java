package logico;

public class DiscoDuro extends Componente {
	
	private int capacidad;
	private String tipoConexion;
	
	public DiscoDuro(String numSerie, int stock, float precio, String modelo, String marca, int capacidad,
			String tipoConexion) {
		super(numSerie, stock, precio, modelo, marca);
		this.capacidad = capacidad;
		this.tipoConexion = tipoConexion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	
}

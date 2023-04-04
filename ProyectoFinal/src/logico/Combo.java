package logico;

import java.util.ArrayList;

public class Combo {
	private ArrayList<Componente> misComponentes;

	public Combo(ArrayList<Componente> misComponentes) {
		super();
		this.misComponentes = misComponentes;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}
	
}

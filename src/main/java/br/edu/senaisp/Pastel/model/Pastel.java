package br.edu.senaisp.Pastel.model;

public class Pastel {
	private long id;
	private String sabor;
	
	public Pastel(long id, String sabor) {
		this.id = id;
		this.sabor = sabor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	
}

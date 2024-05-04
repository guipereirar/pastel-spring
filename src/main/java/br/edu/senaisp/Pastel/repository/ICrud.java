package br.edu.senaisp.Pastel.repository;

import java.util.List;

import br.edu.senaisp.Pastel.model.Pastel;

public interface ICrud {
	public List<Pastel> lista();
	
	public Pastel buscaPorId(long id);
	
	public int altera(Pastel pastel, long id);
	
	public int insere(Pastel pastel);
	
	public boolean exclui(long id);
	
}

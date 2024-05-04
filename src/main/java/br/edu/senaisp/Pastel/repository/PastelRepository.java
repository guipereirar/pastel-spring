package br.edu.senaisp.Pastel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Pastel.model.Pastel;

@Repository
public class PastelRepository implements ICrud{
	
	private String qrSelectAll = "SELECT id, sabor FROM pastel";
	private String qrSelectById = "SELECT id, sabor FROM pastel WHERE id = ?";
	private String qrUpdate = "UPDATE pastel SET sabor = ? WHERE id = ?";
	private String qrInsert = "INSERT INTO pastel (id, sabor) VALUES (default, ?)";
	private String qrDelete = "DELETE FROM pastel WHERE id = ?";

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public List<Pastel> lista() {
		
		return jdbctemplate.query(qrSelectAll, (rs, rownum) -> 
		{return new Pastel(rs.getLong("id"),
				rs.getString("sabor"));
				});
	}

	@Override
	public Pastel buscaPorId(long id) {
		Object[] params = {id};
		return jdbctemplate.queryForObject(qrSelectById, params, (rs, rownum) -> {
			return new Pastel(rs.getLong("id"),
					rs.getString("sabor"));
		});
	}

	@Override
	public int altera(Pastel pastel, long id) {
		Object[] params = {pastel.getSabor(), id};
		return jdbctemplate.update(qrUpdate, params);
	}

	@Override
	public int insere(Pastel pastel) {
		Object[] params = {pastel.getSabor()};
		return jdbctemplate.update(qrInsert, params);
	}

	@Override
	public int exclui(long id) {
		Object[] params = {id};
		return jdbctemplate.update(qrDelete, params);
	}

}

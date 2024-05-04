package br.edu.senaisp.Pastel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Pastel.model.Pastel;
import br.edu.senaisp.Pastel.repository.PastelRepository;

@RestController
@RequestMapping("/pastel")
public class PastelController {
	
	@Autowired
	PastelRepository repository;
	
	@GetMapping()
	public String ListaPasteis() {
		String tmp = "";
		for (Pastel pastel : repository.lista()) {
			tmp += pastel.getSabor() + " ";
		}
		return tmp;
	}

	@GetMapping("/busca/{id}")
	public String BuscaPorId(@PathVariable long id) {
		return repository.buscaPorId(id).getSabor();
	}
	
	@PutMapping("/altera/{id}")
	public String Altera(@RequestBody Pastel pastel, @PathVariable long id) {
		return String.valueOf(repository.altera(pastel, id));
	}
	
	@PostMapping("/insere")
	public String Insere(@RequestBody Pastel pastel) {
		return String.valueOf(repository.insere(pastel));
	}
	
	@DeleteMapping("/delete/{id}")
	public String Delete(@RequestBody Pastel pastel, @PathVariable long id) {
		return String.valueOf(repository.exclui(id));
	}
	
}

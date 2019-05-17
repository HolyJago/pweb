package br.unisul.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Categoria;
import br.unisul.web.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rep;
	
	// Buscar por ID.
	public Categoria find (Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	// Método que faz inserção.
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	// Atualiza BD.
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	// Deletar.
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	// Listar todas.
	public List<Categoria> findAll(){
		return rep.findAll();
	}
	
	// Busca por nome.
	public List<Categoria> search (String nome){
		return rep.findDistinctByNomeContainingOrderByNome(nome);
	}
	
}

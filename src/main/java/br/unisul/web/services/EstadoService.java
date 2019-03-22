package br.unisul.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Estado;
import br.unisul.web.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private  EstadoRepository repEst;
	
	// BUSCAR POR ID
	public Estado find (Integer id) {
		Optional<Estado> obj = repEst.findById(id);
		return obj.orElse(null);
	}
	
	// FAZER INSERÇÃO
	public Estado insert (Estado obj) {
		obj.setId(null);
		return repEst.save(obj);
	}
	
	// ATUALIZAR CATEGORIA SERVICE
	public Estado update (Estado obj) {
		find(obj.getId());
		return repEst.save(obj);
	}
	
	//DELETAR
		public void delete (Integer id) {
			find(id);
			repEst.deleteById(id);
		}
		
		//LISTAR TODAS
		public List<Estado> findAll(){
			return repEst.findAll();
		}
}
package br.unisul.web.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.web.domain.Cidade;
import br.unisul.web.domain.Estado;
import br.unisul.web.dtos.CidadeDto;
import br.unisul.web.dtos.EstadoDto;
import br.unisul.web.resources.utils.URL;
import br.unisul.web.services.CidadeService;
import br.unisul.web.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;

	//LISTAR CIDADES DE UM ESTADO
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDto>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeDto> listDto = list.stream().map(obj -> new CidadeDto(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	// Buscar por Id
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Estado> find(@PathVariable Integer id){
		Estado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Inserir
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Estado obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// Atualiza
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Estado obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	// Exclui
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	// Lista todas
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDto>> findAll() {
		List<Estado> lista = service.findAll();
		
		// Ou for pra percorrer a lista
		List<EstadoDto> listDto = new ArrayList<EstadoDto>();
		
		for (Estado e : lista) {
			listDto.add(new EstadoDto(e));
		}
		
		return ResponseEntity.ok().body(listDto);
	}
	
	// Filtro
	@RequestMapping(value = "/filtro", method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDto>> find(
			@RequestParam(value = "nome", defaultValue = "") String nome
		){
		
		String nomeDecoded = URL.decodeParam(nome);
		List<Estado> list = service.search(nomeDecoded);
		List<EstadoDto> listDto = new ArrayList<EstadoDto>();
		for (Estado e : list) {
			listDto.add(new EstadoDto(e));
		}
		return ResponseEntity.ok().body(listDto);
	}
	
}

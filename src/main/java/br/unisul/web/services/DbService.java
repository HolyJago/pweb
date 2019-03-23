package br.unisul.web.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Categoria;
import br.unisul.web.domain.Estado;
import br.unisul.web.domain.Produto;
import br.unisul.web.repositories.CategoriaRepository;
import br.unisul.web.repositories.EstadoRepository;
import br.unisul.web.repositories.ProdutoRepository;

@Service
public class DbService {
	@Autowired
	private CategoriaRepository catRep;
	
	@Autowired
	private EstadoRepository estRep;
	
	@Autowired
	private ProdutoRepository prodRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		
		
		Estado est1 = new Estado(null, "Santa Catarina");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Mato Grosso");
		Estado est4 = new Estado(null, "Paraná");
		Estado est5 = new Estado(null, "Rio Grande do Sul");
		Estado est6 = new Estado(null, "Distrito Federal");
		Estado est7 = new Estado(null, "Bahia");
		
		estRep.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 100.00);
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		catRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRep.saveAll(Arrays.asList(p1,p2,p3));
		
	}
	
}

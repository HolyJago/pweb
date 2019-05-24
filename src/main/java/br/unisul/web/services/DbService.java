package br.unisul.web.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Categoria;
import br.unisul.web.domain.Cidade;
import br.unisul.web.domain.Cliente;
import br.unisul.web.domain.Endereco;
import br.unisul.web.repositories.CategoriaRepository;
import br.unisul.web.repositories.CidadeRepository;
import br.unisul.web.repositories.ClienteRepository;
import br.unisul.web.repositories.EnderecoRepository;
import br.unisul.web.domain.Estado;
import br.unisul.web.domain.ItemPedido;
import br.unisul.web.domain.Pedido;
import br.unisul.web.domain.Produto;
import br.unisul.web.domain.enums.TipoCliente;
import br.unisul.web.repositories.EstadoRepository;
import br.unisul.web.repositories.ItemPedidoRepository;
import br.unisul.web.repositories.PedidoRepository;
import br.unisul.web.repositories.ProdutoRepository;

@Service
public class DbService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Estado e1 = new Estado(null, "Acre");
		Estado e2 = new Estado(null, "Alagoas");
		Estado e3 = new Estado(null, "Amapá");
		Estado e4 = new Estado(null, "Amazonas");
		Estado e5 = new Estado(null, "Bahia");
		Estado e6 = new Estado(null, "Ceará");
		Estado e7 = new Estado(null, "Distrito Federal");
		Estado e8 = new Estado(null, "Espírito Santo");
		Estado e9 = new Estado(null, "Goiás");
		Estado e10 = new Estado(null, "Maranhão");
		Estado e11 = new Estado(null, "Mato Grosso");
		Estado e12 = new Estado(null, "Mato Grosso do Sul");
		Estado e13 = new Estado(null, "Minas Gerais");
		Estado e14 = new Estado(null, "Pará");
		Estado e15 = new Estado(null, "Paraíba");
		Estado e16 = new Estado(null, "Paraná");
		Estado e17 = new Estado(null, "Pernambuco");
		Estado e18 = new Estado(null, "Piauí");
		Estado e19 = new Estado(null, "Rio de Janeiro");
		Estado e20 = new Estado(null, "Rio Grande do Norte");
		Estado e21 = new Estado(null, "Rio Grande do Sul");
		Estado e22 = new Estado(null, "Rondônia");
		Estado e23 = new Estado(null, "Roraima");
		Estado e24 = new Estado(null, "Santa Catarina");
		Estado e25 = new Estado(null, "São Paulo");
		Estado e26 = new Estado(null, "Sergipe");
		Estado e27 = new Estado(null, "Tocantins");
		
		Cidade c1 = new Cidade(null, "Curitiba", e1);
		Cidade c2 = new Cidade(null, "Tubarão", e2);
		Cidade c3 = new Cidade(null, "Gravatal", e2);
		Cidade c4 = new Cidade(null, "Laguna", e2);
		Cidade c5 = new Cidade(null, "Porto Alegre", e3);
		Cidade c6 = new Cidade(null, "Guaíba", e3);
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2, c3, c4));
		e3.getCidades().addAll(Arrays.asList(c5, c6));
		
		estadoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16,
				e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Cliente cli1 = new Cliente(null, "Handsome Jack", "Handsome@Hyperion.net", "00000000000", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("48000000000", "48111111111"));
		
		Endereco end1 = new Endereco(null, "Pandora", "0", "Lunar Base", "Hyperion", "00000000", cli1, c2);
		Endereco end2 = new Endereco(null, "Promethea", "1", "Sanctuary", "Catch", "000000000", cli1, c2);
	
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));	
	
	}

}
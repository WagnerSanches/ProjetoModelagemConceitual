package com.sanches;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sanches.domain.Categoria;
import com.sanches.domain.Cidade;
import com.sanches.domain.Cliente;
import com.sanches.domain.Endereco;
import com.sanches.domain.Estado;
import com.sanches.domain.ItemPedido;
import com.sanches.domain.Pagamento;
import com.sanches.domain.PagamentoBoleto;
import com.sanches.domain.PagamentoCartao;
import com.sanches.domain.Pedido;
import com.sanches.domain.Produto;
import com.sanches.domain.enums.EstadoPagamento;
import com.sanches.domain.enums.TipoCliente;
import com.sanches.repositories.CategoriaRepository;
import com.sanches.repositories.CidadeRepository;
import com.sanches.repositories.ClienteRepository;
import com.sanches.repositories.EnderecoRepository;
import com.sanches.repositories.EstadoRepository;
import com.sanches.repositories.ItemPedidoRepository;
import com.sanches.repositories.PagamentoRepository;
import com.sanches.repositories.PedidoRepository;
import com.sanches.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository repositoryCategoria;
	
	@Autowired
	private ProdutoRepository repositoryProduto;
	
	@Autowired
	private CidadeRepository repositoryCidade;
	
	@Autowired
	private EstadoRepository repositoryEstado;
	
	@Autowired
	private ClienteRepository repositoryCliente;
	
	@Autowired
	private EnderecoRepository repositoryEndereco;
	
	@Autowired
	private PedidoRepository repositoryPedido;
	
	@Autowired
	private PagamentoRepository repositoryPagamento;
	
	@Autowired
	private ItemPedidoRepository repositoryItemPedido;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		// CATEGORIA
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		// PRODUTO
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
	 
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 ,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// ESTADO
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		// CIDADE
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Campinas", est2);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		// CLIENTE
		Cliente cli1 = new Cliente(null, "Maria SIlva", "maria@gmail.com", "46610991823", TipoCliente.PESSOA_FISICA.getCodigo());
		cli1.getTelefones().addAll(Arrays.asList("1190273848", "86752837"));
		
		// ENDERECO
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "213123312", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "12312312", cli1, c3);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		// PEDIDO
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		// PAGAMENTO
		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO.getCodigo(), ped1, 6);
		Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE.getCodigo(), ped2, sdf.parse("20/10/2017 00:00"), null);
		
		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		// ITEM PEDIDO
		ItemPedido ip1 = new ItemPedido(ped1, p1, 00.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 00.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItems().addAll(Arrays.asList(ip1, ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));
		
		repositoryEstado.saveAll(Arrays.asList(est1, est2));
		repositoryCidade.saveAll(Arrays.asList(c1, c2, c3));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		repositoryCategoria.saveAll(Arrays.asList(cat1, cat2));
		repositoryProduto.saveAll(Arrays.asList(p1, p2, p3));
	
		repositoryCliente.save(cli1);
		repositoryEndereco.saveAll(Arrays.asList(e1, e2));
	
		repositoryPedido.saveAll(Arrays.asList(ped1, ped2));
		repositoryPagamento.saveAll(Arrays.asList(pagto1, pagto2));
		
		
		repositoryItemPedido.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}

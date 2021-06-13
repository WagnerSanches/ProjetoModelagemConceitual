package com.sanches;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sanches.domain.Categoria;
import com.sanches.domain.Cidade;
import com.sanches.domain.Estado;
import com.sanches.domain.Produto;
import com.sanches.repositories.CategoriaRepository;
import com.sanches.repositories.CidadeRepository;
import com.sanches.repositories.EstadoRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
	 
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 ,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Campinas", est2);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		repositoryEstado.saveAll(Arrays.asList(est1, est2));
		repositoryCidade.saveAll(Arrays.asList(c1, c2, c3));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		repositoryCategoria.saveAll(Arrays.asList(cat1, cat2));
		repositoryProduto.saveAll(Arrays.asList(p1, p2, p3));
	
	}
}

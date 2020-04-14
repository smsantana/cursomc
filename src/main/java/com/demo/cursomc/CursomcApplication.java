package com.demo.cursomc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.cursomc.domain.Categoria;
import com.demo.cursomc.domain.Cidade;
import com.demo.cursomc.domain.Cliente;
import com.demo.cursomc.domain.Endereco;
import com.demo.cursomc.domain.Estado;
import com.demo.cursomc.domain.Produto;
import com.demo.cursomc.domain.enuns.TipoCliente;
import com.demo.cursomc.repositories.CategoriaRepository;
import com.demo.cursomc.repositories.CidadeRepository;
import com.demo.cursomc.repositories.ClienteRepository;
import com.demo.cursomc.repositories.EnderecoRepository;
import com.demo.cursomc.repositories.EstadoRepository;
import com.demo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		/*
		 * Testing Estado/Cidade
		 */
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "campinas", est2);

		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@email.com", "03333344433", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("22442233", "33443344"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "ap 203", "Jardim", "38884433", cli1, c1);
		Endereco e2 = new Endereco(null, "Av matos", "105", "ap 800", "Centro", "338884433", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		


	}

}

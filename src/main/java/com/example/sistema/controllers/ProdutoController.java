package com.example.sistema.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sistema.models.Produto;
import com.example.sistema.repositories.ProdutoRepository;


@Controller
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/cadastroProduto")
	public ModelAndView cadastrar(Produto produto) {
		ModelAndView mv = new ModelAndView("administrativo/produtos/cadastro");
		mv.addObject("produto", produto);
		return mv;
	}
	
	@GetMapping("/listarProduto")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/produtos/lista");
		mv.addObject("listaProdutos", produtoRepository.findAll());
		return mv;
	}

	@GetMapping("/editarProduto/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return cadastrar(produto.get());
		
	}

	
	@GetMapping("/excluirProduto/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produtoRepository.delete(produto.get());
		return listar();
		
	}
	
	
	@PostMapping("/salvarProduto")
	public ModelAndView salvar(Produto produto, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(produto);
		}
		produtoRepository.saveAndFlush(produto);
		return cadastrar(new Produto());
		
	}

}

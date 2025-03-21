package com.example.sistema.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sistema.models.Fornecedor;
import com.example.sistema.repositories.CidadeRepository;
import com.example.sistema.repositories.FornecedorRepository;



@Controller
public class FornecedorController {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping("/cadastroFornecedor")
	public ModelAndView cadastrar(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView("administrativo/fornecedores/cadastro");
		mv.addObject("fornecedor", fornecedor);
		mv.addObject("listaCidades", cidadeRepository.findAll());
		return mv;
	}
	
	@GetMapping("/listarFornecedor")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/fornecedores/lista");
		mv.addObject("listaFornecedores", fornecedorRepository.findAll());
		return mv;
	}

	@GetMapping("/editarFornecedor/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return cadastrar(fornecedor.get());
		
	}

	
	@GetMapping("/excluirFornecedor/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		fornecedorRepository.delete(fornecedor.get());
		return listar();
		
	}
	
	
	@PostMapping("/salvarFornecedor")
	public ModelAndView salvar(Fornecedor fornecedor, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(fornecedor);
		}
		fornecedorRepository.saveAndFlush(fornecedor);
		return cadastrar(new Fornecedor());
		
	}

}

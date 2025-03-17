package com.example.sistema.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sistema.models.Funcionario;
import com.example.sistema.repositories.FuncionarioRepository;



@Controller
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/cadastroFuncionario")
	public ModelAndView cadastrar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("administrativo/funcionarios/cadastro");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	@GetMapping("/listarFuncionario")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/funcionarios/lista");
		mv.addObject("listaFuncionarios", funcionarioRepository.findAll());
		return mv;
	}

	@GetMapping("/editarFuncionario/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return cadastrar(funcionario.get());
		
	}

	
	@GetMapping("/excluirFuncionario/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		funcionarioRepository.delete(funcionario.get());
		return listar();
		
	}
	
	
	@PostMapping("/salvarFuncionario")
	public ModelAndView salvar(Funcionario funcionario, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(funcionario);
		}
		funcionarioRepository.saveAndFlush(funcionario);
		return cadastrar(new Funcionario());
		
	}

}

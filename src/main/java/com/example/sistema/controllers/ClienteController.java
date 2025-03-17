package com.example.sistema.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sistema.models.Cliente;
import com.example.sistema.repositories.CidadeRepository;
import com.example.sistema.repositories.ClienteRepository;



@Controller
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping("/cadastroCliente")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("administrativo/clientes/cadastro");
		mv.addObject("cliente", cliente);
		mv.addObject("listaCidades", cidadeRepository.findAll());
		return mv;
	}
	
	@GetMapping("/listarCliente")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/clientes/lista");
		mv.addObject("listaClientes", clienteRepository.findAll());
		return mv;
	}

	@GetMapping("/editarCliente/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cadastrar(cliente.get());
		
	}

	
	@GetMapping("/excluirCliente/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		clienteRepository.delete(cliente.get());
		return listar();
		
	}
	
	
	@PostMapping("/salvarCliente")
	public ModelAndView salvar(Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(cliente);
		}
		clienteRepository.saveAndFlush(cliente);
		return cadastrar(new Cliente());
		
	}

}

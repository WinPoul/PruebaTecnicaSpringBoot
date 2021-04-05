package com.altioracorp.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.altioracorp.dao.ClienteDao;
import com.altioracorp.model.Cliente;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("clientes")
public class ClienteRest {

	@Autowired
	private ClienteDao clienteDao;

	@PostMapping("/guardar")
	public void guardar(@RequestBody Cliente cliente) {
		clienteDao.save(cliente);
	}
	
	
	@GetMapping("/listar")
	public List<Cliente> listar() {
		return clienteDao.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		clienteDao.deleteById(id);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Cliente cliente) {
		clienteDao.save(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable("id") Integer id) {
		 Optional<Cliente> clienteOptional= clienteDao.findById(id);
		 if(clienteOptional.isPresent()) {
			 return clienteOptional.get();
		 }else {
			 return null;
		 }
	}

}

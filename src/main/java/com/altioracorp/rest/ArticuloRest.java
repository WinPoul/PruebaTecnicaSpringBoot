package com.altioracorp.rest;

import java.util.List;

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

import com.altioracorp.dao.ArticuloDao;
import com.altioracorp.model.Articulo;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("articulos")
public class ArticuloRest {

	@Autowired
	private ArticuloDao articuloDao;

	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Articulo articulo) {
		articuloDao.save(articulo);
	}

	@GetMapping("/listar")
	public List<Articulo> listar() {
		return articuloDao.findAll();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		articuloDao.deleteById(id);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Articulo articulo) {
		articuloDao.save(articulo);
	}

}

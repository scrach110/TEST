package ciu.objetos2.patterns.mvc.rest.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ciu.objetos2.patterns.mvc.rest.dto.CriminalDto;
import ciu.objetos2.patterns.mvc.rest.model.Criminal;
import ciu.objetos2.patterns.mvc.rest.model.Integrante;
import ciu.objetos2.patterns.mvc.rest.model.Respetable;
import ciu.objetos2.patterns.mvc.rest.store.Store;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {
	
	@GetMapping("/listar")
	public Collection<Integrante>lista(){
		return Store.getInstance().findAll();
	}
	
	@PostMapping("/agregarRespetable")
	public Respetable agregarRespetable(@RequestBody Respetable r) {
		Store.getInstance().add(r);
		
		return r;
	}
	
	@PostMapping("/agregarCriminal")
	public Criminal agregarCriminal(@RequestBody CriminalDto c) {
		return c.toModel();
	}
	
	@DeleteMapping("/eliminarIntegrante/{Id}")
	public void deleteById(@PathVariable Integer Id) {
		Store.getInstance().delete(Id);
	}
	
	@GetMapping("findById/{Id}")
	public Integrante findById(@PathVariable Integer Id) {
		return Store.getInstance().findById(Id);
	}
	
	@PutMapping("update/{Id}/{Nombre}")
	public Integrante update(@PathVariable Integer Id,@PathVariable String Nombre) {
		return Store.getInstance().update(Id, Nombre);
	}
	
}

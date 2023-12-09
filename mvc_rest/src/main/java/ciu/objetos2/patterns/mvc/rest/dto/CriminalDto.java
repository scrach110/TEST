package ciu.objetos2.patterns.mvc.rest.dto;

import java.util.ArrayList;
import java.util.Collection;

import ciu.objetos2.patterns.mvc.rest.model.Ametralladora;
import ciu.objetos2.patterns.mvc.rest.model.Bomba;
import ciu.objetos2.patterns.mvc.rest.model.Criminal;
import ciu.objetos2.patterns.mvc.rest.model.Cuchillo;

public class CriminalDto {
	private Integer id;
	private String nombre;
	private Integer puntos;
	private Collection<String>armas;

	
	public CriminalDto(Integer id, String nom, Integer punt) {
		this.id = id;
		this.nombre = nom;
		this.puntos = punt;
		
		this.armas = new ArrayList<String>();
	}
	
	public Criminal toModel() {
		Criminal cr7 = new Criminal();
		cr7.setId(this.id);
		cr7.setNombre(this.nombre);
		cr7.setPuntosDeHonor(this.puntos);
		this.armas.forEach(a -> {
			if(a.equals("Cuchillo")) {
				cr7.add(new Cuchillo(1));
			} else if (a.equals("Bomba")) {
				cr7.add(new Bomba());
				}
			cr7.add(new Ametralladora(5)); //FIJAR ENUNCIADO NO SEAS BOLUDO
			
		});
		return cr7;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Collection<String> getArmas() {
		return this.armas;
	}

	public void setArmas(String armas) {
		this.armas.add(armas);
	}
	
}

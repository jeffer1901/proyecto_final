package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Guia extends Persona implements Serializable{
	private int experiencia;
	private ArrayList<String> lenguajes;
	public Guia() {
		
	}
	public Guia(ArrayList<String> lenguajes,int experiencia,String nombre,String identificacion) {
		super(nombre,identificacion);
		this.lenguajes=lenguajes;
		this.experiencia=experiencia;
		
	}
}

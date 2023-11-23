package modelo;

import java.io.Serializable;

import lombok.Data;

@Data
public abstract class Persona implements Serializable {
	private String nombre;
	private String cedula;
	public Persona(){
		
	}

	Persona(String nombre,String cedula){
		this.nombre=nombre;
		this.cedula=cedula;
	}
}

package modelo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Destinos implements Serializable{
	private String nombre;
	private String descrpcion;
	private String clima;
	private String ciudad;
	private String[] imagenes;
	public Destinos() {
		
	}
	public Destinos(String nombre,String descrpcion,String clima,String ciudad,String[] imagenes){
		this.nombre=nombre;
		this.descrpcion=descrpcion;
		this.clima=clima;
		this.ciudad=ciudad;
		this.imagenes=imagenes;
	}
}

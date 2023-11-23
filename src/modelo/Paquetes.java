package modelo;

import java.io.Serializable;
import org.threeten.bp.LocalDate;
import java.util.ArrayList;

import lombok.Data;
@Data
public class Paquetes implements Serializable{
	private double precio;
	private String nombre;
	private String inicio;
	private String fechaFinal;
	private String duracion;
	private ArrayList<Destinos> destinos;
	private int cupo;
	public Paquetes() {
		
	}
	public Paquetes(double precio,String nombre,String inicio,String fechaFinal,String duracion,ArrayList<Destinos> destinos,int cupo) {
		this.destinos=destinos; this.duracion=duracion;this.fechaFinal=fechaFinal;
		this.inicio=inicio;this.nombre=nombre;this.precio=precio;this.cupo=cupo;
		
	}
	
}

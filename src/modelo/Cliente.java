package modelo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cliente extends Persona implements Serializable{
	private String numero;
	private String direccion;
	private String correo;
	private String contraseña;
	public Cliente() {};
	public Cliente(String nombre,String identificacion,String numero,String direccion,String correo,String contraseña) {
		super(nombre, identificacion);
		this.numero=numero;
		this.direccion=direccion;
		this.correo=correo;
		this.contraseña=contraseña;
	}
}

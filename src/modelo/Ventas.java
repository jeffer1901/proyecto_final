package modelo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Ventas implements Serializable{
	private Paquetes paquete;
	private Cliente cliente;
	private Guia guia;
	public Ventas() {};
	public Ventas(Paquetes paquete,Cliente cliente,Guia guia) {
		this.paquete=paquete;this.cliente=cliente;this.guia=guia;
	}
}

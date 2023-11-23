package controlador;

import java.util.ArrayList;

import modelo.*;

public class contGraficas {
	public static int contarPaquetes(String nombre) {
		ArrayList<Ventas> lista1=contVentas.cargarLista("src/archivos/listaVentas.xml");
		int total=0;
		for(int j=0;j<lista1.size();j++) {
			if(lista1.get(j).getPaquete().getNombre().equals(nombre)) {
				total++;
			}
		}
		return total;
		
	}
	public static int contarGuias(String cedula) {
		ArrayList<Ventas> lista1=contVentas.cargarLista("src/archivos/listaVentas.xml");
		int total=0;
		for(int j=0;j<lista1.size();j++) {
			if(lista1.get(j).getGuia().getCedula().equals(cedula)) {
				total++;
			}
		}
		return total;
	}

}

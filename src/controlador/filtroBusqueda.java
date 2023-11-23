package controlador;

import java.util.ArrayList;

import modelo.Paquetes;

public class filtroBusqueda {
	public static ArrayList<Paquetes> busqueda(String dato){
		ArrayList<Paquetes> lista=contPaquetes.cargarLista("src/archivos/listaPaquetes.xml");
		ArrayList<Paquetes> lista2= new ArrayList<Paquetes>();
		for(int i=0;i<lista.size();i++) {
			for(int j=0;j<lista.get(i).getDestinos().size();j++) {
				if(dato.equals(lista.get(i).getDestinos().get(j).getNombre())) {
					lista2.add(lista.get(i));
				}else if(dato.equals(lista.get(i).getDestinos().get(j).getCiudad())){
					lista2.add(lista.get(i));
				}else if(dato.equals(lista.get(i).getDestinos().get(j).getClima())) {
					lista2.add(lista.get(i));
				}
			}
			if(lista.get(i).getNombre().equals(dato)) {
				lista2.add(lista.get(i));
			}else if(String.valueOf(lista.get(i).getPrecio()).equals(dato)){
				lista2.add(lista.get(i));
			}
		}
			
		return lista2;
		
	}
}

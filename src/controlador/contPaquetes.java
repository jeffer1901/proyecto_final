package controlador;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.threeten.bp.LocalDate;
import java.util.ArrayList;

import modelo.Destinos;
import modelo.Guia;
import modelo.Paquetes;

public class contPaquetes {
	public static ArrayList<Paquetes> listaPaquetes=new ArrayList<Paquetes>();
	
	public static void serializarObjetoXML(String prueba, ArrayList<Paquetes> listaPersonas, boolean adicionar) throws IOException {
        ArrayList<Paquetes> listaCompleta;

        if (adicionar) {
            listaCompleta = cargarLista(prueba);
            listaCompleta.addAll(listaPersonas);
        } else {
            listaCompleta = listaPersonas;
        }

        try (XMLEncoder codificador = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(prueba,adicionar)))) {
            codificador.writeObject(listaCompleta);
        }
    }
	public static ArrayList<Paquetes> cargarLista(String archivo) {
	   	 try (XMLDecoder decodificador = new XMLDecoder(new FileInputStream(archivo))) {
	            return(ArrayList<Paquetes>) decodificador.readObject();
	        } catch (IOException e) {
	            return new ArrayList<>();
	        }
	   }
	
	public static void borrarDestino(ArrayList<Destinos> destinos,String ciudad,int i) {
		if(destinos.get(i).getCiudad().equals(ciudad)) {
			destinos.remove(i);
		}else {
			i++;
			borrarDestino(destinos, ciudad, i);
		}
	}
	public static ArrayList<Paquetes> actualizar(String archivo,String nombre,String dato,int i,ArrayList<Destinos> fotos,String cambio){
		ArrayList<Paquetes> temporal=cargarLista(archivo);
		if(nombre.equals(temporal.get(i).getNombre())) {
			if("Precio".equals(dato)) {
				temporal.get(i).setPrecio(Double.parseDouble(cambio));
				return temporal;
			}else if("Inicio".equals(dato)) {
				temporal.get(i).setInicio(cambio);
				return temporal;
			}else if("Final".equals(dato)) {
				temporal.get(i).setFechaFinal(cambio);
				return temporal;
			}else if("Destinos".equals(dato)) {
				temporal.get(i).setDestinos(fotos);
				return temporal;
			}else if("Cupo".equals(dato)) {
				temporal.get(i).setCupo(Integer.parseInt(cambio));;
				return temporal;
			}
		}else {
			i++;
			actualizar(archivo, nombre, dato, i, fotos, cambio);
		}
		return temporal;
	}
	public static void agregar(String archivo, ArrayList<Paquetes> listaGuias2) throws IOException {

        ArrayList<Paquetes> datosExistente = cargarLista(archivo);
       
        datosExistente.addAll(listaGuias2);
   
        String archivoTemporal = archivo + ".tmp";
        try (XMLEncoder codificador = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(archivoTemporal)))) {
            codificador.writeObject(datosExistente);
        }

        try (FileInputStream in = new FileInputStream(archivoTemporal);
             FileOutputStream out = new FileOutputStream(archivo)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
       
        File archivoTemp = new File(archivoTemporal);
        archivoTemp.delete();
    }
	public static ArrayList<Paquetes> eliminarDatos(String archivo,int i,String nombre){
		 ArrayList<Paquetes> listaTemp=cargarLista(archivo);
		 if(listaTemp.get(i).getNombre().equals(nombre)) {
			listaTemp.remove(i);
			 return listaTemp;
		 }else {
			 i++;
			 eliminarDatos(archivo, i, nombre);
			 
		 }
		 return listaTemp;
	}
	public static Paquetes elegirPaquete(String dato,int i) {
		ArrayList<Paquetes> lista=cargarLista("src/archivos/listaGuias.xml");
		if(dato.equals(lista.get(i).getNombre())) {
			return lista.get(i);
		}else {
			return elegirPaquete(dato, i);
		}
		
	}
}

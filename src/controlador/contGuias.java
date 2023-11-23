package controlador;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Destinos;
import modelo.Guia;
import modelo.Paquetes;

public class contGuias {
	public static Guia actualizar(String dato,ArrayList<String> idiomas,String cambio,Guia objeto){
			if("Nombre".equals(dato)) {
				objeto.setNombre(cambio);
				return objeto;
			}else if("Experiencia".equals(dato)) {
				objeto.setExperiencia(Integer.parseInt(cambio));
				return objeto;
			}else if("Idiomas".equals(dato)) {
				objeto.setLenguajes(idiomas);
				return objeto;
			}
		return objeto;
	}
	public static ArrayList<Guia> cargarLista(String archivo) {
	   	 try (XMLDecoder decodificador = new XMLDecoder(new FileInputStream(archivo))) {
	            return(ArrayList<Guia>) decodificador.readObject();
	        } catch (IOException e) {
	            return new ArrayList<>();
	        }
	   }
	public static void agregar(String archivo, ArrayList<Guia> listaGuias2) throws IOException {

        ArrayList<Guia> datosExistente = cargarLista(archivo);
       
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
	public static ArrayList<Guia> eliminarDatos(String archivo,int i,String cedula){
		 ArrayList<Guia> listaTemp=cargarLista(archivo);
		 if(listaTemp.get(i).getCedula().equals(cedula)) {
			listaTemp.remove(i);
			 return listaTemp;
		 }else {
			 i++;
			 eliminarDatos(archivo, i, cedula);
			 
		 }
		 return listaTemp;
	}
}

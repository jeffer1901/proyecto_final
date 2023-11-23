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
import modelo.Ventas;

public class contVentas {
	public static ArrayList<Ventas> cargarLista(String archivo) {
	   	 try (XMLDecoder decodificador = new XMLDecoder(new FileInputStream(archivo))) {
	            return(ArrayList<Ventas>) decodificador.readObject();
	        } catch (IOException e) {
	            return new ArrayList<>();
	        }
	   }
	public static void serializarObjetoXML(String prueba, ArrayList<Ventas> listaDestinos,boolean adicionar) throws IOException {
        

        try (XMLEncoder codificador = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(prueba,adicionar)))) {
            codificador.writeObject(listaDestinos);
        }

       
    }
	public static ArrayList<Ventas> eliminarDatos(String archivo,int i,String cedula){
		 ArrayList<Ventas> listaTemp=cargarLista(archivo);
		 if(listaTemp.get(i).getPaquete().getNombre().equals(cedula)) {
			listaTemp.remove(i);
			 return listaTemp;
		 }else {
			 i++;
			 eliminarDatos(archivo, i, cedula);
			 
		 }
		 return listaTemp;
	}
	public static void agregar(String archivo, ArrayList<Ventas> listaGuias2) throws IOException {

        ArrayList<Ventas> datosExistente = cargarLista(archivo);
       
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
	public static String mensaje(String cedula,String nombre) {
		String mensajeE="";
		ArrayList<Ventas> datosExistente = cargarLista("src/archivos/listaVentas.xml");
		for(int i=0;i<datosExistente.size();i++) {
			for(int j=0;j<datosExistente.size();j++) {
				if(cedula.equals(datosExistente.get(i).getCliente().getCedula())&& nombre.equals(datosExistente.get(j).getPaquete().getNombre())) {
					mensajeE="Señor o señora "+datosExistente.get(i).getCliente().getNombre()+"\n"+
				"Usted acaba de reservar el Paquete: "+datosExistente.get(j).getPaquete().getNombre();
				}
			}
			
		}
		return mensajeE;
	}
}


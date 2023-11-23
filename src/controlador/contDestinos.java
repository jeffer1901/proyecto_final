package controlador;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Destinos;
import modelo.Guia;

public class contDestinos {
	public static ArrayList<Destinos> listaDestinos=new ArrayList<Destinos>();
	public static String agregarFotos() {
		String ruta="";
		JFileChooser jFileChooser=new JFileChooser();
		FileNameExtensionFilter filtrado= new FileNameExtensionFilter("PNG & JPG","jpg","png");
		jFileChooser.setFileFilter(filtrado);
		int respuesta=jFileChooser.showOpenDialog(jFileChooser);
		if(respuesta==JFileChooser.APPROVE_OPTION) {
			ruta=jFileChooser.getSelectedFile().getPath();
			return ruta;
		}
		return ruta;
		
	}
	public static ArrayList<Destinos> agregarDatos(String nombre,String descripcion,String clima,String Ciudad,String[] fotos){
		ArrayList<Destinos> temporal=new ArrayList<Destinos>();
		temporal.add(new Destinos(nombre, descripcion, clima, Ciudad, fotos));
		return temporal;
		
	}
	public static ArrayList<Destinos> cargarLista(String archivo) {
	   	 try (XMLDecoder decodificador = new XMLDecoder(new FileInputStream(archivo))) {
	            return(ArrayList<Destinos>) decodificador.readObject();
	        } catch (IOException e) {
	            return new ArrayList<>();
	        }
	   }
	public static void serializarObjetoXML(String prueba, ArrayList<Destinos> listaDestinos,boolean adicionar) throws IOException {
        

        try (XMLEncoder codificador = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(prueba,adicionar)))) {
            codificador.writeObject(listaDestinos);
        }

       
    }
	public static ArrayList<Destinos> actualizar(String archivo,String nombre,String dato,int i,String[] fotos,String cambio){
		ArrayList<Destinos> temporal=cargarLista(archivo);
		if(nombre.equals(temporal.get(i).getCiudad())) {
			if("Pais".equals(dato)) {
				temporal.get(i).setNombre(cambio);
				return temporal;
			}else if("Clima".equals(dato)) {
				temporal.get(i).setClima(cambio);
				return temporal;
			}else if("Descripcion".equals(dato)) {
				temporal.get(i).setDescrpcion(cambio);
				return temporal;
			}else if("Imagenes".equals(dato)) {
				temporal.get(i).setImagenes(fotos);
				return temporal;
			}
		}else {
			i++;
			actualizar(archivo, nombre, dato, i, fotos, cambio);
		}
		return temporal;
	}
	public static ArrayList<Destinos> eliminarDatos(String archivo,int i,String cedula){
		 ArrayList<Destinos> listaTemp=cargarLista(archivo);
		 if(listaTemp.get(i).getCiudad().equals(cedula)) {
			listaTemp.remove(i);
			 return listaTemp;
		 }else {
			 i++;
			 eliminarDatos(archivo, i, cedula);
			 
		 }
		 return listaTemp;
	}
	public static void agregar(String archivo, ArrayList<Destinos> listaGuias2) throws IOException {

        ArrayList<Destinos> datosExistente = cargarLista(archivo);
       
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
	
}

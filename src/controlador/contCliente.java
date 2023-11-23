package controlador;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.*;
public class contCliente {
	public static ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();
	public static int validarCliente(String cedula,String contraseña,ArrayList<Cliente> lista,int i) {
		int esta=0;
		if(i<lista.size()) {
			if(cedula.equals(lista.get(i).getCedula())&&contraseña.equals(lista.get(i).getContraseña())) {
				esta=1;
			}else {
				 validarCliente(cedula,contraseña,lista,i++);;
			}
		}
		
		return esta;
	}
	public static ArrayList<Cliente> cargarLista(String archivo) {
	   	 try (XMLDecoder decodificador = new XMLDecoder(new FileInputStream(archivo))) {
	            return(ArrayList<Cliente>) decodificador.readObject();
	        } catch (IOException e) {
	            return new ArrayList<>();
	        }
	   }
public static void serializarObjetoXML(String prueba, ArrayList<Cliente> listaDestinos,boolean adicionar) throws IOException {
        

        try (XMLEncoder codificador = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(prueba,adicionar)))) {
            codificador.writeObject(listaDestinos);
        }

       
    }
public static void agregar(String archivo, ArrayList<Cliente> listaGuias2) throws IOException {

    ArrayList<Cliente> datosExistente = cargarLista(archivo);
   
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
	public static String conseguir(ArrayList<Cliente> lista,int i,String cedula,String datoConseguir) {
		String dato="";
		if(cedula.equals(lista.get(i).getCedula())) {
			if(datoConseguir.equals("Nombre")) {
				dato= lista.get(i).getNombre();
				return dato;
			}else if(datoConseguir.equals("Cedula")){
				dato= lista.get(i).getCedula();
				return dato;
			}else if(datoConseguir.equals("Correo")){
				dato= lista.get(i).getCorreo();
				return dato;
			}else if(datoConseguir.equals("Numero")){
				dato= lista.get(i).getNumero();
				return dato;
			}else if(datoConseguir.equals("Direccion")){
				dato= lista.get(i).getDireccion();
				return dato;
			}
			
		}else {
			i++;
			if(i<lista.size()) {
				conseguir(lista, i, cedula, datoConseguir);
			}
		}
		return dato;
	}
	public static void actualizar(String dato,int i,ArrayList<Cliente> lista,String cambio,String cedula) {
		if(cedula.equals(lista.get(i).getCedula())) {
			if("Nombre del cliente".equals(dato)) {
				lista.get(i).setNombre(cambio);
			}else if("Numero".equals(dato)) {
				lista.get(i).setNumero(cambio);
			}else if("Direccion".equals(dato)) {
				lista.get(i).setDireccion(cambio);
			}else if("Correo".equals(dato)) {
				lista.get(i).setCorreo(cambio);
			}
		}else {
			i++;
			if(i<lista.size()) {
				actualizar(dato, i, lista, cambio, cedula);
			}
		}
	}
}

package controlador;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ComunicacionCliente {

    private static Socket socket;
    private static ObjectOutputStream objectOutputStream;
  private static ObjectInputStream objectInputStream;
  public static ArrayList<String> ciudades= new ArrayList<String>();

    public void conectar(String host, int puerto) throws IOException {
        socket = new Socket(host, puerto);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        System.out.println("Conectado al servidor en " + host + ":" + puerto);
    }

    public static void enviarObjeto(Object objeto) throws IOException {
        objectOutputStream.writeObject(objeto);
        objectOutputStream.flush();
        System.out.println("Objeto enviado al servidor.");
    }
    public static void enivarString(String dato) throws IOException{
    	 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
    	 writer.println(dato);
    }
    public static String recibirString() throws IOException{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	return reader.readLine();
    }
    
    public static Object recibirObjeto() throws IOException, ClassNotFoundException {
    	Object objeto=objectInputStream.readObject();
        System.out.println("Esperando objeto del servidor...");
        return objeto;
        
    }
    public static void enviarArray(ArrayList<String> lista) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(lista.size());
        for (String elemento : lista) {
            dos.writeUTF(elemento);
        }
    }
    
 
    // Otros métodos y propiedades...
    

    public void desconectar() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
            System.out.println("Desconectado del servidor.");
        }
    }
}


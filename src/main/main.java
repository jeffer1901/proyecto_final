package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import modelo.*;
import vista.admin;
import vista.inicio;
import vista.interfazAgregar;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controlador.ComunicacionCliente;

public class main {

	public static void main(String[] args) {
	    final String host = "192.168.1.4";
	    final int puerto = 12346;
	    inicio frame=new inicio();
        frame.setVisible(true);
	    try {
	        // Crear una instancia del cliente y conectar al servidor/
	        ComunicacionCliente comunicacionCliente = new ComunicacionCliente();
	        comunicacionCliente.conectar(host, puerto);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
    
		
}



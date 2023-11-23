package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ComunicacionCliente;
import controlador.contDestinos;
import controlador.contPaquetes;
import modelo.Destinos;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;


public class interfazAgregar extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDato;
	public JButton btnAgregar, btnBorrar,btnRegresar;
	public JList list,list_1;
	public static int numero=0,numero1=0;
	public static ArrayList<Destinos> temp=new ArrayList<Destinos>();
	public static DefaultListModel<String> modelo= new DefaultListModel<String>();
	public static DefaultListModel<String> modelo1= new DefaultListModel<String>();
	private static ComunicacionCliente comunicacionCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazAgregar frame = new interfazAgregar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfazAgregar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textDato = new JTextField();
		textDato.setBounds(26, 198, 192, 20);
		contentPane.add(textDato);
		textDato.setColumns(10);
		
		 btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(228, 198, 89, 23);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(this);
		
		 btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(327, 197, 89, 23);
		contentPane.add(btnBorrar);
		btnBorrar.addActionListener(this);
		
		 btnRegresar = new JButton("Cerrar");
		btnRegresar.setBounds(426, 197, 89, 23);
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(this);
		list = new JList();
		list.setBounds(0, 0, 269, 187);
		contentPane.add(list);
		
		list_1 = new JList();
		list_1.setBounds(265, 0, 269, 187);
		contentPane.add(list_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 153, 255));
		lblNewLabel.setBounds(0, 1, 534, 245);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(numero==1){
			if(e.getSource()==btnAgregar) {
				interfazDeGestion.arrayTemp.add(textDato.getText());
				list.setModel(modelo);
				modelo.addElement(textDato.getText());
			}else if(e.getSource()==btnBorrar){
				interfazDeGestion.arrayTemp.remove(textDato.getText());
				list.setModel(modelo);
				modelo.removeElement(textDato.getText());
			}else if(e.getSource()==btnRegresar) {
				setVisible(false);
			}
		}else if(numero==2) {
			if(e.getSource()==btnAgregar) {
				try {
					ComunicacionCliente.enivarString("1");
					ComunicacionCliente.enivarString(textDato.getText());
					interfazDeGestion.temp.add((Destinos)ComunicacionCliente.recibirObjeto());
				} catch ( IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}else if(e.getSource()==btnBorrar) {
				contPaquetes.borrarDestino(interfazDeGestion.temp,textDato.getText(),0);
				if(numero1==1) {}else {
					list_1.setModel(modelo);
					modelo.removeElement(textDato.getText());
				}
			}else if(e.getSource()==btnRegresar) {
				setVisible(false);
			}
			
		}
		
	}
}

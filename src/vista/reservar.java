package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.contPaquetes;
import controlador.contVentas;
import controlador.enviarCorreo;
import modelo.Guia;
import modelo.Ventas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class reservar extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	public JButton btnSi,btnNo,btnVolver,btnReservar;
	public static Guia guia=new Guia();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reservar frame = new reservar();
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
	public reservar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservar Paquete");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 229, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite el nombre ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(58, 59, 138, 14);
		contentPane.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 102, 229, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quieres tener Guia");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 152, 229, 14);
		contentPane.add(lblNewLabel_2);
		
		btnSi = new JButton("Si");
		btnSi.setBounds(24, 197, 89, 23);
		contentPane.add(btnSi);
		btnSi.addActionListener(this);
		
		btnNo = new JButton("NO");
		btnNo.setBounds(135, 197, 89, 23);
		contentPane.add(btnNo);
		btnNo.addActionListener(this);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(80, 287, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);
		
		JLabel lblNewLabel_3 = new JLabel("a Reservar");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(87, 77, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setBounds(80, 242, 89, 23);
		contentPane.add(btnReservar);
		btnReservar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSi) {
			mostrarGuias mg=new mostrarGuias();
			mg.setVisible(true);
			
		}else if(e.getSource()==btnReservar) {
			ArrayList<Ventas> lista=new ArrayList<Ventas>();
			lista.add(new Ventas(contPaquetes.elegirPaquete(textNombre.getText(),0),inicio.cliente,guia));
			try {
				contVentas.serializarObjetoXML("src/archivos/listaVentas.xml", lista, false);
				String mensaje=contVentas.mensaje(inicio.cliente.getCedula(), textNombre.getText());
				enviarCorreo.enviarConfirmacion(inicio.cliente.getCorreo(), "Reservacion Paquete de Viaje", mensaje);
				enviarCorreo.enviar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==btnNo) {
			guia=null;
		}else if(e.getSource()==btnVolver) {
			inicio in=new inicio();
			in.setVisible(true);
			inicio.numTemp=1;
		}
		
	}
}

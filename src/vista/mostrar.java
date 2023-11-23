package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.contDestinos;
import controlador.contPaquetes;
import controlador.filtroBusqueda;
import modelo.Paquetes;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class mostrar extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDato;
	public JButton btnBuscar,btnIzquierda,btnDerecha,btnDestinos;
	public JLabel lblfotos,lblNombre,lblPrecio1,lblFin,lblInicio,lblDuracion1;
	public static ArrayList<Paquetes> lista=contPaquetes.cargarLista("src/archivos/listaPaquetes.xml");
	public static ArrayList<Paquetes> lista2=new ArrayList<Paquetes>();
	public static int i =0,numero=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mostrar frame = new mostrar();
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
	public mostrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textDato = new JTextField();
		textDato.setBounds(33, 11, 217, 20);
		contentPane.add(textDato);
		textDato.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(260, 10, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		lblfotos = new JLabel("Paquetes de viajes");
		lblfotos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblfotos.setHorizontalAlignment(SwingConstants.CENTER);
		lblfotos.setBounds(359, 11, 208, 75);
		contentPane.add(lblfotos);
		
		JLabel lbl = new JLabel("Nombre:");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setBounds(87, 51, 79, 14);
		contentPane.add(lbl);
		
		lblNombre = new JLabel(lista.get(i).getNombre());
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(176, 51, 173, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(87, 90, 79, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeInicio.setBounds(52, 134, 101, 14);
		contentPane.add(lblFechaDeInicio);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin:");
		lblFechaDeFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeFin.setBounds(64, 173, 89, 14);
		contentPane.add(lblFechaDeFin);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuracion.setBounds(74, 205, 79, 14);
		contentPane.add(lblDuracion);
		
		btnDestinos = new JButton("Ver Destinos");
		btnDestinos.setBounds(380, 145, 142, 23);
		contentPane.add(btnDestinos);
		btnDestinos.addActionListener(this);
		
		lblPrecio1 = new JLabel(String.valueOf(lista.get(i).getPrecio()));
		lblPrecio1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio1.setBounds(176, 90, 173, 14);
		contentPane.add(lblPrecio1);
		
		lblInicio = new JLabel(lista.get(i).getInicio());
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInicio.setBounds(176, 134, 173, 14);
		contentPane.add(lblInicio);
		
		lblFin = new JLabel(lista.get(i).getFechaFinal());
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFin.setBounds(176, 173, 173, 14);
		contentPane.add(lblFin);
		
		lblDuracion1 = new JLabel(lista.get(i).getDuracion());
		lblDuracion1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuracion1.setBounds(176, 205, 173, 14);
		contentPane.add(lblDuracion1);
		
		btnIzquierda = new JButton("New button");
		btnIzquierda.setBounds(0, 90, 35, 40);
		contentPane.add(btnIzquierda);
		btnIzquierda.addActionListener(this);
		
		btnDerecha = new JButton("New button");
		btnDerecha.setBounds(588, 88, 35, 40);
		contentPane.add(btnDerecha);
		btnDerecha.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnDerecha) {
			if(numero==0) {
				if(i<lista.size()-1) {
					i++;
					lblNombre.setText(lista.get(i).getNombre());
					lblPrecio1.setText(String.valueOf(lista.get(i).getPrecio()));
					lblInicio.setText(lista.get(i).getInicio());
					lblFin.setText(lista.get(i).getFechaFinal());
					mostrarDesti.lista=lista.get(i).getDestinos();
					mostrarDesti md=new mostrarDesti();
					md.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null,"No hay mas Paquetes");
				}
			}else if(numero==1){
				if(i<lista.size()-1) {
					i++;
					lblNombre.setText(lista.get(i).getNombre());
					lblPrecio1.setText(String.valueOf(lista.get(i).getPrecio()));
					lblInicio.setText(lista.get(i).getInicio());
					lblFin.setText(lista.get(i).getFechaFinal());
					
				}else {
					JOptionPane.showMessageDialog(null,"No hay mas Paquetes");
				}
			}
			
		}else if(e.getSource()==btnIzquierda) {
			if(numero==0) {
				if(i>0) {
					i--;
					lblNombre.setText(lista.get(i).getNombre());
					lblPrecio1.setText(String.valueOf(lista.get(i).getPrecio()));
					lblInicio.setText(lista.get(i).getInicio());
					lblFin.setText(lista.get(i).getFechaFinal());
					
				}else {
					JOptionPane.showMessageDialog(null,"No hay mas dimensiones");
				}
			}else if(numero==1) {
				if(i>0) {
					i--;
					lblNombre.setText(lista.get(i).getNombre());
					lblPrecio1.setText(String.valueOf(lista.get(i).getPrecio()));
					lblInicio.setText(lista.get(i).getInicio());
					lblFin.setText(lista.get(i).getFechaFinal());
					
				}else {
					JOptionPane.showMessageDialog(null,"No hay mas dimensiones");
				}
			}
			
		}else if(e.getSource()==btnBuscar) {
			lista=filtroBusqueda.busqueda(textDato.getText());
			numero=1;
		}else if(e.getSource()==btnDestinos) {
			mostrarDesti.lista=lista.get(i).getDestinos();
			mostrarDesti md=new mostrarDesti();
			md.setVisible(true);
		}
		
		
	}
}

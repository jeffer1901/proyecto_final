package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.contDestinos;
import modelo.Destinos;

public class mostrarDesti extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnIzquierda,btnDerecha,btnCerrar;
	public JLabel lblfotos,lblNombre,lblCiudad,lblClima,lblDescripcion;
	public static ArrayList<Destinos> lista=contDestinos.cargarLista("src/archivos/listaDestinos.xml");
	private JLabel lblfotos_1;
	private JLabel lblfotos_2;
	private JLabel lblfotos_3;
	private int i=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mostrarDesti frame = new mostrarDesti();
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
	public mostrarDesti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblfotos = new JLabel("New label");
		lblfotos.setBounds(375, 11, 101, 93);
		contentPane.add(lblfotos);
		lblfotos.setIcon(new ImageIcon(lista.get(i).getImagenes()[1]));
		
		JLabel lbl = new JLabel("Nombre:");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setBounds(87, 51, 79, 14);
		contentPane.add(lbl);
		
		lblNombre = new JLabel(lista.get(i).getNombre());
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(176, 51, 173, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Ciudad:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(87, 90, 79, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblFechaDeInicio = new JLabel("Descripcion:");
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeInicio.setBounds(52, 134, 101, 14);
		contentPane.add(lblFechaDeInicio);
		
		JLabel lblFechaDeFin = new JLabel("Clima:");
		lblFechaDeFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeFin.setBounds(103, 173, 50, 14);
		contentPane.add(lblFechaDeFin);
		
		lblCiudad = new JLabel(lista.get(i).getCiudad());
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCiudad.setBounds(176, 90, 173, 14);
		contentPane.add(lblCiudad);
		
		lblDescripcion = new JLabel(lista.get(i).getDescrpcion());
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripcion.setBounds(176, 134, 173, 14);
		contentPane.add(lblDescripcion);
		
		lblClima = new JLabel(lista.get(i).getClima());
		lblClima.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClima.setBounds(176, 173, 173, 14);
		contentPane.add(lblClima);
		
		btnIzquierda = new JButton("New button");
		btnIzquierda.setBounds(0, 90, 35, 40);
		contentPane.add(btnIzquierda);
		btnIzquierda.addActionListener(this);
		
		btnDerecha = new JButton("New button");
		btnDerecha.setBounds(588, 88, 35, 40);
		contentPane.add(btnDerecha);
		btnDerecha.addActionListener(this);
		
		lblfotos_1 = new JLabel("New label");
		lblfotos_1.setBounds(486, 11, 101, 93);
		contentPane.add(lblfotos_1);
		lblfotos_1.setIcon(new ImageIcon(lista.get(i).getImagenes()[0]));
		
		lblfotos_2 = new JLabel("New label");
		lblfotos_2.setBounds(375, 126, 101, 93);
		contentPane.add(lblfotos_2);
		lblfotos_2.setIcon(new ImageIcon(lista.get(i).getImagenes()[2]));
		
		lblfotos_3 = new JLabel("New label");
		lblfotos_3.setBounds(486, 126, 101, 93);
		contentPane.add(lblfotos_3);
		lblfotos_3.setIcon(new ImageIcon(lista.get(i).getImagenes()[3]));
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(275, 223, 89, 23);
		contentPane.add(btnCerrar);
		btnCerrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnDerecha) {
			if(i<lista.size()-1) {
				i++;
				lista=contDestinos.cargarLista("src/archivos/listaDestinos.xml");
				lblNombre.setText(lista.get(i).getNombre());
				lblCiudad.setText(lista.get(i).getCiudad());
				lblDescripcion.setText(lista.get(i).getDescrpcion());
				lblClima.setText(lista.get(i).getClima());
				lblfotos.setIcon(new ImageIcon(lista.get(i).getImagenes()[0]));
				lblfotos_1.setIcon(new ImageIcon(lista.get(i).getImagenes()[1]));
				lblfotos_2.setIcon(new ImageIcon(lista.get(i).getImagenes()[2]));
				lblfotos_3.setIcon(new ImageIcon(lista.get(i).getImagenes()[3]));
			}else {
				JOptionPane.showMessageDialog(null,"No hay mas Destinos");
			}
		}else if(e.getSource()==btnIzquierda) {
			if(i>0) {
				i--;
				lista=contDestinos.cargarLista("src/archivos/listaDestinos.xml");
				lblNombre.setText(lista.get(i).getNombre());
				lblCiudad.setText(lista.get(i).getCiudad());
				lblDescripcion.setText(lista.get(i).getDescrpcion());
				lblClima.setText(lista.get(i).getClima());
				lblfotos.setIcon(new ImageIcon(lista.get(i).getImagenes()[0]));
				lblfotos_1.setIcon(new ImageIcon(lista.get(i).getImagenes()[1]));
				lblfotos_2.setIcon(new ImageIcon(lista.get(i).getImagenes()[2]));
				lblfotos_3.setIcon(new ImageIcon(lista.get(i).getImagenes()[3]));
			}else {
				JOptionPane.showMessageDialog(null,"No hay mas Destinos");
			}
		}else if(e.getSource()==btnCerrar){
			setVisible(false);
		}
		
	}
}

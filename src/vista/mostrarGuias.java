package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.contGuias;
import modelo.Guia;
import modelo.Ventas;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class mostrarGuias extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblNombre,lblIdentificacion,lblAños;
	public JButton btnIzquierda,btnDerecha,btnElegir,btnVolver;
	public static ArrayList<Guia> lista=contGuias.cargarLista("src/archivos/listaGuias.xml");
	public static DefaultListModel<String> modelo= new DefaultListModel<String>();
	private static JList list;
	public int i=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mostrarGuias frame = new mostrarGuias();
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
	public mostrarGuias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 109, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(119, 11, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNombre = new JLabel(lista.get(i).getNombre());
		lblNombre.setBounds(238, 11, 162, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_3 = new JLabel("Identificacion");
		lblNewLabel_3.setBounds(119, 50, 109, 14);
		contentPane.add(lblNewLabel_3);
		
		lblIdentificacion = new JLabel(lista.get(i).getCedula());
		lblIdentificacion.setBounds(238, 43, 162, 14);
		contentPane.add(lblIdentificacion);
		
		JLabel lblNewLabel_5 = new JLabel("Años de experiencia");
		lblNewLabel_5.setBounds(119, 87, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		lblAños = new JLabel("Tiene: "+String.valueOf(lista.get(i).getExperiencia())+" años de experiencia");
		lblAños.setBounds(238, 87, 162, 14);
		contentPane.add(lblAños);
		
		list = new JList();
		list.setBounds(30, 126, 375, 135);
		contentPane.add(list);
		list.setModel(modelo);
		for(int j=0;j<lista.get(i).getLenguajes().size();j++) {
			modelo.addElement(lista.get(i).getLenguajes().get(j));
		}
		
		btnIzquierda = new JButton("New button");
		btnIzquierda.setBounds(0, 103, 31, 23);
		contentPane.add(btnIzquierda);
		btnIzquierda.addActionListener(this);
		
		btnDerecha = new JButton("New button");
		btnDerecha.setBounds(403, 103, 31, 23);
		contentPane.add(btnDerecha);
		btnDerecha.addActionListener(this);
		
		btnElegir = new JButton("Elegir");
		btnElegir.setBounds(316, 266, 89, 23);
		contentPane.add(btnElegir);
		btnElegir.addActionListener(this);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(30, 266, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIzquierda) {
			if(i<lista.size()-1) {
				i++;
				lblNombre.setText(lista.get(i).getNombre());
				lblIdentificacion.setText(lista.get(i).getCedula());
				lblAños.setText("Tiene: "+String.valueOf(lista.get(i).getExperiencia())+" años de experiencia");
				list.setModel(modelo);
				for(int j=0;j<lista.get(i).getLenguajes().size();j++) {
					modelo.addElement(lista.get(i).getLenguajes().get(j));
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay mas Guias");
			}
		}else if(e.getSource()==btnDerecha) {
			if(i>0) {
				i--;
				lblNombre.setText(lista.get(i).getNombre());
				lblIdentificacion.setText(lista.get(i).getCedula());
				lblAños.setText("Tiene: "+String.valueOf(lista.get(i).getExperiencia())+" años de experiencia");
				list.setModel(modelo);
				for(int j=0;j<lista.get(i).getLenguajes().size();j++) {
					modelo.addElement(lista.get(i).getLenguajes().get(j));
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay mas Guias");
			}
		}else if(e.getSource()==btnElegir){
			reservar.guia=lista.get(i);
			setVisible(false);
		}else if(e.getSource()==btnVolver){
			reservar.guia=null;
			setVisible(false);
		}
		
	}
}

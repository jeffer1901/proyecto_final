package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import controlador.ComunicacionCliente;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class admin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel nombre_admin;
	public JButton btnPaquetes, btnDestinos, btnGuias, btnVentas, btnCerrar;
	public static String[] arreglo=new String[4];
	private static ComunicacionCliente comunicacionCliente;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @param comunicacionCliente 
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                admin frame = new admin();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	public admin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 409);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Agencia de viajes UQ");
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(0, 11, 404, 51);
		contentPane.add(lblNewLabel_1);
		
		nombre_admin = new JLabel("");
		nombre_admin.setBounds(444, 0, 242, 39);
		contentPane.add(nombre_admin);
		
		btnPaquetes = new JButton("New button");
		btnPaquetes.setIcon(new ImageIcon(admin.class.getResource("/archivos/Captura de pantalla 2023-11-15 164005.png")));
		btnPaquetes.setBounds(346, 219, 173, 107);
		contentPane.add(btnPaquetes);
		btnPaquetes.addActionListener(this);
		
		btnDestinos = new JButton("New button");
		btnDestinos.setIcon(new ImageIcon(admin.class.getResource("/archivos/destinosd.png")));
		btnDestinos.setBounds(529, 82, 173, 107);
		contentPane.add(btnDestinos);
		btnDestinos.addActionListener(this);
		
		btnGuias = new JButton("New button");
		btnGuias.setIcon(new ImageIcon(admin.class.getResource("/archivos/guias.png")));
		btnGuias.setBounds(346, 82, 173, 107);
		contentPane.add(btnGuias);
		btnGuias.addActionListener(this);
		
		btnVentas = new JButton("New button");
		btnVentas.setIcon(new ImageIcon(admin.class.getResource("/archivos/graficos.png")));
		btnVentas.setBounds(529, 219, 173, 107);
		contentPane.add(btnVentas);
		btnVentas.addActionListener(this);
		
		btnCerrar = new JButton("New button");
		btnCerrar.setIcon(new ImageIcon(admin.class.getResource("/archivos/imagen_2023-11-15_162556171 (2).png")));
		btnCerrar.setBounds(529, 48, 87, 23);
		contentPane.add(btnCerrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 102, 204));
		lblNewLabel.setBounds(0, 0, 727, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(admin.class.getResource("/archivos/imagen_2023-11-15_153229548.png")));
		lblNewLabel_2_1.setBounds(0, 73, 242, 297);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion de Guias");
		lblNewLabel_3.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(346, 194, 173, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gestion de Destinos");
		lblNewLabel_4.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(529, 194, 173, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gestion de Paquetes");
		lblNewLabel_5.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(346, 337, 173, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Graficas de ventas");
		lblNewLabel_6.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(529, 337, 173, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setBounds(0, 64, 727, 306);
		contentPane.add(lblNewLabel_2);
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnGuias) {
                   interfazDeGestion registro = new interfazDeGestion();
                    setVisible(false);
                    registro.textUno.setText("Digite el nombre");
        			registro.txtIdentificacion.setVisible(false);
        			registro.lblAyuda.setText("Ingrese los Idiomas");
        			registro.btnAyuda.setText("Ingresar los idiomas");
        			interfazDeGestion.textoTemp="src/archivos/listaGuias.xml";
        			interfazDeGestion.numero=1;
        			registro.lblOpcion.setText("Gestionar Guias");
        			registro.setVisible(true);
        			registro.txtNombre.setText("Digite la cedula");
        			registro.textDos.setText("Cuantos años de experiencia tiene");
        			registro.textTres.setVisible(false);
        			registro.opciones_1.setVisible(false);
        			registro.opciones_1.addItem("Nombre");registro.opciones_1.addItem("Experiencia");
        			registro.opciones_1.addItem("Idiomas");
        			registro.btnAyuda.setVisible(true);
        			registro.lblAyuda.setVisible(true);
        			registro.textUno.setVisible(true);
        			registro.textDos.setVisible(true);
		}else if(e.getSource()==btnDestinos) {
                    interfazDeGestion registro = new interfazDeGestion();
                    setVisible(false);
        			interfazDeGestion.numero=2;
        			registro.opciones_1.addItem("Pais");registro.opciones_1.addItem("Clima");
        			registro.opciones_1.addItem("Descripcion");registro.opciones_1.addItem("Imagenes");
        			registro.setVisible(true);
        			interfazDeGestion.textoTemp="src/archivos/listaDestinos.xml";
        			registro.lblOpcion.setText("Gestionar Guias");
        			registro.lblOpcion.setText("Gestionar Destinos");
        			registro.textUno.setText("Ciudad");
        			registro.textUno.setVisible(true);
        			registro.textTres.setText("Tipo de clima");
        			registro.textTres.setVisible(true);
        			registro.textDos.setText("descripcion");
        			registro.textDos.setVisible(true);
        			registro.btnAyuda.setVisible(true);
        			registro.lblAyuda.setVisible(true);
        			registro.opciones_1.setVisible(false);
        			registro.txtIdentificacion.setVisible(false);
        			registro.txtIdentificacion.setText("Nombre");
		}else if(e.getSource()==btnPaquetes) {
                    interfazDeGestion registro = new interfazDeGestion();
                    registro.opciones_1.addItem("Precio");registro.opciones_1.addItem("Inicio");
        			registro.opciones_1.addItem("Final");registro.opciones_1.addItem("Destinos");
        			registro.opciones_1.addItem("Cupo");
        			interfazDeGestion.numero=3;
        			interfazDeGestion.textoTemp="src/archivos/listaPaquetes.xml";
        			setVisible(false);
        			registro.setVisible(true);
        			registro.lblOpcion.setText("Gestionar Paquetes");
        			registro.textUno.setText("Fecha de Inicio");
        			registro.textUno.setVisible(true);
        			registro.textDos.setText("Fecha de fin");
        			registro.textDos.setVisible(true);
        			registro.textTres.setText("Duracion");
        			registro.textTres.setVisible(true);
        			registro.textCuatro.setText("Cupo");
        			registro.textCuatro.setVisible(true);
        			registro.btnAyuda.setVisible(true);
        			registro.lblAyuda.setVisible(true);
        			registro.lblAyuda.setText("Ingrese los Destinos");
        			registro.btnAyuda.setText("Ingresar los Destinos");
        			registro.opciones_1.setVisible(false);
        			registro.txtIdentificacion.setText("Nombre");	
        			registro.txtNombre.setText("Precio");	
		}else if(e.getSource()==btnVentas) {
			
		}else if(e.getSource()==btnCerrar) {
			inicio frame=new inicio();
			frame.setVisible(true);
			setVisible(false);
		}
	}
	
}

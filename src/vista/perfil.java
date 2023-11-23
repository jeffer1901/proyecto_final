package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.contCliente;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class perfil extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnActualizar;
	public JLabel lblNombre,lblCedula,lblCorreo,lblNumero,lblDireccion;
	public JButton btnRegresar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					perfil frame = new perfil();
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
	public perfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 135, 182);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cuenta");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(145, 0, 339, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(145, 58, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(349, 196, 125, 23);
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
		lblNombre = new JLabel("New label");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(257, 60, 217, 14);
		contentPane.add(lblNombre);
		
		lblCedula = new JLabel("New label");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCedula.setBounds(257, 84, 217, 14);
		contentPane.add(lblCedula);
		
		 lblCorreo = new JLabel("New label");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCorreo.setBounds(257, 108, 217, 14);
		contentPane.add(lblCorreo);
		
		lblNumero = new JLabel("New label");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumero.setBounds(257, 133, 217, 14);
		contentPane.add(lblNumero);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cedula:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(145, 84, 102, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Correo:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(145, 111, 102, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Numero :");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(145, 136, 102, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Direccion");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4.setBounds(145, 161, 102, 14);
		contentPane.add(lblNewLabel_2_4);
		
		 lblDireccion = new JLabel("New label");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDireccion.setBounds(257, 158, 217, 14);
		contentPane.add(lblDireccion);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegresar.setBounds(213, 196, 118, 23);
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(this);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 484, 229);
		contentPane.add(lblNewLabel_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegresar) {
			setVisible(false);
		}else if(e.getSource()==btnActualizar){
			interfazDeGestion act =new interfazDeGestion();
			act.lblOpcion.setText("Actualizar Datos");
			act.textUno.setVisible(false);
			act.txtNombre.setVisible(false);
			act.textUno.setVisible(false);
			act.textTres.setVisible(false);
			act.textDos.setVisible(false);
			act.textCuatro.setVisible(false);
			act.txtIdentificacion.setVisible(false);
			act.lblAyuda.setVisible(false);
			act.btnAyuda.setVisible(false);
			act.opciones.setVisible(false);
			act.btnA.setText("Actualizar");
			act.opciones_1.addItem("Nombre del cliente");act.opciones_1.addItem("Numero");
			act.opciones_1.addItem("Direccion");act.opciones_1.addItem("Correo");
			act.setVisible(true);
			setVisible(false);
			interfazDeGestion.numero=5;
		}
		
	}
}

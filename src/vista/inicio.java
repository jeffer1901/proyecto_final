package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ComunicacionCliente;
import controlador.contCliente;
import modelo.Cliente;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class inicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JToggleButton toggleButton;
    private Timer timer;
    public JButton btnIniciar, btnRegistrarse,btnNewButton,btnCerrar,btnReservar,btnDestinos,btnPaquetes;
    private JPanel panel=new JPanel();
    public JLabel lblNewLabel,lblNewLabel_2,lblNewLabel_3,lblNombreTemp,lblNewLabel_4,lblOlvido;
    public static String cedulaTemp;
    public static int numTemp,numero;
    public static Cliente cliente=new Cliente();
  
	 
    private int targetX = 0;
    private boolean panelVisible = false;
    public JTextField textUsuario;
    public JTextField textContraseña;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
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
	 public inicio() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 754, 407);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        panel.setBackground(new Color(102, 153, 255));
	        panel.setBounds(-184, 0, 186, 368);
	        panel.setOpaque(true);
	        contentPane.add(panel);
	        panel.setLayout(null);
	        
	        lblNewLabel = new JLabel("Iniciar Sesion");
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 19));
	        lblNewLabel.setBounds(10, 11, 172, 31);
	        panel.add(lblNewLabel);
	        
	        textUsuario = new JTextField();
	        textUsuario.setBounds(20, 138, 149, 20);
	        panel.add(textUsuario);
	        textUsuario.setColumns(10);
	        
	        JLabel lblNewLabel_1 = new JLabel("New label");
	        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yefer\\Downloads\\imagen_2023-11-18_232522623.png"));
	        lblNewLabel_1.setBounds(56, 44, 82, 83);
	        panel.add(lblNewLabel_1);
	        
	        lblNewLabel_2 = new JLabel("Usuario");
	        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2.setBounds(20, 124, 46, 14);
	        panel.add(lblNewLabel_2);
	        
	        textContraseña = new JTextField();
	        textContraseña.setColumns(10);
	        textContraseña.setBounds(20, 184, 149, 20);
	        panel.add(textContraseña);
	        
	        lblNewLabel_3 = new JLabel("Contraseña");
	        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_3.setBounds(10, 169, 76, 14);
	        panel.add(lblNewLabel_3);
	        
	        btnIniciar = new JButton("Iniciar Sesion");
	        btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 10));
	        btnIniciar.setBounds(42, 234, 105, 23);
	        panel.add(btnIniciar);
	        btnIniciar.addActionListener(this);
	        
	        btnRegistrarse = new JButton("Registrarse");
	        btnRegistrarse.setBounds(20, 268, 149, 23);
	        panel.add(btnRegistrarse);
	        btnRegistrarse.addActionListener(this);
	        
	        lblOlvido = new JLabel("Olvide contraseña");
	        lblOlvido.setBounds(64, 209, 105, 14);
	        panel.add(lblOlvido);
	        
	        lblNewLabel_4 = new JLabel("Bienvenido");
	        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_4.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
	        lblNewLabel_4.setBounds(20, 141, 149, 17);
	        panel.add(lblNewLabel_4);
	        lblNewLabel_4.setVisible(false);
	        
	        lblNombreTemp = new JLabel("New label");
	        lblNombreTemp.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNombreTemp.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNombreTemp.setBounds(10, 169, 172, 14);
	        panel.add(lblNombreTemp);
	        lblNombreTemp.setVisible(false);
	        
	        btnNewButton = new JButton("Ver Perfil");
	        btnNewButton.setBounds(56, 223, 89, 23);
	        panel.add(btnNewButton);
	        btnNewButton.setVisible(false);
	        btnNewButton.addActionListener(this);

	        JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
	        tglbtnNewToggleButton.setIcon(new ImageIcon("C:\\Users\\yefer\\Downloads\\imagen_2023-11-18_234118846.png"));
	        tglbtnNewToggleButton.setBounds(0, 0, 29, 33);
	        contentPane.add(tglbtnNewToggleButton);
	        toggleButton = tglbtnNewToggleButton; // Asigna el botón al campo de clase
	        
	        btnDestinos = new JButton("New button");
	        btnDestinos.setIcon(new ImageIcon("C:\\Users\\yefer\\Downloads\\imagen_2023-11-22_183142650.png"));
	        btnDestinos.setBounds(153, 70, 175, 165);
	        contentPane.add(btnDestinos);
	        btnDestinos.addActionListener(this);
	        
	       btnPaquetes = new JButton("New button");
	        btnPaquetes.setIcon(new ImageIcon(inicio.class.getResource("/archivos/destinosd.png")));
	        btnPaquetes.setBounds(402, 70, 175, 165);
	        contentPane.add(btnPaquetes);
	        btnPaquetes.addActionListener(this);
	        
	        btnReservar = new JButton("Reservar");
	        btnReservar.setBounds(608, 318, 120, 23);
	        contentPane.add(btnReservar);
	        btnReservar.addActionListener(this);
	        
	        btnCerrar = new JButton("Cerrar Sesion");
	        btnCerrar.setBounds(473, 318, 125, 23);
	        contentPane.add(btnCerrar);
	        btnCerrar.addActionListener(this);
	        
	        JButton btnChat = new JButton("New button");
	        btnChat.setIcon(new ImageIcon("C:\\Users\\yefer\\Downloads\\imagen_2023-11-22_182421924.png"));
	        btnChat.setBounds(91, 296, 62, 61);
	        contentPane.add(btnChat);
	        
	        JLabel lblNewLabel_5 = new JLabel("Agencia de viajes UQ");
	        lblNewLabel_5.setBackground(new Color(0, 153, 255));
	        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 26));
	        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_5.setBounds(28, 0, 710, 33);
	        lblNewLabel_5.setOpaque(true);
	        contentPane.add(lblNewLabel_5);
	        
	        lblNewLabel_6 = new JLabel("Chat de ayuda");
	        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        lblNewLabel_6.setBounds(48, 271, 125, 14);
	        contentPane.add(lblNewLabel_6);
	        
	        lblNewLabel_7 = new JLabel("Ver Paquetes");
	        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_7.setBounds(153, 246, 175, 14);
	        contentPane.add(lblNewLabel_7);
	        
	        lblNewLabel_8 = new JLabel("Ver Destinos");
	        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        lblNewLabel_8.setBounds(402, 246, 175, 14);
	        contentPane.add(lblNewLabel_8);
	        
	        lblNewLabel_9 = new JLabel("New label");
	        lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\yefer\\Downloads\\registro (3).png"));
	        lblNewLabel_9.setBounds(0, 32, 738, 334);
	        contentPane.add(lblNewLabel_9);

	        tglbtnNewToggleButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                togglePanel();
	            }
	        });
	    }

	    private void togglePanel() {
	        int initialX = panel.getX();
	        int finalX = panelVisible ? -200 : 0; // Ajusta la posición final del panel

	        timer = new Timer(10, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if ((panelVisible && panel.getX() > finalX) || (!panelVisible && panel.getX() < finalX)) {
	                    int step = panelVisible ? -2 : 2; // Ajusta la velocidad del deslizamiento
	                    panel.setLocation(panel.getX() + step, panel.getY());
	                    toggleButton.setLocation(toggleButton.getX() + step, toggleButton.getY()); // Ajustar posición del botón
	                    revalidate();
	                    repaint();
	                } else {
	                    timer.stop();
	                    panelVisible = !panelVisible;
	                }
	            }
	        });

	        timer.start();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnRegistrarse) {
				interfazDeGestion registro=new interfazDeGestion();
				interfazDeGestion.numero=4;
				interfazDeGestion.textoTemp="src/archivos/listaClientes1.xml";
				registro.setVisible(true);
				setVisible(false);
				registro.setVisible(true);
				registro.lblOpcion.setText("Registrarse");
				registro.textUno.setText("Numero");
				registro.textUno.setVisible(true);
				registro.textTres.setText("Direccion");
				registro.textTres.setVisible(true);
				registro.textDos.setText("Correo");
				registro.textDos.setVisible(true);
				registro.textCuatro.setText("Contraseña");
				registro.btnA.setText("Registrarse");
				registro.btnAyuda.setVisible(false);
				registro.lblAyuda.setVisible(false);
				registro.opciones_1.setVisible(false);
				registro.opciones.setVisible(false);
				registro.txtIdentificacion.setVisible(true);
				registro.txtIdentificacion.setText("Cedula");	
			}else if(e.getSource()==btnIniciar) {
				ArrayList<Cliente> lista=contCliente.cargarLista("src/archivos/listaClientes1.xml");
				cedulaTemp=textUsuario.getText();
				String contraseña=textContraseña.getText();
				for(int i=0;i<lista.size();i++) {
					if(cedulaTemp.equals(lista.get(i).getCedula()) && contraseña.equals(lista.get(i).getContraseña())) {
						numTemp=1;
						break;
					}
				}
				System.out.println(numTemp);
				if(numTemp==1) {
					for(int i=0;i<lista.size();i++) {
						if(cedulaTemp.equals(lista.get(i).getCedula())) {
							cliente=lista.get(i);
						}
					}
					btnNewButton.setVisible(true);
					lblNombreTemp.setText(cliente.getNombre());
					lblNombreTemp.setVisible(true);
					btnIniciar.setVisible(false);
					btnRegistrarse.setVisible(false);
					 lblNewLabel_3.setVisible(false);
					 lblNewLabel_2.setVisible(false);
					 textContraseña.setVisible(false);
					 textUsuario.setVisible(false);
					 lblNewLabel.setVisible(false);
					 lblNewLabel_4.setVisible(true);
					 lblOlvido.setVisible(false);
					 numero=1;
				}else if(numTemp==2) {
					admin frame=new admin();
					frame.setVisible(true);
					setVisible(false);
					frame.nombre_admin.setText("Bienvenido Administrador");
				}else {
					JOptionPane.showMessageDialog(null,"Usuario o Contraseña incorrectas");
				}
			}if(e.getSource()==btnNewButton) {
				perfil per=new perfil();
				per.setVisible(true);
				per.lblNombre.setText(contCliente.conseguir(contCliente.listaClientes, 0,cedulaTemp , "Nombre"));
				per.lblCedula.setText(cedulaTemp);
				per.lblCorreo.setText(contCliente.conseguir(contCliente.listaClientes, 0,cedulaTemp , "Correo"));
				per.lblDireccion.setText(contCliente.conseguir(contCliente.listaClientes, 0,cedulaTemp , "Direccion"));
				per.lblNumero.setText(contCliente.conseguir(contCliente.listaClientes, 0,cedulaTemp , "Numero"));
			}else if(e.getSource()==btnDestinos) {
				mostrarDesti md=new mostrarDesti();
				md.setVisible(true);
			}else if(e.getSource()==btnReservar) {
				reservar rs=new reservar();
				rs.setVisible(true);
				setVisible(false);
			}else if(e.getSource()==btnCerrar) {
				setVisible(false);
			}else if(e.getSource()==btnPaquetes) {
				mostrar m=new mostrar();
				m.setVisible(true);
			}
			
		}
}

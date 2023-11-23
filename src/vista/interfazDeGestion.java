package vista;
import controlador.*;
import modelo.Cliente;
import modelo.Destinos;
import modelo.Guia;
import modelo.Paquetes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.naming.CommunicationException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.Color;

public class interfazDeGestion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNombre,txtIdentificacion,textUno,textTres,textDos,textCuatro;
	public JButton btnAyuda,btnA;
	public JLabel lblAyuda,lblOpcion;
	public JComboBox opciones;
	public static String textoTemp;
	public static int numero=0,tamaño=0;
	private String[] arregloTemp=new String[4];
	private String[] arregloTemp2=new String[4];
	public JComboBox opciones_1;
	public static ArrayList<String> arrayTemp= new ArrayList<String>();
	public static ArrayList<Destinos> temp=new ArrayList<Destinos>();
	DefaultListModel<String> modelo= new DefaultListModel<String>();
	DefaultListModel<String> modelo1= new DefaultListModel<String>();
	JButton btnCancelar;
	private JLabel lblNewLabel;
	 private ObjectInputStream objectInputStream;
	public static int numero5=0;
	 Guia objeto=new Guia();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazDeGestion frame = new interfazDeGestion();
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
	public interfazDeGestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] opcionesBox = {"Agregar", "Actualizar", "Eliminar"};
		opciones = new JComboBox(opcionesBox);
		opciones.setBounds(235, 271, 113, 22);
		contentPane.add(opciones);
		opciones.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   
                    String seleccion = (String) opciones.getSelectedItem(); 
                    if ("Agregar".equals(seleccion)) {
                    	  btnA.setText(seleccion);
                      if(numero==2||numero==1||numero==3) {
                    	  btnAyuda.setVisible(true);
                          lblAyuda.setVisible(true);
                          textUno.setText("Digite el nombre");
                          txtIdentificacion.setVisible(false);
                      }
                       txtNombre.setVisible(true);
                       textUno.setVisible(true);
                       textDos.setVisible(true);
                       textTres.setVisible(false);
                       textCuatro.setVisible(false);
                       opciones_1.setVisible(false);
                    } else if ("Actualizar".equals(seleccion)) {
                    	 btnA.setText(seleccion);
                    	 txtNombre.setVisible(true);
                         textUno.setVisible(true);
                         textDos.setVisible(true);
                         if(numero==2) {
                        	 textTres.setVisible(true);
                         }
                         opciones_1.setVisible(true);
                    } else if ("Eliminar".equals(seleccion)) {
                    	 btnA.setText(seleccion);
                    	 txtIdentificacion.setVisible(true);
                    	 txtNombre.setVisible(false);
                         textUno.setVisible(false);
                         textDos.setVisible(false);
                         textTres.setVisible(false);
                         opciones_1.setVisible(false);
                         lblAyuda.setVisible(false);
                         btnAyuda.setVisible(false);
                    }
                }
            }
        });
		
		lblOpcion = new JLabel("Agregar Guia");
		lblOpcion.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		lblOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcion.setBounds(35, 11, 269, 29);
		contentPane.add(lblOpcion);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(48, 121, 287, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setText("Cedula");
		txtIdentificacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdentificacion.setBounds(48, 90, 287, 20);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		textUno = new JTextField();
		textUno.setHorizontalAlignment(SwingConstants.CENTER);
		textUno.setBounds(48, 152, 287, 20);
		contentPane.add(textUno);
		textUno.setColumns(10);
		
		textTres = new JTextField();
		textTres.setHorizontalAlignment(SwingConstants.CENTER);
		textTres.setBounds(48, 214, 287, 20);
		contentPane.add(textTres);
		textTres.setColumns(10);
		
		textDos = new JTextField();
		textDos.setHorizontalAlignment(SwingConstants.CENTER);
		textDos.setBounds(48, 183, 287, 20);
		contentPane.add(textDos);
		textDos.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnCancelar.setBackground(new Color(204, 0, 51));
		btnCancelar.setBounds(10, 304, 158, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		btnA = new JButton("Agregar");
		btnA.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnA.setBackground(new Color(51, 153, 51));
		btnA.setBounds(10, 270, 158, 23);
		contentPane.add(btnA);
		btnA.addActionListener(this);
		
		lblAyuda = new JLabel("Imagenes del destino");
		lblAyuda.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAyuda.setBounds(10, 57, 144, 22);
		contentPane.add(lblAyuda);
		
		
		btnAyuda = new JButton("Insertar imagenes");
		btnAyuda.setBounds(164, 59, 158, 23);
		contentPane.add(btnAyuda);
		btnAyuda.addActionListener(this);
		opciones_1 = new JComboBox();
		opciones_1.setBounds(235, 305, 113, 22);
		contentPane.add(opciones_1);
		opciones_1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   
                    String seleccion = (String) opciones_1.getSelectedItem(); 
                    if ("Pais".equals(seleccion)||"Nombre".equals(seleccion)||"Inicio".equals(seleccion)) {
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(true);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	textUno.setText("Dato a cambiar");

                    } else if ("Clima".equals(seleccion)||"Experiencia".equals(seleccion)||"Precio".equals(seleccion)) {
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(true);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	textUno.setText("Dato a cambiar");

                    } else if ("Descripcion".equals(seleccion)||"Final".equals(seleccion)) {
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(true);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	textUno.setText("Dato a cambiar");

                    }else if ("Imagenes".equals(seleccion)||"Idiomas".equals(seleccion)||"Destinos".equals(seleccion)) {
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(false);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(true);
                    	lblAyuda.setVisible(true);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    }else if("Cupo".equals(seleccion)) {
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(true);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	textUno.setText("Dato a cambiar");
                    }else if("Nombre del cliente".equals(seleccion)){
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(false);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	txtNombre.setText("Nombre");
                    }else if("Correo".equals(seleccion)){
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(false);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	txtNombre.setText("Correo");
                    }else if("Numero".equals(seleccion)){
                    	txtNombre.setText("Numero");
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(false);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	txtNombre.setText("Numero");
                    }else if("Direccion".equals(seleccion)){
                    	txtNombre.setText("Direccion");
                    	txtNombre.setVisible(true);
                    	textUno.setVisible(false);
                    	textTres.setVisible(false);
                    	textDos.setVisible(false);
                    	btnAyuda.setVisible(false);
                    	lblAyuda.setVisible(false);
                    	textCuatro.setVisible(false);
                    	txtIdentificacion.setVisible(false);
                    	
                    }
                }
            }
        });
		
		textCuatro = new JTextField();
		textCuatro.setHorizontalAlignment(SwingConstants.CENTER);
		textCuatro.setColumns(10);
		textCuatro.setBounds(48, 240, 287, 20);
		contentPane.add(textCuatro);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yefer\\Downloads\\registro (1).png"));
		lblNewLabel.setBounds(0, 0, 375, 365);
		contentPane.add(lblNewLabel);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(numero==1) {
			if(opciones.getSelectedItem().equals("Agregar")) {
				if(e.getSource()==btnA) {
					try {
						/***
						ComunicacionCliente.enivarString("2");
						ComunicacionCliente.enviarObjeto(new Guia(arrayTemp,Integer.parseInt(textDos.getText()),textUno.getText(),txtNombre.getText()));
						***/
						ArrayList<Guia> lista=new ArrayList<Guia>();
						lista.add(new Guia(arrayTemp,Integer.parseInt(textDos.getText()),textUno.getText(),txtNombre.getText()));
						contGuias.agregar(textoTemp, lista);
						arrayTemp.clear();
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(e.getSource()==btnAyuda) {
					 interfazAgregar gui2 = new interfazAgregar();
	                   interfazAgregar.numero=1;
	                   DefaultListModel<String> modelo1= new DefaultListModel<String>();
	                  for(int i=0;i<arrayTemp.size();i++) {
	                	  modelo1.addElement(arrayTemp.get(i));
	                  }
	                   gui2.list_1.setModel(modelo1);
	                   gui2.setVisible(true);
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
			}else if(opciones.getSelectedItem().equals("Actualizar")) {
				if(e.getSource()==btnAyuda) {
					interfazAgregar gui2 = new interfazAgregar();
	                   interfazAgregar.numero=1;
	                   gui2.list_1.setModel(modelo1);
	                   gui2.setVisible(true);
	                   
				}else if(e.getSource()==btnA){
					ArrayList<Guia> lista=new ArrayList<Guia>();
					lista=contGuias.cargarLista(textoTemp);
					for(int i=0;i<lista.size();i++) {
						if(txtNombre.getText().equals(lista.get(i).getCedula())) {
							lista.add(contGuias.actualizar(opciones_1.getSelectedItem().toString(), arrayTemp, textUno.getText(), lista.get(i)));
							lista.remove(i);
						}
							
					}
					/***
					try {
					
						ComunicacionCliente.enivarString("3");
						ComunicacionCliente.enivarString(txtNombre.getText());
						ComunicacionCliente.enivarString(textUno.getText());			
						ComunicacionCliente.enivarString(opciones_1.getSelectedItem().toString());
						for(int i=0;i<arrayTemp.size();i++) {
							System.out.println(arrayTemp.get(i));
							ComunicacionCliente.enivarString(arrayTemp.get(i));
						}
						
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					***/
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
			}else if(opciones.getSelectedItem().equals("Eliminar")) {
				if(e.getSource()==btnA) {
					contGuias.eliminarDatos(textoTemp, 0,txtIdentificacion.getText() );
					/***
					try {
						
						ComunicacionCliente.enivarString("4");
						ComunicacionCliente.enivarString(txtIdentificacion.getText());
						ComunicacionCliente.enivarString("2");
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					***/
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
				
			}
		}else if(numero==2){
			if(opciones.getSelectedItem().equals("Agregar")) {
				if(e.getSource()==btnA) {
					ArrayList<Destinos> lista=new ArrayList<Destinos>();
					try {
						/***
						ComunicacionCliente.ciudades.add(textUno.getText());
						ComunicacionCliente.enviarObjeto(new Destinos(txtNombre.getText(),textDos.getText(),textTres.getText(),textUno.getText(),arregloTemp));
						***/
						lista.add(new Destinos(txtNombre.getText(),textDos.getText(),textTres.getText(),textUno.getText(),arregloTemp));
						contDestinos.agregar(textoTemp, lista);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
				if(tamaño<4) {
					if(e.getSource()==btnAyuda) {
						arregloTemp[tamaño]=contDestinos.agregarFotos();
						tamaño++;
					}
				}else {
					JOptionPane.showMessageDialog(null,"solo se pueden agregar 4 imagenes");
				}
			}else if(opciones.getSelectedItem().equals("Actualizar")){
				if(e.getSource()==btnA) {
					try {
						/***
						ComunicacionCliente.enivarString("3");
						ComunicacionCliente.enivarString(txtNombre.getText());
						ComunicacionCliente.enivarString(textUno.getText());
						ComunicacionCliente.enivarString(opciones_1.getSelectedItem().toString());
						for(int i=0;i<4;i++) {
							ComunicacionCliente.enivarString(arregloTemp[i]);
						}
						***/
						ArrayList<Destinos> lista=new ArrayList<Destinos>();
						lista=contDestinos.actualizar(textoTemp, txtNombre.getText(), opciones_1.getSelectedItem().toString(), 0, arregloTemp, textUno.getText());
						contDestinos.serializarObjetoXML(textoTemp, lista, false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
				if(tamaño<4) {
					if(e.getSource()==btnAyuda) {
						arregloTemp[tamaño]=contDestinos.agregarFotos();
						tamaño++;
					}
				}else {
					JOptionPane.showMessageDialog(null,"solo se pueden agregar 4 imagenes");
				}
			}else if(opciones.getSelectedItem().equals("Eliminar")) {
				if(e.getSource()==btnA) {
					contDestinos.eliminarDatos(textoTemp, 0, txtIdentificacion.getText());
					/***
					try {
						ComunicacionCliente.enivarString("4");
						ComunicacionCliente.enivarString(txtIdentificacion.getText());
						ComunicacionCliente.enivarString("3");
						contDestinos.eliminarDatos(textoTemp, 0, txtIdentificacion.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					***/
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
				 
			}
		}else if(numero==3){
			if(opciones.getSelectedItem().equals("Agregar")) {
				if(e.getSource()==btnAyuda) {
					SwingUtilities.invokeLater(new Runnable() {
		                @Override
		                public void run() {
							interfazAgregar gui2 = new interfazAgregar();
			                interfazAgregar.numero=2;
			                DefaultListModel<String> modelo1= new DefaultListModel<String>();
			                ArrayList<Destinos> lista=new ArrayList<Destinos>();
			                lista=contDestinos.cargarLista("src/archivos/listaDestinos.xml");
			               for(int i=0;i<lista.size();i++) {
			             	  modelo1.addElement(lista.get(i).getCiudad());
			               }
			                gui2.list_1.setModel(modelo1);
			                 gui2.setVisible(true);
		                }
					});
				}else if(e.getSource()==btnA) {
					try {
						/***
						ComunicacionCliente.enivarString("2");
						ComunicacionCliente.enviarObjeto(new Paquetes(Double.parseDouble(txtNombre.getText()),txtIdentificacion.getText(),textUno.getText(),textDos.getText(),
						textTres.getText(),temp,Integer.parseInt(textCuatro.getText())));
						***/
						ArrayList<Paquetes> lista=new ArrayList<Paquetes>();
						lista.add(new Paquetes(Double.parseDouble(txtNombre.getText()),txtIdentificacion.getText(),textUno.getText(),textDos.getText(),
								textTres.getText(),temp,Integer.parseInt(textCuatro.getText())));
						contPaquetes.agregar(textoTemp, lista);
						temp.clear();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
			}if(opciones.getSelectedItem().equals("Actualizar")){
				if(e.getSource()==btnAyuda) {
					SwingUtilities.invokeLater(new Runnable() {
		                @Override
		                public void run() {
							interfazAgregar gui2 = new interfazAgregar();
			                interfazAgregar.numero=2;
			                DefaultListModel<String> modelo1= new DefaultListModel<String>();
			                ArrayList<Destinos> lista=new ArrayList<Destinos>();
			                lista=contDestinos.cargarLista("src/archivos/listaGuias.xml");
			               for(int i=0;i<lista.size();i++) {
			             	  modelo1.addElement(lista.get(i).getCiudad());
			               }
			                gui2.list_1.setModel(modelo1);
			                 gui2.setVisible(true);
		                }
					});
				}else if(e.getSource()==btnA) {
					ArrayList<Paquetes> lista=new ArrayList<Paquetes>();
					lista=contPaquetes.actualizar(textoTemp,txtNombre.getText(),opciones_1.getSelectedItem().toString(),0,temp,textUno.getText());
					
					try {/***
						ComunicacionCliente.enivarString("3");
						ComunicacionCliente.enivarString(txtNombre.getText());
						ComunicacionCliente.enivarString(textUno.getText());
						ComunicacionCliente.enivarString(opciones_1.getSelectedItem().toString());
						for(int i=0;i<temp.size();i++) {
							ComunicacionCliente.enviarObjeto(temp.get(i));
						}
						***/
						contPaquetes.serializarObjetoXML(textoTemp, lista, false);
						
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
			}else if(opciones.getSelectedItem().equals("Eliminar")) {
				if(e.getSource()==btnA) {
					contPaquetes.eliminarDatos(textoTemp, 0, txtIdentificacion.getText());
					/***
					try {
						
						ComunicacionCliente.enivarString("4");
						ComunicacionCliente.enivarString(txtIdentificacion.getText());
						ComunicacionCliente.enivarString("1");
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
					***/
				}else if(e.getSource()==btnCancelar){
					setVisible(false);
					admin add=new admin();
					add.setVisible(true);
				}
				
			}
		}else if(numero==4){
			if(e.getSource()==btnA) {
				try {
					/***ComunicacionCliente.enivarString("2");
					ComunicacionCliente.enviarObjeto(new Cliente(txtIdentificacion.getText(),txtNombre.getText(),textUno.getText(),
					
					textDos.getText(),textTres.getText(),textCuatro.getText()));
					***/
					ArrayList<Cliente> lista=new ArrayList<Cliente>();
					lista=contCliente.cargarLista(textoTemp);
					lista.add(new Cliente(txtNombre.getText(),txtIdentificacion.getText(),textUno.getText(),
							textTres.getText(),textDos.getText(),textCuatro.getText()));
					contCliente.agregar(textoTemp, lista);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}if(e.getSource()==btnCancelar){
				setVisible(false);
				inicio add=new inicio();
				add.setVisible(true);
			}
			
		}	
	}
}

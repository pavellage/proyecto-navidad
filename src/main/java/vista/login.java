package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;




import com.formdev.flatlaf.FlatLightLaf;
import controlador.correos;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import controlador.comprobaciones;
import controlador.passwords;
import controlador.sqlhelper;
import modelo.Usuarios;
import javax.swing.ImageIcon;
import controlador.acciones;

//autor: Pavel Lage Santos

public class login extends javax.swing.JFrame{

	private JFrame frame;
	private JLabel mandarcorreo;
	private JPanel panel_2;
	private JPasswordField contrasena;
	private JLabel lblPassword;
	private JTextField correo;
	private JButton acceder;
	private passwords p;
	private sqlhelper helper;
	private List<Object> parametros;
	private JLabel errores;
	private JLabel nocuenta;
	private JLabel cesped;
	private acciones a =new acciones();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					login window = new login();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		estilos();
		setLocationRelativeTo(null);
		frame.getRootPane().setDefaultButton(acceder);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void estilos() {
		
		a.adaptar("..\\vista\\puerta.png", acceder);
		a.adaptar("..\\vista\\cesped.png", cesped);
		correo.putClientProperty("JTextField.placeholderText", "Email");
		correo.putClientProperty("JComponent.roundRect",true);
		contrasena.putClientProperty("JTextField.placeholderText", "password");
		contrasena.putClientProperty("JComponent.roundRect",true);
		errores.putClientProperty("Label.foreground", Color.RED);
		acceder.setBackground(new Color(58,91,34));
		acceder.setForeground(Color.WHITE);
		acceder.putClientProperty("JButton.buttonType","roundRect");
	
		
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 238, 250));
		
		frame.setBounds(100, 100, 600, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		acceder = new JButton("Acceder");
		acceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 List comprobar =new ArrayList();
				
				 comprobar.add(correo);
				 comprobar.add(contrasena);
				 
				comprobaciones c =new comprobaciones();
				if(c.haydatosen(comprobar)) {
					p= new passwords();
					helper= new sqlhelper("navidad","root");
					parametros= new ArrayList<Object>();
					String vemail=correo.getText();
					parametros.add(vemail);
				try {
					
					
				
					Usuarios usuario=helper.consulta_usuarios("select * from usuarios where email like ? and permiso = 1",parametros).get(0);
					if(p.comprueba(String.valueOf(contrasena.getPassword()), usuario.getPassword())) {
						System.out.println("entrando");
						a.adaptar("..\\vista\\puerta_abierta.png", acceder);
						if(!usuario.getContrasenagenerada()) {
						inicio i = new inicio();
						i.setVisible(true);
						}else {
							renovar r= new renovar(usuario);
							
						}
						if (!errores.getText().equals("")) {
							errores.setText("");
							
						}
						
						
					}else {
						errores.setText("Contraseña incorrecta");
					}
					
				}catch(Exception ex) {
					errores.setText("El usuario no existe");
					
				}
					
					
					
				}else {
					errores.setText("Faltan campos");
				}
			}
		});
		
		acceder.setBounds(101, 363, 404, 32);
		frame.getContentPane().add(acceder);
		
		JPanel opcioneslogin = new JPanel();
		opcioneslogin.setBackground(new Color(192, 238, 250));
		opcioneslogin.setBounds(91, 141, 421, 168);
		frame.getContentPane().add(opcioneslogin);
		opcioneslogin.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 238, 250));
		panel.setBounds(0, 0, 421, 62);
		opcioneslogin.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo electronico");
		lblNewLabel.setBounds(10, 0, 138, 14);
		panel.add(lblNewLabel);
		
		correo = new JTextField();
		correo.setColumns(10);
		correo.setBounds(10, 24, 404, 32);
		panel.add(correo);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 238, 250));
		panel_2.setBounds(0, 60, 421, 84);
		opcioneslogin.add(panel_2);
		panel_2.setLayout(null);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(10, 23, 404, 32);
		panel_2.add(contrasena);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 0, 94, 14);
		panel_2.add(lblPassword);
		
		mandarcorreo = new JLabel("Olvide la contraseña");
		mandarcorreo.setBounds(290, 60, 124, 14);
		panel_2.add(mandarcorreo);
		
		JLabel lblNewLabel_1 = new JLabel("Acceder como usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(91, 11, 238, 55);
		frame.getContentPane().add(lblNewLabel_1);
		
		errores = new JLabel("");
		errores.setBounds(91, 307, 366, 21);
		frame.getContentPane().add(errores);
		
		JLabel lblNewLabel_2 = new JLabel("¿No tienes cuenta?");
		lblNewLabel_2.setBounds(101, 405, 119, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		nocuenta = new JLabel("Registrarse");
		nocuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 new registrarse();
				
			}
		});
		nocuenta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nocuenta.setForeground(new Color(0, 128, 255));
		nocuenta.setBounds(230, 401, 83, 28);
		frame.getContentPane().add(nocuenta);
		
		cesped = new JLabel("");
		cesped.setBounds(0, 462, 586, 89);
		frame.getContentPane().add(cesped);
		
		
		
		
		
		mandarcorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mandarcorreo.setForeground(Color.GREEN);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mandarcorreo.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (!correo.getText().equals("")) {
					acciones a= new acciones();
				
					a.cambiarContrasena(correo.getText());
			}
			}
		});
	}
}
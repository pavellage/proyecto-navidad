package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.acciones;
import controlador.comprobaciones;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.event.ChangeEvent;
import controlador.sqlhelper;
import controlador.passwords;
import java.awt.Font;
//autor: Pavel Lage Santos
public class registrarseadmin extends javax.swing.JFrame{

	private JFrame frame;
	private JTextField nombre;
	private JTextField correo;
	private JPasswordField contrasena;
	private JCheckBox condiciones;
	private JButton registrarse;
	private JLabel errores;
	private JLabel cesped;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarseadmin window = new registrarseadmin();
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
	public registrarseadmin() {
		//initComponents();
		initialize();
		estilos();
		setLocationRelativeTo(null);
		frame.getRootPane().setDefaultButton(registrarse);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void estilos() {
		acciones a =new acciones();
		a.adaptar("..\\vista\\cesped.png", cesped);
		correo.putClientProperty("JTextField.placeholderText", "Email");
		correo.putClientProperty("JComponent.roundRect",true);
		contrasena.putClientProperty("JTextField.placeholderText", "password");
		contrasena.putClientProperty("JComponent.roundRect",true);
		nombre.putClientProperty("JTextField.placeholderText", "nombre");
		nombre.putClientProperty("JComponent.roundRect",true);
		registrarse.setBackground(new Color(58,91,34));
		registrarse.setForeground(Color.WHITE);
		registrarse.putClientProperty("JButton.buttonType","roundRect");
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 238, 250));
		frame.setVisible(true);
		frame.setBounds(100, 100, 641, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel opcioneslogin = new JPanel();
		opcioneslogin.setBackground(new Color(192, 238, 250));
		opcioneslogin.setLayout(null);
		opcioneslogin.setBounds(91, 83, 470, 235);
		frame.getContentPane().add(opcioneslogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 238, 250));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 423, 69);
		opcioneslogin.add(panel_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 0, 94, 14);
		panel_1.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(10, 24, 404, 32);
		panel_1.add(nombre);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 238, 250));
		panel.setLayout(null);
		panel.setBounds(0, 65, 423, 69);
		opcioneslogin.add(panel);
		
		JLabel lblNewLabel = new JLabel("Correo electronico");
		lblNewLabel.setBounds(10, 0, 94, 14);
		panel.add(lblNewLabel);
		
		correo = new JTextField();
		correo.setColumns(10);
		correo.setBounds(10, 24, 404, 32);
		panel.add(correo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 238, 250));
		panel_2.setLayout(null);
		panel_2.setBounds(0, 133, 423, 69);
		opcioneslogin.add(panel_2);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(10, 23, 404, 32);
		panel_2.add(contrasena);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 0, 94, 14);
		panel_2.add(lblPassword);
		
		condiciones = new JCheckBox("Estoy de acuerdo con los terminos y condiciones");
		condiciones.setBackground(new Color(192, 238, 250));
		condiciones.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(condiciones.isSelected()) {
					registrarse.setEnabled(true);
					
				}else {
					registrarse.setEnabled(false);
					
				}
			}
		});
		condiciones.setBounds(0, 208, 296, 21);
		opcioneslogin.add(condiciones);
		
		registrarse = new JButton("Registrarse");
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 List comprobar =new ArrayList();
				 comprobar.add(nombre);
				 comprobar.add(correo);
				 comprobar.add(contrasena);
				 
				comprobaciones c =new comprobaciones();
				
				if(c.haydatosen(comprobar)) {
					passwords p=new passwords();
					//System.out.println("Registrando usuario en la BBDD");
					String vnombre = nombre.getText();
					String vpassword = p.encriptar(String.valueOf(contrasena.getPassword()));
					String vcorreo = correo.getText();
					Boolean vcontrasenagenerada= false;
					boolean vcondiciones=condiciones.isSelected();
					int vpermiso=2;
					
					String sql="insert into usuarios(nombre, password,email,terminosuso, permiso) values (?,?,?,?,?)";
					try {
					sqlhelper helper= new sqlhelper("navidad", "root");
					
					boolean insertar=helper.insertausuario(sql, vnombre, vpassword,vcorreo, vcondiciones, vpermiso,vcontrasenagenerada);
					if( insertar==false) {
						errores.setText("El correo ya esta usado");
						
					}else {
						errores.setText("Usuario registrado correctamente");
						
					}
					}catch(Exception ex) {
						errores.setText("No se ha podido conectar con la base de datos");
					}
				}else {
					errores.setText("Faltan campos");
				}
				
			}
		});
		registrarse.setEnabled(false);
		registrarse.setBounds(101, 356, 404, 32);
		frame.getContentPane().add(registrarse);
		
		errores = new JLabel("");
		errores.setBounds(86, 337, 345, 13);
		frame.getContentPane().add(errores);
		
		JLabel lblNewLabel_1 = new JLabel("Registrarse como admin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(91, 11, 238, 55);
		frame.getContentPane().add(lblNewLabel_1);
		
		cesped = new JLabel("");
		cesped.setBounds(0, 423, 627, 97);
		frame.getContentPane().add(cesped);
	}
}

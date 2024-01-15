package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import controlador.acciones;
import modelo.Usuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//autor: Pavel Lage Santos
public class renovar {

	private JFrame frame;
	private JPasswordField nueva;
	private JPasswordField antigua;
	private static Usuarios usuario;
	private acciones a = new acciones();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					renovar window = new renovar(usuario);
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
	public renovar(Usuarios usuario) {
		initialize();
		this.usuario=usuario;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password antigua");
		lblNewLabel.setBounds(42, 24, 203, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password nueva");
		lblNewLabel_1.setBounds(42, 109, 203, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		nueva = new JPasswordField();
		nueva.setBounds(42, 144, 301, 19);
		frame.getContentPane().add(nueva);
		
		antigua = new JPasswordField();
		antigua.setBounds(42, 47, 301, 19);
		frame.getContentPane().add(antigua);
		
		JButton btnNewButton = new JButton("Cambiar contraseña");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.cambiarContrasena(usuario, String.valueOf(nueva.getPassword()), String.valueOf(antigua.getPassword()));
				
			}
		});
		btnNewButton.setBounds(128, 196, 215, 21);
		frame.getContentPane().add(btnNewButton);
	}
}

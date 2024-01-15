package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
//autor: Pavel Lage Santos
public class inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel fondo = new JPanel();
		fondo.setBounds(0, 0, 542, 605);
		contentPane.add(fondo);
		fondo.setLayout(null);
		
		JPanel menu_clientes = new JPanel();
		menu_clientes.setBounds(10, 115, 336, 21);
		fondo.add(menu_clientes);
		menu_clientes.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio");
		lblNewLabel.setBounds(10, 0, 49, 14);
		menu_clientes.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hardware");
		lblNewLabel_1.setBounds(49, 0, 69, 14);
		menu_clientes.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Software");
		lblNewLabel_2.setBounds(140, 0, 68, 14);
		menu_clientes.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Accesorios");
		lblNewLabel_3.setBounds(217, 0, 69, 14);
		menu_clientes.add(lblNewLabel_3);
		
		JPanel cabeceraLista = new JPanel();
		cabeceraLista.setBounds(10, 147, 478, 49);
		fondo.add(cabeceraLista);
		cabeceraLista.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 17, 214, 21);
		cabeceraLista.add(separator);
		
		JLabel filtros = new JLabel("Filtros");
		filtros.setBounds(369, 0, 49, 14);
		cabeceraLista.add(filtros);
		
		JLabel lblNewLabel_4 = new JLabel("Agregado recientemente");
		lblNewLabel_4.setBounds(10, 0, 214, 14);
		cabeceraLista.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel novedades = new JPanel();
		novedades.setBounds(20, 207, 475, 387);
		fondo.add(novedades);
		novedades.setLayout(null);
		
		JPanel novedad = new JPanel();
		novedad.setBounds(0, 0, 153, 175);
		novedades.add(novedad);
		novedad.setLayout(null);
		
		JLabel fotoNovedad = new JLabel("");
		fotoNovedad.setBounds(0, 0, 153, 90);
		novedad.add(fotoNovedad);
		
		JLabel descripcion = new JLabel("");
		descripcion.setBounds(0, 94, 153, 29);
		novedad.add(descripcion);
		
		JButton botonComprar = new JButton("Ver producto");
		botonComprar.setIcon(null);
		botonComprar.setBounds(10, 134, 133, 23);
		novedad.add(botonComprar);
		
		JPanel novedad_1 = new JPanel();
		novedad_1.setLayout(null);
		novedad_1.setBounds(163, 0, 153, 175);
		novedades.add(novedad_1);
		
		JLabel fotoNovedad_1 = new JLabel("");
		fotoNovedad_1.setBounds(0, 0, 153, 90);
		novedad_1.add(fotoNovedad_1);
		
		JLabel descripcion_1 = new JLabel("");
		descripcion_1.setBounds(0, 94, 153, 29);
		novedad_1.add(descripcion_1);
		
		JButton botonComprar_1 = new JButton("Ver producto");
		botonComprar_1.setBounds(10, 134, 133, 23);
		novedad_1.add(botonComprar_1);
		
		JPanel novedad_2 = new JPanel();
		novedad_2.setLayout(null);
		novedad_2.setBounds(322, 0, 153, 175);
		novedades.add(novedad_2);
		
		JLabel fotoNovedad_2 = new JLabel("");
		fotoNovedad_2.setBounds(0, 0, 153, 90);
		novedad_2.add(fotoNovedad_2);
		
		JLabel descripcion_2 = new JLabel("");
		descripcion_2.setBounds(0, 94, 153, 29);
		novedad_2.add(descripcion_2);
		
		JButton botonComprar_2 = new JButton("Ver producto");
		botonComprar_2.setBounds(10, 134, 133, 23);
		novedad_2.add(botonComprar_2);
		
		JPanel novedad_3 = new JPanel();
		novedad_3.setLayout(null);
		novedad_3.setBounds(0, 186, 153, 175);
		novedades.add(novedad_3);
		
		JLabel fotoNovedad_3 = new JLabel("");
		fotoNovedad_3.setBounds(0, 0, 153, 90);
		novedad_3.add(fotoNovedad_3);
		
		JLabel descripcion_3 = new JLabel("");
		descripcion_3.setBounds(0, 94, 153, 29);
		novedad_3.add(descripcion_3);
		
		JButton botonComprar_3 = new JButton("Ver producto");
		botonComprar_3.setBounds(10, 134, 133, 23);
		novedad_3.add(botonComprar_3);
		
		JPanel novedad_4 = new JPanel();
		novedad_4.setLayout(null);
		novedad_4.setBounds(163, 186, 153, 175);
		novedades.add(novedad_4);
		
		JLabel fotoNovedad_4 = new JLabel("");
		fotoNovedad_4.setBounds(0, 0, 153, 90);
		novedad_4.add(fotoNovedad_4);
		
		JLabel descripcion_4 = new JLabel("");
		descripcion_4.setBounds(0, 94, 153, 29);
		novedad_4.add(descripcion_4);
		
		JButton botonComprar_4 = new JButton("Ver producto");
		botonComprar_4.setBounds(10, 134, 133, 23);
		novedad_4.add(botonComprar_4);
		
		JPanel novedad_5 = new JPanel();
		novedad_5.setLayout(null);
		novedad_5.setBounds(322, 186, 153, 175);
		novedades.add(novedad_5);
		
		JLabel fotoNovedad_5 = new JLabel("");
		fotoNovedad_5.setBounds(0, 0, 153, 90);
		novedad_5.add(fotoNovedad_5);
		
		JLabel descripcion_5 = new JLabel("");
		descripcion_5.setBounds(0, 94, 153, 29);
		novedad_5.add(descripcion_5);
		
		JButton btnVerProducto = new JButton("Ver producto");
		btnVerProducto.setBounds(10, 134, 133, 23);
		novedad_5.add(btnVerProducto);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(216, 23, 106, 65);
		fondo.add(lblNewLabel_5);
	}
}

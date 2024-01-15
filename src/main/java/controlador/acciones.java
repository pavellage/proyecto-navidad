package controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.Productos;
import modelo.Usuarios;

//autor: Pavel Lage Santos

public class acciones {
public acciones() {
	
	
	
}

public void comprar(Productos p, int cantidad) {
	//comprobar si es cliente
	//llamar a sqlhelper y hacer una consulta para ver cuantas unidades hay
	//si hay unidades, llamar a sqlhelper y hacer un update para restar n unidades, si no, mostrar en errores, no hay stock
	//si hay unidades, pero no tantas como pide mostrar un mensaje, solo hay x unidades en stock y dar opcion a cacelar y seguir con la compra
	
}

public void adaptar(String ruta,JLabel hueco) {
	
	Image img = new ImageIcon(getClass().getResource(ruta)).getImage();
	Image newimg = img.getScaledInstance(hueco.getWidth(), hueco.getHeight(),  java.awt.Image.SCALE_SMOOTH);
	ImageIcon imageIcon = new ImageIcon(newimg); 
	hueco.setIcon(imageIcon);
	
	
}

public void adaptar(String ruta,JButton hueco) {
	
	Image img = new ImageIcon(getClass().getResource(ruta)).getImage();
	Image newimg = img.getScaledInstance(hueco.getHeight(), hueco.getHeight(),  java.awt.Image.SCALE_SMOOTH);
	ImageIcon imageIcon = new ImageIcon(newimg); 
	hueco.setIcon(imageIcon);
	
	
}

public void cambiarContrasena(Usuarios usuario, String passwordnueva, String passwordantigua) {
	passwords p1=new passwords();
	sqlhelper helper= new sqlhelper("navidad","root");
	List parametros=new ArrayList();
	
	
	if(p1.comprueba(passwordantigua, usuario.getPassword())) {
		parametros.add(p1.encriptar(passwordnueva));
		parametros.add(usuario.getEmail());
		helper.modifica_usuario("update usuarios set password = ? where email like ?", parametros);
		parametros.clear();
		parametros.add(usuario.getEmail());
		helper.modifica_usuario("update usuarios set contrasenagenerada = false where email like ?", parametros);
	}
	
	
	
	
	
	
} 

public void cambiarContrasena(String email) {
	
	
	sqlhelper helper= new sqlhelper("navidad","root");
	List parametros=new ArrayList();
	
	passwords p1=new passwords();
	 correos c1= new correos();
	 String nueva=p1.generaraleatoria();
	 c1.prepararymandara(email,nueva);
	 helper= new sqlhelper("navidad","root");
	 parametros=new ArrayList();
	 parametros.add(p1.encriptar(nueva));
	 parametros.add(email);
	 System.out.println(nueva);
	 
	 helper.modifica_usuario("update usuarios set password = ? where email like ?", parametros);
	 
	 parametros.clear();
	 parametros.add(email);
	 helper.modifica_usuario("update usuarios set contrasenagenerada = true where email like ?", parametros);
	
	
}

public void registrar (Usuarios u) {
	
	
}



}


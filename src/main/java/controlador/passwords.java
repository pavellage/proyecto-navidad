package controlador;
import com.password4j.*;
//autor: Pavel Lage Santos
public class passwords {
public passwords() {
	
}
public String generaraleatoria() {
	String caracteres= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	String pw=""; 
			for(int i=0;i<(10+(int)(Math.random()*10));i++) {
				pw=pw+caracteres.charAt((int)(Math.random()*caracteres.length()));
				
			}
	return(pw);
}

public String encriptar(String password) {
	
	
	return(Password.hash(password).withBcrypt().getResult());
}
public boolean comprueba(String password,String hash) {
	boolean correcto=false;
	BcryptFunction cifrado = BcryptFunction.getInstance(10);
	correcto=cifrado.check(password,hash);
	return correcto;
	
}
}



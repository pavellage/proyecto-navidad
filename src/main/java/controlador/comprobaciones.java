package controlador;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//autor: Pavel Lage Santos
public class comprobaciones {
	void comprobaciones() {
	
	}
	public boolean haydatosen(List<Object> campos) {
		boolean hay=false;
		int rellenos=0;
		for(int i=0;i<campos.size();i++) {
			
			if(campos.get(i).getClass().getName().contains("TextField")) {
				JTextField campo= (JTextField)campos.get(i);
				if(!campo.getText().equals("")) {
					rellenos=rellenos+1;
				
					
				}
			}
			
			if(campos.get(i).getClass().getName().contains("PasswordField")) {
				JPasswordField campo= (JPasswordField)campos.get(i);
				if(!String.valueOf(campo.getPassword()).equals("")) {
					rellenos=rellenos+1;
					
					
					
				}
			}
			
		}
		if(rellenos==(campos.size())) {
			hay=true;
			
		}
		
		
		
		return(hay);
	}

}

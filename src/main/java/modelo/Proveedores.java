package modelo;
// Generated 14 dic 2023 18:54:12 by Hibernate Tools 6.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Proveedores generated by hbm2java
 */
public class Proveedores implements java.io.Serializable {

	private int id;
	private String cif;
	

	public Proveedores() {
	}

	public Proveedores(int id, String cif) {
		this.id = id;
		this.cif = cif;
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	

}
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Clientes;
import modelo.Compras;
import modelo.Productos;
import modelo.Proveedores;
import modelo.Usuarios;
//autor: Pavel Lage Santos
public class sqlhelper {
	Connection conex;
	public sqlhelper(String bbdd, String usuario) {
		try {
			conex=DriverManager.getConnection("jdbc:mysql://localhost/"+bbdd,usuario,"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void cogeparametros(PreparedStatement sentencia, List<Object> parametros) {
		try {
		for(int i=0;i<parametros.size();i++) {
			if(parametros.get(i).getClass().getName().contains("String")) {
				sentencia.setString(i+1, (String)parametros.get(i));
			
			}else if(parametros.get(i).getClass().getName().contains("Float")) {
				sentencia.setFloat(i+1, (Float)parametros.get(i));
				
			}else if(parametros.get(i).getClass().getName().contains("Integer")) {
				sentencia.setInt(i+1, (Integer)parametros.get(i));
			
			}else if(parametros.get(i).getClass().getName().contains("Boolean")) {
				sentencia.setBoolean(i+1, (Boolean)parametros.get(i));
			
			}else if(parametros.get(i).getClass().getName().contains("Byte")) {
				sentencia.setByte(i+1, (Byte)parametros.get(i));
				
			}else if(parametros.get(i).getClass().getName().contains("Double")) {
				sentencia.setDouble(i+1, (Double)parametros.get(i));
				
			}
		
			System.out.println("[DEBUG] se ha introducido un parametro tipo "+parametros.get(i).getClass().getName());
		}
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
	}
	
	public void modifica_cliente(String sql) {
		
		try {
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/navidad", "root","");
			PreparedStatement sentencia =(PreparedStatement) conexion.prepareStatement(sql);
			
			sentencia.executeUpdate();
			
			
			sentencia.close();
			conexion.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		}
	
public void modifica_usuario(String sql,List<Object> parametros) {
			
		try {
			conex=DriverManager.getConnection("jdbc:mysql://localhost/navidad", "root","");
			
			PreparedStatement sentencia =(PreparedStatement) conex.prepareStatement(sql);
			cogeparametros(sentencia,parametros);
			sentencia.executeUpdate();
			
			
			sentencia.close();
			conex.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		}

	public List<Clientes> consulta_cliente(String sql) {
		List<Clientes> clientes =new ArrayList<Clientes>();
		try {
			
			PreparedStatement sentencia =(PreparedStatement) conex.prepareStatement(sql);
			
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()) {
				Clientes c1=new Clientes(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("apellido1"),resultado.getString("apellido2"),resultado.getBytes("esFrecuente"),resultado.getString("telefono"),resultado.getString("direccion_postal"),resultado.getString("nif"),resultado.getString("email"));
				clientes.add(c1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return(clientes);
	}
	
	public List<Compras> consulta_compra(String sql) {
		List<Compras> compras =new ArrayList<Compras>();
		try {
			
			PreparedStatement sentencia =(PreparedStatement) conex.prepareStatement(sql);
			
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()) {
				Compras c1=new Compras(resultado.getInt("id_compra"),(Productos)resultado.getObject("producto"),(Clientes)resultado.getObject("cliente"),resultado.getInt("cantidad"),resultado.getDate("fecha"));
				compras.add(c1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return(compras);
	}
	
	public List<Productos> consulta_producto(String sql) {
		List<Productos> productos =new ArrayList<Productos>();
		try {
			
			PreparedStatement sentencia =(PreparedStatement) conex.prepareStatement(sql);
			
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()) {
				Productos p1=new Productos(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("descripcion"),resultado.getInt("precio"),resultado.getInt("stock"),resultado.getDate("fecha_alta"));
				productos.add(p1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return(productos);
	}
	
	public List<Proveedores> consulta_proveedor(String sql) {
		List<Proveedores> proveedores =new ArrayList<Proveedores>();
		try {
			
			PreparedStatement sentencia =(PreparedStatement) conex.prepareStatement(sql);
			
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()) {
				Proveedores p1=new Proveedores(resultado.getInt("id"),resultado.getString("cif"));
				proveedores.add(p1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return(proveedores);
	}
	
	public List<Usuarios> consulta_usuarios(String sql, List<Object> parametros) {
		List<Usuarios> usuarios =new ArrayList<Usuarios>();
		
		
		
		try {
			
			PreparedStatement sentencia =(PreparedStatement) conex.prepareStatement(sql);
			
			for(int i=0;i<parametros.size();i++) {
				if(parametros.get(i).getClass().getName().contains("String")) {
					sentencia.setString(i+1, (String)parametros.get(i));
				
				}else if(parametros.get(i).getClass().getName().contains("Float")) {
					sentencia.setFloat(i+1, (Float)parametros.get(i));
					
				}else if(parametros.get(i).getClass().getName().contains("Integer")) {
					sentencia.setInt(i+1, (Integer)parametros.get(i));
				
				}else if(parametros.get(i).getClass().getName().contains("Boolean")) {
					sentencia.setBoolean(i+1, (Boolean)parametros.get(i));
				
				}else if(parametros.get(i).getClass().getName().contains("Byte")) {
					sentencia.setByte(i+1, (Byte)parametros.get(i));
					
				}else if(parametros.get(i).getClass().getName().contains("Double")) {
					sentencia.setDouble(i+1, (Double)parametros.get(i));
					
				}
			
				System.out.println("[DEBUG] se ha introducido un parametro tipo "+parametros.get(i).getClass().getName());
			}
			
			ResultSet resultado = sentencia.executeQuery();
			while(resultado.next()) {
				Usuarios U1=new Usuarios(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("password"),resultado.getString("email"),resultado.getBoolean("terminosuso"),resultado.getInt("permiso"), resultado.getBoolean("contrasenagenerada"));
				usuarios.add(U1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return(usuarios);
	}

	public boolean insertausuario(String sql, String nombre, String password,String correo, boolean terminos, int permiso, boolean contrasenagenerada ) {
		boolean insertado=true;
		PreparedStatement sentencia;
		try {
			sentencia = (PreparedStatement) conex.prepareStatement(sql);
			sentencia.setString(1,nombre);
			sentencia.setString(2,password);
			sentencia.setString(3,correo);
			
			sentencia.setBoolean(4,terminos);
			sentencia.setInt(5,permiso);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			insertado=false;
			
		}
			
		return insertado;
	}
	
	
	
	

}

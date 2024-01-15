package modelo;


import java.sql.Date;


public class Compras implements java.io.Serializable {

	private int idCompra;
	private Clientes cliente;
	private Productos productos;
	private Integer cantidad;
	private Date fecha;

	public Compras() {
	}

	public Compras(int idCompra, Productos productos, Clientes cliente, Integer cantidad, Date fecha) {
		this.idCompra = idCompra;
		this.cliente = cliente;
		this.productos = productos;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public int getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public Clientes getcliente() {
		return this.cliente;
	}

	public void setcliente(Clientes cliente) {
		this.cliente = cliente;
	}

	

	public Productos getProductos() {
		return this.productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}

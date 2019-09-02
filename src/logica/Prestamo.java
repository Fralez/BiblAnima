package logica;

import java.util.Date;

public class Prestamo {
	private int id;
	private int idLibro;
	private Usuario usuario;
	private Date fechaSolicitado;
	private Date fechaDevolucion;
	
	public Prestamo(int id, int idLibro, Usuario usuario, Date fechaSolicitado, Date fechaDevolucion) {
		super();
		this.id = id;
		this.idLibro = idLibro;
		this.usuario = usuario;
		this.fechaSolicitado = fechaSolicitado;
		this.fechaDevolucion = fechaDevolucion;
		
		this.usuario.addPrestamo(this);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaSolicitado() {
		return fechaSolicitado;
	}
	public void setFechaSolicitado(Date fechaSolicitado) {
		this.fechaSolicitado = fechaSolicitado;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public boolean estaActivo() {
		
		return false;
	}
}

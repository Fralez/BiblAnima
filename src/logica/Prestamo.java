package logica;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
	private int id;
	
	private Date fechaSolicitado = new Date();
	private Date fechaDevolucion;
	private Boolean devuelto;
	private Usuario usuario;
	private Libro libro;
	private ArrayList<Notificacion> notificaciones = new ArrayList<Notificacion>();

	public Prestamo(int id, Date fechaDevolucion, Date fechaSolicitado, Boolean devuelto, Usuario usuario, Libro libro) {
		
		this.id = id;
		this.fechaDevolucion = fechaDevolucion;
		this.fechaSolicitado = fechaSolicitado;
		this.devuelto = devuelto;
		this.usuario = usuario;
		this.libro = libro;

		this.usuario.addPrestamo(this);
		this.libro.addPrestamo(this);

		// Generar notificaciones
		for (int i = 0; i < 3; i++) {
			new Notificacion(this.fechaSolicitado, fechaDevolucion, this);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaSolicitado(Date fechaSolicitado) {
		this.fechaSolicitado = fechaSolicitado;
	}

	public Boolean getDevuelto() {
		return devuelto;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public void setDevuelto(Boolean devuelto) {
		this.devuelto = devuelto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaSolicitado() {
		return fechaSolicitado;
	}

	public void addNotificacion(Notificacion notificacion) {
		this.notificaciones.add(notificacion);
	}

}

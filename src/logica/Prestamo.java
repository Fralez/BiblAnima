package logica;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
	private int idGenerator = 0;

	private int id;
	private Date fechaSolicitado = new Date();
	private Date fechaDevolucion;
	private int idLibro;
	private Usuario usuario;
	private Libro libro;
	private ArrayList<Notificacion> notificaciones = new ArrayList<Notificacion>();

	public Prestamo(Date fechaDevolucion, int idLibro, Usuario usuario, Libro libro) {
		this.idGenerator++;

		this.id = this.idGenerator;

		this.fechaDevolucion = fechaDevolucion;
		this.idLibro = idLibro;
		this.usuario = usuario;
		this.libro = libro;

		this.usuario.addPrestamo(this);
		this.libro.addPrestamo(this);

		// Generar notificaciones
		for (int i = 0; i < 3; i++) {
			Notificacion notif = new Notificacion(this.fechaSolicitado, fechaDevolucion, this);
			this.addNotificacion(notif);
		}
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

	public void addNotificacion(Notificacion notificacion) {
		this.notificaciones.add(notificacion);
	}

}

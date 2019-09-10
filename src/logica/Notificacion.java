package logica;

import java.util.Date;

public class Notificacion {
	private int idGenerator = 0;
	
	private int id;
	private Date fechaSolicitado;
	private Date fechaDevolucion;
	
	public Notificacion(Date fechaSolicitado, Date fechaDevolucion) {
		this.idGenerator++;
		
		this.id = this.idGenerator;
		
		this.fechaSolicitado = fechaSolicitado;
		this.fechaDevolucion = fechaDevolucion;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

}

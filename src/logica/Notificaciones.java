package src.logica;

import java.util.Date;

public class Notificaciones {
	
	private Date FechaSolicitado;
	private Date FechaDevolucion;
	
	public Notificaciones(Date FechaSolicitado, Date FechaDevolucion) {
		super();
		
		this.setFechaSolicitado(FechaSolicitado);
		this.setFechaDevolucion(FechaDevolucion);
		
	}

	public Date getFechaSolicitado() {
		return FechaSolicitado;
	}

	public void setFechaSolicitado(Date fechaSolicitado) {
		FechaSolicitado = fechaSolicitado;
	}

	public Date getFechaDevolucion() {
		return FechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		FechaDevolucion = fechaDevolucion;
	}
	

}

package logica;

import java.util.ArrayList;
import java.util.Date;

public class Libro {

	private String aniCode;
	private String Autor;
	private Date fechaPubl;
	private int nroEdicion;
	private String editorial;
	private String descripcion;
	private int cantEjemplares;
	private int cantEjemplaresDisp;
	private boolean hayEjemplarDisponible;
	private int codigoISBN;
	private String genero;
	private String ImagURL;
	private String titulo;
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

	public Libro(String aniCode, String Autor, Date fechaPubl, int nroEdicion, String editorial, String descripcion,
			int cantEjemplares, boolean hayEjemplarDisponible, int codigoISBN, String genero, String ImagURL,
			String titulo) {
		this.aniCode = aniCode;
		this.Autor = Autor;
		this.fechaPubl = fechaPubl;
		this.nroEdicion = nroEdicion;
		this.editorial = editorial;
		this.descripcion = descripcion;
		this.cantEjemplares = cantEjemplares;
		this.cantEjemplaresDisp = cantEjemplares;
		this.hayEjemplarDisponible = hayEjemplarDisponible;
		this.codigoISBN = codigoISBN;
		this.genero = genero;
		this.ImagURL = ImagURL;
		this.titulo = titulo;
	}

	public String getAniCode() {
		return aniCode;
	}

	public void setAniCode(String aniCode) {
		this.aniCode = aniCode;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public Date getFechaPubl() {
		return fechaPubl;
	}

	public void setFechaPubl(Date fechaPubl) {
		this.fechaPubl = fechaPubl;
	}

	public int getNroEdicion() {
		return nroEdicion;
	}

	public void setNroEdicion(int nroEdicion) {
		this.nroEdicion = nroEdicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantEjemplares() {
		return cantEjemplares;
	}

	public void setCantEjemplares(int cantEjemplares) {
		this.cantEjemplares = cantEjemplares;
	}

	public int getCantEjemplaresDisp() {
		return cantEjemplaresDisp;
	}

	public void setCantEjemplaresDisp(int cantEjemplaresDisp) {
		this.cantEjemplaresDisp = cantEjemplaresDisp;
	}

	public int getCodigoISBN() {
		return codigoISBN;
	}

	public void setCodigoISBN(int codigoISBN) {
		this.codigoISBN = codigoISBN;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getImagURL() {
		return ImagURL;
	}

	public void setImagURL(String imagURL) {
		ImagURL = imagURL;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean hayEjemplarDisponible() {
		return hayEjemplarDisponible;
	}

	public void setHayEjemplarDisponible(boolean hayEjemplarDisponible) {
		this.hayEjemplarDisponible = hayEjemplarDisponible;
	}

	public void addPrestamo(Prestamo prestamo) {
		this.prestamos.add(prestamo);
	}
}

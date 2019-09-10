package src.logica;

import java.util.Date;

public class Libro {
	
	private String Autor;
	private Date FechaPubl;
	private int nroEdicion;
	private String Editorial;
	private String descripcion;
	private int cantEjemplares;
	private int codigoISBN;
	private String genero;
	private String ImagURL;
	private boolean HayEjemplarDisponible;

		
	public Libro(String Autor, Date FechaPubl, int nroEdicion, String Editorial, String descripcion, int cantEjemplares, int codigoISBN, String genero, String ImagURL, boolean HayEjemplarDisponible) {
		super();
		
		this.Autor = Autor;
		this.FechaPubl = FechaPubl;
		this.nroEdicion = nroEdicion;
		this.Editorial = Editorial;
		this.descripcion = descripcion;
		this.cantEjemplares = cantEjemplares;
		this.codigoISBN = codigoISBN;
		this.genero = genero;
		this.ImagURL = ImagURL;
		this.HayEjemplarDisponible = HayEjemplarDisponible; 
		
	}
	
		public String getAutor() {
			return Autor;
		}
		public void setAutor(String autor) {
			Autor = autor;
		}
		public Date getFechaPubl() {
			return FechaPubl;
		}
		public void setFechaPubl(Date fechaPubl) {
			FechaPubl = fechaPubl;
		}
		public int getNroEdicion() {
			return nroEdicion;
		}
		public void setNroEdicion(int nroEdicion) {
			this.nroEdicion = nroEdicion;
		}
		public String getEditorial() {
			return Editorial;
		}
		public void setEditorial(String editorial) {
			Editorial = editorial;
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
		public boolean hayEjemplarDisponible() {
			
			return HayEjemplarDisponible;
		}
		
}

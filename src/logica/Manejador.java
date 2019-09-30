//package logica;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//
//public class Manejador {
//	private Manejador() {
//	}
//
//	private static final Manejador instance = new Manejador();
//
//	public static Manejador getInstance() {
//		return instance;
//	}
//
//	public void altaUsuario(int ci, String nombre, String apellido, String mail, String password, TipoUsuario tipo,
//			Orientacion orient) {
//		// void
//	}
//
//	public Usuario consultaUsuario(int id) {
//		// return Usuario
//	}
//
//	public Usuario buscarUsuario(int ci) {
//		
//	}
//
//	public void modificarDatosUsuario(String nombre, String apellido, String mail, String password) {
//		// void
//	}
//
//	public ArrayList<Usuario> listarUsuariosExistentes() {
//		// return ArrayList<Usuario>
//	}
//
//	public void altaPrestamo(int id, int codigoISBN, Date fechaPres, Date fechaDev, Boolean devuelto) {
//		// void
//	}
//
//	public Usuario consultarPrestamosUsuario(int idUsuario) {
//		// return Usuario
//	}
//
//	public ArrayList<Prestamo> listarPrestamos() {
//		// return ArrayList<Prestamo>
//	}
//
//	public void altaLibro(int codigoISBN) {
//		// void
//	}
//
//	public void darDeBajaUnPrestamo(int idUsuario, int idPrestamo) {
//		// void
//	}
//
//}

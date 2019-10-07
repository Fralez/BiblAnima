package logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import persistencia.Conn;

public class Manejador {
	private Manejador() {
	}

	private static final Manejador instance = new Manejador();

	private Conn connect = new Conn();
	private Connection con = connect.conectarMySQL();
	private Statement s;

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public static Manejador getInstance() {
		return instance;
	}

	// Este método trae los datos de la base de
	// datos y los formatea en los ArrayList presentes
	private void cargarDatos() {
		// Actualizar arrays
	}

	public void altaUsuario(int ci, String nombre, String apellido, String mail, String password, TipoUsuario tipo,
			Orientacion orient) {

		Usuario usuario = null;
		// Query para insertar un usuario en una de las tablas de usuario específico
		// (Estudiante, Profesor o Bibliotecario)
		String typeQuery = "";

		switch (tipo) {
		case ESTUDIANTE:
			usuario = new Estudiante(ci, nombre, apellido, mail, password, orient);
			typeQuery = "INSERT INTO Estudiante(id, orient, tope) VALUES(" + usuario.getId() + ", '" + orient + "', "
					+ (((Estudiante) usuario).getTope()) + ");";
			break;
		case PROFESOR:
			usuario = new Profesor(ci, nombre, apellido, mail, password, orient);
			typeQuery = "INSERT INTO Profesor(id, orient) VALUES(" + usuario.getId() + ", '" + orient + ");";
			break;
		case BIBLIOTECARIO:
			usuario = new Bibliotecario(ci, nombre, apellido, mail, password);
			typeQuery = "INSERT INTO Bibliotecario(id) VALUES(" + usuario.getId() + ");";
			break;
		}

		try {
			s = con.createStatement();
			s.executeUpdate("INSERT INTO Usuario(id, ci, nombre, apellido, mail, password) VALUES(" + usuario.getId()
					+ ", " + ci + ", '" + nombre + "', '" + apellido + "', '" + mail + "', '" + password + "');");
			s.executeUpdate(typeQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Añade al usuario en el array
		usuarios.add(usuario);
	}

	public Usuario consultaUsuario(int ci) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getCi() == ci) {
				return usuarios.get(i);
			}
		}

		return null;
	}

	public void modificarDatosUsuario(int ci, String nombre, String apellido, String mail, String password) {
		try {
			s = con.createStatement();
			s.executeUpdate("UPDATE Usuario(ci, nombre, apellido, mail, password) SET nombre = '" + nombre
					+ "', apellido = '" + apellido + "', mail = '" + mail + "', password = '" + password
					+ "' WHERE Usuario.ci = " + ci + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cargarDatos();
	}

	public ArrayList<Usuario> listarUsuariosExistentes() {
		return usuarios;
	}

	public ArrayList<Libro> listarLibrosExistentes() {
		return libros;
	}

	public void altaPrestamo(Date fechaDev, Usuario usuario, Libro libro) throws Exception {
		if (libro.hayEjemplarDisponible()) {
			try {
				s = con.createStatement();
				new Prestamo(fechaDev, false, usuario, libro);
				s.executeUpdate(
						"INSERT INTO Prestamo (fechaSolicitado, fechaDevolucion, devuelto, idUsuario, codigoAnima) VALUES("
								+ new Date() + ", " + fechaDev + ", " + 0 + ", " + usuario.getId() + ", "
								+ libro.getAniCode() + ");");
				if (libro.getCantEjemplaresDisp() > 0) {
					libro.setCantEjemplaresDisp(libro.getCantEjemplaresDisp() - 1);
					if (libro.getCantEjemplaresDisp() < 1) {
						libro.setHayEjemplarDisponible(false);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("No hay ejemplares disponibles");
		}
	}

	public ArrayList<Prestamo> listarPrestamos() {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

		for (int i = 0; i < usuarios.size(); i++) {
			prestamos.addAll(usuarios.get(i).getPrestamos());
		}

		return prestamos;
	}

	public void altaLibro(String aniCode, String Autor, Date fechaPubl, int nroEdicion, String editorial,
			String descripcion, int cantEjemplares, boolean hayEjemplarDisponible, int codigoISBN, String genero,
			String ImagURL) {

		Libro libro = new Libro(aniCode, Autor, fechaPubl, nroEdicion, editorial, descripcion, cantEjemplares,
				hayEjemplarDisponible, codigoISBN, genero, ImagURL);

		try {
			s.executeUpdate(
					"INSERT INTO Libro(codigoAnima, autor, fechaPubl, nroEdicion, editorial, descripcion, cantEjemplares, hayEjemplaresDisponibles, codigoISBN, genero, imagUrl) VALUES('"
							+ aniCode + "', '" + Autor + "', " + fechaPubl + ", " + nroEdicion + ", '" + editorial
							+ "', '" + descripcion + "', " + cantEjemplares + ", " + hayEjemplarDisponible + ", '"
							+ codigoISBN + "', '" + genero + "', '" + ImagURL + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		libros.add(libro);
	}

	public void darDeBajaUnPrestamo(int ciUsuario, int idPrestamo) {
		try {
			s = con.createStatement();
			s.executeUpdate("UPDATE Prestamo SET devuelto = 1 WHERE Prestamo.id = " + idPrestamo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Actualizar el array de usuarios para que el prestamo sea actualizado
		// cargarDatos();
	}

}

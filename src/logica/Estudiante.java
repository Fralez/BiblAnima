package logica;

public class Estudiante extends Usuario {
	private Orientacion orient;
	// `tope` representa la cantidad de prestamos activos que tiene el usuario,
	// siendo 2 el tope real.
	private int tope = 0;

	public Estudiante(int id, int ci, String nombre, String apellido, String mail, String password, Orientacion orient) {
		super(id, ci, nombre, apellido, mail, password);

		this.orient = orient;
	}

	public Orientacion getOrient() {
		return orient;
	}

	public void setOrient(Orientacion orient) {
		this.orient = orient;
	}

	public int getTope() {
		return tope;
	}

	public void setTope(int tope) {
		this.tope = tope;
	}

}

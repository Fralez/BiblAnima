package logica;

public class Estudiante extends Usuario {
	private Orientacion orient;
	
	public Estudiante(int ci, String nombre, String apellido, String mail, String password, Orientacion orient) {
		super(ci, nombre, apellido, mail, password);
		
		this.orient = orient;
	}
	
	public Orientacion getOrient() {
		return orient;
	}
	public void setOrient(Orientacion orient) {
		this.orient = orient;
	}
	
}

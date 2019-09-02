package logica;

enum Orientacion
{ 
    TIC, ADM, ADMandTIC;
}

public class Profesor extends Usuario {
	private Orientacion orient;
	
	public Profesor(int ci, String nombre, String apellido, String mail, String password, Orientacion orient) {
		super(ci, nombre, apellido, mail, password);
		this.setOrient(orient);
	}

	public Orientacion getOrient() {
		return orient;
	}
	public void setOrient(Orientacion orient) {
		this.orient = orient;
	}

}

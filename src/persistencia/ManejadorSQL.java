package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManejadorSQL {
	private Conn connect = new Conn();
	private Connection con = connect.conectarMySQL();
	private Statement s;

	private ManejadorSQL() {
	}

	private static final ManejadorSQL instance = new ManejadorSQL();

	public static ManejadorSQL getInstance() {
		return instance;
	}

	public ResultSet buscarUsuario(int ci) {
		try {
			s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT user.*, prest.* FROM usuario user INNER JOIN notificacion notif ON user.id=notif.idUsuario "
							+ "INNER JOIN prestamo prest ON notif.idPrestamo=prest.id WHERE user.ci=" + ci + ";");
			return rs;
		} catch (Exception e) {
		}

		return null;
	}
}

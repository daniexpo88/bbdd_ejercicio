package BBDD;
public class Conexion {
	public static void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("ERROR " + ex.toString());
		}
	}
}

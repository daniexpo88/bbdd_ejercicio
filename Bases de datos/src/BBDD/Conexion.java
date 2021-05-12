package BBDD;
public class Conexion {
	public static String conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return "CONEXION ESTABLECIDA";
		} catch (Exception ex) {
			System.out.println("ERROR " + ex.toString());
			return  "ERROR " + ex.toString();
		}
	}
}

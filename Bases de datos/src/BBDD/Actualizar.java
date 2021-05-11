package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Actualizar {
	public static void actualizar() {
		
		Scanner sc = new Scanner(System.in);
		Conexion.conectar();
		Connection con;
		Statement s;
		try {
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			String consulta="";
			System.out.println("Introduzca la consulta de actualización");
			consulta=sc.nextLine();
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			s.executeUpdate(consulta);
			System.out.println("\nActualización correcta");
			Listar.escribirConsulta(consulta);
			s.close();
		} catch (SQLException sql) {
			System.out.println("ERROR "+sql.getMessage());
			sql.printStackTrace();
		}
		sc.close();
	}
}

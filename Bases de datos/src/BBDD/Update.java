package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	public static boolean update() {
		Scanner sc = new Scanner(System.in);
		Conexion.conectar();
		Connection con;
		Statement s;
		try {
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			String consulta="";
			System.out.println("Introduzca la consulta de update");
			consulta=sc.nextLine();
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			s.executeUpdate(consulta);
			System.out.println("\nUpdate correcta");
			Listar.escribirConsulta(consulta);
			s.close();
			sc.close();
			return true;
		} catch (SQLException sql) {
			sc.close();
			System.out.println("ERROR "+sql.getMessage());
			sql.printStackTrace();
			return false;
		}
	}
	
	public static boolean update(String consulta) {
		Conexion.conectar();
		Connection con;
		Statement s;
		try {
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			s.executeUpdate(consulta);
			System.out.println("\nUpdate correcta");
			Listar.escribirConsulta(consulta);
			s.close();
			return true;
		} catch (SQLException sql) {
			System.out.println("ERROR "+sql.getMessage());
			sql.printStackTrace();
			return false;
		}
	}
}

package EmpleadosBBDD;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultar {
	public static void consulta() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la consulta que quieras hacer.");
		String consulta = sc.nextLine();
		Conexion.conectar();
		Connection con;
		Statement s;

		try {
			File archivo = new File("C:\\Users\\Dani\\Desktop\\consulta.txt");
			FileWriter fw = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(fw);
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			ResultSet rs = s.executeQuery(consulta);
			System.out.println("La consulta '" + consulta + "' muestra la siguiente información.\n");
			pw.println("La consulta '" + consulta + "' muestra la siguiente información.\n");

			ResultSetMetaData rsmd = rs.getMetaData();
			int cuentaColumnas = rsmd.getColumnCount();

			for (int i = 1; i <= cuentaColumnas; i++) {
				System.out.print(rsmd.getColumnName(i) + " | ");
				pw.print(rsmd.getColumnName(i) + " | ");
			}
			System.out.println();
			pw.println();
			while (rs.next()) {
				System.out.println();
				pw.println();
				for (int j = 1; j <= cuentaColumnas; j++) {
					System.out.print(rs.getString(j) + " | ");
					pw.print(rs.getString(j) + " | ");
				}
			}
			if (con != null) {
				rs.close();
				s.close();
				con.close();
				sc.close();
				pw.close();
				fw.close();
			}
			sc.close();
		} catch (SQLException sql) {

			System.out.println(sql.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

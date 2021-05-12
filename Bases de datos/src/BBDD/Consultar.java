package BBDD;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultar {
	//Método que hace una consulta introducida por teclado a una base de datos
	public static boolean consulta() {
		Scanner sc = new Scanner(System.in);
		//Introduzco la consulta
		System.out.println("Introduce la consulta que quieras hacer.");
		String consulta = sc.nextLine();
		//Utilizo la clase conexion para la BBDD
		Conexion.conectar();
		//Creo los atributos
		Connection con;
		Statement s;
		File archivo;
		FileWriter fw;
		PrintWriter pw;
		String url;
		String username;
		String password;
		try {
			//Lo conecto al archivo consulta.txt para que se vayan guardando las consultas que hago
			archivo = new File("C:\\Users\\Dani\\Desktop\\consulta.txt");
			fw = new FileWriter(archivo);
			pw = new PrintWriter(fw);
			//Conexión a la Base de datos
			url = "jdbc:mysql://localhost:3306/empleados";
			username = "root";
			password = "12345";
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			//Ejecuto la consulta
			ResultSet rs = s.executeQuery(consulta);
			System.out.println("La consulta '" + consulta + "' muestra la siguiente información.\n");
			pw.println("La consulta '" + consulta + "' muestra la siguiente información.\n");
			//Me hago con la MetaData de la tabla
			ResultSetMetaData rsmd = rs.getMetaData();
			int cuentaColumnas = rsmd.getColumnCount();
			//Bucle for con el nombre de las columnas separadas por barras, que también lo escribe en el archivo consulta.txt
			for (int i = 1; i <= cuentaColumnas; i++) {
				System.out.print(rsmd.getColumnName(i) + " | ");
				pw.print(rsmd.getColumnName(i) + " | ");
			}
			//Hago salto de línea tanto en consola como en el archivo consulta.txt
			System.out.println();
			pw.println();
			//Bucle while, mientras que la consulta tenga un registro siguiente, se ejecuta
			while (rs.next()) {
				//Salto de línea
				System.out.println();
				pw.println();
				//Bucle for que recorre las diferentes columnas de cada registro separadas por "|" y escribe los datos
				//en la consola y el documento consulta.txt 
				for (int j = 1; j <= cuentaColumnas; j++) {
					System.out.print(rs.getString(j) + " | ");
					pw.print(rs.getString(j) + " | ");
				}
			}
			//Utilizo el método estático de la clase Listar(escribirConsulta(String consulta)) que escribirá
			//la consulta en el archivo opoeraciones.txt en el que se almacenan todas las consultas, inserts, updates, etc.
			Listar.escribirConsulta(consulta);
			//Cierro los diferentes atributos.
			if (con != null) {
				rs.close();
				s.close();
				con.close();
				sc.close();
				pw.close();
				fw.close();
			}
			sc.close();
			return true;
		} catch (SQLException sql) {
			System.err.println("ERROR EN CONSULTA "+sql.getMessage());
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	//Método que hace una consulta introducida por parámetro a una base de datos
		public static boolean consulta(String consulta) {
			//Utilizo la clase conexion para la BBDD
			Conexion.conectar();
			//Creo los atributos
			Connection con;
			Statement s;
			File archivo;
			FileWriter fw;
			PrintWriter pw;
			String url;
			String username;
			String password;
			try {
				//Lo conecto al archivo consulta.txt para que se vayan guardando las consultas que hago
				archivo = new File("C:\\Users\\Dani\\Desktop\\consulta.txt");
				fw = new FileWriter(archivo);
				pw = new PrintWriter(fw);
				//Conexión a la Base de datos
				url = "jdbc:mysql://localhost:3306/empleados";
				username = "root";
				password = "12345";
				con = DriverManager.getConnection(url, username, password);
				s = con.createStatement();
				//Ejecuto la consulta
				ResultSet rs = s.executeQuery(consulta);
				System.out.println("La consulta '" + consulta + "' muestra la siguiente información.\n");
				pw.println("La consulta '" + consulta + "' muestra la siguiente información.\n");
				//Me hago con la MetaData de la tabla
				ResultSetMetaData rsmd = rs.getMetaData();
				int cuentaColumnas = rsmd.getColumnCount();
				//Bucle for con el nombre de las columnas separadas por barras, que también lo escribe en el archivo consulta.txt
				for (int i = 1; i <= cuentaColumnas; i++) {
					System.out.print(rsmd.getColumnName(i) + " | ");
					pw.print(rsmd.getColumnName(i) + " | ");
				}
				//Hago salto de línea tanto en consola como en el archivo consulta.txt
				System.out.println();
				pw.println();
				//Bucle while, mientras que la consulta tenga un registro siguiente, se ejecuta
				while (rs.next()) {
					//Salto de línea
					System.out.println();
					pw.println();
					//Bucle for que recorre las diferentes columnas de cada registro separadas por "|" y escribe los datos
					//en la consola y el documento consulta.txt 
					for (int j = 1; j <= cuentaColumnas; j++) {
						System.out.print(rs.getString(j) + " | ");
						pw.print(rs.getString(j) + " | ");
					}
				}
				//Utilizo el método estático de la clase Listar(escribirConsulta(String consulta)) que escribirá
				//la consulta en el archivo opoeraciones.txt en el que se almacenan todas las consultas, inserts, updates, etc.
				Listar.escribirConsulta(consulta);
				//Cierro los diferentes atributos.
				if (con != null) {
					rs.close();
					s.close();
					con.close();
					pw.close();
					fw.close();
				}
				return true;
			} catch (SQLException sql) {
				System.err.println("ERROR EN CONSULTA "+sql.getMessage());
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
}

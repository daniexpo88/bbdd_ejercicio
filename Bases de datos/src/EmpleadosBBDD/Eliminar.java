package EmpleadosBBDD;

import java.util.Scanner;
import java.sql.*;

public class Eliminar {
	public static void eliminarTabla() {
		Conexion.conectar();
		Connection con;
		Statement s;
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué tabla desea eliminar?");
		String tabla = sc.next();
		
		try {
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			s.executeUpdate("drop table "+tabla+";");
			System.out.println("La tabla "+tabla+" se ha eliminado correctamente.");
			sc.close();
			s.close();
			con.close();
		}catch(SQLException sql) {
			System.err.println("Ha habido un error al eliminar la tabla "+tabla+". ");
			sql.printStackTrace();
		}
	}
	
	public static void eliminarRegistro() {
		Conexion.conectar();
		Connection con;
		Statement s;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		try {
			System.out.println("¿De qué tabla desea eliminar un registro?");
			String tabla = sc.next();
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from "+tabla);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("¿Que columna conoces para eliminar el registro?");
			String columna = sc1.next();
			Object dato;
			int type=0;
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				if(rsmd.getColumnName(i).equals(columna)) {
					type = rsmd.getColumnType(i);
				}
			}
			System.out.println("Introduce el valor del campo");
            if (type == Types.VARCHAR || type == Types.CHAR) {
               dato=sc2.next();
            } else {
               dato=sc2.nextLong();
            }
			if	(type == Types.VARCHAR || type == Types.CHAR) {
				s.executeUpdate("delete from "+tabla+" where "+columna+"='"+dato+"';");
			}else {
				s.executeUpdate("delete from "+tabla+" where "+columna+"="+dato+";");
			}
			System.out.println("El registro se ha eliminado correctamente");
			s.close();
			con.close();
			sc.close();
			sc1.close();
			sc2.close();
		}catch(SQLException sql) {
			System.err.println("Ha habido un error al eliminar el campo ");
			sql.printStackTrace();
		}
	}
		
}

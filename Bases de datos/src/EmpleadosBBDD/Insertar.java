package EmpleadosBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insertar {
	public static void insertarEmpleados() {
		Scanner sc = new Scanner(System.in);
		String respuesta = ".";
		Empleados e;
		try {
			while (!respuesta.equalsIgnoreCase("no")) {
				e = new Empleados();
				e.setCodigo((Empleados.getUltimoCodigo()+1));
				System.out.print("Introduce el nif del trabajador: ");
				e.setNif(sc.next());
				System.out.print("Introduce el nombre del trabajador: ");
				e.setNombre(sc.next());
				System.out.print("Introduce el apellido1 del trabajador: ");
				e.setApellido1(sc.next());
				System.out.print("Introduce el apellido2 del trabajador: ");
				e.setApellido2(sc.next());
				System.out.print("Introduce el codigo de departamento del trabajador: ");
				e.setCodigo_departamento(sc.nextInt());
				System.out.println(e.getNombre());
				insertar(e);
				System.out.println("Desea continuar introduciendo empleados(Si/no)");
				respuesta = sc.next();
			}
			sc.close();
		} catch (Exception exception) {
			System.out.println("ERORR");
		}
	}
	
	public static void insertarDepartamento() {
		Scanner sc = new Scanner(System.in);
		String respuesta = ".";
		Departamentos d;
		try {
			while (!respuesta.equalsIgnoreCase("no")) {
				d = new Departamentos();
				d.setCodigo((Departamentos.getUltimoCodigo()+1));
				System.out.print("Introduce el nombre del departamento: ");
				d.setNombre(sc.next());
				System.out.print("Introduce el presupuesto: ");
				d.setPresupuesto(sc.nextDouble());
				System.out.print("Introduce los gastos del departamento: ");
				d.setGastos(sc.nextDouble());
				System.out.println(d.getNombre());
				insertar(d);
				System.out.println("Desea continuar introduciendo departamentos(Si/no)");
				respuesta = sc.next();
			}
			sc.close();
		} catch (Exception exception) {
			System.out.println("ERORR");
		}
	}
	
	
	
	private static void insertar(Empleados e) {
		Conexion.conectar();
		Connection con;
		Statement s;
		try {
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			String consulta =	"INSERT INTO empleado VALUES(" + e.getCodigo() + ", '" + e.getNif() + "', '"
					+ e.getNombre() + "', '" + e.getApellido1() + "', '" + e.getApellido2() + "', "
					+ e.getCodigo_departamento() + ");";
			
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			s.executeUpdate(consulta);
			System.out.println("EMPLEADO " + e.getNombre() + " CREADO");
			Listar.escribirConsulta(consulta);
			s.close();
		} catch (SQLException sql) {
			System.out.println("ERROR "+sql.getMessage());
			sql.printStackTrace();
		}

	}
	private static void insertar(Departamentos d) {
		Conexion.conectar();
		Connection con;
		Statement s;
		try {
			String url = "jdbc:mysql://localhost:3306/empleados";
			String username = "root";
			String password = "12345";
			String consulta = "INSERT INTO departamento VALUES(" + d.getCodigo() + ", '" +d.getNombre() + "', "
					+ d.getPresupuesto()  + ", " + d.getGastos() + ");";
			
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			s.executeUpdate(consulta);
			System.out.println("DEPARTAMENTO " + d.getNombre() + " CREADO");
			Listar.escribirConsulta(consulta);
			s.close();
		} catch (SQLException sql) {
			System.out.println("ERROR "+sql.getMessage());
			sql.printStackTrace();
		}
	}
}

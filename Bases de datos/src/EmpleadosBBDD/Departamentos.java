package EmpleadosBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Departamentos {
	private int codigo;
	private String nombre;
	private double presupuesto;
	private double gastos;
	
	public static int getUltimoCodigo() {
		int codigo=0;
		Connection con;
		Statement s;
		Conexion.conectar();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados","root","12345");
			s = con.createStatement();
			ResultSet rs = s.executeQuery ("SELECT max(codigo)codigo from departamento;");
			if(rs.next())
			codigo=rs.getInt(1);
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error "+e.toString());
		}
		return codigo;
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public double getGastos() {
		return gastos;
	}
	public void setGastos(double gastos) {
		this.gastos = gastos;
	}
}

package BBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empleados {
	private  int codigo;
	private  String nif;
	private  String nombre;
	private  String apellido1;
	private  String apellido2;
	private  int codigo_departamento;
	
	public Empleados() {};
	
	public static int getUltimoCodigo() {
		int codigo=0;
		Connection con;
		Statement s;
		Conexion.conectar();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados","root","12345");
			s = con.createStatement();
			ResultSet rs = s.executeQuery ("SELECT max(codigo)codigo from empleado;");
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getCodigo_departamento() {
		return codigo_departamento;
	}

	public void setCodigo_departamento(int codigo_departamento) {
		this.codigo_departamento = codigo_departamento;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

}

package BBDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestClase {
	//Test de conexion
	@Test
	void testConexion() {
		Assertions.assertEquals("CONEXION ESTABLECIDA", Conexion.conectar());
	}
	
	//Test de consultas
	@Test
	void testConsultaVerdadera() {
		Assertions.assertEquals(true, Consultar.consulta("Select * from empleado;"));
		System.out.println();
	}
	@Test
	void testConsultaTablaNoExistente() {
		Assertions.assertEquals(false, Consultar.consulta("Select * from tablaNoExistente"));
		System.out.println();
	}
	@Test
	void testConsultaMalEscrita() {
		Assertions.assertEquals(false, Consultar.consulta("hola"));
		System.out.println();
	}
	
	//Test de insert para ver que realiza un insert correcto y lo guarda en la tabla
	@Test
	void testInsert() {
		//También se puede hacer con Insertar.insertarEmpleados()
		System.out.println();
		Assertions.assertEquals(true, Insertar.insertarDepartamento());
		System.out.println();
	}

	
	//Test de updates
	@Test
	void testUpdate() {
		System.out.println();
		Assertions.assertEquals(true, Update.update("Update empleado set nombre='Juan' where codigo=10;"));
	}
	//Test de delete
	@Test
	void testDelete() {
		System.out.println();
		Assertions.assertEquals(true, Eliminar.eliminarPorParametro("Delete from empleado where codigo='8';"));
	}
}


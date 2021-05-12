package BBDD;

import java.util.Scanner;

public class PrincipalBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu();
	}
	
	static void Menu() {
		Scanner sc = new Scanner(System.in);
		int resp;
		try {
		System.out.println("PROGRAMA BASE DE DATOS");
		System.out.println("¿QUÉ OPERACIÓN DESEA REALIZAR?"+
		"\n\t1.Consultar"+
		"\n\t2.Insertar"+
		"\n\t3.Update"+
		"\n\t4.Eliminar"+
		"\n\t5.Listar fichero con las operaciones");
		resp = sc.nextInt();
		switch(resp) {
		case 1:
			Consultar.consulta();
			break;
		case 2:
			System.out.println("Desea insertar \n1.Empleados \n2.Departamentos");
			resp = sc.nextInt();
			if(resp==1) {
				Insertar.insertarEmpleados();
			}
			else if(resp==2) {
				Insertar.insertarDepartamento();
			}
			else {
				System.out.println("LO SIENTO HA HABIDO UN ERROR");
			}
			break;
		case 3:
			Update.update();
			break;
		case 4:
			System.out.println("Desea eliminar \n1.Tabla \n2.Registro");
			resp = sc.nextInt();
			if(resp==1) {
				Eliminar.eliminarTabla();
			}
			else if(resp==2) {
				Eliminar.eliminarRegistro();
			}
			else {
				System.out.println("LO SIENTO HA HABIDO UN ERROR");
			}
			break;
		case 5:
				Listar.listarFichero();
			break;
		}
		
		sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
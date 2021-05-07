package EmpleadosBBDD;

import java.io.*;

public class Listar{
	
	public static void escribirConsulta(String consulta) {
		File file = new File("C:\\Users\\Dani\\Desktop\\operaciones.txt");
		FileWriter fw;
		BufferedWriter bw;
		
		try {
			fw = new FileWriter(file.getAbsoluteFile(),true);
			bw = new BufferedWriter(fw);
			
			bw.write(consulta);
			bw.newLine();
			
			
			bw.close();
			fw.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public static void listarFichero() {
		File file = new File("C:\\Users\\Dani\\Desktop\\operaciones.txt");
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String consulta="";
			int i=1;
			while((consulta=br.readLine())!=null) {
				System.out.println("Consulta "+i);
				System.out.println("\t"+consulta+"\n");
				i++;
			}
			br.close();
			fr.close();
			
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

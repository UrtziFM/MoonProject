package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModuloVisionAuxiliar extends ModuloVisionAbstracto{

	private String rutaArchivo="filelunar.txt";//ruta de archivo donde se guardan las rocas reconocidas en la misi�n
	private File fileRocas;//clase que representa el archivo
	private FileWriter fw;// clase de escritura en archivo con flujo orientado a caracteres

	//Constructor
	public ModuloVisionAuxiliar() {
			// crear archivo si no existe
			fileRocas = new File(rutaArchivo);
		try {
			
			fw = new FileWriter(fileRocas);
			
		} catch (IOException e) {
			System.out.println("Error: el archivo no existe..");
			e.printStackTrace();
		}

	}
	
	/** m�todo que simula un reconocimiento de Rocas lunares
	 * 
	 */
	public void escanearSuperficie() {
		int cod;
		System.out.println("INFO: Iniciando secuencia de reconocimiento con m�dulo auxiliar...");
		
		try {
			
			//Generamos 100 rocas de 5 tipos de formas aleatoria entre (1-5)
			for (int i=0;i<100;i++) {
				cod = (int)(Math.random()*4+1);
				System.out.println("Reconocida roca lunar con modulo auxiliar");			
				fw.write(String.valueOf(cod));
				fw.write('\n');
			}
		} catch (IOException e) {
			System.out.println("ERROR : al escribir en archivo de salida ..");
			try {
				fw.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {try {
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}}

	}
	public static void main( String[] args ){
		// Instanciar modulo de visi�n para prueba		
		ModuloVision mV=new ModuloVision();
		//
		mV.escanearSuperficie();
		
	}
}

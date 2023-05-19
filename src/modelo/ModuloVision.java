package modelo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase que representa el módulo de acquisión de datos en misión lunar
 * @author 
 *
 */
public class ModuloVision extends ModuloVisionAbstracto {
	
	private String rutaArchivo="filelunar.txt";//ruta de archivo donde se guardan las rocas reconocidas en la misión
	private File fileRocas;//clase que representa el archivo
	private FileWriter fw;// clase de escritura en archivo con flujo orientado a caracteres

	//Constructor
	public ModuloVision() {
			// crear archivo si no existe
			fileRocas = new File(rutaArchivo);
		try {
			
			fw = new FileWriter(fileRocas);
			
		} catch (IOException e) {
			System.out.println("Error: el archivo no existe..");
			e.printStackTrace();
		}

	}
	
	/** método que simula un reconocimiento de Rocas lunares
	 * 
	 */
	public void escanearSuperficie() {
		int cod;
		System.out.println("INFO: Iniciando secuencia de reconocimiento...");
		
		try {
			
			//Generamos 100 rocas de 5 tipos de formas aleatoria entre (1-5)
			for (int i=0;i<100;i++) {
				cod = (int)(Math.random()*4+1);
				System.out.println("Reconocida roca lunar");			
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
		// Instanciar modulo de visión para prueba		
		ModuloVision mV=new ModuloVision();
		//
		mV.escanearSuperficie();
		
	}

}

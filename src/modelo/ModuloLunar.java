package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import interfaz.IUModuloLunar;

public class ModuloLunar {

	private String rutaArchivo = "filelunar.txt";// ruta de archivo donde se guardan las rocas reconocidas en la misi�n
	private Map<String, String> mapaHashRocas;// lista <clave,valor> donde clave es el tipo de roca y valor su c�digo
	//las asociaciones
	private ModuloVisionAbstracto mV;// enlace con el Modulo de visi�n	
	
	private ArrayList<RocaLunar> listaRocas;

	private IUModuloLunar iu;
	
	
	public ModuloLunar(IUModuloLunar iu) {
		
		this.iu = iu;
		
		iu.setMensajeConsola("INFO: Inicializando Modulo Vision....");
		
		
		mV = new ModuloVision();
		
		iu.setMensajeConsola("INFO: Creando estructura de almacenamiento de rocas lunares detectadas....");
	
		
		listaRocas = new ArrayList<RocaLunar>();
		iu.setMensajeConsola("INFO: Creando mapa de codigos de tipos de roca lunar....");
		
		
		mapaHashRocas = new HashMap<String, String>();
		mapaHashRocas.put("basalt", "1");
		mapaHashRocas.put("breccia", "2");
		mapaHashRocas.put("highland", "3");
		mapaHashRocas.put("regolith", "4");
		mapaHashRocas.put("unknown", "5");
		iu.setMensajeConsola("INFO: Mapa de codigos de tipos de roca lunar creado....");
		
		
	}

	public ModuloLunar() {
	}

	/**
	 * Desarrolla la tarea de la misison lunar: escanear superficie, recuento de
	 * rocas detectadas y mostrar resultados
	 */
	public void desarrollarMisionReconocimiento() {	
		
			mV.escanearSuperficie();			
			recuento();			
			mostrarResutados();
	
	}
	
	public void cambiarModuloVisionAuxiliar() {
		iu.setMensajeConsola("INFO: Modulo Vision cambiado escaneando con modulo auxiliar....");
		ModuloVisionAuxiliar mVAux = new ModuloVisionAuxiliar();
		mVAux.escanearSuperficie();
		recuento();
		mostrarResutados();
	}

	/**
	 * Metodo que hace el recuento de cada tipo de roca lunar detectada
	 * 
	 * 
	 */
	private void recuento() {

		// TAREA :recorrer el archivo creado por el modulo de visi�n y contar el tipo de

		File archivo = new File(this.rutaArchivo);
		FileReader fw = null;
		BufferedReader br = null;
		
		try {
			// acumuladores 
			int basalt = 0, brecia = 0, highland = 0, regolith = 0, unkhown = 0;

			fw = new FileReader(archivo);
			br = new BufferedReader(fw);
			String lectura = null;
			
			//leer cada l�nea del archivo y acumular el n�mero de rocas lunares de cada tipo detectado
			while ((lectura = br.readLine()) != null) {

				if (lectura.equals(mapaHashRocas.get("basalt"))) {
					basalt++;

				} else if (lectura.equals(mapaHashRocas.get("breccia"))) {
					brecia++;

				} else if (lectura.equals(mapaHashRocas.get("highland"))) {
					highland++;

				} else if (lectura.equals(mapaHashRocas.get("regolith"))) {
					regolith++;

				} else if (lectura.equals(mapaHashRocas.get("unkhown"))) {
					unkhown++;

				}
			}

			// Crear un objeto por cada roca lunar reconocida y a�adir el n�mero de ellas detectadas
			iu.setMensajeConsola("INFO: Creando estructura de rocas reconocidas");
			//System.out.println("INFO: Creando estructura de rocas reconocidas");
			RocaLunar r1 = new RocaLunar(1, "basalt");
			r1.setRecuento(basalt);
			listaRocas.add(r1);
			RocaLunar r2 = new RocaLunar(2, "brecia");
			r2.setRecuento(brecia);
			listaRocas.add(r2);
			RocaLunar r3 = new RocaLunar(3, "highland");
			r3.setRecuento(highland);
			listaRocas.add(r3);
			RocaLunar r4 = new RocaLunar(4, "regolith");
			r4.setRecuento(regolith);
			listaRocas.add(r4);
			RocaLunar r5 = new RocaLunar(5, "unkhown");
			r5.setRecuento(unkhown);
			listaRocas.add(r5);
			

		} catch (FileNotFoundException e) {
			iu.setMensajeConsola("ERROR:archivo no encrontrado");
			System.out.println("ERROR:archivo no encrontrado");
			e.printStackTrace();
			
		} catch (IOException e) {
			iu.setMensajeConsola("ERROR:lectura de archivo");
			System.out.println("ERROR:lectura de archivo");
			e.printStackTrace();
			
		} finally {

			try {
				br.close();
				fw.close();
			} catch (IOException e) {
				iu.setMensajeConsola("ERROR:lectura de archivo");
				e.printStackTrace();
			}

		}

	}

	/**
	 * Imprime el resultado del recuento de rocas lunares detectadas en la misi�n
	 */
	private void mostrarResutados() {

		
		iu.setMensajeMision(" RESULTADO DE LA MISION DE RECONOCIMIENTO ++++++++++++++++++");
		for (RocaLunar roca : listaRocas) {
			iu.setMensajeMision(roca.toString());
			
		}

	}

	public static void main(String[] args) {
		
		// Dejamos que todo se interaccione desde la interfaz

	}
}

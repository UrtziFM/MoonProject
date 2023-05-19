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

	private String rutaArchivo = "filelunar.txt";// ruta de archivo donde se guardan las rocas reconocidas en la misión
	private Map<String, String> mapaHashRocas;// lista <clave,valor> donde clave es el tipo de roca y valor su código
	//las asociaciones
	private ModuloVisionAbstracto mV;// enlace con el Modulo de visión	
	
	private ArrayList<RocaLunar> listaRocas;

	private IUModuloLunar iu;
	
	private EstacionMedicionAmbiental estacionMedicion;
	private PanelSolar panel_izq,panel_drch;
	
	
	public ModuloLunar(IUModuloLunar iu) {
		
		 this.iu=iu;
		
		 iu.setMensajeConsola("INFO: Inicializando Modulo Visión....");
		
		
		mV = new ModuloVision();
		iu.setMensajeConsola("INFO: Módulo Visión inicializado....");
		
		iu.setMensajeConsola("INFO: Creando estructura de almacenamiento de rocas lunares detectadas....");
	
		
		listaRocas = new ArrayList<RocaLunar>();
		iu.setMensajeConsola("INFO: Creando mapa de códigos de tipos de roca lunar....");
		
		
		mapaHashRocas = new HashMap<String, String>();
		mapaHashRocas.put("basalt", "1");
		mapaHashRocas.put("breccia", "2");
		mapaHashRocas.put("highland", "3");
		mapaHashRocas.put("regolith", "4");
		mapaHashRocas.put("unknown", "5");
		iu.setMensajeConsola("INFO: Mapa de códigos de tipos de roca lunar creado....");
		
		
		estacionMedicion=new EstacionMedicionAmbiental();
		estacionMedicion.desplegarMastil();
		iu.setMensajeConsola("INFO:Estacion de Medición desplegada y opeartiva... ");
		
		panel_izq=new PanelSolar();
		panel_drch=new PanelSolar();
		panel_izq.desplegar();
		panel_drch.desplegar();
		iu.setMensajeConsola("INFO:Paneles Solares desplegados... ");
		
	}

	/**
	 * Desarrolla la tarea de la misisón lunar: escanear superficie, recuento de
	 * rocas detectadas y mostrar resultados
	 */
	public void desarrollarMisionReconocimiento() {	
		
			mV.escanearSuperficie();			
			recuento();			
			mostrarResutados();
	
	}
	
	public void cambiarModuloVisionAuxiliar() {
		iu.setMensajeConsola("INFO: Módulo Visión cambiado escaneando con modulo auxiliar....");
		this.mV= new ModuloVisionAuxiliar();
	}

	/**
	 * Método que hace el recuento de cada tipo de roca lunar detectada
	 * 
	 * 
	 */
	private void recuento() {

		// TAREA :recorrer el archivo creado por el modulo de visión y contar el tipo de

		File archivo = new File(this.rutaArchivo);
		FileReader fw = null;
		BufferedReader br = null;
		
		try {
			// acumuladores 
			int basalt = 0, brecia = 0, highland = 0, regolith = 0, unkhown = 0;

			fw = new FileReader(archivo);
			br = new BufferedReader(fw);
			String lectura = null;
			
			//leer cada línea del archivo y acumular el número de rocas lunares de cada tipo detectado
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

			// Crear un objeto por cada roca lunar reconocida y añadir el número de ellas detectadas
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
	 * Imprime el resultado del recuento de rocas lunares detectadas en la misión
	 */
	private void mostrarResutados() {

		
		iu.setMensajeConsola(" RESULTADO DE LA MISISóN DE RECONOCIMIENTO ++++++++++++++++++");
		for (RocaLunar roca : listaRocas) {
			iu.setMensajeConsola(roca.toString());
			
		}

	}

	public static void main(String[] args) {
		
		// Instanciar Modulo de lectura
		//ModuloLunar mL = new ModuloLunar();
		//mL.desarrollarMisionReconocimiento();

	}
}

package modelo;

import java.util.Random;

public class EstacionMedicionAmbiental {

	private int temperatura;
	private int radiacion;
	private int estadoMastil;
	private int estadoSensorUV;

	public EstacionMedicionAmbiental() {
			
		 temperatura = 0; //Grados celsius -150 a 214		 
		 radiacion = 0; //W/m2
		 estadoMastil = 0 ; //O NO DESPLEGLADO, 1 DESPLEGADO
		 estadoSensorUV = 0;//O NO OPERATIVO, 1 OPERATIVO
	}

	public int getEstadoSensorUV() {
		Random random = new Random();
		estadoSensorUV = random.nextInt(2); // Genera un número aleatorio de 0 o 1 
		return estadoSensorUV;
	}

	public int getEstadoMastil() {
		Random random = new Random();
		estadoMastil = random.nextInt(2); // Genera un número aleatorio de 0 o 1
		return estadoMastil;
	}
	
	public int getTemperatura() {
		Random random = new Random();
		temperatura = random.nextInt(501) - 200; // Genera un número aleatorio entre -200 y 300 (inclusive)
		return temperatura;		
	}

	public int getRadiacion() {
		Random random = new Random();
		radiacion = random.nextInt(300); // Genera un número aleatorio entre 0 y 300
		return radiacion;		
	}

}

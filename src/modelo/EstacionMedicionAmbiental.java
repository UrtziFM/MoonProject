package modelo;

public class EstacionMedicionAmbiental {

	float temperatura;
	float radiacion;
	int estado_mastil;
	int estado_sensor_ultrvioleta;

	public EstacionMedicionAmbiental() {
			
		 temperatura=0.0f;//Grados celsius -150 a 214		 
		 radiacion=0.0f;//W/m2
		 estado_mastil=0; //O NO DESPLEGLADO, 1 DESPLEGADO
		 estado_sensor_ultrvioleta=0;//O NO OPERATIVO, 1 OPERATIVO
	}

	public void desplegarMastil() {
		//Simulamos que se recogen estos valores
		estado_mastil=1;
		estado_sensor_ultrvioleta=1;
		activarSensores();
	}

	public int getEstadoSensorUltra() {
		return estado_sensor_ultrvioleta;

	}

	public int getEstadoMastil() {
		return estado_sensor_ultrvioleta;

	}
	
	public void activarSensores() {
		// Este m�todo simula la activaci�n y lectura de sensores
		temperatura=150;			
		radiacion=110 ; 

	}

}

package modelo;

import java.util.Random;

public class BateriaPanelSolar {
    private int cargaBateria;
    
    public void bateriaPanelSolar() {
		
		cargaBateria = 0;
	}
	
	public int getEstadoBateria() {
		Random random = new Random();
		cargaBateria = random.nextInt(101); // Genera un número aleatorio de 0 y 100
		return cargaBateria;
	}

}

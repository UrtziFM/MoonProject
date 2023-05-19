package interfaz;

import javax.swing.*;

import modelo.ModuloLunar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * IUModuloLunar es la interfaz grafica con la que el projecto viaje a la luna manejara el modulo lunar desde la tierra
 * Paneles de control que debe tener el proyecto:
 * -  Ver estado de la informacion sobre los Paneles, la Temperatura, Sensores Ultra violetas y la Bateria del modulo lunar
 * -  Informacion de control del modulo
 * -  Informacion de la mision
 * -  Boton de activacion escaner auxiliar
 * @author 
 */

public class IUModuloLunar extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Controles graficos de la IU
	private JTextArea textMensajes;
	private JPanel panelSuperior;
	private JPanel panelBotonHerramientas;
	private JButton btnVerInfoHerramientas;
	private JPanel panelControles;
	private JPanel panelCampos;
	private JPanel plPaneles;
	private JLabel lblPaneles;
	private JLabel resultPaneles;
	private JPanel plTemperatura;
    private JLabel lblTemperatura;
	private JLabel resultTemperatura;
	private JPanel plSensoresUV;
	private JLabel lblSensoresUV;
	private JLabel resultSensoresUV;
	private JPanel plNivelBateria;
	private JLabel lblNivelBateria;
	private JLabel resultNivelBateria;
	private JPanel panelInferior;
	private JButton btnIniciarMision;
	private JButton btnActivarEscanerAuxiliar;

	//modelo asbtracto que manipula la IU
	private ModuloLunar moduloLunar;

	public IUModuloLunar() {
		
		inicializarControles();
	}
	
	private void inicializarControles() {
		
		// Configurar el titulo y el tamano de la ventana
		setTitle("IU MODULO LUNAR");
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crear componentes de la interfaz grafica
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.BLACK);
        panelSuperior.setPreferredSize(new Dimension(1000, 250));
		panelBotonHerramientas = new JPanel();
		panelBotonHerramientas.setBackground(Color.RED);
        panelBotonHerramientas.setPreferredSize(new Dimension(250, 40));
		btnVerInfoHerramientas = new JButton("Ver Estado de Información");
		panelControles = new JPanel();
        panelControles.setPreferredSize(new Dimension(250, 240));
		panelControles.setLayout(new BoxLayout(panelControles, BoxLayout.Y_AXIS));
		panelCampos = new JPanel();
        panelCampos.setPreferredSize(new Dimension(250, 240));
		plPaneles = new JPanel();
		lblPaneles = new JLabel("Estado de los Paneles");
		plPaneles.setBackground(Color.WHITE);
		resultPaneles = new JLabel();
		resultPaneles.setBackground(Color.WHITE);
		plTemperatura = new JPanel();
		lblTemperatura = new JLabel("Temperatura");
		plTemperatura.setBackground(Color.YELLOW);
		resultTemperatura = new JLabel();
		resultTemperatura.setBackground(Color.YELLOW);
		plSensoresUV = new JPanel();
		lblSensoresUV = new JLabel("Sensores UV");
		plSensoresUV.setBackground(Color.WHITE);
		resultSensoresUV = new JLabel();
		resultSensoresUV.setBackground(Color.WHITE);
		plNivelBateria = new JPanel();
		lblNivelBateria = new JLabel("Nivel de Batería");
		plNivelBateria.setBackground(Color.YELLOW);
		resultNivelBateria = new JLabel();
		resultNivelBateria.setBackground(Color.YELLOW);
		textMensajes = new JTextArea(50, 50);
		btnIniciarMision = new JButton("Iniciar mision de reconocimiento");

		// Instanciamos el modulo lunar y le pasamos la propia refrencia a esta interfaz (enlace bidireccional)
		// esto es importante porque Modulo lunar tienen que invocar metodos de la interfaz
		moduloLunar = new ModuloLunar(this);
		
		// Configurar la disposici0n de elementos de la interfaz grafica
		plPaneles.setLayout(new BorderLayout());
		plTemperatura.setLayout(new BorderLayout());
		plSensoresUV.setLayout(new BorderLayout());
		plNivelBateria.setLayout(new BorderLayout());

		plPaneles.add(lblPaneles, BorderLayout.CENTER);
		plTemperatura.add(lblTemperatura, BorderLayout.CENTER);
		plSensoresUV.add(lblSensoresUV, BorderLayout.CENTER);
		plNivelBateria.add(lblNivelBateria, BorderLayout.CENTER);
		
		panelControles.add(plPaneles, BorderLayout.CENTER);
		panelControles.add(plTemperatura, BorderLayout.CENTER);
		panelControles.add(plSensoresUV, BorderLayout.CENTER);
		panelControles.add(plNivelBateria, BorderLayout.CENTER);

		panelCampos.add(resultPaneles, BorderLayout.CENTER);
		panelCampos.add(resultTemperatura, BorderLayout.CENTER);
		panelCampos.add(resultSensoresUV, BorderLayout.CENTER);
		panelCampos.add(resultNivelBateria, BorderLayout.CENTER);

		panelBotonHerramientas.add(btnVerInfoHerramientas, BorderLayout.CENTER);

		panelSuperior.add(panelBotonHerramientas, BorderLayout.WEST);
		panelSuperior.add(panelControles, BorderLayout.CENTER);
		panelSuperior.add(panelCampos, BorderLayout.EAST);

		
		// Agregar los componentes a la ventana
		add(panelSuperior, BorderLayout.NORTH);
		add(new JScrollPane(textMensajes), BorderLayout.CENTER);
		add(btnIniciarMision, BorderLayout.SOUTH);
		
		/**
		 * INICIALIZAR NUEVOS CONTROLES
		 *
		 */
		
  
		// Registrar el manejador de eventos para el bot�n
		btnIniciarMision.addActionListener(this);
		
		/**
		 * REGISTRAR NUEVOS MANEJADORES DE EVENTOS EN CONTROLES
		 *
		 */
		
		// Mostrar la ventana
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciarMision) {
		
			/**
			 * PROGRAMAR LA LOGICA DE CONTROL DE PARA MANEJAR LOS EVENTOS DE LA INTERFAZ
			 * 1.-Control bot�n ver estado de instrumentaci�n
			 * 2.-Control bot�n iniciar misi�n ( ojo si el radio est� activado deber� realizarse con 
			 * el M�dulo Auxiliar de vision
			 * 
			 */
		} 
	}
	/**
	 * SetMensaje permite imprimir un mensaje en el cuadro de texto de la interfaz gr�fica
	 * @param msg
	 */
	public void setMensajeConsola(String msg) {
		String newline = "\n";
		textMensajes.append(msg + newline);
	}

	public static void main(String[] args) {
		// Crear y mostrar la interfaz gr�fica en el hilo de eventos de Swing
		SwingUtilities.invokeLater(() -> {
			new IUModuloLunar();
		});
	}
}


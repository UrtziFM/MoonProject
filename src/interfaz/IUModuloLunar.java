package interfaz;

import javax.swing.*;

import modelo.ModuloLunar;
import modelo.EstacionMedicionAmbiental;
import modelo.BateriaPanelSolar;

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
	private JPanel panelSuperior;
	private JPanel panelBotonHerramientas;
	private JButton btnVerInfoHerramientas;
	private JPanel panelControles;
	private JPanel plPaneles;
	private JLabel lblPaneles;
	private JTextField resultPaneles;
	private JPanel plTemperatura;
    private JLabel lblTemperatura;
	private JTextField resultTemperatura;
	private JPanel plSensoresUV;
	private JLabel lblSensoresUV;
	private JTextField resultSensoresUV;
	private JPanel plNivelBateria;
	private JLabel lblNivelBateria;
	private JTextField resultNivelBateria;
	private JPanel panelNombreMision;
	private JLabel lblNombreMision;
	private JPanel panelInferior;
	private JPanel panelBotones;
	private JButton btnIniciarMision;
	private JButton btnActivarEscanerAuxiliar;
	private JPanel panelInfoControl;
	private JLabel lblInfoControl;
	private JTextArea textMensajes;
	private JPanel panelInfoMision;
	private JLabel lblInfoMision;
	private JTextArea resultMision;

	//modelo asbtracto que manipula la IU

	private EstacionMedicionAmbiental estacionMA = new EstacionMedicionAmbiental();

	private BateriaPanelSolar nivelBateria = new BateriaPanelSolar();

	private ModuloLunar moduloLunar = new ModuloLunar();

	public IUModuloLunar() {
		
		inicializarControles();
	}
	
	private void inicializarControles() {
		
		// Configurar el titulo y el tamano de la ventana
		setTitle("IU MODULO LUNAR");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crear componentes de la interfaz grafica
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.BLACK);
        panelSuperior.setPreferredSize(new Dimension(600, 250));

		panelBotonHerramientas = new JPanel();
		panelBotonHerramientas.setBackground(Color.BLUE);
        panelBotonHerramientas.setPreferredSize(new Dimension(250, 40));
		btnVerInfoHerramientas = new JButton("Comprobar Status Herramientas");

		panelControles = new JPanel();
        panelControles.setPreferredSize(new Dimension(250, 240));
		panelControles.setLayout(new GridLayout(4, 4));

		plPaneles = new JPanel();
		lblPaneles = new JLabel("Estado de los Paneles");
		plPaneles.setBackground(Color.WHITE);
		resultPaneles = new JTextField();
		resultPaneles.setBackground(Color.RED);
	

		plTemperatura = new JPanel();
		lblTemperatura = new JLabel("Temperatura");
		plTemperatura.setBackground(Color.WHITE);
		resultTemperatura = new JTextField();
		resultTemperatura.setBackground(Color.RED);
		

		plSensoresUV = new JPanel();
		lblSensoresUV = new JLabel("Sensores UV");
		plSensoresUV.setBackground(Color.WHITE);
		resultSensoresUV = new JTextField();
		resultSensoresUV.setBackground(Color.RED);

		plNivelBateria = new JPanel();
		lblNivelBateria = new JLabel("Nivel de Batería");
		plNivelBateria.setBackground(Color.WHITE);
		resultNivelBateria = new JTextField();
		resultNivelBateria.setBackground(Color.RED);

		panelNombreMision = new JPanel();
		lblNombreMision = new JLabel("Viaje a la Luna: Comprueba Estado Herramientas primero, se habilitaran los botones de Inicio segun capacidad");
		lblNombreMision.setForeground(Color.BLACK);
		panelNombreMision.setBackground(Color.YELLOW);
		panelNombreMision.setPreferredSize(new Dimension(1000, 50));

		panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(1000, 500));

		panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLUE);
		panelBotones.setPreferredSize(new Dimension(250, 100));
		btnIniciarMision = new JButton("Iniciar mision de reconocimiento");
		btnIniciarMision.setPreferredSize(new Dimension(100, 40));
		btnActivarEscanerAuxiliar = new JButton("Activar Modulo Vision Auxiliar");
		btnActivarEscanerAuxiliar.setPreferredSize(new Dimension(100, 30));

		panelInfoControl = new JPanel();
		panelInfoControl.setPreferredSize(new Dimension(300, 475));
		lblInfoControl = new JLabel("Informacion Control");
		lblInfoControl.setPreferredSize(new Dimension(50,50));
		textMensajes = new JTextArea();
		textMensajes.setBackground(Color.WHITE);

		panelInfoMision = new JPanel();
		panelInfoMision.setPreferredSize(new Dimension(400, 475));
		lblInfoMision = new JLabel("Informacion Mision");
		lblInfoMision.setPreferredSize(new Dimension(50,50));
		resultMision = new JTextArea();
		resultMision.setBackground(Color.BLACK);
		resultMision.setForeground(Color.WHITE);

		// Instanciamos el modulo lunar y le pasamos la propia refrencia a esta interfaz (enlace bidireccional)
		// esto es importante porque Modulo lunar tienen que invocar metodos de la interfaz
		moduloLunar = new ModuloLunar(this);
		
		// Configurar la disposici0n de elementos de la interfaz grafica
		panelControles.add(plPaneles);
		panelControles.add(plTemperatura);
		panelControles.add(plSensoresUV);
		panelControles.add(plNivelBateria);

		plPaneles.setLayout(new BorderLayout());
		plPaneles.add(lblPaneles, BorderLayout.CENTER);
		plPaneles.add(resultPaneles, BorderLayout.SOUTH);

		plTemperatura.setLayout(new BorderLayout());
		plTemperatura.add(lblTemperatura, BorderLayout.CENTER);
		plTemperatura.add(resultTemperatura, BorderLayout.SOUTH);

		plSensoresUV.setLayout(new BorderLayout());
		plSensoresUV.add(lblSensoresUV, BorderLayout.CENTER);
		plSensoresUV.add(resultSensoresUV, BorderLayout.SOUTH);

		plNivelBateria.setLayout(new BorderLayout());
		plNivelBateria.add(lblNivelBateria, BorderLayout.CENTER);
		plNivelBateria.add(resultNivelBateria, BorderLayout.SOUTH);

		panelBotonHerramientas.add(btnVerInfoHerramientas, BorderLayout.CENTER);

		panelSuperior.add(panelBotonHerramientas, BorderLayout.WEST);
		panelSuperior.add(panelControles, BorderLayout.EAST);

		panelNombreMision.add(lblNombreMision, BorderLayout.SOUTH);

		panelBotones.setLayout(new BorderLayout());
		panelBotones.add(btnIniciarMision, BorderLayout.NORTH);
		panelBotones.add(btnActivarEscanerAuxiliar, BorderLayout.SOUTH);

		panelInfoControl.setLayout(new BorderLayout());
		panelInfoControl.add(lblInfoControl, BorderLayout.NORTH);
		panelInfoControl.add(new JScrollPane(textMensajes), BorderLayout.CENTER);

		panelInfoMision.setLayout(new BorderLayout());
		panelInfoMision.add(lblInfoMision, BorderLayout.NORTH);
		panelInfoMision.add(new JScrollPane(resultMision), BorderLayout.CENTER);

		panelInferior.add(panelBotones, BorderLayout.WEST);
		panelInferior.add(panelInfoControl, BorderLayout.CENTER);
		panelInferior.add(panelInfoMision, BorderLayout.EAST);

		// Agregar los componentes a la ventana
		add(panelSuperior, BorderLayout.NORTH);
		add(panelNombreMision, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);
		
  
		// Registrar el manejador de eventos para los botones
		ActionListener iniciarMisionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMensajeConsola("INFO: Modulo Vision inicializado....");
				setMensajeConsola("INFO: Las herramientas necesarias ya están listas, se puede iniciar la misión... ");
				moduloLunar.desarrollarMisionReconocimiento();
			}
		};

		ActionListener activarEscanerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMensajeConsola("INFO: Bateria inferior a 50%, Modulo Vision auxiliar activado ... ");
				moduloLunar.cambiarModuloVisionAuxiliar();
			}
		};

		btnIniciarMision.addActionListener(iniciarMisionListener);
		btnIniciarMision.setEnabled(false);

		btnActivarEscanerAuxiliar.addActionListener(activarEscanerListener);
		btnActivarEscanerAuxiliar.setEnabled(false);

		// Primero el boton de estado de las herramientas del modulo lunar
		// Debe ser independiente del boton de iniciar mision, y servira como control para iniciar la mision
		// Si esta todo ok es cuando se puede iniciar la mision
		btnVerInfoHerramientas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Primero comprobamos el estado de las herramientas
				
				int mastil = estacionMA.getEstadoMastil();

				if(mastil == 0){
					resultPaneles.setBackground(Color.RED);
					setMensajeConsola("INFO: Paneles NO desplegados...");
				} else {
					resultPaneles.setBackground(Color.GREEN);
					setMensajeConsola("INFO: Paneles desplegados...");
				}

				int temp = estacionMA.getTemperatura();

				if(temp > 214){
					resultTemperatura.setBackground(Color.RED);
				} else {
					resultTemperatura.setBackground(Color.GREEN);
				}

				resultTemperatura.setText(String.valueOf(temp));
	
				if(estacionMA.getEstadoSensorUV() == 0){
					resultSensoresUV.setBackground(Color.RED);
				} else {
					resultSensoresUV.setBackground(Color.GREEN);
				}

				int bat = nivelBateria.getEstadoBateria();

				if(bat < 50){
					resultNivelBateria.setBackground(Color.RED);
					setMensajeConsola("INFO: Bateria inferior al 50%...");
				} else {
					resultNivelBateria.setBackground(Color.GREEN);
					setMensajeConsola("INFO: Bateria superior al 50%...");
				}

				resultNivelBateria.setText(String.valueOf(bat));
				
				// Si estan todos las herramientas ok, desplegamos el mastil y habilitamos los botones 
				// El nivel de bateria no se tiene en cuenta ya que en caso de estar por debajo %50 vamos al escaner auxiliar

				if (mastil == 1 && bat > 50) {
					btnIniciarMision.setEnabled(true);
					btnActivarEscanerAuxiliar.setEnabled(false);
				} else if(mastil == 1 && bat < 50){
					btnIniciarMision.setEnabled(false);
					btnActivarEscanerAuxiliar.setEnabled(true);
				} else {
					btnIniciarMision.setEnabled(false);
					btnActivarEscanerAuxiliar.setEnabled(false);
				}
			}
		});

		// Mostrar la ventana
		setVisible(true);
	}
	
	/**
	 * SetMensaje permite imprimir un mensaje en el cuadro de texto de la interfaz gr�fica
	 * @param msg
	 */
	public void setMensajeConsola(String msg) {
		String newline = "\n";
		textMensajes.append(msg + newline);
	}

	public void setMensajeMision(String msgM) {
		String newline = "\n";
		resultMision.append(msgM + newline);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		 
	}
	

	public static void main(String[] args) {
		// Crear y mostrar la interfaz gr�fica en el hilo de eventos de Swing
		SwingUtilities.invokeLater(() -> {
			new IUModuloLunar();
		});
	}
}


/*
 * ESCUELA POLITECNICA NACIONAL
 * COMPILADORES Y LENGUAJES
 * PROYECTO
 * Nombres: Roberto Toapanta, Bryan Jarrin.
 * GR!
 * Tema: Analizaodr Lexico.
 */
package EscritorioPrin;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import BusArchivo.BuscarArchivo;

public class Indicaciones extends JFrame implements ActionListener{
	private JFrame jfrVentana;
	private JPanel pnlSuperior,pnlInferior;
	private JLabel jlaComentario,jlaVacio;
	private JButton jbuAceptar,jbuCancelar;
	private JLabel jlaIndicacion;
	private JTextArea jtexIndicacion;
	
	public Indicaciones() {
		construirPnlSuperior();
		construirPnlInferior();
		construirVentana();	
	}
	
	public void construirPnlSuperior(){
		pnlSuperior = new JPanel();
		pnlSuperior.setLayout(new GridLayout(1,1,5,5));

		jtexIndicacion = new JTextArea();
		jtexIndicacion.setFont(new Font("Monospaced", Font.PLAIN, 14));
		jtexIndicacion.setPreferredSize(new Dimension(1300,3000));
		jtexIndicacion.append("\n\t\t\tBIENVENIDOS AL ANALIZADOR LEXICO\n\tCreadores: Roberto Toapanta y Bryan Jarrin\n\tUniversidad : ESCUELA POLITECNICA NACIONAL\n\tIngeniero : Ivan Carrera");
		jtexIndicacion.append("\n\tInformacion:\n\tNuestro prorgama es un analizador texto, en el cual nos permite ingresar \n\tun archivo .txt para analizarlo y nos deveulve el resultado en un archivo \n\t.csv .Nuesto programa nos permite observar las palabras perteneciente a\n\tcada token class.El archivo de salida se encunetra en la misma carpeta \n\tdel programa\n\t");
		jtexIndicacion.append("Indicaciones:\n\t-Primeramente se ingresa el archivo a analizar \n\t-En el menu de Token Class se encuentran la palabra perteneciente\n\tal token class seleccionado");
		
		jtexIndicacion.setEditable(false);

		pnlSuperior.add(jtexIndicacion);
		pnlSuperior.setPreferredSize(new Dimension(700,350));	
	}
	
	public void construirPnlInferior(){
			pnlInferior = new JPanel();
			pnlInferior.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion:"));
			pnlInferior.setLayout(new GridLayout(2,2,5,5));

			jlaComentario= new JLabel("DESEA MANTENERSE EN EL PROGRAMA");
			jlaVacio= new JLabel("");

			jbuAceptar=new JButton();
			jbuAceptar.setText("ACEPTAR");
			jbuAceptar.setActionCommand("aceptar");
			jbuAceptar.addActionListener(this);
			jbuCancelar=new JButton();
			jbuCancelar.setText("CANCELAR");
			jbuCancelar.setActionCommand("cancelar");
			jbuCancelar.addActionListener(this);

			pnlInferior.add(jlaComentario);         pnlInferior.add(jlaVacio);
			pnlInferior.add(jbuAceptar);            pnlInferior.add(jbuCancelar);

			pnlInferior.setPreferredSize(new Dimension(500,80));

	}
	
	public void construirVentana(){
		jfrVentana= new JFrame("INDICACIONES ANALIZADOR LEXICO");
		jfrVentana.setLayout(new BoxLayout(jfrVentana.getContentPane(), BoxLayout.Y_AXIS));
		jfrVentana.add(pnlSuperior);
		jfrVentana.add(pnlInferior);
		jfrVentana.pack();
		jfrVentana.setResizable(false);
		jfrVentana.setVisible(true);
		jfrVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jfrVentana.setBounds(4, 5, 700, 430);
	}
	@Override
	public void actionPerformed(ActionEvent comando) {
		String strAccionarBoton = String.valueOf(comando.getActionCommand());
		if(strAccionarBoton.equals("aceptar")){
			jfrVentana.setVisible(false);
		}
		if(strAccionarBoton.equals("cancelar")){
			System.exit(0);
		}
	}
	
	public static void main (String [] args ){
		Indicaciones main=new Indicaciones();
	}
}
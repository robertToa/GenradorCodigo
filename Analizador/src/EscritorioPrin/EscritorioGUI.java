/*
 * ESCUELA POLITECNICA NACIONAL
 * COMPILADORES Y LENGUAJES
 * PROYECTO
 * Nombres: Roberto Toapanta, Bryan Jarrin.
 * GR!
 * Tema: Analizaodr Lexico.
 */
package EscritorioPrin;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import EscritorioPrin.*;
import Token.*;
import AnalizadorL.analizadorLex;
import BusArchivo.BuscarArchivo;

public class EscritorioGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	protected escritorio escritorio=new escritorio();
	private boolean verificacion=false;
	public EscritorioGUI(){
		super("ANALIZADOR LEXICO");
		this.setGui();
		this.setBounds(0, 0, 900, 600);
		this.setVisible(true);
	}


	private void setGui() {
		Container contenedor = this.getContentPane();
		contenedor.add(escritorio);

		JMenuBar menuBarra=new JMenuBar();
		this.setJMenuBar(menuBarra);

		JMenu archivo = new JMenu("ARCHIVOS");

		JMenuItem entrada = new JMenuItem("Entrada");	
		entrada.setIcon(new ImageIcon("imagenes/new.png"));
		entrada.setActionCommand("entrada");
		entrada.addActionListener(this);
		archivo.add(entrada);

		JMenuItem salida = new JMenuItem("Indicaciones");	
		salida.setIcon(new ImageIcon("imagenes/new.png"));
		salida.setActionCommand("indicaciones");
		salida.addActionListener(this);
		archivo.add(salida);
		menuBarra.add(archivo);

		JMenu token = new JMenu("TOKEN CLASS");

		JMenuItem General = new JMenuItem("General");	
		General.setIcon(new ImageIcon("imagenes/new.png"));
		General.setActionCommand("general");
		General.addActionListener(this);
		token.add(General);

		JMenuItem PalabrasReservadas = new JMenuItem("Palabras Reservadas");	
		PalabrasReservadas.setIcon(new ImageIcon("imagenes/new.png"));
		PalabrasReservadas.setActionCommand("reservadas");
		PalabrasReservadas.addActionListener(this);
		token.add(PalabrasReservadas);

		JMenuItem CaraceteresEspeciales = new JMenuItem("Caraceteres Especiales");	
		CaraceteresEspeciales.setIcon(new ImageIcon("imagenes/new.png"));
		CaraceteresEspeciales.setActionCommand("caracteres");
		CaraceteresEspeciales.addActionListener(this);
		token.add(CaraceteresEspeciales);

		JMenuItem OperadoresCompuestos = new JMenuItem("OperadoresCompuestos");	
		OperadoresCompuestos.setIcon(new ImageIcon("imagenes/new.png"));
		OperadoresCompuestos.setActionCommand("operadores");
		OperadoresCompuestos.addActionListener(this);
		token.add(OperadoresCompuestos);

		JMenuItem Identificadores= new JMenuItem("Identificadores");	
		Identificadores.setIcon(new ImageIcon("imagenes/new.png"));
		Identificadores.setActionCommand("identificadores");
		Identificadores.addActionListener(this);
		token.add(Identificadores);

		JMenuItem Literales= new JMenuItem("Literales");	
		Literales.setIcon(new ImageIcon("imagenes/new.png"));
		Literales.setActionCommand("literales");
		Literales.addActionListener(this);
		token.add(Literales);

		JMenuItem Error = new JMenuItem("Errores");	
		Error.setIcon(new ImageIcon("imagenes/new.png"));
		Error.setActionCommand("error");
		Error.addActionListener(this);
		token.add(Error);
		menuBarra.add(token);

		JMenu Salir = new JMenu("SALIR");
		JMenuItem salir1 = new JMenuItem("Salir");
		salir1.setActionCommand("salir");
		salir1.addActionListener(this);
		Salir.add(salir1);
		menuBarra.add(Salir);
	}

	private boolean mensaje(){
		
		if(!BuscarArchivo.fileName.equals("")){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Ingrese primeramente el archivo a analizar: ARCHIVO - entrada\nLea las indicaciones donde se encuentra detallado nuestro prorgama");
			return false;
		}
	}

	public static void main(String[] args) {
		EscritorioGUI main=new EscritorioGUI();
		main.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public void actionPerformed(ActionEvent evento) {
		String comando=evento.getActionCommand();
		if(comando.equals("entrada")){
			BuscarArchivo rc=new BuscarArchivo();
		}
		if(comando.equals("indicaciones")) {
			Indicaciones rc=new Indicaciones();
		}
		if(comando.equals("general")) {
			if(verificacion!=mensaje()){
				TokenGeneral rc=new TokenGeneral(); 
			}
		}
		if(comando.equals("literales")) {
			if(verificacion!=mensaje()){
				Literales rc=new Literales(); 
			}
		}
		if(comando.equals("identificadores")) {
			if(verificacion!=mensaje()){
				Identificadores rc=new Identificadores(); 
			}
		}
		if(comando.equals("operadores")) {
			if(verificacion!=mensaje()){
				OperacionCom rc=new OperacionCom();
			}
		}
		if(comando.equals("caracteres")) {
			if(verificacion!=mensaje()){
				CaracteresEsp rc=new CaracteresEsp();
			}
		}
		if(comando.equals("reservadas")) {
			if(verificacion!=mensaje()){
				PalabrasRes rc=new PalabrasRes();
			}
		}
		if(comando.equals("error")) {
			if(verificacion!=mensaje()){
				Errores rc=new Errores(); 
			}
		}
		if(comando.equals("salir")){
			System.exit(-1);
		}


	}
}

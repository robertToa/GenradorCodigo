package EscritorioPrin;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import BusArchivo.BuscarArchivo;

public class Indicaciones extends JFrame implements ActionListener{
	private JFrame jfrVentana;
	private JPanel pnlSuperior,pnlInferior;
	private JButton jbuAceptar,jbuSalir;
	private JLabel jlaIndicacion;
	private JTextArea jtexIndicacion;
	private JScrollPane jscindicacion;
	
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
		jtexIndicacion.append("\n\t\t\tBIENVENIDOS AL ANALIZADOR LEXICO\n");
		jtexIndicacion.setEditable(false);

		pnlSuperior.add(jtexIndicacion);
		pnlSuperior.setPreferredSize(new Dimension(700,350));	
	}
	
	public void construirPnlInferior(){
		pnlInferior = new JPanel();
		pnlInferior.setBorder(javax.swing.BorderFactory.createTitledBorder("Lextura del archivo de enrtada"));
		pnlInferior.setLayout(new GridLayout(1,2));
		
		jlaIndicacion= new JLabel("Ingresar el archivo a analizar");
		jbuAceptar=new JButton();
		jbuAceptar.setText("ACEPTAR");
		jbuAceptar.setActionCommand("aceptar");
		jbuAceptar.addActionListener(this);
		
		pnlInferior.add(jlaIndicacion);  pnlInferior.add(jbuAceptar); 
		pnlInferior.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
		pnlInferior.setPreferredSize(new Dimension(700,40));
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
		jfrVentana.setBounds(4, 5, 700, 400);
	}
	@Override
	public void actionPerformed(ActionEvent comando) {
		String strAccionarBoton = String.valueOf(comando.getActionCommand());
		if(strAccionarBoton.equals("aceptar")){
			BuscarArchivo rc=new BuscarArchivo();
		}
	}
	
	public static void main (String [] args ){
		new Indicaciones();
	}
}
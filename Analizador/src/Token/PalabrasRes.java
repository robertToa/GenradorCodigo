/*
 * ESCUELA POLITECNICA NACIONAL
 * COMPILADORES Y LENGUAJES
 * PROYECTO
 * Nombres: Roberto Toapanta, Bryan Jarrin.
 * GR!
 * Tema: Analizaodr Lexico.
 */
package Token;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import AnalizadorL.analizadorLex;
import javax.swing.table.DefaultTableModel;

public class PalabrasRes extends JFrame implements ActionListener{
	private JFrame jfrVentana;
	private JPanel pnlSuperior,pnlInferior;
	private JLabel jlaComentario,jlaVacio;
	private JButton jbuAceptar,jbuCancelar;
	private JTable jtaTabla;
	public DefaultTableModel dtmTabla= new DefaultTableModel();
	private JScrollPane jscTabla;

	public PalabrasRes() {
		construirPnlSuperior();
		construirPnlInferior();
		ImpresionPalabras();
		construirVentana();	

	}

	public void construirPnlInferior(){
		pnlSuperior = new JPanel();
		pnlSuperior.setLayout(new GridLayout(1,1));

		jtaTabla=new JTable(dtmTabla);
		jtaTabla.setPreferredSize( new Dimension(300,1000));
		jscTabla= new JScrollPane();
		jtaTabla.setEnabled(false);
		jscTabla.setViewportView(jtaTabla);
		String[ ] datos = {"PALABRA","LINEA"};
		for(int i=0;i<2;i++){
			dtmTabla.addColumn("");
		}
		dtmTabla.addRow(datos);
		

		pnlSuperior.add(jscTabla); 
		pnlSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
		pnlSuperior.setPreferredSize(new Dimension(500,400));
	}
	
	public void construirPnlSuperior(){
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
		jfrVentana= new JFrame("PALABRAS RESERVADAS EN EL TEXTO");
		jfrVentana.setLayout(new BoxLayout(jfrVentana.getContentPane(), BoxLayout.Y_AXIS));
		jfrVentana.add(pnlSuperior);
		jfrVentana.add(pnlInferior);
		jfrVentana.pack();
		jfrVentana.setResizable(false);
		jfrVentana.setVisible(true);
		jfrVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jfrVentana.setBounds(4, 5, 500, 400);
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
	
	private void ImpresionPalabras(){
		String[] datoFin=new String[2];
		for(int i=0;i<analizadorLex.cadena.size();i++){
			String[] cadena=(analizadorLex.cadena.get(i)).split(";");
				if(cadena[0].equals("Palabra reservada")){
					datoFin[0]=cadena[1];
							datoFin[1]=cadena[2];
					dtmTabla.addRow(datoFin);
				}
		}
		
		
	}

	public static void main (String [] args ){
		PalabrasRes main=new PalabrasRes();
		main.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
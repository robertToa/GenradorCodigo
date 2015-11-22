/*
 * ESCUELA POLITECNICA NACIONAL
 * COMPILADORES Y LENGUAJES
 * PROYECTO
 * Nombres: Roberto Toapanta, Bryan Jarrin.
 * GR!
 * Tema: Analizaodr Lexico.
 */
package BusArchivo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import AnalizadorL.analizadorLex;
import EscritorioPrin.EscritorioGUI;

public class BuscarArchivo {
public static String fileName="";
public static String fileNameSalida="";
private JFrame frame = new JFrame("ARCHIVO DE ENTRADA");
public BuscarArchivo(){
	    JFileChooser fileChooser = new JFileChooser(".");
	    FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "txt");
        fileChooser.setFileFilter(filtro);
	    fileChooser.setControlButtonsAreShown(true);
	    frame.add(fileChooser, BorderLayout.CENTER);
	    ActionListener actionListener = new ActionListener() {
	      public void actionPerformed(ActionEvent actionEvent) {
	        JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();	        
	        String command = actionEvent.getActionCommand();
	        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
	          File selectedFile = theFileChooser.getSelectedFile();
	         fileName=selectedFile.getParent()+"\\" +selectedFile.getName();
	         cerrar();
	         fileNameSalida=JOptionPane.showInputDialog("Ingresar Nombre del archivo de salida");
	         analizadorLex pc=new analizadorLex();
	         
	        } else if (command.equals(JFileChooser.CANCEL_SELECTION)){
	          System.out.println(JFileChooser.CANCEL_SELECTION);
	        }
	      }
	    };
	    fileChooser.addActionListener(actionListener);
	    frame.pack();
	    frame.setVisible(true);
}

public void cerrar(){
	frame.setVisible(false);
}

  public static void main(String[] a) {
	  new BuscarArchivo();
  }
}

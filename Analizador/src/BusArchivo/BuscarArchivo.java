package BusArchivo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import EscritorioPrin.EscritorioGUI;

public class BuscarArchivo {
public static String fileName;

public BuscarArchivo(){
	 JFrame frame = new JFrame("JFileChooser Popup");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JFileChooser fileChooser = new JFileChooser(".");
	    fileChooser.setControlButtonsAreShown(false);
	    frame.add(fileChooser, BorderLayout.CENTER);
	    ActionListener actionListener = new ActionListener() {
	      public void actionPerformed(ActionEvent actionEvent) {
	        JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();
	        String command = actionEvent.getActionCommand();
	        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
	          File selectedFile = theFileChooser.getSelectedFile();
	         fileName=selectedFile.getParent()+"\\" +selectedFile.getName();
	         EscritorioGUI rc= new EscritorioGUI();
	        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
	          System.out.println(JFileChooser.CANCEL_SELECTION);
	        }
	      }
	    };
	    fileChooser.addActionListener(actionListener);
	    frame.pack();
	    frame.setVisible(true);
}

  public static void main(String[] a) {
	  BuscarArchivo main=new BuscarArchivo();
  }
}

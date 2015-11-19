package AnalizadorL;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import AnalizadorL.TokenClass;

import javax.swing.*;

import java.io.*;
public class analizadorLex{	
	TokenClass patron=new TokenClass();
	private boolean verificacion;
	private String palabra;
	public analizadorLex(){
			verificacion=false;
			//texto=JOptionPane.showInputDialog("Ingresar dato: ");
			lecturaArchivo();
	}
	
	private void lecturaArchivo(){
		try{
			FileReader fileName=new FileReader("C:\\Users\\Roberto\\Documents\\GitHub\\repositorio\\Analizador\\doc\\hola.txt");
			BufferedReader br=new BufferedReader(fileName);
			String cadena;
			while((cadena=br.readLine())!=null){
				StringTokenizer st = new StringTokenizer(cadena);
				while (st.hasMoreTokens()){
					palabra=st.nextToken();
					VerificarTokenClass(palabra);//Enviamos la palabra para saber a que token class pertenece.
				}
				
			}
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void VerificarTokenClass(String texto){
		for(int i=0 ; i<7 ;i++){
			switch(i){
			case 0:
				if(verificacion!=patron.PalabraReservada(texto)){
					System.out.println("Palabra reservda: "+texto);
					i=7;
				}
				break;
			case 1:
				if(verificacion!=patron.Identificador(texto)){
					System.out.println("Identificador: "+texto);
					i=7;
				}
				break;
			case 2:
				if(verificacion!=patron.Numero(texto)){
					System.out.println("Numero: "+texto);
					i=7;
				}
				break;
			case 3:
				if(verificacion!=patron.Operador(texto)){
					System.out.println("Operador: "+texto);
					i=7;
				}
				break;
			case 4:
				if(verificacion!=patron.Agrupadores(texto)){
					System.out.println("Agrupador: "+texto);
					i=7;
				}
				break;
			case 5:
				if(verificacion!=patron.Terminador(texto)){
					System.out.println("Terminador: "+texto);
					i=7;
				}
				break;
			default:
				System.out.println("No es un Token Class: "+texto);
				break;
			}
		}
	}

	public static void main (String [] args ){
		new analizadorLex();
	}
}


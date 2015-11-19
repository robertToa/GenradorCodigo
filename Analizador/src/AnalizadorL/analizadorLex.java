package AnalizadorL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import AnalizadorL.TokenClass;
import javax.swing.*;
public class analizadorLex{	
	TokenClass patron=new TokenClass();
	private boolean verificacion;
	private String texto;
	public analizadorLex(){
		verificacion=false;
		texto="1.432";
		VerificarTokenClass();
		
	}
	
	private void VerificarTokenClass(){
		for(int i=0 ; i<7 ;i++){
			switch(i){
			case 0:
				if(verificacion!=patron.PalabraReservada(texto)){
					System.out.println("Palabra reservda");
					i=6;
				}
				break;
			case 1:
				if(verificacion!=patron.Identificador(texto)){
					System.out.println("Identificador");
					i=6;
				}
				break;
			case 2:
				if(verificacion!=patron.Numero(texto)){
					System.out.println("Numero");
					i=6;
				}
				break;
			case 3:
				if(verificacion!=patron.Operador(texto)){
					System.out.println("Operador");
					i=6;
				}
				break;
			case 4:
				if(verificacion!=patron.Agrupadores(texto)){
					System.out.println("Agrupador");
					i=6;
				}
				break;
			case 5:
				if(verificacion!=patron.Terminador(texto)){
					System.out.println("Terminador");
					i=6;
				}
				break;
				
			default:
				System.out.println("No es un Token Class");
				break;
			}
		}
	}
	
	public static void main (String [] args ){
		
		new analizadorLex();
		
		
	}
}


/*
 * ESCUELA POLITECNICA NACIONAL
 * COMPILADORES Y LENGUAJES
 * PROYECTO
 * Nombres: Roberto Toapanta, Bryan Jarrin.
 * GR!
 * Tema: Analizaodr Lexico.
 */
package AnalizadorL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import AnalizadorL.TokenClass;
import BusArchivo.BuscarArchivo;
import java.io.*;
public class analizadorLex{	
	BuscarArchivo archivoIngreso=new BuscarArchivo();
	TokenClass patron=new TokenClass();
	private boolean verificacion;
	private String palabra;	
	private ArrayList <String> cadena =new ArrayList<String>();
	
	public analizadorLex(){
			lecturaArchivo();
	}
	
	private void lecturaArchivo(){
		try{
			FileReader fileName=new FileReader(archivoIngreso.fileName);
			BufferedReader br=new BufferedReader(fileName);
			String cadena;
			while((cadena=br.readLine())!=null){
				StringTokenizer st = new StringTokenizer(cadena);
				while (st.hasMoreTokens()){
					palabra=st.nextToken();
					VerificarTokenClass(palabra);
				}
				CrearArchivoSalida();
			}
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CrearArchivoSalida(){
		try{
			FileWriter fileNa=new FileWriter("salida.csv");
			BufferedWriter br=new BufferedWriter(fileNa);
			PrintWriter wr=new PrintWriter(br);
			wr.write("TOKEN CLASS;PALABRA;LINEA DE ERROR\n");
			for(int i=0;i<cadena.size();i++){
				wr.write(cadena.get(i));
				wr.write("\n");
			}
			wr.close();
			br.close();
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void VerificarTokenClass(String texto){
		verificacion=false;
		for(int i=0 ; i<6 ;i++){
			switch(i){
			case 0:
				if(verificacion!=patron.PalabraReservada(texto)){
					cadena.add("Palabra reservada;"+texto+";NO");
					i=7;
				}
				break;
			case 1:
				if(verificacion!=patron.Literales(texto)){
					cadena.add("Literales;"+texto+";NO");
					i=7;
				}
				break;
			
			case 2:
				if(verificacion!=patron.OperadorCompuesto(texto)){
					cadena.add("Operador Compuesto;"+texto+";NO");
					i=7;
				}
				break;
			case 3:
				if(verificacion!=patron.CaracterEspecial(texto)){
					cadena.add("Caracter Especial;"+texto+";NO");
					i=7;
				}
				break;
			case 4:
				if(verificacion!=patron.Identificador(texto)){
					cadena.add("Identificador;"+texto+";NO");
					i=7;
				}
				break;
			default:
				cadena.add("No Token Class;"+texto+";Li");
				break;
			}
		}
	}
	public static void main (String [] args ){
		new analizadorLex();
	}
}


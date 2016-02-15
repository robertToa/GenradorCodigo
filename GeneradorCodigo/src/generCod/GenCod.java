package generCod;
import java.util.ArrayList;
import java.util.StringTokenizer;
class GenCod{
	public ArrayList<String> hola=new ArrayList<String>();
	String cadena="a = 4";
	public  GenCod(){
		hola.add("a");
		hola.add("b");
		hola.add("c");
		hola.add("d");
		hola.add("e");
		hola.add("f");
		for(int i=0;i<=5;i++){
		switch(i){
		case 0:
			cadena="int: a = 3";
			Inicializacion(cadena);
			cadena="int: a = e";
			Inicializacion(cadena);
			break;
		case 1:
			cadena="a = 4";
			Declaracióndevariables(cadena);
			cadena="c = e";
			Declaracióndevariables(cadena);
			break;
		case 2:
			cadena="d = e + b * 3 - 40";
			Expresionesaritméticas(cadena);
			break;
		case 3:
			Expresioneslógicas(cadena);
			break;
		case 4:
			ComandosdeControldeFlujo(cadena);
			break;
		}
		}
	}
	
	void Inicializacion(String texto){
		StringTokenizer st = new StringTokenizer(texto);
		String palabra;
		palabra=st.nextToken();
		palabra="";
		try{
			while (st.hasMoreTokens()){	
				palabra +=(st.nextToken()+" ");
			}}catch(Exception e){}
		Declaracióndevariables(palabra);
	}
	
	void Declaracióndevariables(String texto){
		StringTokenizer st = new StringTokenizer(texto);
		String palabra[]=new String[3];
		int i=0;
		try{
		while (st.hasMoreTokens()){	
			palabra[i]=st.nextToken();
			i++;
		}}catch(Exception e){}
		if(hola.indexOf(palabra[0])==-1)
			hola.add(palabra[0]);
		letraNum(palabra[2],"a0");
		System.out.println("store a0 => r" + hola.indexOf(palabra[0]));	
	}
	void Expresionesaritméticas(String texto){
		StringTokenizer st = new StringTokenizer(texto);
		String palabra[]=new String[5];
		try{
			for(int i=0;i<5;i++)
				palabra[i]=st.nextToken();			
		}catch(Exception e){}
		letraNum(palabra[2],"t1");
		letraNum(palabra[4],"t2");
		Operaciones(palabra[3],"t2");
		try{
			while (st.hasMoreTokens()){	
				palabra[3]=st.nextToken();
				palabra[4]=st.nextToken();
				letraNum(palabra[4],"t1");
				Operaciones(palabra[3],"t3");
			}
		}catch(Exception e){}
		System.out.println("Load t3 => a0");
		System.out.println("store a0 => r" + hola.indexOf(palabra[0]));
	}
	void Expresioneslógicas(String texto){
		
	}
	void ComandosdeControldeFlujo(String texto){
		
	}
	
	void letraNum(String tex,String da){
		if(tex.matches("[0-9]*"))
			System.out.println("LoadI "+tex+" => "+da);
		else
			System.out.println("Load r"+hola.indexOf(tex)+" => "+da);
	}
	void Operaciones(String text, String da){
		if(text.equals("+"))
			System.out.println("ADD t1, "+da+" => t3");
		if(text.equals("-"))
			System.out.println("SUB t1, "+da+" => t3");
		if(text.equals("*"))
			System.out.println("MULT t1, "+da+" => t3");
		if(text.equals("/"))
			System.out.println("DIV t1, "+da+" => t3");
	}
	
	public static void main (String [] args ){
		new GenCod();
	}
}
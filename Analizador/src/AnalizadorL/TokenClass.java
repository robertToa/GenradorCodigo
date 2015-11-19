package AnalizadorL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TokenClass{
	public boolean PalabraReservada(String texto){
		 Pattern pat = Pattern.compile("while|for|if|do|int");
	     Matcher mat = pat.matcher(texto);
	     if (mat.matches()) {
	         return true;
	     } else {
	         return false;
	     }
	}
	
	public boolean Identificador(String texto){
		 Pattern pat = Pattern.compile("[a-z][a-zA-Z0-9]*");
	     Matcher mat = pat.matcher(texto);
	     if (mat.matches()) {
	    	    return true;
	     } else {
	         return false;
	     }
	}
	public boolean Numero(String texto){
		 Pattern pat = Pattern.compile("[0-9]*(.)?[0-9]+");
	     Matcher mat = pat.matcher(texto);
	     if (mat.matches()) {
	    	    return true;
	     } else {
	         return false;
	     }
	}
	public boolean Operador(String texto){
		 Pattern pat = Pattern.compile(">|<|==|>=|=>|-|/|<=|=<|=");
	     Matcher mat = pat.matcher(texto);
	     if (mat.matches()||texto.equals("+")||texto.equals("*")) {
	    	    return true;
	     } else {
	         return false;
	     }
	}
	public boolean Agrupadores(String texto){
	     if (texto.equals("(")||texto.equals(")")||texto.equals("[")||texto.equals("]")||texto.equals("{")||texto.equals("}")) {
	    	    return true;
	     } else {
	         return false;
	     }
	}
	public boolean Terminador(String texto){
	     if (texto.equals(";")) {
	    	    return true;
	     } else {
	         return false;
	     }
	}
}


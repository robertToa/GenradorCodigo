/*
 * ESCUELA POLITECNICA NACIONAL
 * COMPILADORES Y LENGUAJES
 * PROYECTO
 * Nombres: Roberto Toapanta, Bryan Jarrin.
 * GR!
 * Tema: Analizaodr Lexico.
 */
package EscritorioPrin;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


public class escritorio extends JDesktopPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JInternalFrame[] ventanas;

	public escritorio() {
		super();
		this.putClientProperty("JDesktopPane.dragMode", "outline");
	}
	public void adicionar(JInternalFrame comp) {
		add(comp, null, 0);
	}
}

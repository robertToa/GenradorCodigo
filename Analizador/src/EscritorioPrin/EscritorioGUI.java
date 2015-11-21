package EscritorioPrin;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import EscritorioPrin.*;
import AnalizadorL.analizadorLex;

public class EscritorioGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	protected escritorio escritorio=new escritorio();

	public EscritorioGUI(){		
		super("ANALIZADOR LEXICO");
		this.setGui();
		this.setBounds(0, 0, 900, 600);
		this.setVisible(true);
	}


	private void setGui() {
		Container contenedor = this.getContentPane();
		contenedor.add(escritorio);

		JMenuBar menuBarra=new JMenuBar();
		this.setJMenuBar(menuBarra);

		JMenu archivo = new JMenu("REGISTRO");
		
		JMenuItem registro = new JMenuItem("Pedido");	
		registro.setIcon(new ImageIcon("imagenes/new.png"));
		registro.setActionCommand("pedido");
		registro.addActionListener(this);
		archivo.add(registro);
		menuBarra.add(archivo);

		JMenuItem registro1 = new JMenuItem("Cliente");	
		registro1.setIcon(new ImageIcon("imagenes/new.png"));
		registro1.setActionCommand("cliente");
		registro1.addActionListener(this);
		archivo.add(registro1);
		menuBarra.add(archivo);

		JMenu Salir = new JMenu("SALIR");
		JMenuItem salir1 = new JMenuItem("Salir");
		salir1.setActionCommand("salir");
		salir1.addActionListener(this);
		Salir.add(salir1);
		menuBarra.add(Salir);

	}


	public static void main(String[] args) {

		EscritorioGUI main=new EscritorioGUI();
		main.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


	}

	public void actionPerformed(ActionEvent evento) {
		String comando=evento.getActionCommand();

		if(comando.equals("cliente")) {
			System.out.println("se arbio al ventan");
			analizadorLex rc=new analizadorLex();
			//RegistrarCliente rc= new RegistrarCliente();
			//escritorio.add(rc);
		}
		if(comando.equals("salir")){
			System.exit(-1);
		}


	}
}

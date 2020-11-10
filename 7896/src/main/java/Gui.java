import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class Gui{
	JFrame frame;
	JPanel main_panel;
	
	String selected_file;
	
	public Gui() {
		this.frame = new JFrame("ES");
		main_panel = new JPanel();
		
		
	}
	
	public void start() {
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(main_panel);
		main_panel.setLayout(new GridLayout(3,1));
	}
	
	public void manage_gui(JPanel panel) {
		main_panel.add(panel);  // aqui adicionamos a nossa clase JPanel para JFrame
	}
	
	public void manage_gui2(JScrollPane scroll_pane) {
		main_panel.add(scroll_pane);  // aqui adicionamos a nossa clase JPanel para JFrame
	}
	public String getSelectedFile()  {  // objetiovo de sempre conseguir buscar o ficheiro EXCEL selecionado 1a
		return selected_file;
	}
	
	public void guiUpdate() {
		frame.setTitle(getSelectedFile());
	}
	
	
	public void setSelectedFile(String text) { // objetivo de conseguir quardar numa String o ficheiro selecionado 1b
		this.selected_file = text;
		///Gsdfs
		//ola
	}
	
}

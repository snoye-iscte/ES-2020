import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class getExcel extends JPanel {
	JButton browse;
	JLabel label = new JLabel("                                CODE SPELLS");
	Gui gui;
	private String selected_excel; // guarda o nome do ficheiro ecvel selecionado
	
	public getExcel(Gui gui) {
		this.gui = gui;
		browse = new JButton("Browse");
		makeItAlive();
		readFromFile();
	}
	
	public void addThings() { //adiciona elementos da SWING ao JPanel que depois vai ser usado na GUI
		this.add(browse);
		this.add(label);
	}
	
	
	
	public void makeItAlive() { // adicionar sentinela ao nosso botao brawse
		
		browse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("YOU JUST CLICKED ON BROWSE BUTTON"); //just for testng can be deleted later
				
				 JFileChooser jfc = new JFileChooser(".");
				 jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				 int returnValue = jfc.showOpenDialog(null);
				 
				 if (returnValue == JFileChooser.APPROVE_OPTION) {
					 File selectedFile = jfc.getSelectedFile();
					 selected_excel = selectedFile.getAbsolutePath();
					 System.out.println("selected dir: " + selected_excel);
					 gui.setSelectedFile(selectedFile.getAbsolutePath());
					 gui.guiUpdate();
				 }
				
			}
		});
	}
	
	public void readFromFile() throws NullPointerException{ // at the begining our file location is uknown, so wee need to use try catch or if
		
	}

}

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;



public class Gui{
	JFrame frame;
	JPanel main_panel;
	
	String selected_file;
//	browse = new JButton("Browse");
		//makeItAlive();
		
	
	public Gui() {
		this.frame = new JFrame("ES");
		main_panel = new JPanel();
		
		
	}
	
	public void start() {
		
		frame.setVisible(true);
		frame.setSize(900,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(main_panel);
		main_panel.setLayout(new GridLayout(3,1));
		
	}
	
	public void manage_gui(JPanel panel) {
		main_panel.add(panel);  // aqui adicionamos a nossa clase JPanel para JFrame
	}
	
	public void addExcelTable(JScrollPane scroll_pane) {
		main_panel.add(scroll_pane);  // aqui adicionamos a nossa clase JPanel para JFrame
	}
	public String getSelectedFile()  {  // objetiovo de sempre conseguir buscar o ficheiro EXCEL selecionado 1a
		return selected_file;
	}
	
	
	
	
	public void setSelectedFile(String text) { // objetivo de conseguir quardar numa String o ficheiro selecionado 1b
		this.selected_file = text;
		///Gsdfs
		//ola
	}
	
	
//	public void makeItAlive() { // adicionar sentinela ao nosso botao brawse
//	
//	browse.addActionListener(new ActionListener() {
//		
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("YOU JUST CLICKED ON BROWSE BUTTON"); //just for testng can be deleted later
//			
//			 JFileChooser jfc = new JFileChooser(".");
//			 jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//			 int returnValue = jfc.showOpenDialog(null);
//			 
//			 if (returnValue == JFileChooser.APPROVE_OPTION) {
//				 File selectedFile = jfc.getSelectedFile();
//				 selected_excel = selectedFile.getAbsolutePath();  //neste momento o ficheiro foi escolhido
//				 //System.out.println("selected dir: " + selected_excel);
//				 
//				 gui.setSelectedFile(selectedFile.getAbsolutePath()); //diz a gui qual ficheiro foi adicionado
//				// gui.guiUpdate();
//			 }
//			//d
//		}
//	});
//}
	
}

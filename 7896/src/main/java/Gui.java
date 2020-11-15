import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.poi.EncryptedDocumentException;



public class Gui{
	private JFrame frame;
	private JPanel main_panel;
	private JButton button_browse = new JButton("Browse");
	private getExcel get_excel = new getExcel();
	String selected_file = "Ficheiros/Defeitos.xlsx";;
//	browse = new JButton("Browse");
		//makeItAlive();
	
	
	GetChart get_chart = new GetChart();
	
		
	
	public Gui(getExcel get_excel) {
		this.frame = new JFrame("ES");
		main_panel = new JPanel();
		start();
		
	}
	
	public void start() {
		
		frame.setVisible(true);
		frame.setSize(900,1000);
		frame.setTitle(selected_file);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(main_panel);
		main_panel.setLayout(new GridLayout(3,1));
		config1();
		
		
	}
	
	public void config1() {
		makeItAlive();
		main_panel.add(get_chart);
		//main_panel.add(button_browse);
		main_panel.add(get_excel.getScroolPaneExcel());
		
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
	
	
	public void makeItAlive() { // adicionar sentinela ao nosso botao brawse
	
	button_browse.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("YOU JUST CLICKED ON BROWSE BUTTON"); //just for testng can be deleted later
			
			 JFileChooser jfc = new JFileChooser(".");
			 jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			 int returnValue = jfc.showOpenDialog(null);
			 
			 if (returnValue == JFileChooser.APPROVE_OPTION) {
				 File selectedFile = jfc.getSelectedFile();
				 selected_file = selectedFile.getAbsolutePath();  //neste momento o ficheiro foi escolhido
				 //System.out.println("selected dir: " + selected_excel);
				 try {
					 System.out.println("selected file" + selected_file);
					 main_panel.removeAll();
					 setSelectedFile(selectedFile.getAbsolutePath()); //diz a gui qual ficheiro foi adicionado
					get_excel.readFromFile(selected_file);
					addExcelTable(get_excel.getScroolPaneExcel());
				} catch (EncryptedDocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// gui.guiUpdate();
			 }
			//d
		}
	});
}
	
}

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.poi.EncryptedDocumentException;

public class Gui{
	private JFrame frame;
	private JPanel main_panel;
	private getExcel get_excel = new getExcel();
	String selected_file = "Ficheiros/Defeitos.xlsx";;

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
		main_panel.setLayout(new GridLayout(5,1));
		importFileToGUI();
	}

	public void importFileToGUI() {
		try {
			System.out.println("selected file" + selected_file);
			main_panel.removeAll();
			setSelectedFile(selected_file); //diz a gui qual ficheiro foi adicionado
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
		main_panel.add(get_excel.getScroolPaneExcel());
	}

	public void addChart(JPanel panel) {
		main_panel.add(panel);
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

	public void manage_gui(Regra regra) {
		main_panel.add(regra);
	}

}

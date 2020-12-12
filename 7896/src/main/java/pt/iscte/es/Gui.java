package pt.iscte.es;
import java.awt.BorderLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;



public class Gui extends JFrame{
	
	private JPanel main_panel;
	private JPanel panel_for_regra = new JPanel(new BorderLayout());
	private JScrollPane scroll_pane_for_chart_panel;
	private GetExcel get_excel = new GetExcel();
	private String selected_file = "Ficheiros/Defeitos.xlsx";
	
	public Gui(GetExcel get_excel) {
		
		main_panel = new JPanel();
		start();
	}

	public void start() {
		
		setVisible(true);
		setSize(900,1000);
		setTitle(selected_file);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(main_panel);
		main_panel.setLayout(new BorderLayout());
		config();
	}
	
	public void config() {
		main_panel.add(get_excel.getScroolPaneExcel());
	}
	
	public void addPanelRegra(JPanel panel) {
		panel_for_regra.add(panel, BorderLayout.NORTH);
		panel_for_regra.setSize(900, 60);
		main_panel.add(panel_for_regra,BorderLayout.SOUTH);  // aqui adicionamos a nossa clase JPanel para JFrame
	}
	
	public void addExcelTable(JScrollPane scroll_pane) {
		main_panel.add(scroll_pane, BorderLayout.WEST);  // aqui adicionamos a nossa clase JPanel para JFrame
	}
	
	public void addChart(JPanel panel) {
		scroll_pane_for_chart_panel =    new JScrollPane(panel,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_for_regra.add(scroll_pane_for_chart_panel, BorderLayout.CENTER);
		main_panel.add(panel_for_regra, BorderLayout.EAST);
	}
	
	public String getSelectedFile()  {  // objetiovo de sempre conseguir buscar o ficheiro EXCEL selecionado 1a
		return selected_file;
	}
	
	public void setSelectedFile(String text) { // objetivo de conseguir quardar numa String o ficheiro selecionado 1b
		this.selected_file = text;
	}
	
}


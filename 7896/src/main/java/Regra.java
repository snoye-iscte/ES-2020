import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Regra extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6879152907289925039L;

	private JButton runButton;
	private JTextArea text_area = new JTextArea(20,30);
	private JPanel panel_up = new JPanel();
	private JPanel panel_down = new JPanel();
	//	private JTextPane text_pane = new JTextPane();
	JScrollPane scroll_for_text_area = new JScrollPane(text_area);
	private JComboBox<String> comboBox_defeitos1, comboBox_defeitos2, comboBox_defeitos3, comboBox_operadores;
	private  JTextField textField_threshold1, textField_threshold2; 
	private List<Defeito> list_Defeitos;
	private CodeSmellDetection code_smell_detection = new CodeSmellDetection();

	/**
	 * @param list
	 * 
	 * Este construtor instancia o objecto Regra, permitindo a sua vizualização na 
	 * interface gráfica da aplicação e a possível detecção de code smells.
	 */
	public Regra(List<Defeito> list) {
		this.list_Defeitos = list;
		inicializar_Regra();
	}

	/**
	 * Este método cria a estrutura da Regra e as suas funcionalidades na interface 
	 * gráfica da aplicação.
	 */
	public void inicializar_Regra() {
		this.setLayout(new BorderLayout());
		inicializar_comboBox1();
		inicializar_comboBox2(); 
		inicializar_threshold1();
		inicializar_operadores();
		inicializar_comboBox3();
		inicializar_threshold2();
		button_function();
		panel_up.add(scroll_for_text_area);
		add(panel_up, BorderLayout.CENTER);
		add(panel_down, BorderLayout.EAST);
	}

	public void inicializar_comboBox1() {
		this.runButton = new JButton("Run");
		String[] defeitos_boolean = {"Long Method", "iPlasma", "PMD", "Feature Envy"}; 
		this.comboBox_defeitos1 = new JComboBox<String>(defeitos_boolean);
		comboBox_defeitos1.setBounds(50, 50,90,20);
		panel_up.add(comboBox_defeitos1);
	}

	public void inicializar_comboBox2() {
		String[] defeitos_integer = {"LOC", "CYCLO", "ATFD", "LAA"};
		this.comboBox_defeitos2 = new JComboBox<String>(defeitos_integer);
		comboBox_defeitos2.setBounds(50, 50,90,20);
		panel_up.add(comboBox_defeitos2);
	}

	public void inicializar_comboBox3() {
		String[] defeitos_integer = {"LOC", "CYCLO", "ATFD", "LAA"};
		this.comboBox_defeitos2 = new JComboBox<String>(defeitos_integer);
		comboBox_defeitos2.setBounds(50, 50,90,20);
		panel_up.add(comboBox_defeitos2);
	}

	public void inicializar_operadores() {
		String[] operadores = {"∧", "∨", "null"};
		this.comboBox_operadores = new JComboBox<String>(operadores);
		comboBox_operadores.setBounds(50, 50,90,20);
		panel_up.add(comboBox_operadores);
	}

	public void inicializar_threshold1() {
		this.textField_threshold1 = new JTextField(3);
		textField_threshold1.setEditable(true);
		panel_up.add(textField_threshold1);
	}

	public void inicializar_threshold2() {
		this.textField_threshold2 = new JTextField(3);
		textField_threshold2.setEditable(true);
		panel_up.add(textField_threshold2);
	}

	public void button_function() {
		text_area.setText("");

		panel_up.add(runButton);
		runButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Defeito defeito : list_Defeitos) {
					if(comboBox_defeitos1.getSelectedItem().toString() == "Long Method") {
						if(code_smell_detection.isLongMethod(Integer.parseInt(textField_threshold1.getText()),Integer.parseInt(textField_threshold2.getText()),defeito)) {
							text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using is_long_method tool \n");
						}
					}else if(comboBox_defeitos1.getSelectedItem().toString().equals("Feature Envy")) {
						code_smell_detection.isFeatureEnvy(Integer.parseInt(textField_threshold1.getText()), Integer.parseInt(textField_threshold2.getText()), defeito);
						text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using is_feature_envy tool \n");
					}
				}
			}
		});
	}

	public JButton getRunButton() {
		return runButton;
	}

	public JComboBox<String> getComboBox_defeitos1() {
		return comboBox_defeitos1;
	}

	public void setComboBox_defeitos1(JComboBox<String> comboBox_defeitos1) {
		this.comboBox_defeitos1 = comboBox_defeitos1;
	}

	public JComboBox<String> getComboBox_defeitos2() {
		return comboBox_defeitos2;
	}

	public void setComboBox_defeitos2(JComboBox<String> comboBox_defeitos2) {
		this.comboBox_defeitos2 = comboBox_defeitos2;
	}

	public JComboBox<String> getComboBox_defeitos3() {
		return comboBox_defeitos3;
	}

	public void setComboBox_defeitos3(JComboBox<String> comboBox_defeitos3) {
		this.comboBox_defeitos3 = comboBox_defeitos3;
	}

	public JComboBox<String> getComboBox_operadores() {
		return comboBox_operadores;
	}

	public void setComboBox_operadores(JComboBox<String> comboBox_operadores) {
		this.comboBox_operadores = comboBox_operadores;
	}

	public JTextField getTextField_threshold1() {
		return textField_threshold1;
	}

	public void setTextField_threshold1(JTextField textField_threshold1) {
		this.textField_threshold1 = textField_threshold1;
	}

	public JTextField getTextField_threshold2() {
		return textField_threshold2;
	}

	public void setTextField_threshold2(JTextField textField_threshold2) {
		this.textField_threshold2 = textField_threshold2;
	}

	public List<Defeito> getList_Defeitos() {
		return list_Defeitos;
	}

	public void setList_Defeitos(List<Defeito> list_Defeitos) {
		this.list_Defeitos = list_Defeitos;
	}

}
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Regra extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6879152907289925039L;
	private JButton button;
	private JTextArea text_area = new JTextArea(20,30);
	JPanel panel_up = new JPanel();
	JPanel panel_down = new JPanel();
//	private JTextPane text_pane = new JTextPane();
	JScrollPane scroll_for_text_area = new JScrollPane(text_area);
	private JComboBox<String> comboBox_defeitos1, comboBox_defeitos2, comboBox_defeitos3, comboBox_operadores;
	public  JTextField textField_threshold1, textField_threshold2; 
	private List<Defeito> list_Defeitos;
	public CodeSmellDetection code_smell_detection = new CodeSmellDetection();
	public Regra(List<Defeito> list) {
		this.list_Defeitos = list;
		inicializar_Regra();
	}

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
		this.button = new JButton("OK");
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
		
		panel_up.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Defeito defeito : list_Defeitos) {
					if(comboBox_defeitos1.getSelectedItem().toString() == "Long Method") {
						System.out.println("" + code_smell_detection.isLongMethod(Integer.parseInt(textField_threshold1.getText()),Integer.parseInt(textField_threshold2.getText()),defeito));
						
						if(code_smell_detection.isLongMethod(Integer.parseInt(textField_threshold1.getText()),Integer.parseInt(textField_threshold2.getText()),defeito)) {
							System.out.println("CodeSmell Detected " + "MethodId: " + defeito.getMethod_ID());
							text_area.append("CodeSmell Detected " + "MethodId: " + defeito.getMethod_ID() + "\n");
						
							
						}
					}
				}
				
			}
		});
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
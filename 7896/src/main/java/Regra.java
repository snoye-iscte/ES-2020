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
	private JComboBox<String> comboBox_defeitos1, comboBox_defeitos2, 
	comboBox_defeitos3, comboBox_operadores;
	private JTextField textField_threshold1, textField_threshold2; 
	private List<Defeito> list_Defeitos;

	public Regra(List<Defeito> list) {
		this.list_Defeitos = list;
		inicializar_Regra();
	}

	private void inicializar_Regra() {
		inicializar_comboBox1();
		inicializar_comboBox2(); 
		inicializar_threshold1();
		inicializar_operadores();
		inicializar_comboBox3();
		inicializar_threshold2();
		button_function();
	}

	private void inicializar_comboBox1() {
		this.button = new JButton("OK");
		String[] defeitos_boolean = {"Long Method", "iPlasma", "PMD", "Feature Envy"}; 
		this.comboBox_defeitos1 = new JComboBox<String>(defeitos_boolean);
		comboBox_defeitos1.setBounds(50, 50,90,20);
		this.add(comboBox_defeitos1);
	}
	
	private void inicializar_comboBox2() {
		String[] defeitos_integer = {"LOC", "CYCLO", "ATFD", "LAA"};
		this.comboBox_defeitos2 = new JComboBox<String>(defeitos_integer);
		comboBox_defeitos2.setBounds(50, 50,90,20);
		this.add(comboBox_defeitos2);
	}
	
	private void inicializar_comboBox3() {
		String[] defeitos_integer = {"LOC", "CYCLO", "ATFD", "LAA"};
		this.comboBox_defeitos2 = new JComboBox<String>(defeitos_integer);
		comboBox_defeitos2.setBounds(50, 50,90,20);
		this.add(comboBox_defeitos2);
	}
	
	private void inicializar_operadores() {
		String[] operadores = {"∧", "∨", "null"};
		this.comboBox_operadores = new JComboBox<String>(operadores);
		comboBox_operadores.setBounds(50, 50,90,20);
		this.add(comboBox_operadores);
	}
	
	private void inicializar_threshold1() {
		this.textField_threshold1 = new JTextField(3);
		textField_threshold1.setEditable(true);
		this.add(textField_threshold1);
	}
	
	private void inicializar_threshold2() {
		this.textField_threshold2 = new JTextField(3);
		textField_threshold2.setEditable(true);
		this.add(textField_threshold2);
	}
	  
	private void button_function() {
		this.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Defeito defeito : list_Defeitos) {
					
				}
				
			}
		});
	}
	
	
}
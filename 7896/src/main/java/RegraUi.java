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

public class RegraUi extends JPanel {
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
	RegraInterface i;

	public RegraUi(List<Defeito> list) {
		this.list_Defeitos = list;
		inicializar_Regra();
		this.i = null;
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
		this.comboBox_defeitos3 = new JComboBox<String>(defeitos_integer);
		comboBox_defeitos3.setBounds(50, 50,90,20);
		panel_up.add(comboBox_defeitos3);
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
				// Extração de dados da UI
				for(Defeito defeito : list_Defeitos) {
					if(comboBox_defeitos1.getSelectedItem().toString() == "Long Method") {
						if(!(textField_threshold1.getText().equals("") && textField_threshold2.getText().equals(""))) {
							if(code_smell_detection.isLongMethod(Integer.parseInt(textField_threshold1.getText()),Integer.parseInt(textField_threshold2.getText()),defeito)) {
								text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using is_long_method tool \n");
							}
						}else if(defeito.isIs_long_method())
							text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using is_long_method tool \n");

					}else if(comboBox_defeitos1.getSelectedItem().toString().equals("Feature Envy")) {
						if(!(textField_threshold1.getText().equals("") && textField_threshold2.getText().equals(""))) {
							if (code_smell_detection.isFeatureEnvy(Integer.parseInt(textField_threshold1.getText()), Integer.parseInt(textField_threshold2.getText()), defeito) || code_smell_detection.isFeatureEnvy());
							text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using is_feature_envy tool \n");
						}else if(defeito.isIs_feature_envy()) 
							text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using is_feature_envy tool \n");
						
					}else if(comboBox_defeitos1.getSelectedItem().toString().equals("iPlasma")) {
						if (defeito.isiPlasma())
							text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using iPlasma tool \n");
						
					}else if(comboBox_defeitos1.getSelectedItem().toString().equals("PMD")) {
						if(defeito.isPMD())
							text_area.append("CodeSmell Detected on MethodId: " + defeito.getMethod_ID() + " using PMD tool \n");
					}
				}

				String defectString = comboBox_defeitos1.getSelectedItem().toString();
				String metric1String = comboBox_defeitos2.getSelectedItem().toString();
				String threshold1String = textField_threshold1.getText();
				String operationString = comboBox_operadores.getSelectedItem().toString();
				String metric2String = comboBox_defeitos3.getSelectedItem().toString();
				String threshold2String = textField_threshold2.getText();

				// Validação
				if(defectString.length() == 0) return;
				if(metric1String.length() == 0) return;
				if(threshold1String.length() == 0) return;
				if(operationString.length() == 0) return;
				if(metric2String.length() == 0) return;
				if(threshold2String.length() == 0) return;

				// Transformação de dados
				DefectEnum defect = defectString == "Long Method" ? DefectEnum.isLongMethod : DefectEnum.featureEnvy;
				MetricEnum metric1;
				if(metric1String == "LOC") {
					metric1 = MetricEnum.LOC;
				} else if(metric1String == "CYCLO") {
					metric1 = MetricEnum.CYCLO;
				} else if(metric1String == "ATFD") {
					metric1 = MetricEnum.ATFD;
				} else {
					metric1 = MetricEnum.LAA;
				}
				int threshold1 = Integer.parseInt(threshold1String);
				OperationEnum operation = operationString == "∧" ? OperationEnum.AND : OperationEnum.OR;
				MetricEnum metric2;
				if(metric2String == "LOC") {
					metric2 = MetricEnum.LOC;
				} else if(metric2String == "CYCLO") {
					metric2 = MetricEnum.CYCLO;
				} else if(metric2String == "ATFD") {
					metric2 = MetricEnum.ATFD;
				} else {
					metric2 = MetricEnum.LAA;
				}
				int threshold2 = Integer.parseInt(threshold2String);

				// Atualizar regra
				i.update(defect, metric1, threshold1, operation, metric2, threshold2);
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

	public void setListener(RegraInterface i) {
		this.i = i;
	}

}
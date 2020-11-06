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
	
	public getExcel(Gui gui) {
		this.gui = gui;
		browse = new JButton("Browse");
		makeItAlive();
		
	}
	
	public void addThings() { //adiciona elementos da SWING ao JPanel que depois vai ser usado na GUI
		this.add(browse);
		this.add(label);
	}
	
	
	
	public void makeItAlive() {
		
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("YOU JUST CLICKED ON BROWSE BUTTON");
				
				 JFileChooser jfc = new JFileChooser(".");
				 jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				 int returnValue = jfc.showOpenDialog(null);
				 
				 if (returnValue == JFileChooser.APPROVE_OPTION) {
					 File selectedFile = jfc.getSelectedFile();
//					 selected_dir = selectedFile.getAbsolutePath();
//					 textField_pasta.setText(selected_dir);
					 System.out.println("selected dir: " + selectedFile.getAbsolutePath());
					 gui.setSelectedFile(selectedFile.getAbsolutePath());
					 gui.guiUpdate();
				 }
				
			}
		});
	}
	
	

}

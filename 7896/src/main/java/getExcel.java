
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;







public class getExcel extends JPanel {
	private JButton browse;
	private JLabel label = new JLabel("                                CODE SPELLS");
	private Gui gui;
	private String selected_excel = "C:\\Users\\ASUS\\Downloads\\Defeitos.xlsx"; // guarda o nome do ficheiro ecxel selecionado
	
	public getExcel(Gui gui) {
		this.gui = gui;
		browse = new JButton("Browse");
		makeItAlive();
		
		try {
			readFromFile();
		} catch (EncryptedDocumentException | NullPointerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
					 selected_excel = selectedFile.getAbsolutePath();  //neste momento o ficheiro foi escolhido
					 //System.out.println("selected dir: " + selected_excel);
					 
					 gui.setSelectedFile(selectedFile.getAbsolutePath()); //diz a gui qual ficheiro foi adicionado
					 gui.guiUpdate();
				 }
				
			}
		});
	}
	
	
	
//	public void read2() {
//		File file = new File("resources/Test Data.xlsx");
// 
//		try(var workbooks = WorkbookFactory.create(file)){
// 
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		try(var workbooks = WorkbookFactory.create()){
//		    currentSheet = workbooks.getSheet("john");
//		}catch(Exception e){
//		    e.printStackTrace();
//		}
//   }
	
	
	//FOI USADA a versão Apache POI » 4.1.2, porque ela permite metodos mais simples para  ver conteudo duma cell comparando com 3.17

	public void readFromFile() throws NullPointerException, EncryptedDocumentException, IOException{ // at the begining our file location is uknown, so wee need to use try catch or if
		
			//System.out.println("from readFrom file method: " + selected_excel);
			 List<Defeito> lista_defeitos = new ArrayList<Defeito>();
			   
			//Using a File object allows for lower memory consumption, while an InputStream requires more memory as it has to buffer the whole file.
			    Workbook workbook = WorkbookFactory.create(new File(selected_excel));
			    
			   // System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			    
			    Sheet firstSheet = workbook.getSheetAt(0);
			    Iterator<Row> iterator = firstSheet.iterator();
			 
			    while (iterator.hasNext()) {
			    	int row_number = 0;
			    	Row nextRow = iterator.next();
			        Iterator<Cell> cellIterator = nextRow.cellIterator();
			        Defeito o_defeito = new Defeito();
			       
			        while (cellIterator.hasNext() ) {
			            Cell nextCell = cellIterator.next();
			            int rowIndex = nextCell.getRowIndex();
			            int columnIndex = nextCell.getColumnIndex();
			// System.out.println(row_number);
			            if(rowIndex>0) {
			           // System.out.println("dentro do if");
			            //	System.out.println("column index " + columnIndex);
			            switch (columnIndex) {
			            	
			            case 0:
			            	System.out.println("id  " + nextCell.getNumericCellValue());
			            	break;
			            
			            case 1:
			            	System.out.println(nextCell.getStringCellValue());
			            	 o_defeito.setPackage_name(nextCell.getStringCellValue());
			            		//System.out.println(nextCell.getNumericCellValue());
			                //System.out.println(nextCell.getStringCellValue());
			            	//printCellValue(nextCell);
			                break;
			         
			            case 2:
			               // o_defeito.setClass_name(nextCell.getStringCellValue());
			                //System.out.println(o_defeito);
			            	//printCellValue(nextCell);
			                //System.out.println(nextCell.getStringCellValue());
			                break;
			            case 3:
			             // o_defeito.setClass_name(nextCell.getStringCellValue());
			            	//printCellValue(nextCell);
			                break;
			            case 4:
				            // o_defeito.setMethod_name(nextCell.getStringCellValue());
			            	//printCellValue(nextCell);
				            break;    
			          
			            }
			            
			        }else {
			        	row_number++;
			        }
			            row_number++;
			            lista_defeitos.add(o_defeito);
			            //System.out.println(o_defeito);
			           // lista_defeitos.add(o_defeito);
			          //  System.out.println(lista_defeitos.toString());
			           
			        }
			        
			      // System.out.println("row number " +row_number);
			      
			    }
			   // System.out.println(lista_defeitos.size());
//			   System.out.println(lista_defeitos.toString());
			    try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			    System.out.println(lista_defeitos.toString());
			    
			 
			   
		
		
		{
		}
		
		
	}
	
	public  void printCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	        case BOOLEAN:
	            System.out.print(cell.getBooleanCellValue());
	            break;
	        case STRING:
	            System.out.print(cell.getRichStringCellValue().getString());
	            break;
	        case NUMERIC:
	        	System.out.println(cell.getNumericCellValue());
	        	break;
	        case FORMULA:
	            System.out.print(cell.getCellFormula());
	            break;
	        case BLANK:
	            System.out.print("");
	            break;
	        default:
	            System.out.print("");
	    }

	    System.out.print("\t");
	}

}

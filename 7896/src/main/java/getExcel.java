
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




//TY5


public class getExcel extends JPanel {
	private JButton browse;
	private JLabel label = new JLabel("                                CODE SPELLS");
	private Gui gui;
	private String selected_excel = "C:\\Users\\ASUS\\Downloads\\Defeitos.xlsx"; // guarda o nome do ficheiro ecxel selecionado
	 private List<Defeito> lista_defeitos = new ArrayList<Defeito>();
	public getExcel(Gui gui) {
		this.gui = gui;
		browse = new JButton("Browse");
		makeItAlive();
		
		try {
			readFromFile();
			passExcelDataToJavaTable();
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
			
			   
			//Using a File object allows for lower memory consumption, while an InputStream requires more memory as it has to buffer the whole file.
			    Workbook workbook = WorkbookFactory.create(new File(selected_excel));
			    
			   // System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			    
			    Sheet firstSheet = workbook.getSheetAt(0);
			    Iterator<Row> iterator = firstSheet.iterator();
			 
			    while (iterator.hasNext()) {
			    	
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
			            	//System.out.println("id  " + nextCell.getNumericCellValue());
			            	o_defeito.setMethod_ID((int)nextCell.getNumericCellValue());
			            	//System.out.println(o_defeito.getMethod_ID());
			            	break;
			            
			            case 1:
			            	//System.out.println(nextCell.getStringCellValue());
			            	 o_defeito.setPackage_name(nextCell.getStringCellValue());
			            	 //System.out.println(o_defeito.getPackage_name());
			            		//System.out.println(nextCell.getNumericCellValue());
			                //System.out.println(nextCell.getStringCellValue());
			            	//printCellValue(nextCell);
			                break;
			         
			            case 2:
			                o_defeito.setClass_name(nextCell.getStringCellValue());
			                //System.out.println(o_defeito.getClass_name());
			                //System.out.println(o_defeito);
			            	//printCellValue(nextCell);
			                //System.out.println(nextCell.getStringCellValue());
			                break;
			            case 3:
			               o_defeito.setMethod_name(nextCell.getStringCellValue());
			              // System.out.println(o_defeito.getMethod_name());
			            	//printCellValue(nextCell);
			                break;
			            case 4:
				            o_defeito.setLOC((int)nextCell.getNumericCellValue());
				           // System.out.println(o_defeito.getLOC());
			            	//printCellValue(nextCell);
				            break;  
				            
			            case 5:
				            o_defeito.setCYCLO((int)nextCell.getNumericCellValue());
				           // System.out.println(o_defeito.getCYCLO());
			            	//printCellValue(nextCell);
				            break; 
				            
			            case 6:
				            o_defeito.setATFD((int)nextCell.getNumericCellValue());
				           // System.out.println(o_defeito.getATFD());
			            	//printCellValue(nextCell);
				            break;  
				            
			            case 7:
			            	if(nextCell.getCellType() == CellType.STRING) {
			            		o_defeito.setLAA( Double.valueOf(nextCell.getStringCellValue()));
			            	}else { o_defeito.setLAA(nextCell.getNumericCellValue());}
			            	 break; 
			            	 
			            case 8:
				            o_defeito.setIs_long_method(nextCell.getBooleanCellValue());
				            //System.out.println(o_defeito.isIs_long_method());
				           // System.out.println(o_defeito.getATFD());
			            	//printCellValue(nextCell);
				            break;  
			            case 9:
				            o_defeito.setiPlasma(nextCell.getBooleanCellValue());
				           // System.out.println(o_defeito.isiPlasma());
				            //System.out.println(o_defeito.isIs_long_method());
				           // System.out.println(o_defeito.getATFD());
			            	//printCellValue(nextCell);
				            break;      
				            
			            case 10:
				            o_defeito.setPMD(nextCell.getBooleanCellValue());
				          //  System.out.println(o_defeito.isPMD());
				            //System.out.println(o_defeito.isIs_long_method());
				           // System.out.println(o_defeito.getATFD());
			            	//printCellValue(nextCell);
				            break; 
				            
			            case 11:
				            o_defeito.setIs_feature_envy(nextCell.getBooleanCellValue());
				          //  System.out.println(o_defeito.isPMD());
				            //System.out.println(o_defeito.isIs_long_method());
				           // System.out.println(o_defeito.getATFD());
			            	//printCellValue(nextCell);
				            break;  
			            
			            }
			           
			            
			        }
			         //   lista_defeitos.add(o_defeito);
			            //System.out.println(o_defeito);
			           // lista_defeitos.add(o_defeito);
			           
			         
			           
			        }
			        
			       
			        lista_defeitos.add(o_defeito);
			       // System.out.println("lista defeitos size " + lista_defeitos.size());
			      // System.out.println("row number " +row_number);
			      
			    }
			  
		//	 System.out.println(lista_defeitos.toString());
			    try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			    System.out.println(lista_defeitos.toString());
			    System.out.println(lista_defeitos.size() + "s");
			 
			   
			    for(int i = 0; i<20;i++) {
		        	 System.out.println(lista_defeitos.get(i));
		        	 
		         }
			    
//			    for(Defeito defeito : lista_defeitos) {
//			    	System.out.println(defeito);
//			    }
			    
			  //  System.out.println(lista_defeitos); imprime lista toda numa linha, por issso dificil fazer debug
		
		{
		}
		
		
	}
	
	public void passExcelDataToJavaTable() {
		
		String [][] data_from_excel = new String [12][3];
		
		for(int i=0;i<data_from_excel.length;i++) {
			for(int j=0;j<data_from_excel[i].length;j++) {
				data_from_excel[i][j]=i*j + "";
			}
		}
		   
		    String data[][]={ {"101","Amit","670000"},    
		                          {"102","Jai","780000"},    
		                          {"101","Sachin","700000"}};    
		    String column[]={"Method_ID","NAME","SALARY"};         
		    JTable jt=new JTable(data_from_excel,column);    
		    jt.setBounds(30,40,200,300);          
		    JScrollPane sp=new JScrollPane(jt);    
		    gui.manage_gui2(sp);          
		   
		     
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
//dkfnejfjsssss
	    System.out.print("\t");
	}

}

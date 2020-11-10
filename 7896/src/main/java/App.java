

public class App 
{
    public static void main( String[] args )
    {
    	
//    	String s = "sdfsdfs";
//    	System.out.println("FUNIONA");
//    	System.out.println(s);
//    	
    	Gui gui = new Gui();
		gui.start();
		getExcel getE = new getExcel(gui);
		getE.addThings();
		
		gui.manage_gui(getE);
		
		
    }
}

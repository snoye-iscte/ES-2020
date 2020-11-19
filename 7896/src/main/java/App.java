
public class App {
	public static void main( String[] args ) {
		getExcel get_excel = new getExcel();

		Gui gui = new Gui(get_excel);

		gui.start();
		Regra regra = new  Regra(get_excel.getListaDefeitos());
		//gui.manage_gui(regra);
		int g= 3;
	}
}

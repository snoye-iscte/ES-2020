//este ficheiro serve para voces meter no vosso projeto local o destino do ficheiro excel e nao alterarem o fichei
//excel cada vez que precisarem de aceder ao ficheirpo excel para testar o programa
//logo assim que fizerem pull da classe teem que meter a opccao tram ignore para nao enviar comits sobre e
//alterações nesta classse
public class Config {
	String path_to_excel_file = "";
	
	public Config(String path_to_excel_file) {
		this.path_to_excel_file = path_to_excel_file;
	}
	
	public String getPathToExcelFiel() {
		return path_to_excel_file;
	}
	
	public void setPathToExcelFiel(String path_to_excel_file) {
		this.path_to_excel_file = path_to_excel_file;
	}
}

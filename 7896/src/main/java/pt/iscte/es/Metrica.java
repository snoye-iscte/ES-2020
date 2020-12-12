package pt.iscte.es;
public class Metrica {
	
	private String nome_da_metrica;
	private int valor_da_metrica;
	
	
	public Metrica(String nome, int valor) {
		this.nome_da_metrica = nome;
		this.valor_da_metrica = valor;
	}

	public String getNome_da_metrica() {
		return nome_da_metrica;
	}

	public int getValor_da_metrica() {
		return valor_da_metrica;
	}

}
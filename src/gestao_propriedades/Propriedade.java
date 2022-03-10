package gestao_propriedades;

public class Propriedade {
	
	private String localizacao, tipo;
	private int quarto;
	private double preco, desconto;
	
	public Propriedade(String localizacao, String tipo, int quarto, double preco, double desconto) {
		this.localizacao = localizacao;
		this.tipo = tipo;
		this.quarto = quarto;
		this.preco = preco;
		this.desconto = desconto;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public String getTipo() {
		return tipo;
	}

	public int getQuarto() {
		return quarto;
	}

	public double getPreco() {
		return preco;
	}

	public double getDesconto() {
		return desconto;
	}

	

}

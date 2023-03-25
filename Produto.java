package questao;

public class Produto {
	private String nome, sigla;
	private int estoque, vendidos, estoqueDisponivel;
	private double preco, percentEstDisp;
	
	public Produto(String nome, String sigla, int estoque, double preco)throws Exception {
		this.nome = nome;
		this.sigla = sigla;
		this.estoque = estoque;
		this.preco = preco;
		this.vendidos = 0;
		this.estoqueDisponivel = (estoque - vendidos);
		this.percentEstDisp = (100 * estoqueDisponivel)/estoque;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public int getVendidos() {
		return vendidos;
	}
	
	public double getEstoqueDisponivel() {
		return estoqueDisponivel;
	}
	
	public boolean adicionarVenda(double qtd) {
		if(qtd > estoqueDisponivel) {
			System.out.println("Não é possóvel vender mais do que " + estoqueDisponivel + " unidades.");
			return false;
		} else {
			vendidos++;
		}
		return true;
	}
	
	public double getFaturamentoVenda() {
		return (preco * vendidos);
	}
	
	public boolean isDisponivel() {
		if(estoqueDisponivel == 0) {
			return false;
		}
		return true;
	}
	
	public double getPercentEstoqueDisponivel() {
		return percentEstDisp;
	}
}
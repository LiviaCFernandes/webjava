package entity;

public class Estoque {

	private Integer idEstoque;
	private Integer quantidade=0;
	//1p1
	private Produto produto;
	
	public String operacao;
	
	public Estoque() {
		
	}
	public Estoque(Integer idEstoque, Integer quantidade, Produto produto) {
		this.idEstoque = idEstoque;
		this.quantidade = quantidade;
		this.produto = produto;
	}
		
	@Override
	public String toString() {
		return "Estoque [idEstoque=" + idEstoque + ", produto=" + produto + ", operacao=" + operacao + ", quantidade:"
				+ quantidade + "]";
	}
	
	public Integer getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	//Definindo a faixa(range)
	public boolean isOperacao() {
		if(this.operacao.equalsIgnoreCase("retirar") || this.operacao.equalsIgnoreCase("adicionar")) {
			return true;
		}else 
			return false;
	}
	
	
//	public void adicionarEstoque(Integer qtd) {
//		if (!this.isOperacao()) throw new IllegalArgumentException("Operação invalida!");
//		setQuantidade(getQuantidade() + qtd);
//		if (this.quantidade<10) {
//			System.out.println("Quantidade adicionada abaixo do limite");
//		}
//	}
	
	public void adicionarEstoque() {
		if (!this.isOperacao())
			throw new IllegalArgumentException("Operacao Invalida");	
		this.getProduto().setQuantidadeTotal(this.getProduto().getQuantidadeTotal() + this.getQuantidade());		
		if (this.quantidade < 10) {
			System.out.println("Quantidade adicionada abaixo do limite");
		}
		if (this.getProduto().getQuantidadeTotal() < 10) {
			System.out.println("Quantidade Total  abaixo do limite de 10");
		}
	}
	
	
//	public void retirarEstoque(Integer qtd) {
//		if (!this.isOperacao()) throw new IllegalArgumentException("Operação invalida!");
//		if (qtd > this.quantidade) throw new IllegalArgumentException("Retirada acima do que possui!");
//		setQuantidade(getQuantidade() - qtd);
//		if (this.quantidade<10) {
//			System.out.println("Quantidade retirada deixou o estoque abaixo do limite");
//		}
//	}
	
	public void retiradaEstoque() {
		if (!this.isOperacao())	throw new IllegalArgumentException("Operacao Invalida");	
		if (this.quantidade >this.getProduto().getQuantidadeTotal()) {
			throw new IllegalArgumentException("Nao da para retirar o que nao tem");
		}		
		this.getProduto().setQuantidadeTotal(this.getProduto().getQuantidadeTotal() - this.getQuantidade());
		if (this.quantidade < 10) {
			System.out.println("Quantidade retirada abaixo do limite");
		}
		if (this.getProduto().getQuantidadeTotal() < 10) {
			System.out.println("Quantidade Total  abaixo do limite de 10");
		}
	}
	
	public static void main(String[] args) {
		Produto p = new Produto (100, "lenovo", 400.);

		try {
			Estoque e = new Estoque(200, 5, p);	
			e.setOperacao("adicionar");
			e.adicionarEstoque();

			System.out.println(p);
			System.out.println(e);
			System.out.println("Total da quantidade: " +p.getQuantidadeTotal());
			
			System.out.println("-------------------");
			Estoque e1 = new Estoque(201, 20, p);	
			e1.setOperacao("adicionar");
			e1.adicionarEstoque();

			System.out.println(p);
			System.out.println(e1);
			System.out.println("Total da quantidade: " +p.getQuantidadeTotal());
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}

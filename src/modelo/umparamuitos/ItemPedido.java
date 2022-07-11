package modelo.umparamuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import modelo.basico.Produto;

@Entity
public class ItemPedido 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*Configura a chave prim�ria como uma chave artificial que ser� gerada por auto incremento no banco de dados*/
	private Long id;
	//Por padr�o, quando uma classe possui uma rela��o muitos para um ou um para um, o atributo busca � ansioso (fetch = FetchType.EAGER)
	@ManyToOne (fetch = FetchType.EAGER)
	private Pedido pedido;
	@ManyToOne (fetch = FetchType.EAGER)
	private Produto produto;
	@Column(nullable = false)
	private int quantidade;
	@Column(nullable = false)
	private Double preco;
	
	public ItemPedido()
	{
		
	}

	public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
		super();
		this.pedido = pedido;
		this.setProduto(produto);
		this.quantidade = quantidade;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		if(this.produto != null && this.preco == null)
		{
			this.preco = this.produto.getPreco();
		}
		
		
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}

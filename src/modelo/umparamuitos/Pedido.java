package modelo.umparamuitos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Date data;
	//Por padrão, quando uma classe possui uma relação um para muitos ou muitos para muitos, o atributo busca é preguiçoso (fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY) /*Estabelecendo o lado bidirecional da relação entre pedido e ItemPedido*/
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido()
	{
		this(new Date());
	}
	
	public Pedido(Date data)
	{
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
}

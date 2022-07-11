package modelo.umparaum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "assentos")
public class Assento
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/* Percebi que um cliente poderia comprar mais de um assento, cada assento com um Id diferente, mas isso não impede de os dois assentos terem o mesmo
		nome, exemplo: Maria compra os assentos 02 e 03 (lembrando que Chaves auto incrementadas não aparecem para o usuário), ambos assentos com nome F04,
		por isso a importância de definir o atributo como único, impedindo que assentos tenham o mesmo nome, impedindo que em nosso aplicativo, um cliente compre duas vezes
		o mesmo assento.*/
	@Column(unique = true)
	private String nome;
	
	/*Basicamente estou dizendo ao Hibernate que este atributo é nada mais nada menos que o lado bidirecional da relação, pois a relação está
		mapeada na classe Cliente, no  atributo assento. É importante fazer isso para que nas duas tabelas não seja criado uma coluna contendo 
		o id um do outro (cliente_id em assentos e assento_id em cliente), pois isso fere os princípios de banco de dados relacionais, não é
		uma boa prática*/
	@OneToOne(mappedBy = "assento") 
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Assento() {
		
	}

	public Assento(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

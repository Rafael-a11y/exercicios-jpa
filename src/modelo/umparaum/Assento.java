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
	
	/* Percebi que um cliente poderia comprar mais de um assento, cada assento com um Id diferente, mas isso n�o impede de os dois assentos terem o mesmo
		nome, exemplo: Maria compra os assentos 02 e 03 (lembrando que Chaves auto incrementadas n�o aparecem para o usu�rio), ambos assentos com nome F04,
		por isso a import�ncia de definir o atributo como �nico, impedindo que assentos tenham o mesmo nome, impedindo que em nosso aplicativo, um cliente compre duas vezes
		o mesmo assento.*/
	@Column(unique = true)
	private String nome;
	
	/*Basicamente estou dizendo ao Hibernate que este atributo � nada mais nada menos que o lado bidirecional da rela��o, pois a rela��o est�
		mapeada na classe Cliente, no  atributo assento. � importante fazer isso para que nas duas tabelas n�o seja criado uma coluna contendo 
		o id um do outro (cliente_id em assentos e assento_id em cliente), pois isso fere os princ�pios de banco de dados relacionais, n�o �
		uma boa pr�tica*/
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

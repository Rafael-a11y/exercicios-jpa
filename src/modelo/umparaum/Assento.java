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
	
	@Column(unique = true) // Percebi que um cliente poderia comprar mais de um assento, cada assento com um Id diferente, mas isso n�o impede de os dois assentos terem o mesmo
	private String nome;   //nome, exemplo: Maria compra os assentos 02 e 03 (lembrando que Chaves auto incrementadas n�o aparecem para o usu�rio), ambos assentos com nome F04.
	
	@OneToOne(mappedBy = "assento") //Basicamente estou dizendo ao Hibernate que este atributo � nada mais nada menos que o lado bidirecional da rela��o, pois a rela��o est�
	private Cliente cliente;		//mapeada na classe Cliente, no  atributo assento.

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

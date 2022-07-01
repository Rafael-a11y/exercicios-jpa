package modelo.umparaum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	@OneToOne(cascade = CascadeType.PERSIST) //Serve para fazer uma persistência em cascata, assim o objeto associado também é persistido
	@JoinColumn (name = "assento_id", unique = true) /*@JoinColumn serve para atributos que representam a junção entre duas colunas, como uma coluna de chave estrangeira por 
															exemplo.*/
	private Assento assento;
	public Cliente() {
		super();
	}
	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
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
	public Assento getAssento() {
		return assento;
	}
	public void setAssento(Assento assento) {
		this.assento = assento;
	}
	
}

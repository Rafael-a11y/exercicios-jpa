package modelo.heranca;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Date dataCadastro;
	
	protected Pessoa() {}
	
	protected Pessoa(String nome, Date dataCadastro)
	{
		super();
		this.nome = nome;
		this.dataCadastro = dataCadastro;
	}

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected Date getDataCadastro() {
		return dataCadastro;
	}

	protected void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}

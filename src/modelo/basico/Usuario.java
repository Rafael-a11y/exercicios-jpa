package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Para que seja uma tabela
public class Usuario
{

	@Id // Para que seja uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para que o atributo seja auto_increment
	private Long id;
	
	private String nome;
	
	private String email;

	public Usuario() 
	{
		super();
	}

	public Usuario(Long id, String nome, String email) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
}

package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Para que seja uma tabela
@Table(name = "produtos", schema = "curso_java") /* Anotação usada para fornecer parâmetros como nome da tabela equivalente no banco de dados, qual o esquema 
													em que a tabela correspondente será criada */ 
public class Produto 
{
	@Id // Para que seja uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para que o atributo seja auto_increment
	private Long id;
	@Column(name = "prod_nome", length = 200, nullable = false) /* Anotação usada para fornecer parâmetros como nome da coluna, tamanho em caracteres, se aceita campo
	 																nulo ou não.*/
	private String nome;
	@Column(name = "prod_preco", nullable = false, precision = 11, scale = 2) /* Parâmetro precision serve para fornecer o total de dígitos, scale serve para
	 																			fornecer o total de dígitos após a vírgula.*/
	private Double preco;
	
	public Produto() 
	{
		
	}

	public Produto(String nome, Double preco) {
		
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}

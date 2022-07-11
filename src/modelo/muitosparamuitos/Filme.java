package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Double nota;
	
	/*A anota��o @JoinTable tem a mesma fun��o que a anota��o @JoinColumn, a difer�a � que @JoinTable serve para tabela intermedi�rias entre entidades com rela��o muitos para
	 * muitos. Uma tabela que possui duas foreign keys ser� criada, referenciando as primary keys de atores e filmes, e a primary key desta tabela ser� composta pelas duas
	 * foreign keys, por isso que neste caso usamos @JoinTable ao inv�s de @JoinColumn, esta �ltima � usada quando uma coluna foreign key ser� criada referenciando uma 
	 * primary key.
	 * O atributo cascade dentro de @ManyToMany serve para definir a��es em cascata dentro do banco de dados, o valor PERSIST em CascadeType serve para definir efeito em cascata
	 * apenas no comando persist(), ou seja, quando um Filme filme for persistido com EntityManager em.persist(filme), os objetos dentro da List<Ator> atores ser�o tamb�m
	 * persistidos no banco de dados, isso serve para n�o ser necess�rio persistir objeto por objeto. J� pensou em ter que persistir um objeto Filme filme com uma lista List<Ator>
	 * com mais de 100 elementos um por um? N�o parece nada interessante. O atributo cascade deve ser usado apenas em uma das Classes de rela��o muitos para muitos para se evitar
	 * inser��es indevidas de registros no banco de dados (ou n�o, depende da l�gica da aplica��o), o atributo cascade deve ser usado na classe em que a rela��o muitos para 
	 * muitos come�a. */
	@ManyToMany (cascade = CascadeType.PERSIST) 
	@JoinTable (name = "atores_filmes", 
	joinColumns = @JoinColumn (name = "filme_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn (name = "ator_id", referencedColumnName = "id"))
	private List<Ator> atores = new ArrayList<>();
	
	public Filme() {}
	
	public Filme(String nome, Double nota) {this.nome = nome; this.nota = nota;}

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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		if(atores == null)
		{
			atores = new ArrayList<>();
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	public void adicionarAtor(Ator ator)
	{
		if(ator != null && !getAtores().contains(ator))
		{
			getAtores().add(ator);
			if(!ator.getFilmes().contains(this))
			{
				ator.getFilmes().add(this);
			}
		}
	}
}

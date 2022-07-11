package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atores")
public class Ator 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	/*O atributo mappedBy em @ManyToMnay serve para definir esta classe como o lado bidirecional da rela��o muitos para muitos 
	 * O atributo cascade dentro de @ManyToMany serve para definir a��es em cascata dentro do banco de dados, o valor PERSIST em CascadeType serve para definir efeito em cascata
	 * apenas no comando persist(), ou seja, quando um Ator ator for persistido com EntityManager em.persist(ator), os objetos dentro da List<Filme> filmes ser�o tamb�m
	 * persistidos no banco de dados, isso serve para n�o ser necess�rio persistir objeto por objeto. J� pensou em ter que persistir um objeto Ator ator com uma lista List<Filme>
	 * com mais de 100 elementos um por um? N�o parece nada interessante. O atributo cascade deve ser usado apenas em uma das Classes de rela��o muitos para muitos para se evitar
	 * inser��es indevidas de registros no banco de dados (ou n�o, depende da l�gica da aplica��o), o atributo cascade deve ser usado na classe em que a rela��o muitos para 
	 * muitos come�a (preferencisalmente, lembrando que cascade n�o � um atributo obrigat�rio)*/
	@ManyToMany (mappedBy = "atores", cascade = CascadeType.PERSIST)
	private List<Filme> filmes = new ArrayList<>();
	
	public Ator() {}
	
	public Ator(String nome) {this.nome = nome;}

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

	public List<Filme> getFilmes() {
		if(filmes == null)
		{
			filmes = new ArrayList<>();
		}
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	public void adicionarFilme(Filme filme)
	{
		if(filme != null && !getFilmes().contains(filme))
		{
			getFilmes().add(filme);
			if(!filme.getAtores().contains(this))
			{
				filme.getAtores().add(this);
			}
		}
	}
		
}
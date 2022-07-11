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
	
	/*O atributo mappedBy em @ManyToMnay serve para definir esta classe como o lado bidirecional da relação muitos para muitos 
	 * O atributo cascade dentro de @ManyToMany serve para definir ações em cascata dentro do banco de dados, o valor PERSIST em CascadeType serve para definir efeito em cascata
	 * apenas no comando persist(), ou seja, quando um Ator ator for persistido com EntityManager em.persist(ator), os objetos dentro da List<Filme> filmes serão também
	 * persistidos no banco de dados, isso serve para não ser necessário persistir objeto por objeto. Já pensou em ter que persistir um objeto Ator ator com uma lista List<Filme>
	 * com mais de 100 elementos um por um? Não parece nada interessante. O atributo cascade deve ser usado apenas em uma das Classes de relação muitos para muitos para se evitar
	 * inserções indevidas de registros no banco de dados (ou não, depende da lógica da aplicação), o atributo cascade deve ser usado na classe em que a relação muitos para 
	 * muitos começa (preferencisalmente, lembrando que cascade não é um atributo obrigatório)*/
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
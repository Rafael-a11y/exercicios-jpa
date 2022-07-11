package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO <E> 
{
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe; //Recebe literalmente uma classe de parâmetro
	
	static /* Serve para iniciar emf apenas uma única vez, já que este servirá para várias conexões
			em. Também serve para criar um bloco, pois objetos e métodos são exeutados apenas em
			blocos de código.*/ 
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		}
		catch(Exception e)
		{
			
		}
	}
	
	public DAO()
	{
		this(null);
	}
	
	/*Passando uma classe E como parâmetro que sera usada em obterPorId() que usa Class.getName() para achar o registro equivalente no banco de dados. Acontece que o método
		find() que retorna o registro pesquisado, precisa do Class.name, cujo valor é guardado dentro do atributo classe*/
	public DAO(Class <E> classe)  
	{
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> comecarTransacao()
	{
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> commitarTransacao()
	{
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> persistirEntidade(E entidade) 
	{
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirDeFormaAtomica(E entidade)
	{
		this.comecarTransacao().persistirEntidade(entidade).commitarTransacao();
		return this;
	}
	
	public List<E> obterTodos()
	{
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int quantidade, int deslocamento)
	{
		if(classe == null)
		{
			throw new UnsupportedOperationException("Classe nula."); 
		}
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	public void fecharEntityManager()
	{
		em.close();
	}
	
	/*Aqui está um motivo de usar Generics, com este método que usa um id, me permite usar este método para obter qualquer objeto de qualquer tipo, e por isso o motivo de 
	 * fornecer uma classe no construtor, para poder referenciar o tipo genérico E como parâmetro e assim pesquisar o objeto desejado a partir do método Class.getName() 
	 * que retorna a classe passada no construtor*/
	public E obterPorId(Object id)
	{
		return em.find(classe, id);
	}
}

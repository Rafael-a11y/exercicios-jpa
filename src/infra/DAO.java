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
	private Class<E> classe;
	
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
	
	public DAO(Class <E> classe) // Passando a classe como parâmetro. 
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
}

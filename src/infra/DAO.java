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
	private Class<E> classe; //Recebe literalmente uma classe de par�metro
	
	static /* Serve para iniciar emf apenas uma �nica vez, j� que este servir� para v�rias conex�es
			em. Tamb�m serve para criar um bloco, pois objetos e m�todos s�o exeutados apenas em
			blocos de c�digo.*/ 
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		}
		catch(Exception e)
		{
			System.out.println("EntityManagerFactory n�o foi criado, emf nulo.");
			e.getMessage();
		}
	}
	
	public DAO()
	{
		this(null);
	}
	
	/*Passando uma classe E como par�metro que sera usada em obterPorId() que usa Class.getName() para achar o registro equivalente no banco de dados. Acontece que o m�todo
		find() que retorna o registro pesquisado, precisa do Class.name, cujo valor � guardado dentro do atributo classe*/
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
	//Precisa estar dentro do contexto de transa��o para funcionar
	public DAO<E> persistirEntidade(E entidade) 
	{
		if(entidade!= null)
		{
			em.persist(entidade);
		}
		return this;
	}
	//Precisa estar dentro do contexto de transa��o para funcionar
	public DAO<E> removerEntidade(E entidade)
	{
		if(entidade != null)
		{
			em.remove(entidade);
		}
		return this;
	}
	//Precisa estar dentro do contexto de transa��o para funcionar
	public DAO<E> alterarEntidade(E entidade)
	{
		/*� bom chamar o detach() para o caso da vari�vel estiver nula e o JPA tentar comit�-la ao chamar commitarTransacao() por conta do estado gerenciado, evitando um
		 * IllegalArgumentException por tentar atualizar no banco de dados a partir de uma inst�ncia nula.*/
		em.detach(entidade);
		if(entidade != null)
		{
			em.merge(entidade);
		}
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
	
	/*Utiliza uma String que representa uma consulta JPQL, e uma classe de par�metro. O Objeto TypedQuery<E> query recebe de valor a consulta propriamente dita. Para a consulta
	 * ser passada como o valor do objeto TypedQuery<E> query, chamamos o m�todo createQuery(String argumento1, Class<E> argumrno2), o Class<E> passado precisa ser o mesmo
	 * passado no generics do TypedQuery, e a consulta tamb�m precisa coerente, n�o adianta voc� passar E como classe e tentar consultar F na consulta. Um exemplo de cnsulta
	 * seria: select e from E e; No lugar de 'e' voc� pode por o nome que mais achar coerente como alias, o 'E' representa a classe mapeada que voc� deseja buscar no banco
	 * de dados, esta classe precisa ser a mesma do TypedQuery<E>. O m�todo setMaxResults(int argumento1) serve para limitar a quantidade de elementos retornados, o m�todo
	 * getResultList serve para de fato retornar a lista de elementos obtidos com a consulta, este m�todo est� dentro da classe TypedQuery<E> e � chamado a partir de sua
	 * inst�ncia.  O m�todo setFirstResult(int argumento1) serve para pular os 'argumento01' primeiros elementos da tabela no banco de dados.*/
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
	
	public List<E> consultar(String nomeConsulta, Object... params)
	{
		/*Os par�metros do m�todo createNamedQuery s�o: o nome da consulta declarada no consultas.xml que foi mapeado em 
		 * persistence.xml e a classe em que se deseja manipular a consulta*/
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		for(int i = 0; i < params.length; i = i + 2)
		{
			//Setando os par�metros...
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params)
	{
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void fecharEntityManager()
	{
		em.close();
	}
	
	/*Aqui est� um motivo de usar Generics, com este m�todo que usa um id, me permite usar este m�todo para obter qualquer objeto de qualquer tipo, e por isso o motivo de 
	* fornecer uma classe no construtor, para poder referenciar o tipo gen�rico E como par�metro e assim pesquisar o objeto desejado a partir do m�todo Class.getName() 
	* que retorna a classe passada no construtor
	* Obtem um objeto do banco de dados pelo id, o m�todo public E find(Class<E> argumento1, Object argumento2) faz uma consulta do tipo where, por isso � recomend�vel usar
	* um id como par�metro, mas o m�todo aceita qualquer Object como segundo par�metro. O Class<E> deve estar mapeado no persistence.xml e � usado para se saber qual o 
	* tipo de objeto que ser� recuperado no banco de dados*/
	public E obterPorId(Object id)
	{
		return em.find(classe, id);
	}
}

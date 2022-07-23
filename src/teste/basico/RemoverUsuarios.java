package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuarios 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // f�brica de gerenciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		//O m�todo findo(Class<E> arg0, Object arg1) espera o .class e o id mapeado com @Id, o par�metro � tido como Object, porqu� o atributo declarado como @Id pode ser de
		//qualquer tipo, mas neste caso, o atributo private Long id est� mapeado como @Id, ent�o, o valor que o m�todo espera no segundo argumento � do tipo Long.
		Usuario usuario01 = em.find(Usuario.class, 1l);
		Usuario usuario02 = new Usuario("Rafael", "rsowtto@gmail.com"); 
		Usuario usuario03 = new Usuario("Israel", "neck929@gmail.com");
		Usuario usuario04 = new Usuario("Boanerges", "boanergesmedeiros2@gmail.com");
		Usuario usuario05 = new Usuario("Rodrigo", "digao@gmail.com");
		
		System.out.println(usuario02.getNome());
		if(usuario02 != null)
		{
			em.getTransaction().begin();
			em.remove(usuario02); // Remove o elemento do banco de dados.
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
	}
	
	/*Para se remover um usu�rio do banco de dados, � preciso primeiro acha-lo no banco com o m�todo find() para mapea-lo para dentro do da vari�vel e a partir da� exclu�-lo
	 * com o m�todo remove() que far� isso a partir de seu atributo marcado com @Id, ou seja, se voc� passar um usu�rio sem id setado e sem estar presente no banco de dados 
	 * para ser removido, n�o acontecer� nada, mas se voc� passar um usu�rio que n�o est� presente no baco de dados mas com um id setado com o mesmo valor de um usuario do 
	 * banco de dados, acontecer� um IllegalArgumentExcepion, por tentar remover uma inst�ncia separada do banco de dados, o mesmo acontece se a inst�ncia estiver ausente do
	 * banco mas com um id diferente. Ou seja, para o remove funcionar, a inst�ncia deve estar presente no banco, caso n�o esteja presente mas sem id setado (atributo que o
	 * m�todo usa para achar o registro equivalente no banco), n�o acontecer� nada, mas caso a inst�ncia tenha um id setado mas ainda esteja ausente do banco, acarretar� 
	 * numa IllegalArgumentException   */
}

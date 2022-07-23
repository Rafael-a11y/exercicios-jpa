package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuarios 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // fábrica de gerenciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		//O método findo(Class<E> arg0, Object arg1) espera o .class e o id mapeado com @Id, o parâmetro é tido como Object, porquê o atributo declarado como @Id pode ser de
		//qualquer tipo, mas neste caso, o atributo private Long id está mapeado como @Id, então, o valor que o método espera no segundo argumento é do tipo Long.
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
	
	/*Para se remover um usuário do banco de dados, é preciso primeiro acha-lo no banco com o método find() para mapea-lo para dentro do da variável e a partir daí excluí-lo
	 * com o método remove() que fará isso a partir de seu atributo marcado com @Id, ou seja, se você passar um usuário sem id setado e sem estar presente no banco de dados 
	 * para ser removido, não acontecerá nada, mas se você passar um usuário que não está presente no baco de dados mas com um id setado com o mesmo valor de um usuario do 
	 * banco de dados, acontecerá um IllegalArgumentExcepion, por tentar remover uma instância separada do banco de dados, o mesmo acontece se a instância estiver ausente do
	 * banco mas com um id diferente. Ou seja, para o remove funcionar, a instância deve estar presente no banco, caso não esteja presente mas sem id setado (atributo que o
	 * método usa para achar o registro equivalente no banco), não acontecerá nada, mas caso a instância tenha um id setado mas ainda esteja ausente do banco, acarretará 
	 * numa IllegalArgumentException   */
}

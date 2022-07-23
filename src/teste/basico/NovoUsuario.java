package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario 
{
	public static void main(String[] args)
	{	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // fábrica de geremciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		Usuario novoUsuario = new Usuario("Arthur", "lacerda2@gmail.com");
		Usuario usuario2 = null;
//		novoUsuario.setId(01L);
		em.getTransaction().begin(); // começa transação
		em.persist(usuario2); // Persiste um novo elemento no banco de dados.
		em.getTransaction().commit(); // commita e termina a transação
		
		System.out.println("O id gerado foi " + novoUsuario.getId()); //Mesmo que você crie um objeto sem id, o id é gerado por conta do mapeamento objeto-relacional.
		
		em.close(); // Fecha
		emf.close();// Fecha
		
		//Se você tentar persistir uma variável nula, dará IllegalAgumentEcveption: attempt to create event with null entity.
	}
}

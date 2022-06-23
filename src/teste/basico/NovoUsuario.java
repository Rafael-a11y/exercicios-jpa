package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario 
{
	public static void main(String[] args)
	{	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // f�brica de geremciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		Usuario novoUsuario = new Usuario("Rafael", "rsowtto@gmail.com");
//		novoUsuario.setId(01L);
		em.getTransaction().begin(); // come�a transa��o
		em.persist(novoUsuario); // Persiste um novo elemento no banco de dados.
		em.getTransaction().commit(); // commita e termina a transa��o
		
		System.out.println("O id gerado foi " + novoUsuario.getId()); //Mesmo que voc� crie um objeto sem id, o id � gerado por conta do mapeamento objeto-relacional.
		
		em.close(); // Fecha
		emf.close();// Fecha
	}
}

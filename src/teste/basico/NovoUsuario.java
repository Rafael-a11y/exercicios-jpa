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
		
//		Usuario novoUsuario = new Usuario("Rodrigo","rodrigo@lanche.com.br");
		Usuario novoUsuario1 = new Usuario("Andr�","andre@lanche.com.br");
		Usuario novoUsuario2 = new Usuario("Carlos","carlos@lanche.com.br");
		Usuario novoUsuario3 = new Usuario("Djalma","djalma@lanche.com.br");
		Usuario novoUsuario4 = new Usuario("Lulu","lulu@lanche.com.br");
		Usuario novoUsuario5 = new Usuario("Arthur","arthur@lanche.com.br");
//		novoUsuario.setId(01L);
		em.getTransaction().begin(); // come�a transa��o
		em.persist(novoUsuario1);
		em.persist(novoUsuario2);
		em.persist(novoUsuario3);
		em.persist(novoUsuario4);
		em.persist(novoUsuario5);
		em.getTransaction().commit(); // commita e termina a transa��o
		
		em.close(); // Fecha
		emf.close();// Fecha
	}
}

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
		
		Usuario usuario = em.find(Usuario.class, 9L);
		
		if(usuario != null)
		{
			em.getTransaction().begin();
			em.remove(usuario); // Remove o elemento do banco de dados.
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
	}
}

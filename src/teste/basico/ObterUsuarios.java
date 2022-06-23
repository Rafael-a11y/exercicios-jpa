package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;
public class ObterUsuarios 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // fábrica de gerenciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		String jpql = "select u from Usuario u"; // Consulta jpql
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class); /*É preciso fornecer a classe Usuario para dar match com o tipo da TypedQuery que também deve ser o 
																			mesmo tipo retornado pela consulta jpql */
		query.setMaxResults(8); // Define o máximo de elementos a serem retornados do banco de dados.									
		
		java.util.List<Usuario> usuarios = query.getResultList(); // Retorna os elementos em uma lista
		
		for(Usuario usuario : usuarios)
		{
			System.out.println("ID: " + usuario.getId() + " Email: " + usuario.getEmail());
		}
		
		em.close();
		emf.close();
	}
}

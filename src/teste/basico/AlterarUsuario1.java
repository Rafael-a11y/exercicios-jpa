package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // f�brica de gerenciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		em.getTransaction().begin(); //Merge() necessita de um comtexto de transa��o
		
		Usuario usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Leonardo");
		usuario.setEmail("leonardo@lanche.com.br");
		
		em.merge(usuario); //Respons�vel por atualizar um objeto que j� existe no banco de dados
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}

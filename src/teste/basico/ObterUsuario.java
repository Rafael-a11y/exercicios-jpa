package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // f�brica de geremciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		//O JPA n�o exige uma transa��o para recuperar valores do banco de dados.
		Usuario usuario = em.find(Usuario.class, 8L); // Encontra um elemento no banco de dados de acordo com os par�metros passados.
		System.out.println(usuario.getNome());
		
		em.close();
		emf.close();
	}
}

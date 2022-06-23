package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // f�brica de gerenciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		Usuario usuario = em.find(Usuario.class, 7l); //Preenche o objeto com a tupla do banco de dados
		usuario.setNome("Leonardo");
		em.detach(usuario);

		em.getTransaction().begin(); //Merge() precisa estar em comtexto de atualiza��o para funcionar, serve para atualizar um objeto j� existente no bamco de dados.	
		
		 /*Quando um objeto � criado a partir de uma consulta no banco de dados, este objeto  dentro de um comtexto de transa��o fica em estado de gerenciado. O m�todo 
		  * detach() serve para tornar o objeto em estado n�o gerenciado, para que qualquer altera��o nele feita seja validada de forma expl�cita com o uso do m�todo de 
		  * atualiza��o merge(), caso o detach() n�o seja chamado, este ser� atualizado dentro da transa��o mesmo que o merge n�o sejachamado, pois estar� em estado gerenciado.*/
		
		em.merge(usuario); // Efetua atualiza��o em um objeto j� existente no banco de dados.
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}

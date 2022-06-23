package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // fábrica de gerenciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		Usuario usuario = em.find(Usuario.class, 7l); //Preenche o objeto com a tupla do banco de dados
		usuario.setNome("Leonardo");
		em.detach(usuario);

		em.getTransaction().begin(); //Merge() precisa estar em comtexto de atualização para funcionar, serve para atualizar um objeto já existente no bamco de dados.	
		
		 /*Quando um objeto é criado a partir de uma consulta no banco de dados, este objeto  dentro de um comtexto de transação fica em estado de gerenciado. O método 
		  * detach() serve para tornar o objeto em estado não gerenciado, para que qualquer alteração nele feita seja validada de forma explícita com o uso do método de 
		  * atualização merge(), caso o detach() não seja chamado, este será atualizado dentro da transação mesmo que o merge não sejachamado, pois estará em estado gerenciado.*/
		
		em.merge(usuario); // Efetua atualização em um objeto já existente no banco de dados.
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}

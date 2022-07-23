package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // fábrica de gerenciador de entidades
		EntityManager em = emf.createEntityManager(); // gerenciador de entidades
		
		Usuario usuario = new Usuario();
		
		usuario = em.find(Usuario.class, 1L);
		Usuario usuario02 = new Usuario("Feijao", "feijao@gmail.com");
		usuario02.setId(9L);
		Usuario usuario3 = new Usuario("Boanerges", "boanergesmedeiros2@gmail.com");
//		usuario.setNome("Leonardo");
		usuario.setEmail("soutodasilvarafael.com.br");
		usuario.setNome("Rafael");
		
		em.getTransaction().begin(); //Merge() necessita de um comtexto de transação
//		usuario.setEmail("soutadasilvarafael.com.br");
//		usuario.setNome("FAFA");
		em.detach(usuario02);
		em.merge(usuario02); //Responsável por atualizar um objeto que já existe no banco de dados
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		/*O merge(Object arg0) serve para atualizar uma instância no banco de dados, se esta instância oferecida de parâmetro não estiver setada no banco de dados, ele chama 
		 * o persist(Object arg0).
		 *Caso você crie uma variável que recebe uma instância do banco de dados a partir do find(Class<E>, Object arg0), mesmo que você não dê a variável de parâmetro para
		 *o método merge(), ou faça as alterações nos valores de seus atributos fora do contexto de transação, ou até mesmo nem chame o método merge() (neste último caso,
		 *as alterações serão validades com o começo da transação a partir do beguin() e o commite através do commit())ainda assim, suas alterações serão validadas no registro
		 *equivalente do banco de dados.
		 *Para que as validações nas instâncias sejam validadas no banco de dados se e somente se o merge(Object arg01) com a instância que foi alterada, usaa-se o método
		 *detach (Object arg0) oferecendo de parâmetro a instância que se deseja alterar no banco de dados.
		 *Quando você preenche uma instância com um registro do banco de dados, dentro do contexto de transação (entre begin() e commit()), esta instância torna-se gerenciada e
		 *qualquer mudança detectada nela será validada no banco de dados.
		 *Outra coisa: se você criar uma instância que não está mapeada no banco de dados, mas definir teu id com o valor de um registro de mesmo id no banco de dados e em
		 *seguida oferecer esta insância de parâmetro para o merge(), esta instância será mapeada para o registro de mesmo Id no banco de dados, e quaisquer modificações
		 *serão aplicadas no registro de mesmo Id no banco de dados  */
	}
}

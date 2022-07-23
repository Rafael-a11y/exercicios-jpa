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
		
		Usuario usuario = new Usuario();
		
		usuario = em.find(Usuario.class, 1L);
		Usuario usuario02 = new Usuario("Feijao", "feijao@gmail.com");
		usuario02.setId(9L);
		Usuario usuario3 = new Usuario("Boanerges", "boanergesmedeiros2@gmail.com");
//		usuario.setNome("Leonardo");
		usuario.setEmail("soutodasilvarafael.com.br");
		usuario.setNome("Rafael");
		
		em.getTransaction().begin(); //Merge() necessita de um comtexto de transa��o
//		usuario.setEmail("soutadasilvarafael.com.br");
//		usuario.setNome("FAFA");
		em.detach(usuario02);
		em.merge(usuario02); //Respons�vel por atualizar um objeto que j� existe no banco de dados
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		/*O merge(Object arg0) serve para atualizar uma inst�ncia no banco de dados, se esta inst�ncia oferecida de par�metro n�o estiver setada no banco de dados, ele chama 
		 * o persist(Object arg0).
		 *Caso voc� crie uma vari�vel que recebe uma inst�ncia do banco de dados a partir do find(Class<E>, Object arg0), mesmo que voc� n�o d� a vari�vel de par�metro para
		 *o m�todo merge(), ou fa�a as altera��es nos valores de seus atributos fora do contexto de transa��o, ou at� mesmo nem chame o m�todo merge() (neste �ltimo caso,
		 *as altera��es ser�o validades com o come�o da transa��o a partir do beguin() e o commite atrav�s do commit())ainda assim, suas altera��es ser�o validadas no registro
		 *equivalente do banco de dados.
		 *Para que as valida��es nas inst�ncias sejam validadas no banco de dados se e somente se o merge(Object arg01) com a inst�ncia que foi alterada, usaa-se o m�todo
		 *detach (Object arg0) oferecendo de par�metro a inst�ncia que se deseja alterar no banco de dados.
		 *Quando voc� preenche uma inst�ncia com um registro do banco de dados, dentro do contexto de transa��o (entre begin() e commit()), esta inst�ncia torna-se gerenciada e
		 *qualquer mudan�a detectada nela ser� validada no banco de dados.
		 *Outra coisa: se voc� criar uma inst�ncia que n�o est� mapeada no banco de dados, mas definir teu id com o valor de um registro de mesmo id no banco de dados e em
		 *seguida oferecer esta ins�ncia de par�metro para o merge(), esta inst�ncia ser� mapeada para o registro de mesmo Id no banco de dados, e quaisquer modifica��es
		 *ser�o aplicadas no registro de mesmo Id no banco de dados  */
	}
}

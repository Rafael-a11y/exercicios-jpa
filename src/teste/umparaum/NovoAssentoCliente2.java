package teste.umparaum;

import infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class NovoAssentoCliente2 
{
	public static void main(String[] args) 
	{
		Assento assento = new Assento("04D");
		Cliente cliente = new Cliente("Maria", assento);
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		
		dao.incluirDeFormaAtomica(cliente).fecharEntityManager();
		
		/*Como o cascade est� setado para persistir em cascata (na anota��o OneToOne), mesmo que somente o objeto cliente seja oferecido para ser persistido,
		 * o objeto Assento assnto que foi criado e oferecido de par�metro no construtor de Cliente, tamb�m � persistido, por conta da Enum CascadeType.PERSIST
		 * Repare que o objeto Assento assento n�o oferecido de par�metro para ser persistido*/
	}
}

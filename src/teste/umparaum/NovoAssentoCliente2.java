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
		
		/*Como o cascade está setado para persistir em cascata (na anotação OneToOne), mesmo que somente o objeto cliente seja oferecido para ser persistido,
		 * o objeto Assento assnto que foi criado e oferecido de parâmetro no construtor de Cliente, também é persistido, por conta da Enum CascadeType.PERSIST
		 * Repare que o objeto Assento assento não oferecido de parâmetro para ser persistido*/
	}
}

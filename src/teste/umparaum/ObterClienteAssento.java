package teste.umparaum;

import infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class ObterClienteAssento 
{
	public static void main(String[] args) 
	{
		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		Cliente cliente =  daoCliente.obterPorId(1L);
		Assento assento = daoAssento.obterPorId(1L);
		System.out.println("Nome: " + cliente.getNome() + ", Assento: " + cliente.getAssento().getNome());
		System.out.println("Assento: " + assento.getNome() + ", Cliente: " + assento.getCliente().getNome()); //Repare que eu consigo achar o nome do cliente a partir do objeto assento.
		daoCliente.fecharEntityManager();
		
	}
}
package teste.heranca;

import java.util.Date;

import infra.DAO;
import modelo.heranca.Cliente;
import modelo.heranca.Usuario;

public class InserirClientesEUsuarios 
{
	public static void main(String[] args) 
	{
		DAO<Cliente> daoCliente = new DAO<>();
//		DAO<Usuario> daoUsuario = new DAO<Usuario>();
		Cliente cliente = new Cliente("Rafael Souto da Silva", new Date(System.currentTimeMillis()) ,"rsowtto@gmail.com", "Quadra 306 Conjunto 5A", "61994143284");
		daoCliente.incluirDeFormaAtomica(cliente).fecharEntityManager();
		
	}
}

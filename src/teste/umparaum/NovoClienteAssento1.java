package teste.umparaum;

import infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class NovoClienteAssento1 
{
	public static void main(String[] args) 
	{
		Assento assento = new Assento("01A");
		Cliente cliente = new Cliente("Daniel", assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao.comecarTransacao().persistirEntidade(cliente).persistirEntidade(assento).commitarTransacao().fecharEntityManager();
	}
}

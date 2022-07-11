package teste.umparamuitos;

import infra.DAO;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class ObterPedido
{
	public static void main(String[] args) 
	{
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		//Recupera um registro da tabela pedido, registro este que preenche o objeto.
		Pedido pedido = dao.obterPorId(1L);  
		Pedido pedido01 = new Pedido();
		
	//Faz um loop cuja condi��o � a quantidade de itens presentes na lista de itens do objeto pedido
	for(ItemPedido item : pedido.getItens()) 
	{
		/*Como o pedido recuperado do banco de dados s� possui um item associado, ent�o a itera��o acontece uma vez s�*/
		System.out.println("Quantidade: " + item.getQuantidade()); 
		System.out.println("Nome do produto: " + item.getProduto().getNome());
	}
		dao.fecharEntityManager();
	}
	/*Enfim, quando o objeto pedido � preenchido com o registro equivalente do banco dedados, o atributo list<ItemPedido> itens � preenchido com um objeto ItemPedidos, 
	 * referente ao registro da tabela de itempedidos na banco de dados, pois nesta tabela existe uma foreign key que referencia o id do pedido da tabela de pedido 
	 * (isso s� � poss�vel por conta da anota��o @OneToMany na classe Pedido, em cima do atributo List<ItemPedido> itens)*/
}

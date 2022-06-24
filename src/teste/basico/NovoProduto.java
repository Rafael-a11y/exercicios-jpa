package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto
{
	public static void main(String[] args) 
	{
		Produto produto = new Produto("Samsung Gallaxy S22 FE", 5500.00);
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.incluirDeFormaAtomica(produto);
		
		System.out.println("ID do Produto: " + produto.getId());
	}
}

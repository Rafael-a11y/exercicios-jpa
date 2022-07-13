package teste.composicao;

import infra.DAO;
import modelo.composicao.Endereco;
import modelo.composicao.Fornecedor;

public class InserirFornecedoresEFuncionarios 
{
	public static void main(String[] args) 
	{
		DAO<Fornecedor> dao = new DAO<>();
		Fornecedor fornecedor = new Fornecedor("Rafael Souto da Silva", new Endereco("Quadra 306 Conjunto 5A", "Casa 05"));
		dao.incluirDeFormaAtomica(fornecedor).fecharEntityManager();
	}
}

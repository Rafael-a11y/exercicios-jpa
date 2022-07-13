package teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;
import modelo.muitosparamuitos.Filme;

public class ObterMediaFilmes 
{
	public static void main(String[] args) 
	{
		Double notaTeste;
		/*Passar um tipo que não seja NotaFilme vai dar exceção em tempo de execução, pois o tipo especificado para a TypedQuery nativa é NotaFilme, significa que chamar o método
		 * DAO<E> consultarUm(String nomeConsulta, Object... params) gerará uma Exceção em tempo de execução java.lang.IllegalArgumentException*/
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		/*O método consultarUm(String nomeConsulta, Object... params) vai retornar um tipo NotaFilme, caso você queira oferecer o retorno para um objeto de tipo diferente, vai
		 * dar exceção, pois o tipo retornado pela consulta nativa SQL vai ser um tipo NotaFilme*/
		NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");
		System.out.println(nota.getMedia());
		dao.fecharEntityManager();
		
	}
}

package teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;
import modelo.muitosparamuitos.Filme;

public class ObterMediaFilmes 
{
	public static void main(String[] args) 
	{
		Double notaTeste;
		/*Passar um tipo que n�o seja NotaFilme vai dar exce��o em tempo de execu��o, pois o tipo especificado para a TypedQuery nativa � NotaFilme, significa que chamar o m�todo
		 * DAO<E> consultarUm(String nomeConsulta, Object... params) gerar� uma Exce��o em tempo de execu��o java.lang.IllegalArgumentException*/
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		/*O m�todo consultarUm(String nomeConsulta, Object... params) vai retornar um tipo NotaFilme, caso voc� queira oferecer o retorno para um objeto de tipo diferente, vai
		 * dar exce��o, pois o tipo retornado pela consulta nativa SQL vai ser um tipo NotaFilme*/
		NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");
		System.out.println(nota.getMedia());
		dao.fecharEntityManager();
		
	}
}

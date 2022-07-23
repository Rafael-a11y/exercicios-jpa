package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno 
{
	public static void main(String[] args) 
	{
		DAO<Aluno> dao = new DAO<>();
		Aluno aluno = new Aluno(3L, "Israel");
		AlunoBolsista aluno02 = new AlunoBolsista(04L, "Tirza", 1000);
		System.out.println(aluno);
		dao.incluirDeFormaAtomica(aluno);
		dao.incluirDeFormaAtomica(aluno02).fecharEntityManager();
	}
}
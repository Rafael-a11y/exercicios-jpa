package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Sobrinho;
import modelo.muitosparamuitos.Tio;

public class NovoTioSobrinho
{
	public static void main(String[] args)
	{
		Tio tia01 = new Tio("Maria");
		Tio tio02 = new Tio("João");
		
		Sobrinho sobrinho01 = new Sobrinho("Davi");
		Sobrinho sobrinha02 = new Sobrinho("Ana");
		
		tia01.getSobrinhos().add(sobrinho01);
		sobrinho01.getTios().add(tia01);
		
		tia01.getSobrinhos().add(sobrinha02);
		sobrinha02.getTios().add(tia01);
		
		tio02.getSobrinhos().add(sobrinho01);
		sobrinho01.getTios().add(tio02);
		
		tio02.getSobrinhos().add(sobrinha02);
		sobrinha02.getTios().add(tio02);
		
		DAO<Object> dao = new DAO<>();
		dao.comecarTransacao().persistirEntidade(tia01).persistirEntidade(tio02).persistirEntidade(sobrinho01).persistirEntidade(sobrinha02).commitarTransacao()
			.fecharEntityManager();
		
		/*É muito importante que se tenha uma consistêcia, uma vez que uma relação bidirecional é estabelecida, é importante sempre estar fazendo as alterações necessárias nos
		 * dois lados da relação para não dar brecha para inconsistência de dados*/
	}
}

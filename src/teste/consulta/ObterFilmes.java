package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class ObterFilmes 
{
	public static void main(String[] args) 
	{
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.0);
		
		for(Filme filme : filmes)
		{
			System.out.println("\n" + filme.getNome() + " -> " + filme.getNota());
			for(Ator ator : filme.getAtores())
			{
				System.out.println("      " + ator.getNome());
			}
		}
	}
	/*Manipulando consultas por meio de uma NamedQuery
	 * 
	 * select distinct f from Filme f
			join fetch f.atores
			where f.nota > :nota
	 * 
	 * Me lembrar de voltar aqui para tentar compreender melhor este código!*/
}

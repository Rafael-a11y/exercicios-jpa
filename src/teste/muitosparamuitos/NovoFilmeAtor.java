package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class NovoFilmeAtor 
{
	public static void main(String[] args) 
	{
		Filme filmeA = new Filme("Star Wars ep 4", 8.9);
		Filme filmeB = new Filme("O fugitivo", 8.1);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atrizB = new Ator("Carrie Fisher");
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atrizB);
		
		filmeB.adicionarAtor(atorA);
		
		DAO<Filme> dao = new DAO<Filme>();
		/*Quando o objeto Filme filmeA for persistido na tabela de filmes, os objetos contidos na List<Ator> atores ser�o persistidos tamb�m, isso acontece por conta do 
		 * atributo cascade estar definido como @ManyToMany (cascade = CascadeType.PERSIST), mas na classe Ator a List<Filme> tamb�m est� setada como @ManyToMany(cascade = 
		 * CascadeType.PERSIST), isso significa que no momento que os atores forem persistidos, os elementos presentes na List<Filme> filmes de cada objeto Ator ser� persistido.
		 * Portanto, o Filme filmeB ser� persistido pois est� presente na List<Filme> filmes do atorA, estando este �ltimo presente em List<Ator> atores de Filme filmeA*/
		dao.incluirDeFormaAtomica(filmeA).fecharEntityManager();
		
		}
}

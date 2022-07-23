package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*TABLE_PER_CLASE significa tabela por classe concreta. Como a classe Aluno n�o � abstrata, tal classe ter� uma tabela equivalente no banco de dados, a classe filha AlunoBolsista
 * tamb�m est� mapeaeada com @Entity e tamb�m ter� uma tabela equivalente no banco de dados, por�m esta �ltima possui apenas um atributo declarado, o private double valorBolsa.
 * Com a estrat�gia TABLE_PER_CLASS, as duas classes ter�o suas tabelas, a tabela aluno com os campos matricula (primary key) e nome, a tabela alunobolsa com os campos matricula
 * (primary key), nome evalorbolsa, pois a classe AlunoBolsista herda os dois primeiros atributos de Aluno, por�m as tabelas criadas s�o independentes, os registros precisam ser
 * inseridos separadamente em suas tabelas, elas s�o criadas sem uma Foreign Key de refer�ncia a outra e vice versa, nesse tipo de estrat�gia, a distin��o por meio das anota��es
 * @DiscriminatorColumn e @DiscriminatorValue, ou seja, a coluna discriminadora ipoAluno n�o ser� criada, na minha opni�o, essa estrat�gia � a pior.
 * Com a estrat�gia InheritanceType.SINGLE_TABLE, uma tabela apenas ser� criada, a tabela aluno (Classe pai Aluno), a tabela aluno criada ter� todos os campos equivalentes aos
 * atributos da classe pai Aluno e classe filha AlunoBolsista, os campos ser�o: tipoAluno, matricula (primary key), nome e valorbolsa. Como o valor SINGLE_TABLE � padr�o, logo, 
 * se o programador n�o declarar uma estrat�gia de heran�a, a estrat�gia usada ser� esta.
 * Com a estrat�gia SINGL_TABLE, junto do devido mapeamento das classes, temos uma �nica tabela aluno devidamente mapeada, o mapeamento se deve �s anota��es
 * @DiscriminatorColumn(name = "tipoAluno", length = 2, discriminatorType = DiscriminatorType.STRING) e @DiscriminatorValue("AL"), dentro de @DiscriminatorColumn, o atributo 
 * name se refere ao nome da coluna discriminadora, length se refere ao tamanho, discriminatorType se refere ao tipo do valor que a coluna ter�, no caso, STRING, em 
 * @DiscriminatorValue temos o valor que ser� inserido no campo AUTOMATICAMENTE na inser��o de um objeto aluno pelo JPA.  
 * Com a estrat�gia JOINED, duas tabelas ser�o criadas, aluno e alunobolsista, aluno ter� os campos: tipoAluno, matricula (primary key) e nome, a tabela alunobolsista ter�
 * os campos: valorBolsa e matr�cula (primary key e foreign key) referenciando a tabela aluno. Por padr�o, a melhor escolha � a estrat�gia JOINED.*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipoAluno", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL")

 public class Aluno 
{
	@Id
	private Long matricula;
	
	private String nome;
	
	public Aluno() {}

	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

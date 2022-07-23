package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*TABLE_PER_CLASE significa tabela por classe concreta. Como a classe Aluno não é abstrata, tal classe terá uma tabela equivalente no banco de dados, a classe filha AlunoBolsista
 * também está mapeaeada com @Entity e também terá uma tabela equivalente no banco de dados, porém esta última possui apenas um atributo declarado, o private double valorBolsa.
 * Com a estratégia TABLE_PER_CLASS, as duas classes terão suas tabelas, a tabela aluno com os campos matricula (primary key) e nome, a tabela alunobolsa com os campos matricula
 * (primary key), nome evalorbolsa, pois a classe AlunoBolsista herda os dois primeiros atributos de Aluno, porém as tabelas criadas são independentes, os registros precisam ser
 * inseridos separadamente em suas tabelas, elas são criadas sem uma Foreign Key de referência a outra e vice versa, nesse tipo de estratégia, a distinção por meio das anotações
 * @DiscriminatorColumn e @DiscriminatorValue, ou seja, a coluna discriminadora ipoAluno não será criada, na minha opnião, essa estratégia é a pior.
 * Com a estratégia InheritanceType.SINGLE_TABLE, uma tabela apenas será criada, a tabela aluno (Classe pai Aluno), a tabela aluno criada terá todos os campos equivalentes aos
 * atributos da classe pai Aluno e classe filha AlunoBolsista, os campos serão: tipoAluno, matricula (primary key), nome e valorbolsa. Como o valor SINGLE_TABLE é padrão, logo, 
 * se o programador não declarar uma estratégia de herança, a estratégia usada será esta.
 * Com a estratégia SINGL_TABLE, junto do devido mapeamento das classes, temos uma única tabela aluno devidamente mapeada, o mapeamento se deve às anotações
 * @DiscriminatorColumn(name = "tipoAluno", length = 2, discriminatorType = DiscriminatorType.STRING) e @DiscriminatorValue("AL"), dentro de @DiscriminatorColumn, o atributo 
 * name se refere ao nome da coluna discriminadora, length se refere ao tamanho, discriminatorType se refere ao tipo do valor que a coluna terá, no caso, STRING, em 
 * @DiscriminatorValue temos o valor que será inserido no campo AUTOMATICAMENTE na inserção de um objeto aluno pelo JPA.  
 * Com a estratégia JOINED, duas tabelas serão criadas, aluno e alunobolsista, aluno terá os campos: tipoAluno, matricula (primary key) e nome, a tabela alunobolsista terá
 * os campos: valorBolsa e matrícula (primary key e foreign key) referenciando a tabela aluno. Por padrão, a melhor escolha é a estratégia JOINED.*/
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

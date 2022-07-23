package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/*@DiscriminatorValue("AB") se refere ao valor que será inserido AUTOMATICAMENTE na tabela pelo JPA, no momento em que o objeto do tipo AlunoBolsista ser persistido no banco!*/
@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno
{
	private double valorBolsa;
	
	public AlunoBolsista() {}

	public AlunoBolsista(Long matricula, String nome, double valorBolsa) {
		super(matricula, nome);
		this.valorBolsa = valorBolsa;
	}

	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}
}

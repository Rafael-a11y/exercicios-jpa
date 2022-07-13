package modelo.composicao;

import javax.persistence.Embeddable;

/*A anota��o @Embeddable serve para os casos de composi��o de classes, a classe Endereco n�o � persistida em forma de tabela no banco de dados, ela apenas serve para servir
 * de reutiliza��o de c�digo, pois tanto Fornecedor quanto Funcionario possuem um atributo do tipo Endereco endereco, sendo assim, os dados inseridos nos atributos do objeto
 * Endereco endereco ser�o persistidos como colunas nas tabelas equivalentes de Fornecedor e Funcionario no banco de dados. */
@Embeddable
public class Endereco 
{
	private String logradouro;
	private String complemento;
	
	public Endereco() {}
	
	public Endereco(String logradouro, String complemento)
	{
		this.logradouro = logradouro;
		this.complemento = complemento;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}   

package modelo.heranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario extends Pessoa
{
	@Column (nullable = false) private String loguin;
	@Column (nullable = false) private String senha;
	
	public Usuario() {}

	public Usuario(String loguin, String senha) {
		super();
		this.loguin = loguin;
		this.senha = senha;
	}

	public String getLoguin() {
		return loguin;
	}

	public void setLoguin(String loguin) {
		this.loguin = loguin;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

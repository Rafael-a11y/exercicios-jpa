package modelo.heranca;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa 
{
	@Column 
	(nullable = false) private String email;
	@Column 
	(nullable = false) private String endereco;
	@Column 
	(nullable = false) private String telefone;
	
	public Cliente() 
	{
		super();
	}
	
	public Cliente(String email, String endereco, String telefone) {
		super();
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public Cliente(String nome, Date dataCadastro, String email, String endereco, String telefone) {
		super(nome, dataCadastro);
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

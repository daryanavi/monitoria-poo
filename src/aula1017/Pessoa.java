/**
 * 18 de out de 2019
 */
package aula1017;

import java.util.Date;

/**
 * @author Daryan Avi
 *
 */
public class Pessoa
{
	private int codigo;
	private String nome, email, fone;
	private Date dataNascimento;
	
	public Pessoa() {}
	
	public Pessoa(int codigo, String nome, String email, String fone, Date dataNascimento)
	{
		this.codigo = codigo;
		this.email = email;
		this.nome = nome;
		this.fone = fone;
		this.dataNascimento = dataNascimento;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public String getFone()
	{
		return fone;
	}

	public void setFone(String fone)
	{
		this.fone = fone;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getDataNascimento()
	{
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString()
	{
		return nome + " (Código: " + codigo + "; Fone: " + fone + "; e-Mail: " + email + "; Data de Nascimento: " + Util.dateToString(dataNascimento) + ")";
	}
}
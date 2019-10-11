/**
 * 10 de out de 2019
 */
package aula1003.prova.v1;

/**
 * @author Daryan Avi
 *
 */
public class Pessoa
{
	private String nome;

	public Pessoa(String nome) 
	{
		this.nome = nome;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	@Override
	public String toString()
	{
		return "Pessoa [nome=" + nome + "]";
	}
}
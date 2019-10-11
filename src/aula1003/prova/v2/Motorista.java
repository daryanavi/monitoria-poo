/**
 * 11 de out de 2019
 */
package aula1003.prova.v2;

/**
 * @author Daryan Avi
 *
 */
public class Motorista
{
	private String nome;

	public Motorista(String nome)
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
		return "Motorista [nome=" + nome + "]";
	}
}
/**
 * 10 de out de 2019
 */
package aula1003.prova.v1;

/**
 * @author Daryan Avi
 *
 */
public class Atleta extends Pessoa
{
	private int ranking;

	public Atleta(String nome, int ranking)
	{
		super(nome);
		
		this.ranking = ranking;
	}
	
	public int getRanking() 
	{
		return ranking;
	}

	public void setRanking(int ranking) 
	{
		this.ranking = ranking;
	}

	@Override
	public String toString()
	{
		return "Atleta [ranking=" + ranking + "]";
	}
}
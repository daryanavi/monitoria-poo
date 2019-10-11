/**
 * 3 de out de 2019
 */
package aula1003.prova.v2;

/**
 * @author Daryan Avi
 *
 */
public class Item
{
	private Cidade cidade;
	
	public Item(Cidade cidade)
	{
		this.cidade = cidade;
	}

	public Cidade getCidade()
	{
		return cidade;
	}

	public void setCidade(Cidade cidade)
	{
		this.cidade = cidade;
	}
}
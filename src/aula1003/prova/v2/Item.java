/**
 * 11 de out de 2019
 */
package aula1003.prova.v2;

/**
 * @author Daryan Avi
 *
 */
public class Item
{
	private double valor;
	private String rastreio;
	private Cidade origem, destino;
	
	public Item(double valor, String rastreio, Cidade origem, Cidade destino)
	{
		this.valor = valor;
		this.rastreio = rastreio;
		this.origem = origem;
		this.destino = destino;
	}

	public double getValor()
	{
		return valor;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}

	public String getRastreio()
	{
		return rastreio;
	}

	public void setRastreio(String rastreio)
	{
		this.rastreio = rastreio;
	}

	public Cidade getOrigem()
	{
		return origem;
	}

	public void setOrigem(Cidade origem)
	{
		this.origem = origem;
	}

	public Cidade getDestino()
	{
		return destino;
	}

	public void setDestino(Cidade destino)
	{
		this.destino = destino;
	}

	@Override
	public String toString()
	{
		return "Item: Valor = " + valor + "; Rastreio = " + rastreio + "; Origem = " + origem + "; Destino = " + destino + "";
	}
}
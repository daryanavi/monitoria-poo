/**
 * 11 de out de 2019
 */
package aula1003.prova.v2;

import java.util.ArrayList;

/**
 * @author Daryan Avi
 *
 */
public class Frete
{
	private Motorista motorista;
	private Cidade cidade;
	private ArrayList<Item> itens;
	
	public Frete(Motorista motorista, Cidade cidade, ArrayList<Item> itens)
	{
		this.motorista = motorista;
		this.cidade = cidade;
		this.itens = itens;
	}

	public Motorista getMotorista()
	{
		return motorista;
	}

	public void setMotorista(Motorista motorista)
	{
		this.motorista = motorista;
	}

	public Cidade getCidade()
	{
		return cidade;
	}

	public void setCidade(Cidade cidade)
	{
		this.cidade = cidade;
	}

	public ArrayList<Item> getItens()
	{
		return itens;
	}

	public void setItens(ArrayList<Item> itens)
	{
		this.itens = itens;
	}
	
	public double valorTotalFrete()
	{
		double total = 0;
		
		for (Item i : itens)
			total += i.getValor();
		
		return total;
	}
	
	public String cidades()
	{
		ArrayList<String> cidades = new ArrayList<>();
		
		for (Item i : itens)
		{
			if (! cidades.contains(i.getOrigem().getNome()))
				cidades.add(i.getOrigem().getNome());
			
			if (! cidades.contains(i.getDestino().getNome()))
				cidades.add(i.getDestino().getNome());
		}
		
		return String.join("\n", cidades);
	}
	
	public Item maiorValor()
	{
		Item maiorValor = null;
		
		for (Item i : itens)
		{
			if (maiorValor == null || i.getValor() > maiorValor.getValor())
				maiorValor = i;
		}
		
		return maiorValor;
	}
	
	public String nomeMotorista()
	{
		return motorista.getNome();
	}
	
	public String cidadeItens()
	{
		StringBuilder retorno = new StringBuilder(); // Builder para concatenar a String de retorno
		
		ArrayList<Cidade> cidadesOrigem = new ArrayList<>();
		ArrayList<Cidade> cidadesDestino = new ArrayList<>();
		
		for (Item i : itens) // Percorre itens e armazena todas as cidades de origem e destino em ArrayLists separados
		{
			cidadesOrigem.add(i.getOrigem());
			cidadesDestino.add(i.getDestino());
		}
		
		retorno.append("Origem\n");
		retorno.append(cidadeItensTotalizado(cidadesOrigem)); // Busca String de listagem das cidades de origem
		retorno.append("\n\n");
		retorno.append("Destino\n");
		retorno.append(cidadeItensTotalizado(cidadesDestino)); // Busca String de listagem das cidades de destino
		
		return retorno.toString(); // Retorna String presente no Builder
	}
	
	/**
	 * M�todo que recebe como par�metro um ArrayList de Cidades, e retorna uma String com as Cidades separadas
	 * por quebra de linha, tendo ao lado de cada uma, entre par�nteses, o total de vezes que a Cidade em 
	 * quest�o � listada no ArrayList.
	 * 
	 * M�todo foi criado com o intuito de auxiliar o m�todo cidadesItens(), fazendo com que n�o seja 
	 * necess�rio repetir o mesmo c�digo para a listagem das cidades de Origem e Destino.
	 * 
	 * A cl�usula private garante que o m�todo ser� utilizado apenas na classe Frete.
	 */
	private String cidadeItensTotalizado(ArrayList<Cidade> cidades)
	{
		ArrayList<String> retorno = new ArrayList<>(); // Lista de Strings que ser�o concatenadas para compor a String de retorno
		ArrayList<String> cidadesListadas = new ArrayList<>(); // Lista de String que armazena as cidades j� listadas
		
		for (int i = 0; i < cidades.size(); i ++) // Percorre o ArrayList de Cidades passado como par�metro
		{
			String cidade = cidades.get(i).getNome(); // Nome da Cidade da itera��o atual
			
			if (! cidadesListadas.contains(cidade)) // Verifica se cidade n�o consta entre as j� listadas
			{
				int total = 1; // Se a cidade n�o foi listada ainda, inicia vari�vel com 1
				
				for (int j = i + 1; j < cidades.size(); j ++) // Percorre posi��es � frente da atual no ArrayList
				{
					if (cidades.get(j).getNome().equals(cidade)) // Verifica se cidade atual � repetida no ArrayList
						total ++; // Se for repetida, incrementa ao total de itens relacionados � cidade
				}
				
				cidadesListadas.add(cidade); // Ao terminar itera��o, armazena cidade entre as j� listadas
				retorno.add(cidade + " (" + total + ")"); // Adiciona String ao ArrayList de retorno
			}
		}
		
		return String.join("\n", retorno); // Retorna ArrayList 'retorno' j� identado com quebras de linhas
	}

	@Override
	public String toString()
	{
		return "Frete [motorista=" + motorista + ", cidade=" + cidade + ", itens=" + itens + "]";
	}
}
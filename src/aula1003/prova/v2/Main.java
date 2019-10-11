/**
 * 3 de out de 2019
 */
package aula1003.prova.v2;

import java.util.ArrayList;

/**
 * @author Daryan Avi
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Item> itens = new ArrayList<>();
		
		itens.add(new Item(new Cidade("Joinville")));
		itens.add(new Item(new Cidade("Criciúma")));
		itens.add(new Item(new Cidade("Rio do Sul")));
		itens.add(new Item(new Cidade("Joinville")));
		itens.add(new Item(new Cidade("Jaraguá")));
		itens.add(new Item(new Cidade("Rio do Sul")));
		itens.add(new Item(new Cidade("Criciúma")));
		itens.add(new Item(new Cidade("Rio do Sul")));
		itens.add(new Item(new Cidade("Agronômica")));
		
		ArrayList<Cidade> cidades = new ArrayList<>();
		
		for (Item i : itens)
		{
			cidades.add(i.getCidade());
		}
		
		int count = 0;
		
		for (int i = cidades.size() - 1; i >= 0; i --)
		{
			String nomeCidade = cidades.get(i).getNome();
			
			count = 1;
			
			cidades.remove(i);
			
			for (int j = i - 1; j >= 0; j --)
			{
				if (nomeCidade.equals(cidades.get(j).getNome()))
				{
					count ++;
					
					cidades.remove(j);
					
					i --;
				}
			}
			
			System.out.println(nomeCidade + " (" + count + ")");
			System.out.println();
		}
		
		
		
		
	}
}

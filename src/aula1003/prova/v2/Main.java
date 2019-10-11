/**
 * 11 de out de 2019
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
		/*
		 * Instancia um objeto do tipo Motorista
		 */
		Motorista motorista = new Motorista("Fudencio");
		
		/*
		 * Instancia um objeto do tipo Cidade
		 */
		Cidade cidade = new Cidade("Rio do Sul");
		
		/*
		 * Instancia um ArrayList composto pelo tipo Item, e em seguida o preenche
		 */
		ArrayList<Item> itens = new ArrayList<>();
		
		itens.add(new Item(130, "AHBDHU1282189D", new Cidade("Rio do Sul"), new Cidade("Ca�ador")));
		itens.add(new Item(400, "AU98289ENUSA93", new Cidade("Joinville"), new Cidade("Florian�polis")));
		itens.add(new Item(120, "OJGJ98238U9RJ2", new Cidade("Crici�ma"), new Cidade("Rio do Sul")));
		itens.add(new Item(800, "FD98U89FJ43904", new Cidade("Florian�polis"), new Cidade("Lages")));
		itens.add(new Item(200, "LOJEJ2E983EH39", new Cidade("Ibirama"), new Cidade("Lages")));
		itens.add(new Item(990, "M273E78D7D3NAD", new Cidade("Laurentino"), new Cidade("Ca�ador")));
		itens.add(new Item(666, "IUIUQ98D8D290D", new Cidade("Laurentino"), new Cidade("Lages")));
		itens.add(new Item(235, "LOJEJ2E983EH39", new Cidade("Ibirama"), new Cidade("Chapec�")));
		itens.add(new Item(827, "M273E78D7D3NAD", new Cidade("Agron�mica"), new Cidade("Blumenau")));
		itens.add(new Item(544, "IUIUQ98D8D290D", new Cidade("Agrol�ndia"), new Cidade("Joinville")));
		
		/*
		 * Instancia um Frete, passando como par�metros os objetos criados acima
		 */
		Frete frete = new Frete(motorista, cidade, itens);
		
		/*
		 * Quest�o 1
		 */
		System.out.println("*** Quest�o 1 ***");
		System.out.println(frete.valorTotalFrete());
		System.out.println();
		
		/*
		 * Quest�o 2
		 */
		System.out.println("*** Quest�o 2 ***");
		System.out.println(frete.cidades());
		System.out.println();
		
		/*
		 * Quest�o 3
		 */
		System.out.println("*** Quest�o 3 ***");
		System.out.println(frete.maiorValor());
		System.out.println();
		
		/*
		 * Quest�o 4
		 */
		System.out.println("*** Quest�o 4 ***");
		System.out.println(frete.nomeMotorista());
		System.out.println();
		
		/*
		 * Quest�o 5
		 */
		System.out.println("*** Quest�o 5 ***\n");
		System.out.println(frete.cidadeItens());
		System.out.println();
	}
}
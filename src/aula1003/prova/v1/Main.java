/**
 * 10 de out de 2019
 */
package aula1003.prova.v1;

import java.util.Calendar;

/**
 * @author Daryan Avi
 *
 */
public class Main
{
	public static void main(String[] args) 
	{
		/*
		 * Inicializa o vetor 'saltos' com 5 valores
		 */
		float[] saltos = new float[]
		{
			5.5f, 6f, 7f, 8f, 11.2f
		};
		
		/*
		 * Instancia um objeto Atleta
		 */
		Atleta atleta = new Atleta("Daryan", 15);
		
		/*
		 * Inicializa um vetor com 5 itens do tipo Jurado
		 */
		Jurado[] jurados = new Jurado[5];
		
		/*
		 * Instancia a classe Calendar
		 */
		Calendar cal = Calendar.getInstance();
		
		/*
		 * Classe Calendar � manipulada para ir mudando a data de cadastro de cada novo jurado
		 */
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.YEAR, 2018);
		
		/*
		 * Instancia um novo Jurado para cada uma das 5 posi��es do vetor
		 */
		jurados[0] = new Jurado("Adamastor", cal.getTime());
		
		cal.set(Calendar.DAY_OF_MONTH, 23);
		cal.set(Calendar.MONTH, 7);
		cal.set(Calendar.YEAR, 2015);
		
		jurados[1] = new Jurado("Josias", cal.getTime());
		
		cal.set(Calendar.DAY_OF_MONTH, 4);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.YEAR, 2017);
		
		jurados[2] = new Jurado("Clebinho", cal.getTime());
		
		cal.set(Calendar.DAY_OF_MONTH, 3);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.YEAR, 2012);
		
		jurados[3] = new Jurado("Simas Turbo", cal.getTime());
		
		cal.set(Calendar.DAY_OF_MONTH, 18);
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.YEAR, 2019);
		
		jurados[4] = new Jurado("Pingolo", cal.getTime());
		
		/*
		 * Instancia um objeto Apresentacao com as informa��es de entrada dadas acima
		 */
		Apresentacao a = new Apresentacao(saltos, atleta, jurados);
		
		/*
		 * Quest�o 1
		 */
		System.out.println("Quest�o 1: " + a.mediaSimples());
		
		/*
		 * Quest�o 2
		 */
		System.out.println("Quest�o 2: " + a.mediaFinal());
		
		/*
		 * Quest�o 3
		 */
		System.out.println("Quest�o 3: " + a.nomeJurados());
		
		/*
		 * Quest�o 4
		 */
		System.out.println("Quest�o 4: " + a.ranking());
		
		/*
		 * Quest�o 5
		 */
		System.out.println("Quest�o 5: " + a.maisAntigo().getNome());
	}
}
/**
 * 27 de set de 2019
 */
package aula0926.ex11;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Daryan Avi
 *
 */
public class Ex04
{
	public static void main(String[] args)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.DAY_OF_MONTH, 29);
		cal1.set(Calendar.MONTH, 1);
		cal1.set(Calendar.YEAR, 2020);
		
		final String[] diasSemana = new String[]
		{
			"Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"	
		};
		
		System.out.println("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(cal1.getTime()));
		System.out.println("Dia da Semana: " + diasSemana[cal1.get(Calendar.DAY_OF_WEEK) - 1]);
	}
}
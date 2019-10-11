/**
 * 26 de set de 2019
 */
package aula0926.ex11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Daryan Avi
 *
 */
public class Ex03
{
	public static void main(String[] args)
	{
		final int FERIADO_DIA = 0;
		final int FERIADO_MES = 1;
		
		final int[][] feriados = new int[][]
		{
			new int[] {1, 1},
			new int[] {5, 3},
			new int[] {19, 4},
			new int[] {21, 4},
			new int[] {1, 5},
			new int[] {7, 9},
			new int[] {12, 10},
			new int[] {2, 11},
			new int[] {15, 11},
			new int[] {25, 12},
		};
		
		final int parcelas = 15;
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		cal1.set(Calendar.MONTH, 11);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		int diasPular = 30;
		
		for (int i = 0; i < parcelas; i ++)
		{
			cal1.add(Calendar.DAY_OF_MONTH, diasPular);
			
			diasPular = 30;
			
			boolean diaUtil = false;
			
			while (! diaUtil)
			{
				diaUtil = cal1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
						cal1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY;
				
				if (diaUtil)
				{
					for (int[] f : feriados)
					{
						if (f[FERIADO_DIA] == cal1.get(Calendar.DAY_OF_MONTH) && f[FERIADO_MES] == cal1.get(Calendar.MONTH) + 1)
						{
							diaUtil = false;
							
							break;
						}
					}
				}
				
				if (! diaUtil)
				{
					cal1.add(Calendar.DAY_OF_MONTH, 1);
					
					diasPular --;
				}
			}
			
			System.out.println((i + 1) + "ª parcela: " + format.format(cal1.getTime()));
		}
	}
}
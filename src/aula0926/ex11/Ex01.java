/**
 * 26 de set de 2019
 */
package aula0926.ex11;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Daryan Avi
 *
 */
public class Ex01
{
	public static void main(String[] args)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		cal2.set(Calendar.DAY_OF_MONTH, 30);
		cal2.set(Calendar.MONTH, 11);
		
		int sabados = 0, domingos = 0;
		
		while (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR) || 
			   cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && 
			   cal1.get(Calendar.DAY_OF_YEAR) <= cal2.get(Calendar.DAY_OF_YEAR))
		{
			if (cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			{
				domingos ++;
				
				cal1.add(Calendar.DAY_OF_MONTH, 6);
			}
			else
			{
				if (cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
					sabados ++;
				
				cal1.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		
		System.out.println("Sábados: " + sabados);
		System.out.println("Domingos: " + domingos);
	}
}
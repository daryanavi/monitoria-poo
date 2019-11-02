/**
 * 18 de out de 2019
 */
package aula1017;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Daryan Avi
 *
 */
public final class Util
{
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String dateToString(Date date)
	{
		return dateFormat.format(date);
	}
	
	public static Date stringToDate(String date) throws ParseException
	{
		return dateFormat.parse(date);
	}
}
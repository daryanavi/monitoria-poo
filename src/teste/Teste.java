/**
 * 11 de out de 2019
 */
package teste;

/**
 * @author Daryan Avi
 *
 */
public class Teste extends I2
{
	public String a()
	{
		return "asda";
	}
	
	public static void main(String[] args)
	{
		I2 a = new Teste();
		
		System.out.println(a.a());
	}
}
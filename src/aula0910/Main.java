/**
 * 15 de set de 2019
 */
package aula0910;

/**
 * @author Daryan Avi
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		try
		{
			Extrator ex = new Extrator("40800");
			
			System.out.println(ex.uri());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
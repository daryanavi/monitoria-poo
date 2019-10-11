/**
 * 29 de set de 2019
 */
package aula0926.ex12;

import java.util.Date;

/**
 * @author Daryan Avi
 *
 */
public abstract class Operacao
{
	protected Date dtInicio, dtFim;

	@Override
	public String toString()
	{
		return "Operacao [dtInicio=" + dtInicio + ", dtFim=" + dtFim + "]";
	}
}
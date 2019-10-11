/**
 * 10 de out de 2019
 */
package aula1003.prova.v1;

import java.util.Date;

/**
 * @author Daryan Avi
 *
 */
public class Jurado extends Pessoa
{
	private Date dataCadastro;
	
	public Jurado(String nome, Date dataCadastro)
	{
		super(nome);
		
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() 
	{
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) 
	{
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString()
	{
		return "Jurado [dataCadastro=" + dataCadastro + "]";
	}
}
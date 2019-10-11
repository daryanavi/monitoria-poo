/**
 * 10 de out de 2019
 */
package aula1003.prova.v1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Daryan Avi
 *
 */
public class Apresentacao
{
	private float[] saltos;
	private Atleta atleta;
	private Jurado[] jurados;
	
	public Apresentacao(float[] saltos, Atleta atleta, Jurado[] jurados) 
	{
		this.saltos = saltos;
		this.atleta = atleta;
		this.jurados = jurados;
	}
	
	public float[] getSaltos() 
	{
		return saltos;
	}
	
	public void setSaltos(float[] saltos) 
	{
		this.saltos = saltos;
	}
	
	public Atleta getAtleta() 
	{
		return atleta;
	}
	
	public void setAtleta(Atleta atleta) 
	{
		this.atleta = atleta;
	}
	
	public Jurado[] getJurados() 
	{
		return jurados;
	}
	
	public void setJurados(Jurado[] jurados) 
	{
		this.jurados = jurados;
	}
	
	public float mediaSimples()
	{
		float soma = 0f;
		
		for (float s : saltos)
			soma += s;
		
		return soma / saltos.length;
	}
	
	public float mediaFinal()
	{
		float soma = 0f;
		float maiorNota = 0f, menorNota = 0f;
		
		for (int i = 0; i < saltos.length; i ++)
		{
			if (i == 0)
			{
				maiorNota = saltos[i];
				menorNota = saltos[i];
			}
			else if (saltos[i] > maiorNota)
			{
				maiorNota = saltos[i];
			}
			else if (saltos[i] < menorNota)
			{
				menorNota = saltos[i];
			}
			
			soma += saltos[i];
		}
		
		return (soma - maiorNota - menorNota) / (saltos.length - 2);
	}
	
	public String nomeJurados()
	{
		ArrayList<String> nomes = new ArrayList<>();
		
		for (Jurado j : jurados)
			nomes.add(j.getNome());
		
		return String.join(", ", nomes);
	}
	
	public int ranking()
	{
		return atleta.getRanking();
	}
	
	public Jurado maisAntigo()
	{
		Jurado maisAntigo = null;
		
		for (Jurado j : jurados)
		{
			if (maisAntigo == null || j.getDataCadastro().before(maisAntigo.getDataCadastro()))
				maisAntigo = j;
		}
		
		return maisAntigo;
	}

	@Override
	public String toString()
	{
		return "Apresentacao [saltos=" + Arrays.toString(saltos) + ", atleta=" + atleta + ", jurados="
				+ Arrays.toString(jurados) + "]";
	}
}
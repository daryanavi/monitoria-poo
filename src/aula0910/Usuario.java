/**
 * 15 de set de 2019
 */
package aula0910;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * @author Daryan Avi
 *
 */
public class Usuario
{
	public int posicao, resolvidos, tentados, envios;
	public String nome, pais, universidade;
	public Date dataEntrada;
	public double pontos;
	
	public int getPosicao()
	{
		return posicao;
	}
	
	public void setPosicao(int posicao)
	{
		this.posicao = posicao;
	}
	
	public int getResolvidos()
	{
		return resolvidos;
	}
	
	public void setResolvidos(int resolvidos)
	{
		this.resolvidos = resolvidos;
	}
	
	public int getTentados()
	{
		return tentados;
	}
	
	public void setTentados(int tentados)
	{
		this.tentados = tentados;
	}
	
	public int getEnvios()
	{
		return envios;
	}
	
	public void setEnvios(int envios)
	{
		this.envios = envios;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getPais()
	{
		return pais;
	}
	
	public void setPais(String pais)
	{
		this.pais = pais;
	}
	
	public String getUniversidade()
	{
		return universidade;
	}
	
	public void setUniversidade(String universidade)
	{
		this.universidade = universidade;
	}
	
	public Date getDataEntrada()
	{
		return dataEntrada;
	}
	
	public void setDataEntrada(Date dataEntrada)
	{
		this.dataEntrada = dataEntrada;
	}
	
	public double getPontos()
	{
		return pontos;
	}
	
	public void setPontos(double pontos)
	{
		this.pontos = pontos;
	}

	@Override
	public String toString()
	{
		Vector<String> dadosUsuario = new Vector<>();
			
		dadosUsuario.add("*** DADOS DO USUÁRIO ***");
		dadosUsuario.add("Nome: " + nome);
		dadosUsuario.add("Posição: " + posicao + "º");
		dadosUsuario.add("País: " + pais);
		dadosUsuario.add("Universidade: " + universidade);
		dadosUsuario.add("Data de Entrada: " + new SimpleDateFormat("dd/MM/yyyy").format(dataEntrada));
		dadosUsuario.add("Pontos: " + pontos);
		dadosUsuario.add("Resolvidos: " + resolvidos);
		dadosUsuario.add("Tentados: " + tentados);
		dadosUsuario.add("Envios: " + envios);
		
		return String.join("\r\n", dadosUsuario);
	}
}
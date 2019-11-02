/**
 * 18 de out de 2019
 */
package aula1017;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Daryan Avi
 *
 */
public class Agenda
{
	private List<Pessoa> pessoas;
	
	public Agenda()
	{
		pessoas = new ArrayList<>();
	}
	
	public Agenda(List<Pessoa> pessoas)
	{
		this.pessoas = pessoas;
	}
	
	public void addPessoa(Pessoa pessoa)
	{
		pessoas.add(pessoa);
	}
	
	public List<Pessoa> getPessoas()
	{
		return pessoas;
	}
	
	public void alterarCodigoPessoa(int codigo, int novoCodigo)
	{
		Pessoa p = getPessoaCodigo(codigo);
		
		if (p != null)
			p.setCodigo(novoCodigo);
	}
	
	public void alterarNomePessoa(int codigo, String novoNome)
	{
		Pessoa p = getPessoaCodigo(codigo);
		
		if (p != null)
			p.setNome(novoNome);
	}
	
	public void alterarEmailPessoa(int codigo, String novoEmail)
	{
		Pessoa p = getPessoaCodigo(codigo);
		
		if (p != null)
			p.setEmail(novoEmail);
	}
	
	public void alterarFonePessoa(int codigo, String novoFone)
	{
		Pessoa p = getPessoaCodigo(codigo);
		
		if (p != null)
			p.setFone(novoFone);
	}
	
	public void alterarDataNascimentoPessoa(int codigo, Date novaData)
	{
		Pessoa p = getPessoaCodigo(codigo);
		
		if (p != null)
			p.setDataNascimento(novaData);
	}
	
	public void excluirPessoa(int codigo)
	{
		Pessoa p = getPessoaCodigo(codigo);
		
		if (p != null)
			pessoas.remove(p);
	}
	
	public List<Pessoa> buscarPorNome(String nome)
	{
		List<Pessoa> retorno = new ArrayList<>(); 
		
		for (Pessoa p : pessoas)
		{
			if (p.getNome().contains(nome))
				retorno.add(p);
		}
		
		return retorno;
	}
	
	public List<Pessoa> buscarPorMesAniversario(int mes)
	{
		List<Pessoa> retorno = new ArrayList<>(); 
		
		Calendar cal = Calendar.getInstance();
		
		for (Pessoa p : pessoas)
		{
			cal.setTime(p.getDataNascimento());
			
			if (cal.get(Calendar.MONTH) == mes - 1)
				retorno.add(p);
		}
		
		return retorno;
	}
	
	public List<Pessoa> buscarPorDominioEmail(String dominio)
	{
		List<Pessoa> retorno = new ArrayList<>(); 
		
		for (Pessoa p : pessoas)
		{
			if (p.getEmail().split("@")[1].equals(dominio))
				retorno.add(p);
		}
		
		return retorno;
	}
	
	public boolean isCodigoExiste(int codigo)
	{
		for (Pessoa p : pessoas)
		{
			if (p.getCodigo() == codigo)
				return true;
		}
		
		return false;
	}
	
	private Pessoa getPessoaCodigo(int codigo)
	{
		for (Pessoa p : pessoas)
		{
			if (p.getCodigo() == codigo)
				return p;
		}
		
		return null;
	}
}
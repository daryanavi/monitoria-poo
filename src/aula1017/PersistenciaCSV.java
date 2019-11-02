/**
 * 18 de out de 2019
 */
package aula1017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daryan Avi
 *
 */
public class PersistenciaCSV implements Persistencia
{
	private final int POS_CODIGO = 0;
	private final int POS_NOME = 1;
	private final int POS_EMAIL = 2;
	private final int POS_FONE = 3;
	private final int POS_DATA_NASCIMENTO = 4;
	
	@Override
	public void gravar(String caminho, List<Pessoa> listaPessoas) throws IOException
	{
		FileWriter writer = null;
		
		try
		{
			writer = new FileWriter(caminho);
			
			for (Pessoa p : listaPessoas)
			{
				String[] info = new String[5];
				
				info[POS_CODIGO] = Integer.toString(p.getCodigo());
				info[POS_NOME] = p.getNome();
				info[POS_EMAIL] = p.getEmail();
				info[POS_FONE] = p.getFone();
				info[POS_DATA_NASCIMENTO] = Util.dateToString(p.getDataNascimento());
				
				writer.write(String.join(";", info) + "\n");
			}
		}
		finally
		{
			if (writer != null)
			{
				writer.close();
				writer = null;
			}
		}
	}

	@Override
	public List<Pessoa> ler(String caminho) throws IOException, ParseException
	{
		BufferedReader reader = null;
		
		try
		{
			List<Pessoa> pessoas = new ArrayList<>();
			
			File arquivo = new File(caminho);
			
			if (arquivo.exists())
			{
				reader = new BufferedReader(new FileReader(arquivo));
				
				String linha;
				
				while ((linha = reader.readLine()) != null)
				{
					if (linha.isEmpty())
						continue;
					
					String[] info = linha.split(";");
					
					Pessoa p = new Pessoa();
					
					p.setCodigo(Integer.parseInt(info[POS_CODIGO]));
					p.setNome(info[POS_NOME]);
					p.setEmail(info[POS_EMAIL]);
					p.setFone(info[POS_FONE]);
					p.setDataNascimento(Util.stringToDate(info[POS_DATA_NASCIMENTO]));
					
					pessoas.add(p);
				}
			}
			
			return pessoas;
		}
		finally
		{
			if (reader != null)
			{
				reader.close();
				reader = null;
			}
		}
	}
}
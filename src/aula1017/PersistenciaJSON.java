/**
 * 22 de out de 2019
 */
package aula1017;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Daryan Avi
 *
 */
public class PersistenciaJSON implements Persistencia
{
	@Override
	public void gravar(String caminho, List<Pessoa> listaPessoas) throws IOException
	{
		FileWriter writer = null;
		
		try
		{
			writer = new FileWriter(caminho);
			
			Gson gson = new Gson();
			
			gson.toJson(listaPessoas, writer);
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
		FileReader reader = null;
		
		try
		{
			List<Pessoa> pessoas = new ArrayList<>();
			
			File arquivo = new File(caminho);
			
			if (arquivo.exists())
			{
				reader = new FileReader(arquivo);
				
				Gson gson = new Gson();
				
				pessoas = gson.fromJson(reader, new TypeToken<List<Pessoa>>(){}.getType());
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
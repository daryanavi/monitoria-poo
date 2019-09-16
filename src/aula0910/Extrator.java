/**
 * 15 de set de 2019
 */
package aula0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author Daryan Avi
 *
 */
public class Extrator
{
	private Usuario uri;
	
	public Extrator(String url) throws MalformedURLException, IOException, ParseException
	{
		URLConnection conn = null;
		BufferedReader reader = null;
		
		try
		{
			uri = new Usuario();
			
			conn = new URL("https://www.urionlinejudge.com.br/judge/en/profile/" + url).openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.connect();
			
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String s = null;
			
			while ((s = reader.readLine()) != null)
			{
				s = s.trim();
				
				if (s.equals("<p itemprop=\"name\">"))
				{
					uri.setNome(reader.readLine().split("</a>")[0].trim().split("\">")[1]);
				}
				else if (s.equals("<span>Place:</span>"))
				{
					uri.setPosicao(Integer.parseInt(reader.readLine().split("&ordm;")[0].trim().replaceAll(",", "")));
				}
				else if (s.equals("<span>Country:</span>"))
				{
					String a = reader.readLine().split("</a>")[0].trim();
					
					uri.setPais(a.substring(a.length() - 2));
				}
				else if (s.equals("<span>University:</span>"))
				{
					uri.setUniversidade(reader.readLine().split("</i>")[0].split("itemprop='name'>")[1]);
				}
				else if (s.equals("<span>Since:</span>"))
				{
					uri.setDataEntrada(new SimpleDateFormat("MM/dd/yy").parse(reader.readLine().split("</li>")[0].trim()));
				}
				else if (s.equals("<span>Points:</span>"))
				{
					uri.setPontos(Double.parseDouble(reader.readLine().split("</li>")[0].trim().replaceAll(",", "")));
				}
				else if (s.equals("<span>Solved:</span>"))
				{
					uri.setResolvidos(Integer.parseInt(reader.readLine().split("</li>")[0].trim().replaceAll(",", "")));
				}
				else if (s.equals("<span>Tried:</span>"))
				{
					uri.setTentados(Integer.parseInt(reader.readLine().split("</li>")[0].trim().replaceAll(",", "")));
				}
				else if (s.equals("<span>Submissions:</span>"))
				{
					uri.setEnvios(Integer.parseInt(reader.readLine().split("</li>")[0].trim().replaceAll(",", "")));
					
					break;
				}
			}
		}
		finally
		{
			if (conn != null)
				conn.getInputStream().close();
			
			if (reader != null)
				reader.close();
		}
	}
	
	public Usuario uri()
	{
		return uri;
	}
}
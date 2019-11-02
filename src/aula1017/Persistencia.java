/**
 * 18 de out de 2019
 */
package aula1017;

import java.util.List;

/**
 * @author Daryan Avi
 *
 */
public interface Persistencia
{
	public void gravar(String caminho, List<Pessoa> listaPessoas) throws Exception;
	
	public List<Pessoa> ler(String caminho) throws Exception;
}
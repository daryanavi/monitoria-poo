/**
 * 18 de out de 2019
 */
package aula1017;

/**
 * @author Daryan Avi
 *
 */
public enum TiposArquivo
{
	CSV("arquivos/agenda.csv", new PersistenciaCSV()),
	JSON("arquivos/agenda.json", new PersistenciaJSON()),
	XML("arquivos/agenda.xml", new PersistenciaXML());
	
	private String caminho;
	private Persistencia persistencia;
	
	private TiposArquivo(String caminho, Persistencia persistencia)
	{
		this.caminho = caminho;
		this.persistencia = persistencia;
	}

	public String getCaminho()
	{
		return caminho;
	}

	public Persistencia getPersistencia()
	{
		return persistencia;
	}
}
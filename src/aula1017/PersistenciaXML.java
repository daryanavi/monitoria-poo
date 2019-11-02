/**
 * 18 de out de 2019
 */
package aula1017;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Daryan Avi
 *
 */
public class PersistenciaXML implements Persistencia
{
	@Override
	public void gravar(String caminho, List<Pessoa> listaPessoas) throws IOException, ParserConfigurationException, TransformerException
	{
		FileWriter writer = null;
		
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element agenda = document.createElement("agenda");
            document.appendChild(agenda);
			
            for (Pessoa p : listaPessoas)
            {
                Element pessoa = document.createElement("pessoa");
                agenda.appendChild(pessoa);
                
                Attr codigo = document.createAttribute("codigo");
                codigo.setValue(Integer.toString(p.getCodigo()));
                pessoa.setAttributeNode(codigo);
                
                Attr nome = document.createAttribute("nome");
                nome.setValue(p.getNome());
                pessoa.setAttributeNode(nome);
                
                Attr email = document.createAttribute("email");
                email.setValue(p.getEmail());
                pessoa.setAttributeNode(email);
                
                Attr fone = document.createAttribute("fone");
                fone.setValue(p.getFone());
                pessoa.setAttributeNode(fone);
                
                Attr dataNascimento = document.createAttribute("data_nascimento");
                dataNascimento.setValue(Util.dateToString(p.getDataNascimento()));
                pessoa.setAttributeNode(dataNascimento);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(caminho));
 
            transformer.transform(domSource, streamResult);
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
	public List<Pessoa> ler(String caminho) throws IOException, ParseException, ParserConfigurationException, SAXException
	{
		List<Pessoa> pessoas = new ArrayList<>();
		
		File arquivo = new File(caminho);
		
		if (arquivo.exists())
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(arquivo);
			
			Element agenda = document.getDocumentElement();
			
			NodeList nList = agenda.getElementsByTagName("pessoa");
			
			for (int i = 0; i < nList.getLength(); i ++)
			{
				Element element = (Element)nList.item(i);
				
				pessoas.add(new Pessoa(Integer.parseInt(element.getAttribute("codigo")), 
						element.getAttribute("nome"), 
						element.getAttribute("email"), 
						element.getAttribute("fone"), 
						Util.stringToDate(element.getAttribute("data_nascimento"))));
			}
		}
		
		return pessoas;
	}
}
/**
 * 18 de out de 2019
 */
package aula1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Daryan Avi
 *
 */
public class Main
{
	public static void main(String[] args) throws Exception
	{
		final TiposArquivo tipo = TiposArquivo.JSON;
		
		String caminho = tipo.getCaminho();
		Persistencia p = tipo.getPersistencia();
		
		Agenda agenda;
		
		try
		{
			agenda = new Agenda(p.ler(caminho));
		}
		catch (Exception e)
		{
			System.err.println("Ocorreu um erro ao buscar arquivo gravado!");
			
			agenda = new Agenda();
		}
		
		System.out.println("*** AGENDA ***");
		
		boolean continuar = true;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Deseja importar dados? (1 - Sim, OUTRO - Não)");
		
		String op = scanner.next();
		
		if ("1".equals(op))
			importarDados(100, agenda.getPessoas());
		
		while (continuar)
		{
			System.out.println();
			System.out.println("1 - Incluir");
			System.out.println("2 - Alterar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Buscar por nome");
			System.out.println("5 - Buscar por mês de aniversário");
			System.out.println("6 - Buscar por domínio de e-Mail");
			System.out.println("OUTRO - Sair");
			System.out.println();
			
			try
			{
				scanner = new Scanner(System.in);
				
				System.out.print("Opção: ");
				
				int opcao = scanner.nextInt();
				
				System.out.println();
				
				switch (opcao)
				{
					case 1 :
					{
						Pessoa pessoa = new Pessoa();
						
						boolean codigoRepetido = true;
						
						while (codigoRepetido)
						{
							System.out.print("Código: ");
							
							int codigo = scanner.nextInt();
							
							codigoRepetido = agenda.isCodigoExiste(codigo);
							
							if (codigoRepetido)
							{
								System.err.println("Código já cadastrado!");
								
								Thread.sleep(1000);
							}
							else
							{
								pessoa.setCodigo(codigo);
							}
						}
						
						System.out.print("Nome: ");
						
						pessoa.setNome(scanner.next());
						
						boolean emailInvalido = true;
						
						while (emailInvalido)
						{
							System.out.print("E-Mail: ");
							
							String email = scanner.next();
							
							emailInvalido = ! email.contains("@");
							
							if (emailInvalido)
							{
								System.err.println("E-Mail inválido!");
								
								Thread.sleep(1000);
							}
							else
							{
								pessoa.setEmail(email);
							}
						}
						
						boolean foneInvalido = true;
						
						while (foneInvalido)
						{
							System.out.print("Fone (11 dígitos): ");
							
							String fone = scanner.next();
							
							foneInvalido = fone.length() != 11;
							
							if (! foneInvalido)
							{
								try
								{
									Long.parseLong(fone);
								}
								catch (NumberFormatException e)
								{
									foneInvalido = true;
								}
							}
							
							if (foneInvalido)
							{
								System.err.println("Fone inválido!");
								
								Thread.sleep(1000);
							}
							else
							{
								pessoa.setFone(fone);
							}
						}
						
						System.out.print("Data de Nascimento (XX/XX/XXXX): ");
						
						pessoa.setDataNascimento(Util.stringToDate(scanner.next()));
						
						agenda.addPessoa(pessoa);
						
						System.out.println();
						System.out.println("* Cadastro realizado com sucesso! *");
						
						Thread.sleep(1000);
						
						break;
					}
					
					case 2 :
					{
						System.out.println("Código da pessoa a ser alterada: ");
						
						int codigoAlterar = scanner.nextInt();
						
						System.out.println();
						
						if (agenda.isCodigoExiste(codigoAlterar))
						{
							System.out.println("Informação a ser alterada: ");
							System.out.println("1 - Código");
							System.out.println("2 - Nome");
							System.out.println("3 - E-Mail");
							System.out.println("4 - Fone");
							System.out.println("5 - Data de Nascimento");
							System.out.println("OUTRO - Voltar");
							
							System.out.println();
							
							int opcaoAlterar = scanner.nextInt();
							
							if (opcaoAlterar >= 1 && opcaoAlterar <= 5)
							{
								System.out.print("Novo valor: ");
							}
							
							switch (opcaoAlterar)
							{
								case 1 :
								{
									boolean codigoRepetido = true;
									
									while (codigoRepetido)
									{
										int codigo = scanner.nextInt();
										
										codigoRepetido = codigo != codigoAlterar && agenda.isCodigoExiste(codigo);
										
										if (codigoRepetido)
										{
											System.err.println("Código já cadastrado!");
											
											Thread.sleep(1000);
										}
										else
										{
											agenda.alterarCodigoPessoa(codigoAlterar, codigo);
										}
									}
									
									System.out.println();
									System.out.println("* Alteração realizada com sucesso! *");
									
									Thread.sleep(1000);
									
									break;
								}
								
								case 2 :
								{
									agenda.alterarNomePessoa(codigoAlterar, scanner.next());
									
									System.out.println();
									System.out.println("* Alteração realizada com sucesso! *");
									
									Thread.sleep(1000);
									
									break;
								}
								
								case 3 :
								{
									boolean emailInvalido = true;
									
									while (emailInvalido)
									{
										String email = scanner.next();
										
										emailInvalido = ! email.contains("@");
										
										if (emailInvalido)
										{
											System.err.println("E-Mail inválido!");
											
											Thread.sleep(1000);
										}
										else
										{
											agenda.alterarEmailPessoa(codigoAlterar, email);
										}
									}
									
									System.out.println();
									System.out.println("* Alteração realizada com sucesso! *");
									
									Thread.sleep(1000);
									
									break;
								}
								
								case 4 :
								{
									boolean foneInvalido = true;
									
									while (foneInvalido)
									{
										String fone = scanner.next();
										
										foneInvalido = fone.length() != 11;
										
										if (! foneInvalido)
										{
											try
											{
												Long.parseLong(fone);
											}
											catch (NumberFormatException e)
											{
												foneInvalido = true;
											}
										}
										
										if (foneInvalido)
										{
											System.err.println("Fone inválido!");
											
											Thread.sleep(1000);
										}
										else
										{
											agenda.alterarFonePessoa(codigoAlterar, fone);
										}
									}
									
									System.out.println();
									System.out.println("* Alteração realizada com sucesso! *");
									
									Thread.sleep(1000);
									
									break;
								}
								
								case 5 :
								{
									agenda.alterarDataNascimentoPessoa(codigoAlterar, Util.stringToDate(scanner.next()));
									
									System.out.println();
									System.out.println("* Alteração realizada com sucesso! *");
									
									Thread.sleep(1000);
									
									break;
								}
								
								default :
								{
									break;
								}
							}
						}
						else
						{
							System.err.println("Não há nenhuma pessoa relacionada a este código!");
							
							Thread.sleep(1000);
						}
						
						break;
					}
					
					case 3 :
					{
						System.out.println("Código da pessoa a ser excluída:");
						
						int codigoExcluir = scanner.nextInt();
						
						System.out.println();
						
						if (agenda.isCodigoExiste(codigoExcluir))
						{
							agenda.excluirPessoa(codigoExcluir);
							
							System.out.println();
							System.out.println("* Exclusão realizada com sucesso! *");
							
							Thread.sleep(1000);
						}
						else
						{
							System.err.println("Não há nenhuma pessoa relacionada a este código!");
							
							Thread.sleep(1000);
						}
						
						break;
					}
					
					case 4 :
					{
						System.out.print("Nome: ");
						
						String nome = scanner.next();
						
						System.out.println();
						
						List<Pessoa> pessoas = agenda.buscarPorNome(nome);
						
						if (! pessoas.isEmpty())
						{
							for (Pessoa pessoa : pessoas)
								System.out.println(pessoa.getNome());
						}
						else
						{
							System.err.println("Não foram encontrados resultados para este nome!");
							
							Thread.sleep(1000);
						}
						
						break;
					}
					
					case 5 :
					{
						System.out.print("Mês: ");
						
						int mes = scanner.nextInt();
						
						System.out.println();
						
						List<Pessoa> pessoas = agenda.buscarPorMesAniversario(mes);
						
						if (! pessoas.isEmpty())
						{
							for (Pessoa pessoa : pessoas)
								System.out.println(pessoa.getNome());
						}
						else
						{
							System.err.println("Não foram encontrados resultados para este mês!");
							
							Thread.sleep(1000);
						}
						
						break;
					}
					
					case 6 :
					{
						System.out.print("Domínio: ");
						
						String dominio = scanner.next();
						
						System.out.println();
						
						List<Pessoa> pessoas = agenda.buscarPorDominioEmail(dominio);
						
						if (! pessoas.isEmpty())
						{
							for (Pessoa pessoa : pessoas)
								System.out.println(pessoa.getNome());
						}
						else
						{
							System.err.println("Não foram encontrados resultados para este domínio!");
							
							Thread.sleep(1000);
						}
						
						break;
					}
					
					default :
					{
						continuar = false;
						
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("Informação inserida de forma incorreta!");
				
				Thread.sleep(1000);
			}
			finally
			{
				scanner.reset();
			}
		}
		
		scanner.close();
		
		try
		{
			p.gravar(caminho, agenda.getPessoas());
		}
		catch (Exception e)
		{
			System.err.println("Ocorreu um erro ao gravar arquivo!");
		}
		
		System.exit(0);
	}
	
	private static void importarDados(int total, List<Pessoa> pessoas) throws IOException, ParseException
	{
		URLConnection conn = new URL("http://www.curvello.com/gerador/pessoa/" + total).openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		conn.connect();
		
		BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		
		String conteudo = "", s;
		
		while ((s = read.readLine()) != null)
			conteudo += s;
		
		Gson gson = new Gson();
		
		List<Object> pessoasObj = new ArrayList<>();
		
		pessoasObj = gson.fromJson(conteudo, new TypeToken<List<Object>>(){}.getType());
		
		for (Object o : pessoasObj)
		{
			Pessoa p = new Pessoa();
			
			String str = o.toString().substring(1).substring(0, o.toString().length() - 2);
			
			String[] split = str.split(", ");
			
			String codigo = split[0];
			
			p.setCodigo((int)Double.parseDouble(codigo.split("codigo=")[1]));
			
			String nome = split[1];
			
			p.setNome(nome.split("nome=")[1]);
			
			String email = split[2];
			
			p.setEmail(email.split("email=")[1]);
			
			String fone = split[3];	
			
			p.setFone(fone.split("fone=")[1]);
			
			String data = split[4];
			
			p.setDataNascimento(Util.stringToDate(data.split("dataNascimento=")[1]));
			
			pessoas.add(p);
		}
	}
}
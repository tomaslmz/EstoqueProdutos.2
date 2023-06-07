import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
	//Declaração do scanner
	public static Scanner ler = new Scanner(System.in);
	//Declaração de listas
	public static ArrayList<ProdutoAlimenticio> produtosAli = new ArrayList<ProdutoAlimenticio>();
	public static ArrayList<ProdutoVestuario> produtosVest = new ArrayList<ProdutoVestuario>();
	public static ArrayList<ProdutoEletronico> produtosEle = new ArrayList<ProdutoEletronico>();
	
	public static void registrarProduto(int tipo) {
		int escolher;
		int codigo;
		String nome;
		float preco;
		
		String marca;
		
		String validade;
		
		System.out.println("Iniciando o registro do produto...\n");
		
			do {
				System.out.print("\nDigite o código do produto: ");
				codigo = ler.nextInt();
			} while(codigo < 0);
			
			ler.nextLine();
			
			do {
				System.out.print("\nDigite o nome do produto: ");
				nome = ler.nextLine();
			} while(nome.isEmpty());
			
			do {
				System.out.print("\nDigite o preço do código: ");
				preco = ler.nextFloat();
			} while(preco < 0);
			
			ler.nextLine();
			
			switch(tipo) {
				case 1:
					do {
						System.out.print("\nDigite a marca do produto: ");
						marca = ler.nextLine();
					} while(marca.isEmpty());
					
					ProdutoEletronico produtoEle = new ProdutoEletronico(codigo, nome, preco, marca);
					
					produtosEle.add(produtoEle);
				break;
				case 2:
					do {
						System.out.print("\nDigite a data de validade do produto (dd/mm/yyyy): ");
						validade = ler.nextLine();
					} while(validade.isEmpty());
					
					ProdutoAlimenticio produtoAli = new ProdutoAlimenticio(codigo, nome, preco, validade);
					
					produtosAli.add(produtoAli);
				break;
				case 3:
					do {
						System.out.print("\nDigite o tamanho do produto:\n1) P	2) M	3) G	4) GG");
						escolher = ler.nextInt();
					} while(escolher < 1 || escolher > 4);
					
					Tamanhos tamanho = Tamanhos.N;
					
					switch(escolher) {
						case 1:
							tamanho = Tamanhos.P;
						break;
						case 2:
							tamanho = Tamanhos.M;
						break;
						case 3:
							tamanho = Tamanhos.G;
						break;
						case 4:
							tamanho = Tamanhos.GG;
						break;
					}
					
					ProdutoVestuario produtoVest = new ProdutoVestuario(codigo, nome, preco, tamanho);
					
					
				break;
			}
	}
	
	public static void escolherTipo() {
		int escolher;
		
		ler.nextLine();
		
		System.out.println("Selecione um dos tipos de produtos para registrar:"
				+ "\n1) Produto eletrônico	2) Produto alimentício	3) Produto vestuario	4) Sair");
		
		do {
			System.out.print("Resposta: ");
			escolher = ler.nextInt();
			
			switch(escolher) {
				case 1:
					registrarProduto(1);
				break;
				case 2:
					registrarProduto(2);
				break;
				case 3:
					registrarProduto(3);
				break;
				case 4:
					registrarProduto(4);
				break;
				default:
					System.out.println("\nResposta inválida!\n");
				break;
			}
		} while(escolher < 1 || escolher > 4);
	}
	
	public static void visualizar(int tipo) {
		switch(tipo) {
			case 1:
				for(ProdutoEletronico pe : produtosEle) {
					System.out.println("----------\nCódigo: " + pe.getCodigo() + "\nNome: " + pe.getNome() + "\nPreço: " + pe.getPreco() + "\nMarca: " + pe.getMarca() + "\n----------");
				}
			break;
			case 2:
				for(ProdutoAlimenticio pa : produtosAli) {
					System.out.println("----------\nCódigo: " + pa.getCodigo() + "\nNome: " + pa.getNome() + "\nPreço: " + pa.getPreco() + "\nData de validade: " + pa.getDataValidade() + "\n----------");
				}
			break;
			case 3:
				for(ProdutoVestuario pv : produtosVest) {
					System.out.println("----------\nCódigo: " + pv.getCodigo() + "\nNome: " + pv.getNome() + "\nPreço: " + pv.getPreco() + "\nTamanho: " + pv.getTamanho() + "\n----------");
				}
			break;
		}
		
		System.out.println("Pressione ENTER para continuar");
		ler.nextLine();
	}
	
	public static void remover() {
		int escolha;
		int tipo;
		int escolha2;
		
		System.out.println("Escolha uma dessa funções:\n1) Apagar com um código específico	2) Apagar todo o estoque	3) Sair");
		
		do {
			System.out.print("Resposta: ");
			escolha = ler.nextInt();
			
			switch(escolha) {
				case 1:
					do {
						System.out.println("Selecione um dos tipos de produtos para registrar:"
								+ "\n1) Produto eletrônico	2) Produto alimentício	3) Produto vestuario");
						tipo = ler.nextInt();
					} while(tipo < 1 || tipo > 3);
					
					switch(tipo) {
						case 1:
							do {
								System.out.println("Digite o código do produto que deseja remover:");
								escolha2 = ler.nextInt();
								if(escolha > produtosEle.size()) {
									System.out.println("O valor inserido é maior que o número de registros\n");
								}
							} while(escolha2 < -1 || escolha > produtosEle.size());
							
							produtosEle.remove(escolha2);
						break;
						case 2:
							do {
								System.out.println("Digite o código do produto que deseja remover:");
								escolha2 = ler.nextInt();
								if(escolha > produtosAli.size()) {
									System.out.println("O valor inserido é maior que o número de registros\n");
								}
							} while(escolha2 < -1 || escolha > produtosAli.size());
							
							produtosAli.remove(escolha2);
						break;
						case 3:
							do {
								System.out.println("Digite o código do produto que deseja remover:");
								escolha2 = ler.nextInt();
								
								if(escolha > produtosVest.size()) {
									System.out.println("O valor inserido é maior que o número de registros\n");
								}
							} while(escolha2 < -1 || escolha > produtosVest.size());
							
							produtosVest.remove(escolha2);
						break;
					}
					break;
				case 2:
					do {
						System.out.println("Selecione um dos tipos de produtos para registrar:"
								+ "\n1) Produto eletrônico	2) Produto alimentício	3) Produto vestuario");
						tipo = ler.nextInt();
					} while(tipo < 1 || tipo > 3);
					
					switch(tipo) {
						case 1:
							produtosEle.clear();
						break;
						case 2:
							produtosAli.clear();
						break;
						case 3:
							produtosVest.clear();
						break;
					}
			}
		} while(escolha < 1 || escolha > 3);
		
		
	}
	
	public static void pesquisar() {
		int escolha;
		String nome;
		
		System.out.println("Escolha o tipo de produtos que deseja visualizar:\n1) Eletrônico	2) Alimentício	3) Vestuario	4) Sair");
		do {
			System.out.print("\nResposta: ");
			escolha = ler.nextInt();
		} while(escolha < 1 || escolha > 4);
		
		ler.nextLine();
		
		if(escolha != 4) {
			do {
				System.out.print("\nDigite o nome que deseja procurar: ");
				nome = ler.nextLine();
			} while(nome.isEmpty());
			
			System.out.print("\n----------");
			switch(escolha) {
				case 1:
					for(ProdutoEletronico pe : produtosEle) {
						if(pe.getNome().equals(nome)) {
							System.out.println("O código deste produto eletrônico é: " + pe.getCodigo());
							break;
						}
					}
				break;
				case 2:
					for(ProdutoAlimenticio pa : produtosAli) {
						if(pa.getNome().equals(nome)) {
							System.out.println("O código deste produto alimentício é: " + pa.getCodigo());
							break;
						}
					}
				break;
				case 3:
					for(ProdutoVestuario pv : produtosVest) {
						if(pv.getNome().equals(nome)) {
							System.out.println("O código deste produto vestuario é: " + pv.getCodigo());
							break;
						}
					}
				break;
			}
			System.out.print("\n----------");
		}
	}
	
	public static void menuGerenciamento() {
		int escolha;
		
		System.out.println("Escolha a função que deseja usar:\n1) Visualizar	2) Remover	3) Pesquisar	4) Sair");
		do {
			System.out.print("\nResposta: ");
			escolha = ler.nextInt();
			
			switch(escolha) {
				case 1:
					System.out.println("Escolha o tipo de produtos que deseja visualizar:\n1) Eletrônico	2) Alimentício	3) Vestuario	4) Sair");
					do {
						System.out.print("\nResposta: ");
						escolha = ler.nextInt();
					} while(escolha < 1 || escolha > 4);
					
					if(escolha != 4) {
						visualizar(escolha);
					}
					
				break;
				case 2:
					remover();
				break;
				case 3:
					pesquisar();
				break;
				case 4:
					//Sair
				break;
			}
		} while(escolha < 0 || escolha > 4);
	}
	
	public static void main(String[] args) {
		int escolha;
		
		
		
		do {
			System.out.println("Olá! Seja bem-vindo ao sistema de escolherTipo de produtos!\nEscolha uma dessas opções:"
					+ "\n1) Registrar produtos	2) Gerenciar registros produtos	3) Sair");
			
			System.out.print("Resposta: ");
			escolha = ler.nextInt();
			
			switch(escolha) {
				case 1:
					escolherTipo();
				break;
				case 2:
					menuGerenciamento();
				break;
				case 3:
					//Saindo
				break;
				default:
					System.out.println("\nResposta inválida!\n");
				break;
			}
		} while(escolha != 3);
	}
}
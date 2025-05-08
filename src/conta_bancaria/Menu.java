package conta_bancaria;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
import conta_bancaria.controller.ContaController;

public class Menu {
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		ContaController conta = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		double saldo, limite, valor;
		
		//dados de contas para testes
		ContaCorrente cc1 = new ContaCorrente(conta.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		conta.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(conta.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		conta.cadastrar(cp1);
		
		//While principal
		while(true) {
			//Menu de acesso 
			menuLogin();
			opcao = leia.nextInt(); 
			//Switch case do menu de acesso
			switch(opcao) {
			case 1:
				System.out.println("ACESSAR CONTA");
				System.out.println("Digite o numero da conta que deseja Acessar: ");
				numero = leia.nextInt();
				
				//Passa a conta escolhida no login para a OPTIONAL contaLogada
				Optional<Conta> contaLogada = conta.acessar(numero);
				keyPress();
				
				//Verifica se a contaLogada existe no array de contas
				if(contaLogada.isPresent()) {
					boolean controleWhileMenuPrincipal = true;
					int opcaoMenuPrincipal;
					//if == true, acessa os dasdos da conta escolhida no acesso
					while(controleWhileMenuPrincipal) {
						//Menu Principal
						menuPrincipal();
						opcaoMenuPrincipal = leia.nextInt();
						
						//Switch case do menu principal
						switch(opcaoMenuPrincipal) {
						//Depósito
						case 1:
							System.out.println("DEPÓSITO");
				            
				            System.out.print("Digite o valor do depósito: ");
				            saldo = leia.nextDouble();
				            
				            conta.depositar(numero, saldo);
				            
				            keyPress();
				            break;
						//Saque
						case 2:
							System.out.println("SAQUE");

				            System.out.print("Digite o valor do saque: ");
				            saldo = leia.nextDouble();
				            
				            conta.sacar(numero, saldo);
				            
				            keyPress();
				            break;
						//Transferência entre contas
						case 3:
							System.out.println("TRANSFERÊNCIA");		
							System.out.println("Digite o numero da conta de destino: ");
							numeroDestino = leia.nextInt();
							
							System.out.println("Digite o valor: ");
							valor = leia.nextDouble();
							

							conta.transferir(numero, numeroDestino, valor);
							keyPress();
							break;
						//Atualizar dados de uma conta
						case 4:
							System.out.println("Atualizar Dados");
							
							System.out.println("Digite o número da conta");
							numero = leia.nextInt();
							//Acessa a conta que sera atualizada
							Optional <Conta> buscarConta = conta.buscarNaCollection(numero);
							
							//Verifica se a conta existe no array
							if(buscarConta.isPresent()) {
								System.out.println("Digite o número da Agência:");
								agencia = leia.nextInt();

								System.out.println("Digite o nome do Titular:");
								leia.skip("\\R");
								titular = leia.nextLine();
								
								//O tipo é inalterável
								tipo = buscarConta.get().getTipo();
								
								System.out.println("Digite o saldo inicial da conta:");
								saldo = leia.nextFloat();
								
								//A partir do tipo, define se o limite ou o aniversário sera alterado
								switch(tipo) {
									//Conta Corrente
									case 1 ->{
										System.out.println("Digite o limite da conta: ");
										limite = leia.nextDouble();
										conta.cadastrar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
										}
									//Conta poupança
									case 2->{
										System.out.println("Digite o dia de aniversário da conta: ");
										aniversario = leia.nextInt();
										conta.cadastrar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
										}
									default->{
										System.out.println("Opção inválida. Tente novamente.");
										keyPress();
										break;
										}
								}
							//Caso a conta nao exista no array
							}else 
								System.out.printf("\n A conta %d não existe!", numero);
													
							keyPress();
							break;
						//Mostra os dados da conta logada
						case 5:
							contaLogada.get().vizualizar();

				            keyPress();
							break;
						//Listagem de contas
						case 6:
							boolean controleWhileListar = true;
							while(controleWhileListar) {
								menuListar();
								int opcaoMenuListar = leia.nextInt();
								switch(opcaoMenuListar) {
								
									//Lista contas sem filtro
									case 1:
										System.out.println("Listar Todas");
										conta.listarTodas();
						            
						            keyPress();
									break;
									//Lista contas pelo nome do titular
									case 2:
										System.out.println("Listar por titular");
										
										System.out.println("Digite o nome do titular");
										leia.skip("\\R");
										titular = leia.nextLine();
						             	
										conta.listarPorTitular(titular);		
						             
										keyPress();
										break;
									//Volta ao menu de acesso	
									case 0:
										System.out.println("VOLTANDO AO MENU ANTERIOR...");
						            	controleWhileListar = false;
						            
						            	keyPress();
						            	break;
									//Caso o usuário não digite uma opção válida no menu Principal
									default:
										System.out.println("Opção inválida. Tente novamente.");
										keyPress();
										break;
								}
							}   
							
						case 7:
				            System.out.println("VOLTANDO AO MENU ANTERIOR...");
				            controleWhileMenuPrincipal = false;
				            
				            keyPress();
							break;
							
						case 0:
				            System.out.println("SAINDO DO SISTEMA...");
				            sobre();
				            leia.close();
				            System.exit(0);
				            break;
				            
						default:
				            System.out.println("Opção inválida. Tente novamente.");
				            keyPress();
						}
						
					}
				}
						
				keyPress();
				break;
			
			case 2:
				System.out.println("CRIAR CONTA");
				
				System.out.println("Digite o numero da agencia: ");
				agencia = leia.nextInt();
				
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();
				
				System.out.println("Digite o tipo da conta (1 - CC | 2 - CP): ");
				tipo = leia.nextInt();
				
				System.out.println("Digite o saldo inicial da conta");
				saldo = leia.nextDouble();
				
				//Diferência o tipo de conta (Corrente ou Poupança)
				switch(tipo) {
				case 1 ->{
						System.out.println("Digite o limite da conta: ");
						limite = leia.nextDouble();
						conta.cadastrar(new ContaCorrente(conta.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
				case 2->{
						System.out.println("Digite o dia de aniversário da conta: ");
						aniversario = leia.nextInt();
						conta.cadastrar(new ContaPoupanca(conta.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				default->{
					System.out.println("Opção inválida. Tente novamente.");
					keyPress();
					break;
					}
				}
				keyPress();
				break;
				
			case 0:
				System.out.println("Fim da execução");
				sobre();
				leia.close();	
				return;
			
			default:
			    System.out.println("Opção inválida. Tente novamente.");
			    keyPress();
			    break;
			}
		}			    
	}
	
	public static void menuLogin() {
	    System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD);
	    System.out.println("╔═══════════════════════════════════════════╗");
	    System.out.println("║                                           ║");
	    System.out.println("║           Banco do Brasil com Z           ║");
	    System.out.println("║                                           ║");
	    System.out.println("║                                           ║");
	    
	    System.out.print(Cores.TEXT_YELLOW_BOLD);
	    System.out.println("║   ╔═══════════════════════════════════╗   ║");
	    System.out.println("║   ║                                   ║   ║");
	    System.out.println("║   ║   1 - Acessar conta               ║   ║");
	    System.out.println("║   ║   2 - Criar conta                 ║   ║");
	    System.out.println("║   ║   0 - Encerrar                    ║   ║");
	    System.out.println("║   ║                                   ║   ║");
	    System.out.println("║   ╚═══════════════════════════════════╝   ║");

	    System.out.print(Cores.TEXT_GREEN_BOLD);
	    System.out.println("║                                           ║");
	    System.out.println("╚═══════════════════════════════════════════╝");
	    System.out.print(Cores.TEXT_RESET + "Digite a opção desejada: ");
	}


	
	public static void menuPrincipal() {
	    System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD);
	    System.out.println("╔════════════════════════════════════════════════════════════════════╗");
	    System.out.println("║                                                                    ║");
	    System.out.println("║                      BANCO DO BRAZIL COM Z                         ║");
	    System.out.println("║                                                                    ║");

	    System.out.print(Cores.TEXT_YELLOW_BOLD);
	    System.out.println("║   ╔════════════════════════════════════════════════════════════╗   ║");
	    System.out.println("║   ║                                                            ║   ║");
	    System.out.println("║   ║   1 - Depositar                                            ║   ║");
	    System.out.println("║   ║   2 - Sacar                                                ║   ║");
	    System.out.println("║   ║   3 - Transferir valor entre contas                        ║   ║");
	    System.out.println("║   ║   4 - Atualizar Dados da Conta                             ║   ║");
	    System.out.println("║   ║   5 - Visualizar Dados da Conta                            ║   ║");
	    System.out.println("║   ║   6 - Listar contas                                        ║   ║");
	    System.out.println("║   ║   7 - Voltar                                               ║   ║");
	    System.out.println("║   ║   0 - Sair                                                 ║   ║");
	    System.out.println("║   ║                                                            ║   ║");
	    System.out.println("║   ╚════════════════════════════════════════════════════════════╝   ║");

	    System.out.print(Cores.TEXT_GREEN_BOLD);
	    System.out.println("║                                                                    ║");
	    System.out.println("╚════════════════════════════════════════════════════════════════════╝");
	    System.out.print(Cores.TEXT_RESET + "Digite a opção desejada: ");
	}

		
	public static void menuListar() {
	    System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD);
	    System.out.println("╔════════════════════════════════════════════════════════════════════╗");
	    System.out.println("║                                                                    ║");
	    System.out.println("║                      BANCO DO BRAZIL COM Z                         ║");
	    System.out.println("║                                                                    ║");

	    System.out.print(Cores.TEXT_YELLOW_BOLD);
	    System.out.println("║   ╔════════════════════════════════════════════════════════════╗   ║");
	    System.out.println("║   ║                                                            ║   ║");
	    System.out.println("║   ║   1 - Listar todas as contas                               ║   ║");
	    System.out.println("║   ║   2 - Buscar Conta por Titular                             ║   ║");
	    System.out.println("║   ║   0 - Voltar                                               ║   ║");
	    System.out.println("║   ║                                                            ║   ║");
	    System.out.println("║   ╚════════════════════════════════════════════════════════════╝   ║");

	    System.out.print(Cores.TEXT_GREEN_BOLD);
	    System.out.println("║                                                                    ║");
	    System.out.println("╚════════════════════════════════════════════════════════════════════╝");
	    System.out.print(Cores.TEXT_RESET + "Digite a opção desejada: ");
	}

	
	//
	public static void sobre() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND);
		System.out.println(Cores.TEXT_YELLOW    + "************************************************");
		System.out.println(Cores.TEXT_RED       + "Projeto Desenvolvido por: " + Cores.TEXT_WHITE_BOLD + "Eduardo Tosta        "                   + Cores.TEXT_YELLOW + "*");
		System.out.println(Cores.TEXT_RED       + "GitHub: "                   + Cores.TEXT_WHITE_BOLD + "github.com/EduardoTosta                " + Cores.TEXT_YELLOW + "*");
		System.out.println(Cores.TEXT_CYAN_BOLD + "Generation Brasil - generation@generation.org  "                                                + Cores.TEXT_YELLOW + "*");
		System.out.println(Cores.TEXT_YELLOW    + "************************************************");
	}
	
	//Antes de cada break do switch case, deve-se colocar uma chamada para o KeyPress
	public static void keyPress() {
 		try {
  
 			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
 			System.in.read();
  
 		} catch (IOException e) {
  
 			System.err.println("Ocorreu um erro ao tentar ler o teclado");
  
 		}
 	}
	
	

}

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
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		double saldo, limite;
		
		//dados de contas para testes
		ContaCorrente cc1 = new ContaCorrente(conta.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		conta.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(conta.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		conta.cadastrar(cp1);
		
		
		while(true) {
			menuLogin();
			opcao = leia.nextInt(); 
			
			switch(opcao) {
			case 1:
				System.out.println("ACESSAR CONTA");
				System.out.println("Digite o numero da conta que deseja Acessar: ");
				numero = leia.nextInt();

				Optional<Conta> contaLogada = conta.acessar(numero);
				keyPress();
				
				if(contaLogada.isPresent()) {
					int opcaoMenuPrincipal;
					while(true) {
						menuPrincipal();
						opcaoMenuPrincipal = leia.nextInt();
						
						switch(opcaoMenuPrincipal) {
						case 1:
							System.out.println("DEPÓSITO");
				            System.out.print("Digite o número da conta: ");
				            numero = leia.nextInt();
				            
				            System.out.print("Digite o valor do depósito: ");
				            saldo = leia.nextDouble();
				            
				            conta.depositar(numero, saldo);
				            
				            keyPress();
				            break;
						
						case 2:
							System.out.println("SAQUE");
				            System.out.print("Digite o número da conta: ");
				            numero = leia.nextInt();
				            
				            System.out.print("Digite o valor do saque: ");
				            saldo = leia.nextDouble();
				            
				            conta.sacar(numero, saldo);
				            
				            keyPress();
				            break;
						
						case 3:
							
							keyPress();
							break;
							
						case 4:
							System.out.println("Atualizar Dados");
							
							System.out.println("Digite o número da conta");
							numero = leia.nextInt();
							
							Optional <Conta> buscarConta = conta.buscarNaCollection(numero);
							
							if(buscarConta.isPresent()) {
								System.out.println("Digite o número da Agência:");
								agencia = leia.nextInt();

								System.out.println("Digite o nome do Titular:");
								leia.skip("\\R");
								titular = leia.nextLine();
								
								tipo = buscarConta.get().getTipo();
								
								System.out.println("Digite o saldo inicial da conta:");
								saldo = leia.nextFloat();
								
								switch(tipo) {
								case 1 ->{
										System.out.println("Digite o limite da conta: ");
										limite = leia.nextDouble();
										conta.cadastrar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
									}
								case 2->{
										System.out.println("Digite o dia de aniversário da conta: ");
										aniversario = leia.nextInt();
										conta.cadastrar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
									}
								}

							}else {
								System.out.printf("\n A conta %d não existe!", numero);
							}
							
							keyPress();
							break;
						
						case 5:
				            System.out.println("VOLTANDO AO MENU ANTERIOR...");
				            return; // volta para o menu anterior
				            
						case 0:
				            System.out.println("SAINDO DO SISTEMA...");
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
		 System.out.println(" ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■■ ");
		 System.out.println(" ■                                              ■ ");
		 System.out.println(" ■  ╔════════════════════════════════════════╗  ■ ");
		 System.out.println(" ■  ║                                        ║  ■ ");
	     System.out.println(" ■  ║          BANCO DO BRAZIL COM Z         ║  ■ ");
	     System.out.println(" ■  ║                                        ║  ■ ");
	     System.out.println(" ■  ╠════════════════════════════════════════╣  ■ ");
	     System.out.println(" ■  ║  1 - Acessar conta                     ║  ■ ");
	     System.out.println(" ■  ║  2 - Criar conta                       ║  ■ ");
	     System.out.println(" ■  ║  0 - Encerrar                          ║  ■ ");
	     System.out.println(" ■  ╚════════════════════════════════════════╝  ■ ");
		 System.out.println(" ■                                              ■ ");
	     System.out.println(" ■■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
	     System.out.println("==================================================");
	     System.out.println(" Digite a opção desejada:                         ");
	     System.out.println("==================================================");
	}
	
	public static void menuPrincipal() {
			 System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD);
			 System.out.println(" ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■■ ");
			 System.out.println(" ■                                              ■ ");
			 System.out.println(" ■  ╔════════════════════════════════════════╗  ■ ");
			 System.out.println(" ■  ║                                        ║  ■ ");
		     System.out.println(" ■  ║          BANCO DO BRAZIL COM Z         ║  ■ ");
		     System.out.println(" ■  ║                                        ║  ■ ");
		     System.out.println(" ■  ╠════════════════════════════════════════╣  ■ ");
		     System.out.println(" ■  ║  1 - Depositar                         ║  ■ ");
		     System.out.println(" ■  ║  2 - Sacar                             ║  ■ ");
		     System.out.println(" ■  ║  3 - Transferir valor entre contas     ║  ■ ");
		     System.out.println(" ■  ║  4 - Atualizar Dados da Conta          ║  ■ ");
		     System.out.println(" ■  ║  5 - Voltar                            ║  ■ ");
		     System.out.println(" ■  ║  0 - Sair                              ║  ■ ");
		     System.out.println(" ■  ╚════════════════════════════════════════╝  ■ ");
			 System.out.println(" ■                                              ■ ");
		     System.out.println(" ■■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
		     System.out.println("==================================================");
		     System.out.println(" Digite a opção desejada:                         ");
		     System.out.println("==================================================");
		}
		
		public static void menuTransferir() {
			 System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD);
			 System.out.println(" ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■■ ");
			 System.out.println(" ■                                              ■ ");
			 System.out.println(" ■  ╔════════════════════════════════════════╗  ■ ");
			 System.out.println(" ■  ║                                        ║  ■ ");
		     System.out.println(" ■  ║          BANCO DO BRAZIL COM Z         ║  ■ ");
		     System.out.println(" ■  ║                                        ║  ■ ");
		     System.out.println(" ■  ╠════════════════════════════════════════╣  ■ ");
		     System.out.println(" ■  ║  1 - Listar todas as contas            ║  ■ ");
		     System.out.println(" ■  ║  2 - Buscar Conta por Número           ║  ■ ");
		     System.out.println(" ■  ║  0 - Voltar                            ║  ■ ");
		     System.out.println(" ■  ╚════════════════════════════════════════╝  ■ ");
			 System.out.println(" ■                                              ■ ");
		     System.out.println(" ■■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
		     System.out.println("==================================================");
		     System.out.println(" Digite a opção desejada:                         ");
		     System.out.println("==================================================");
		}
	

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Eduardo Tosta");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/EduardoTosta");
		System.out.println("*********************************************************");
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

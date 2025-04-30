package conta_bancaria;
import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
import conta_bancaria.controller.ContaController;

public class Menu {
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		double saldo, limite;
		
		System.out.println("Opcao: ");
		opcao = leia.nextInt();
		
		//dados de contas para testes
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
		
		while(true) {
			switch(opcao) {
			case 1:
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
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
				case 2->{
						System.out.println("Digite o dia de aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
				keyPress();
				break;
			
			case 2:
				System.out.println("LISTAR CONTAS");
				contas.listarTodas();
				
				
				keyPress();
				break;
				
				
			case 3:
				System.out.println("BUSCAR CONTA");
				System.out.println("Digite o numero da conta que deseja buscar: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			}
			leia.close();
		}
		
					
		/*
		 System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD);
		 System.out.println(" ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■■ ");
		 System.out.println(" ■                                              ■ ");
		 System.out.println(" ■  ╔════════════════════════════════════════╗  ■ ");
		 System.out.println(" ■  ║                                        ║  ■ ");
	     System.out.println(" ■  ║          BANCO DO BRAZIL COM Z         ║  ■ ");
	     System.out.println(" ■  ║                                        ║  ■ ");
	     System.out.println(" ■  ╠════════════════════════════════════════╣  ■ ");
	     System.out.println(" ■  ║  1 - Login                             ║  ■ ");
	     System.out.println(" ■  ║  2 - Criar conta                       ║  ■ ");
	     System.out.println(" ■  ║  0 - Encerrar                          ║  ■ ");
	     System.out.println(" ■  ╚════════════════════════════════════════╝  ■ ");
		 System.out.println(" ■                                              ■ ");
	     System.out.println(" ■■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
	     System.out.println("==================================================");
	     System.out.println(" Digite a opção desejada:                         ");
	     System.out.println("==================================================");
		

	     
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
	     
	     */
	     
	     
	     
	     
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

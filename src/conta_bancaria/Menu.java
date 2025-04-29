package conta_bancaria;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	public static void main(String[] args) {
		
		//Instanciar um objeto da classe conta
		Conta c1 = new Conta(01, 123, 1, "Eduardo", 1000000);
		
		c1.sacar(500);
		c1.vizualizar(); 
		
		c1.depositar(200);
		c1.vizualizar();
		
		//Alterar proprietário
		c1.setTitular("Eduardo Tosta");
		c1.vizualizar();
		
		//Instanciando um objeto da classe ContaCorrente
		ContaCorrente cc1 = new ContaCorrente(02,456 ,1 , "João", 600000, 60000);
		
		cc1.vizualizar();
		
		cc1.sacar(659000);
		cc1.vizualizar();
		
		cc1.depositar(50000);
		cc1.vizualizar();
		
		
		//Instanciando objeto da classe ContaPoupanca
		ContaPoupanca cp1 = new ContaPoupanca(03, 785, 2, "Camila", 50000, 29);
		
		cp1.vizualizar();
		
		cp1.sacar(2000);
		cp1.vizualizar();
		
		cp1.depositar(3000);
		cp1.vizualizar();
		
		
		
		
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
	     
	     
	     
	     
	     
	     
	}

}

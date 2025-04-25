package conta_bancaria;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {
	public static void main(String[] args) {
		
		//Instanciar um objeto da classe conta
		Conta c1 = new Conta(01, 123, 1, "Eduardo", 500000000);
		
		c1.sacar(500);
		c1.vizualizar(); 
		
		c1.depositar(200);
		c1.vizualizar();
		
		//Alterar proprietário
		c1.setTitular("Eduardo Tosta");
		c1.vizualizar();
		
		
		 System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD);
		 System.out.println(" ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■■ ");
		 System.out.println(" ■  ╔════════════════════════════════════════╗  ■ ");
		 System.out.println(" ■  ║                                        ║  ■ ");
	     System.out.println(" ■  ║          BANCO DO BRAZIL COM Z         ║  ■ ");
	     System.out.println(" ■  ║                                        ║  ■ ");
	     System.out.println(" ■  ╠════════════════════════════════════════╣  ■ ");
	     System.out.println(" ■  ║  1 - Criar conta                       ║  ■ ");
	     System.out.println(" ■  ║  2 - Listar todas as contas            ║  ■ ");
	     System.out.println(" ■  ║  3 - Buscar Conta por Número           ║  ■ ");
	     System.out.println(" ■  ║  4 - Atualizar Dados da Conta          ║  ■ ");
	     System.out.println(" ■  ║  5 - Apagar conta                      ║  ■ ");
	     System.out.println(" ■  ║  6 - Sacar                             ║  ■ ");
	     System.out.println(" ■  ║  7 - Depositar                         ║  ■ ");
	     System.out.println(" ■  ║  8 - Transferir valor entre contas     ║  ■ ");
	     System.out.println(" ■  ║  9 - Sair                              ║  ■ ");
	     System.out.println(" ■  ╚════════════════════════════════════════╝  ■ ");
	     System.out.println(" ■■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
	     System.out.println("==================================================");
	     System.out.println(" Digite a opção desejada:                         ");
	     System.out.println("==================================================");
	     
	     
	}

}

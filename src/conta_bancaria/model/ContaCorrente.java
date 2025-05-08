package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public class ContaCorrente extends Conta{
	
	private double limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, double saldo, double limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	
	@Override
	public boolean sacar(double valor) {
		if((this.getSaldo() + this.limite) < valor) {
			System.out.println("\nSaldo insuficiente");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override
	public void vizualizar() {
		super.vizualizar();
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		System.out.println(Cores.TEXT_PURPLE_BOLD+"*********************************************");
		System.out.println(Cores.TEXT_GREEN_BOLD +"Limite da conta:      " + nfMoeda.format(this.limite));
		System.out.println(Cores.TEXT_PURPLE_BOLD+"*********************************************");
	}
	

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}

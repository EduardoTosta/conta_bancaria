package conta_bancaria.model;

import java.text.NumberFormat;

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
		System.out.println("Limite da conta:      " + nfMoeda.format(this.limite));
	}
	

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}

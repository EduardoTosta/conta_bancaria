package conta_bancaria.model;
import java.time.LocalDate;

public class ContaPoupanca extends Conta {
	
	private int diaAniversario;

	//Metodo Construtor
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, double saldo, int diaAniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.diaAniversario = diaAniversario;
	}
	
	
	//Metodos
	private void calculoJuros() {
		LocalDate dataAtual = LocalDate.now();
		int diaDoMes = dataAtual.getDayOfMonth();
		
		if(diaDoMes == diaAniversario) {
			double saldoComJuros = this.getSaldo() + (this.getSaldo() * 0.07) ;
			this.setSaldo(saldoComJuros);
		}
	}
	
	
	//Metodos Herdados
	@Override
	public boolean sacar(double valor) {
		if(this.getSaldo() < valor) {
			System.out.println("\nSaldo insuficiente");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override
	public void vizualizar() {
		calculoJuros();
		super.vizualizar();
		System.out.println("Dia de Criação:       " + this.diaAniversario);
	}
	
	
	//Getters e Setters
	public int getDiaAniversario() {
		return this.diaAniversario;
	}

	public void setDiaAniversario(int diaAniversario) {
		this.diaAniversario = diaAniversario;
	}
	
}

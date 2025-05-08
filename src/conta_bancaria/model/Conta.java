package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public abstract class Conta {
	
	//Atributos da Classe
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private double saldo;
	
	
	//Metodo Construtor
	public Conta(int numero, int agencia, int tipo, String titular, double saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	
	//Metodos Bancários
	public boolean sacar(double valor) {
		if(this.saldo < valor) {
			System.out.println("\nSaldo insuficiente");
			return false;
		}
		
		this.saldo -= valor;
		return true;
	}
	
	public void depositar(double valor) {
		if(valor <=0)
			System.out.println("Valor Inválido!");	
		else
			System.out.println("Valor depositado com sucesso!");
		
		this.saldo += valor;
	}
	
	
	//Metodos de impressão
	public void vizualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		String tipo = "";
		
		switch(this.tipo) {
			case 1 -> tipo = "Conta Corrente";
			case 2 -> tipo = "Conta Poupança";
			default -> tipo = "Inválido";
		}    
		    System.out.print(Cores.TEXT_GREEN_BOLD);
		    System.out.println("╔═══════════════════════════════════════════╗");
		    System.out.println("║                                           ║");
		    System.out.println("║           Banco do Brasil com Z           ║");
		    System.out.println("║                                           ║");

		    System.out.print(Cores.TEXT_CYAN_BOLD);
		    System.out.println("║              DADOS DA CONTA               ║");
		    System.out.println("║   ╔═══════════════════════════════════╗   ║");
		    System.out.println("║   ║                                   ║   ║");
		    System.out.println(Cores.TEXT_CYAN_BOLD+"║   ║ Número da Conta:   " + Cores.TEXT_WHITE_BOLD + this.numero + espacosFinais(Integer.toString(this.numero), 15)             + Cores.TEXT_CYAN_BOLD  + "║   ║");
		    System.out.println(Cores.TEXT_CYAN_BOLD+"║   ║ Número da Agência: " + Cores.TEXT_WHITE_BOLD + this.agencia + espacosFinais(Integer.toString(this.agencia), 15)           + Cores.TEXT_CYAN_BOLD  + "║   ║");
		    System.out.println(Cores.TEXT_CYAN_BOLD+"║   ║ Tipo da conta:     " + Cores.TEXT_WHITE_BOLD + tipo + espacosFinais(tipo, 15)                                             + Cores.TEXT_CYAN_BOLD  + "║   ║");
		    System.out.println(Cores.TEXT_CYAN_BOLD+"║   ║ Titular da conta:  " + Cores.TEXT_WHITE_BOLD + this.titular + espacosFinais(this.titular, 15)                             + Cores.TEXT_CYAN_BOLD  + "║   ║");
		    System.out.println(Cores.TEXT_CYAN_BOLD+"║   ║ Saldo da conta:    " + Cores.TEXT_WHITE_BOLD + nfMoeda.format(this.saldo) + espacosFinais(nfMoeda.format(this.saldo), 15) + Cores.TEXT_CYAN_BOLD  + "║   ║");
		    System.out.println(Cores.TEXT_CYAN_BOLD+"║   ║                                   ║   ║");
		    System.out.println(Cores.TEXT_CYAN_BOLD+"║   ╚═══════════════════════════════════╝   ║");

		    System.out.print(Cores.TEXT_GREEN_BOLD);
		    System.out.println("║                                           ║");
		    System.out.println("╚═══════════════════════════════════════════╝");
		    System.out.print(Cores.TEXT_RESET);
	}
	
	public static String espacosFinais(String texto, int larguraDesejada) {
	    int quantidadeEspacos = larguraDesejada - texto.length();
	    StringBuilder espacos = new StringBuilder();
	    for (int i = 0; i < quantidadeEspacos; i++) {
	        espacos.append(" ");
	    }
	    return espacos.toString();
	}

	//Getters e Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int conta) {
		this.numero = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}

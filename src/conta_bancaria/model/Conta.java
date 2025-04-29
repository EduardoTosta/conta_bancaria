package conta_bancaria.model;

import java.text.NumberFormat;

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
		System.out.println("**************************************************");
		System.out.println("                 DADOS DA CONTA                   ");
		System.out.println("**************************************************");
		System.out.println("Número da Conta:      " + this.numero);
		System.out.println("Número da Agência:    " + this.agencia);
		System.out.println("Tipo da conta:        " + tipo);
		System.out.println("Titular da conta:     " + this.titular);
		System.out.println("Saldo da conta:       " + nfMoeda.format(this.saldo));
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

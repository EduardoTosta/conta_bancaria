package conta_bancaria.controller;

import java.util.ArrayList;
import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	//Criar collection array list
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	//Variável para controlar o numero das contas
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.vizualizar();
		else
			System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.vizualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A Conta foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, double valor) {
		// TODO Auto-generated method stub
		
	}
	//Métodos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta: listaContas) {
			if(conta.getNumero() == numero)
				return conta;
		}
		return null;
	}

	@Override
	public Conta acessar(int numero) {
	    var conta = buscarNaCollection(numero);

	    if (conta != null) {
	        conta.vizualizar();
	        return conta;
	    } else {
	        System.out.printf("\n A conta número: %d não foi encontrada!\n", numero);
	        return null;
	    }
	}
		
}
	


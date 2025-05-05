package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	//Criar collection array list
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	//Variável para controlar o numero das contas
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().vizualizar();
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
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.printf("\n A conta numero: %d foi atualizada com sucesso!", conta.getNumero());
		}else
			System.out.printf("\n A conta numero: %d não foi encontrada!", conta.getNumero());
		
	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			if(listaContas.remove(conta.get()) == true)
				System.out.printf("\n A conta numero: %d foi deletada com sucesso!", numero);
		else
			System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
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
	
	public Optional <Conta> buscarNaCollection(int numero) {
		for(var conta: listaContas) {
			if(conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}

	@Override
	public Optional <Conta> acessar(int numero) {
	    Optional<Conta> conta = buscarNaCollection(numero);

	    if (conta.isPresent()) {
	        conta.get().vizualizar();
	        return conta;
	    } else {
	        System.out.printf("\n A conta número: %d não foi encontrada!\n", numero);
	        return Optional.empty();
	    }
	}
		
}
	


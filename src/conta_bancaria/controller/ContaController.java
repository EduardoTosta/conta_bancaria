package conta_bancaria.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	//Criar collection array list
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	//Variável para controlar o numero das contas
	int numero = 0;

	
	//Metodos CRUD
	
	//Procura pelo numero da conta
	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().vizualizar();
		else
			System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
	}

	//Lista todas as contas
	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.vizualizar();
		}
	}
	//Lista as contas pelo nome do titular
	@Override
	public void listarPorTitular(String titular) {
		List<Conta> listaTitulares = listaContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		
		if(listaTitulares.isEmpty())
		
			System.out.printf("\nNenhuma conta foi encontrada com base no criterio %s" + titular);
		
		for(var conta:listaTitulares)
			conta.vizualizar();
	}
	
	//Cadastra um onjeto conta no array
	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A Conta foi criada com sucesso!");
	}

	//Atualiza os dados de um objeto conta
	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.printf("\n A conta numero: %d foi atualizada com sucesso!", conta.getNumero());
		}else
			System.out.printf("\n A conta numero: %d não foi encontrada!", conta.getNumero());
		
	}
	
	//Delete um objeto conta do array
	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			if(listaContas.remove(conta.get()) == true)
				System.out.printf("\n A conta numero: %d foi deletada com sucesso!", numero);
		else
			System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
	}

	//Metodos bancários
	
	//Subtrai valor da váriavel saldo
	@Override
	public void sacar(int numero, double valor) {
		Optional<Conta> conta = buscarNaCollection(numero);
		//Converte a váriavel valor para uma string (Para fins visuais)
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		if(conta.isPresent()) {
			if(conta.get().sacar(valor))
				System.out.printf("\nO saque de: %s foi efetuado com sucesso na conta %d!",nfMoeda.format(valor), numero);
		}else {
			System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
		}
	}
	
	//Adciona valor na váriavel saldo
	@Override
	public void depositar(int numero, double valor) {
		Optional<Conta> conta = buscarNaCollection(numero);
		//Converte a váriavel valor para uma string (Para fins visuais)
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		if(conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf("\nO depósito de: %s foi efetuado com sucesso na conta %d!",nfMoeda.format(valor), numero);
		}else {
			System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
		}
			
		
	}

	//Retira valor da váriavel saldo de um objeto conta e envia para outro
	@Override
	public void transferir(int numeroOrigem, int numeroDestino, double valor) {
		//Converte a váriavel valor para uma string (Para fins visuais)
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		//Cria um optional para conta de origem e de destino, facilitando o acesso aos metodos
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if(contaOrigem.isPresent() && contaDestino.isPresent()) {
			if(contaOrigem.get().sacar(valor)) {
				contaDestino.get().depositar(valor);
				System.out.printf("\nA transferência de %s da conta %d para a conta %d foi efetuado com sucesso!",nfMoeda.format(valor), numeroOrigem, numeroDestino);
			}		
		}else {
			System.out.printf("\n A conta numero: %d não foi encontrada!", numero);
		}
	}
	
	//Métodos Auxiliares
	
	//Cria um numero para cada conta criada
	public int gerarNumero() {
		return ++ numero;
	}
	
	//Usado para procurar contas no array
	public Optional <Conta> buscarNaCollection(int numero) {
		for(var conta: listaContas) {
			if(conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}

	//Acessa as informações da conta acessada
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
	


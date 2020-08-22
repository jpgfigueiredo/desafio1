package br.com.itau;

import java.util.List;
import java.util.stream.Stream;

import br.com.itau.modelo.Lancamento;
import br.com.itau.service.LancamentoService;

public class Exercicio {

	public static void main(String[] args) {
		List<Lancamento> lancamentos = new LancamentoService().listarLancamentos();		
		System.out.println("Gastos ordenados por meses");
			lancamentos.stream()
	           .sorted((lanc1, lanc2) -> lanc1.getMes().compareTo(lanc2.getMes()))
	           .forEach(lancamento -> System.out.println(lancamento));
			
			System.out.println("\nGastos por categoria");
			
			Stream<Lancamento> streamLancamentos = lancamentos.stream();
			
			streamLancamentos.filter(l -> l.getCategoria().equals(1))
							 .forEach(lancamento -> System.out.println(lancamento));
			
System.out.println("\nTotal da fatura por mês");
		Stream<Lancamento> streamFatura = lancamentos.stream();
		Double valorFaturaMensal =	streamFatura.filter(l -> l.getMes().equals(1)).mapToDouble(p -> p.getValor()).sum();
		System.out.println("R$ " + valorFaturaMensal);
			
							
	
	}
}
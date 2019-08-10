import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {

	public static void main(String[] args) {
		
		Collection<String> lista = new ArrayList<String>();
		
		for (int i = 0; i <= 9; i++) {
			lista.add(" Java " + i);			
		}
		
		// Imprimindo com Java 8
		imprimir(lista);
		
		// stream
		// 1) Order
		Stream<String> sorted =
					lista
						.stream()			 //naturalOrder()
							.sorted(Comparator.reverseOrder());
		
		/* Método sorted retorna um Objeto Stream. 
		Precisa ser convertido novamente pra ArrayList */ 
		sorted.collect(Collectors.toList());
		
		// Imprimir lista novamente - Lista desatualizada
		imprimir(lista);
		
		// Atribuir a lista ordenada para atualizar a lista original
//		lista = sorted.collect(Collectors.toList());
		// Código com erro, método stream já foi fechado. 

		lista = lista.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		// Imprimir lista novamente - Lista desatualizada
		imprimir(lista);
		
//		2) Filter
		Stream<String> filtro = lista.stream().filter(l->l.contains("2"));
		List<String> collect = filtro.collect(Collectors.toList());
		imprimir(collect);
		
		filtro = lista.stream().filter(l->l.contains("1"));
		collect = filtro.collect(Collectors.toList());
		imprimir(collect);
		
//		3) Max
		Optional<String> max = lista.stream().max(Comparator.comparing(String::valueOf));
		String maximo = max.get();
		System.out.println("Máximo:" + maximo);
		
//		4) Min
		Optional<String> min = lista.stream().min(Comparator.comparing(String::valueOf));
		String minimo = min.get();
		System.out.println("Mínimo: " + minimo);
		
//		5) Combinações
		// Vazio pq não contém o valor 1 como mínimo
		Optional<String> resultado = lista.stream().min(Comparator.comparing(String::valueOf)).filter(l->l.contains("1"));
		System.out.println(resultado);
		
		// Retorna o valor zero pq é o valor mínimo e depois filtrou
		resultado = lista.stream().min(Comparator.comparing(String::valueOf)).filter(l->l.contains("0"));
		System.out.println(resultado);
		
//		6) foreach
		Map<String, String> mapa = new HashMap<String, String>();
		lista.forEach(l->{
			mapa.put(l, l+" Mapa");
		});
		mapa.forEach((chave,valor)->{
			System.out.println(chave + " - " + valor);
		});
	}
	
	private static void imprimir(Collection<?> lista) {
		System.out.print("Imprimindo lista :" );
		lista.forEach(System.out::print);
		System.out.println();
		// :: method reference
	}

}

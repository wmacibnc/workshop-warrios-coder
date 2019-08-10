import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {

	public static void main(String[] args) {
		// Joda Time
		System.out.println("Data: " + LocalDate.now());
		System.out.println("Hora: " + LocalTime.now());
		System.out.println("Data e Hora:" + LocalDateTime.now());
		
		LocalDate data = LocalDate.of(1989, 4, 9);
		Period periodo = Period.between(data, LocalDate.now());
		System.out.println("Anos: " + periodo.getYears());
		System.out.println("Meses: " + periodo.getMonths());
		System.out.println("Dias: " + periodo.getDays());
		

		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(formatador);
		System.out.println("Hoje: " + hoje); // imutabilidade
		System.out.println("Hoje: " + hoje.format(formatador));
		
		// Manipulação
		hoje = hoje.plusDays(1L);
		System.out.println("Amanhã: " + hoje.format(formatador));
		
		hoje = hoje.plusWeeks(1L);
		System.out.println("Semana que vem: " + hoje.format(formatador));
		
		hoje = hoje.plusMonths(1L);
		System.out.println("Mês que vem: " + hoje.format(formatador));
		
		hoje = hoje.plusYears(1L);
		System.out.println("Ano que vem: " + hoje.format(formatador));
		
		hoje = LocalDate.now();
		System.out.println("Dia no mês: " + hoje.getDayOfMonth());
		System.out.println("Dia: " + hoje.getDayOfWeek());
		System.out.println("Dia no ano: " + hoje.getDayOfYear());
		System.out.println("Mês: " + hoje.getMonth());
		System.out.println("Ano: " + hoje.getYear());
		
	}

}

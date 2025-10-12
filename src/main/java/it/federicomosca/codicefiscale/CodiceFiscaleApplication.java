package it.federicomosca.codicefiscale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodiceFiscaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodiceFiscaleApplication.class, args);

		//ESTRAGGO LA DATA DI NASCITA ==========================================|

		// String codiceFiscale = "MSCFRC93M25G273I";

		// String anno = "19" + codiceFiscale.substring(6,8);
        // System.out.println(anno);

        // String codiceMese = codiceFiscale.substring(8,9);
        // System.out.println(codiceMese);

        // String giorno = codiceFiscale.substring(9, 11);
        // System.out.println(giorno);

		// String mese = switch (codiceMese) {
		// 	case "A" -> "01";
		// 	case "B" -> "02";
		// 	case "C" -> "03";
		// 	case "D" -> "04";
		// 	case "E" -> "05";
		// 	case "H" -> "06";
		// 	case "L" -> "07";
		// 	case "M" -> "08";
		// 	case "P" -> "09";
		// 	case "R" -> "10";
		// 	case "S" -> "11";
		// 	case "T" -> "12";
		// 	default -> throw new IllegalArgumentException("Mese non valido.");
		// };

		// String dataDiNascitaString = anno + "-" + mese + "-" + giorno;
		// System.out.println(dataDiNascitaString);

		//CALCOLO GLI ANNI ========================================================|

		// LocalDate dataDiNascita = LocalDate.parse(dataDiNascitaString);
		// LocalDate oggi = LocalDate.now();
		// // LocalDate oggi = LocalDate.parse("2025-07-12");

		// int anni = Period.between(dataDiNascita, oggi).getYears();

		// System.out.println("anni: " + anni);
	}

}

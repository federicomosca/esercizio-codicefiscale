package it.federicomosca.codicefiscale.service.implementation;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import it.federicomosca.codicefiscale.service.definition.CodiceFiscaleServiceDefinition;

@Service
public class CodiceFiscaleServiceImplementation implements CodiceFiscaleServiceDefinition{

    @Override
    public LocalDate estraiDataDiNascita(String codiceFiscale) {

		String anno = "19" + codiceFiscale.substring(6,8);
        String codiceMese = codiceFiscale.substring(8,9);
        int giornoSesso = Integer.parseInt(codiceFiscale.substring(9, 11));

		String giorno = giornoSesso <= 31 ? "" + giornoSesso : "" + (giornoSesso - 40);

		String mese = switch (codiceMese) {
			case "A" -> "01";
			case "B" -> "02";
			case "C" -> "03";
			case "D" -> "04";
			case "E" -> "05";
			case "H" -> "06";
			case "L" -> "07";
			case "M" -> "08";
			case "P" -> "09";
			case "R" -> "10";
			case "S" -> "11";
			case "T" -> "12";
			default -> throw new IllegalArgumentException("Mese non valido.");
		};

		String dataDiNascitaString = anno + "-" + mese + "-" + giorno;
		return LocalDate.parse(dataDiNascitaString);
    }

    @Override
    public String calcolaEtà(String codiceFiscale) {
        LocalDate dataDiNascita = estraiDataDiNascita(codiceFiscale);
		LocalDate oggi = LocalDate.now();

		String anni = "" + Period.between(dataDiNascita, oggi).getYears();

		return anni;
    }
    
}

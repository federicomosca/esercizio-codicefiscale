package it.federicomosca.codicefiscale.service.implementation;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import it.federicomosca.codicefiscale.DTO.Person;
import it.federicomosca.codicefiscale.service.CodiceFiscaleService;

@Service
public class CodiceFiscaleServiceImplementation implements CodiceFiscaleService {

	private static final Pattern CF_PATTERN = Pattern.compile("^[A-Z]{6}[0-9]{2}[A-EHLMPR-T][0-9]{2}[A-Z][0-9]{3}[A-Z]$");

	@Override
	public Person getBirthdateAndAge(String codiceFiscale) {

		if (codiceFiscale == null || codiceFiscale.isBlank() || !CF_PATTERN.matcher(codiceFiscale).matches()) {
			throw new IllegalArgumentException("Codice fiscale non valido.");
		}

		int yearPart = Integer.parseInt(codiceFiscale.substring(6, 8));
		int currentYear = LocalDate.now().getYear() % 100;
		int fullYear = (yearPart > currentYear ? 1900 : 2000) + yearPart;

		String monthCode = codiceFiscale.substring(8, 9);
		int dayAndSex = Integer.parseInt(codiceFiscale.substring(9, 11));
		int day = dayAndSex <= 31 ? dayAndSex : dayAndSex - 40;

		int month = switch (monthCode) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
			case "D" -> 4;
			case "E" -> 5;
			case "H" -> 6;
			case "L" -> 7;
			case "M" -> 8;
			case "P" -> 9;
			case "R" -> 10;
			case "S" -> 11;
			case "T" -> 12;
			default -> throw new IllegalArgumentException("Mese non valido.");
		};

		LocalDate birthday = LocalDate.parse(String.format("%04d-%02d-%02d", fullYear, month, day));
		int age = calculateAge(birthday);

		Person person = new Person();
		person.setBirthday(birthday);
		person.setAge(age);

		return person;
	}

	@Override
	public int calculateAge(LocalDate birthday) {
		return Period.between(birthday, LocalDate.now()).getYears();
	}
}

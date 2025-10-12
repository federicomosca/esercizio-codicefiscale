package it.federicomosca.codicefiscale.service;

import java.time.LocalDate;

import it.federicomosca.codicefiscale.DTO.Person;

public interface CodiceFiscaleService {
    
    Person getBirthdateAndAge(String codiceFiscale);
    int calculateAge(LocalDate birthdate);
}

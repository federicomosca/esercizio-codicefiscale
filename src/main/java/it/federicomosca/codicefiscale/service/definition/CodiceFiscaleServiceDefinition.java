package it.federicomosca.codicefiscale.service.definition;

import java.time.LocalDate;

public interface CodiceFiscaleServiceDefinition {
    
    LocalDate estraiDataDiNascita(String codiceFiscale);
    String calcolaEtà(String codiceFiscale);
}

package it.federicomosca.codicefiscale.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.federicomosca.codicefiscale.service.definition.CodiceFiscaleServiceDefinition;

@RestController
@RequestMapping("/codicefiscale")
public class CodiceFiscaleController {

    private final CodiceFiscaleServiceDefinition codiceFiscaleService;

    public CodiceFiscaleController(CodiceFiscaleServiceDefinition codiceFiscaleService) {
        this.codiceFiscaleService = codiceFiscaleService;
    }
 
    @GetMapping("/get-data-nascita")
    public LocalDate getDataDiNascita(@RequestParam("codice") String codiceFiscale) {
        return codiceFiscaleService.estraiDataDiNascita(codiceFiscale);
    }

    @GetMapping("/get-eta")
    public String getEta(@RequestParam("eta") String codiceFiscale) {
        return codiceFiscaleService.calcolaEtà(codiceFiscale);
    }
}

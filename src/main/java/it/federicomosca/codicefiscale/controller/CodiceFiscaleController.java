package it.federicomosca.codicefiscale.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.federicomosca.codicefiscale.service.CodiceFiscaleService;
import it.federicomosca.codicefiscale.DTO.Person;

@RestController
@RequestMapping("/codicefiscale")
public class CodiceFiscaleController {

    private final CodiceFiscaleService codiceFiscaleService;

    public CodiceFiscaleController(CodiceFiscaleService codiceFiscaleService) {
        this.codiceFiscaleService = codiceFiscaleService;
    }

    @GetMapping("/calculate-birthday-age")
    public ResponseEntity<Person> calculateBirthdateAndAge (@RequestParam String codiceFiscale){
        return ResponseEntity.ok(codiceFiscaleService.getBirthdateAndAge(codiceFiscale));
    }
}

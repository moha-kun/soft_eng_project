package org.moha.miniproject.rest;

import org.moha.miniproject.dto.CondVoyDTO;
import org.moha.miniproject.dto.VehVoyDTO;
import org.moha.miniproject.services.affectation.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/affectation")
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @PostMapping("/conducteur")
    public String affecterConducteur(@RequestBody CondVoyDTO dto) {
        return affectationService.affecterConducteur(
                dto.getIdConducteur(),
                dto.getIdVoyage());
    }

    @PostMapping("/vehicule")
    public String affecterVehicule(@RequestBody VehVoyDTO dto) {
        return affectationService.affecterVehicule(
                dto.getIdVehicule(),
                dto.getIdVoyage());
    }

}

package org.moha.miniproject.rest;

import org.moha.miniproject.dto.CondVoyDTO;
import org.moha.miniproject.dto.VehVoyDTO;
import org.moha.miniproject.services.affectation.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/affectation")
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @PostMapping("/conducteur")
    public ResponseEntity affecterConducteur(@RequestBody CondVoyDTO dto) throws Exception {
        try {
            return ResponseEntity
                    .ok()
                    .body(affectationService.affecterConducteur(
                            dto.getIdConducteur(),
                            dto.getIdVoyage()));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PostMapping("/vehicule")
    public ResponseEntity affecterVehicule(@RequestBody VehVoyDTO dto) throws Exception {
        try {
            return ResponseEntity
                    .ok()
                    .body(affectationService.affecterVehicule(
                            dto.getIdVehicule(),
                            dto.getIdVoyage()));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }
}

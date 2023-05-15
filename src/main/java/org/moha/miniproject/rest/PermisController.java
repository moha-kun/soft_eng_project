package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Permis;
import org.moha.miniproject.services.permis.PermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permis")
public class PermisController {
    @Autowired
    private PermisService permisService;

    @PostMapping("")
    public ResponseEntity createPermis(Permis permis) {
        try {
            return ResponseEntity
                    .ok()
                    .body(permisService.savePermis(permis));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{idPermis}")
    public ResponseEntity updatePermis(@PathVariable Long idPermis, @RequestBody Permis permis) {
        try {
            permis.setIdPermis(idPermis);
            return ResponseEntity
                    .ok()
                    .body(permisService.savePermis(permis));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping("/{idPermis}")
    public ResponseEntity deletePermis(@PathVariable Long idPermis) {

        try {
            permisService.removePermis(idPermis);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }
}

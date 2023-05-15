package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Voyage;
import org.moha.miniproject.services.voyage.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voyages")
public class VoyageController {
    @Autowired
    private VoyageService voyageService;

    @GetMapping("")
    public ResponseEntity getVoyages() {
        try {
            return ResponseEntity
                    .ok()
                    .body(voyageService.getVoyages());
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{voyageId}")
    public ResponseEntity getVoyage(@PathVariable("voyageId") Long voyageId) {
        try {
            return ResponseEntity
                    .ok()
                    .body(voyageService.getVoyageById(voyageId));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity createVoyage(@RequestBody Voyage voyage) {
        try {
            return ResponseEntity
                    .ok()
                    .body(voyageService.createVoyage(voyage));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping("/{voyageId}")
    public ResponseEntity deleteVoyage(@PathVariable("voyageId") Long voyageId) {
        try {
            voyageService.deleteVoyage(voyageId);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{voyageId}")
    public ResponseEntity updateVoyage(
            @PathVariable("voyageId") Long voyageId,
            @RequestBody Voyage voyage) {
        try {
            voyage.setIdVoyage(voyageId);
            return ResponseEntity
                    .ok()
                    .body(voyageService.updateVoyage(voyage));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }
}

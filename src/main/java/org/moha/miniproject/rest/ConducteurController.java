package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.services.conducteur.ConducteurService;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RequestMapping("/conducteurs")
@RestController
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    @Autowired
    private DisponibiliteService disponibiliteService;

    @GetMapping("")
    public ResponseEntity getConducteurs() {
        try {
            return ResponseEntity
                    .ok()
                    .body(conducteurService.getAllDrivers());
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/disponible")
    public ResponseEntity getDisponibleConducteurs(
            @RequestParam(name = "dateDepart") LocalDate dateDepart,
            @RequestParam(name = "dateArrive") LocalDate dateArrive) {
        try {
            return ResponseEntity
                    .ok()
                    .body(disponibiliteService.getAvailableConducteurs(dateDepart, dateArrive));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity createConducteur(@RequestBody Conducteur cond) {
        try {
            return ResponseEntity
                    .ok()
                    .body(conducteurService.saveDriver(cond));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{idCond}")
    public ResponseEntity getConducteur(@PathVariable Long idCond) {
        try {
            return ResponseEntity
                    .ok()
                    .body(conducteurService.saveDriver(conducteurService.getDriverById(idCond)));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{idCond}")
    @PreAuthorize("@userVerification.checkUser(#idCond)")
    public ResponseEntity updateConducteur(@PathVariable Long idCond, @RequestBody Conducteur cond) {
        try {
            cond.setId(idCond);
            return ResponseEntity
                    .ok()
                    .body(conducteurService.updateDriver(cond));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{idCond}/password")
    @PreAuthorize("@userVerification.checkUser(#idCond)")
    public ResponseEntity updateConducteurPassword(@PathVariable Long idCond,
            @RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        try {
            return ResponseEntity
                    .ok()
                    .body(conducteurService.updateDriver(
                            conducteurService.updateDriverPassword(idCond, passwordUpdateDTO)));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping("/{idCond}")
    @PreAuthorize("@userVerification.checkUser(#idCond) or hasAnyRole('MANAGER')")
    public ResponseEntity deleteConducteur(@PathVariable Long idCond) {
        try {
            conducteurService.removeDriver(idCond);
            return ResponseEntity
                    .ok().build();
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }
}

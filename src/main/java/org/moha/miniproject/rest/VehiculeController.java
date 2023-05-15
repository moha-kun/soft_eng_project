package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.moha.miniproject.services.vehicule.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private DisponibiliteService disponibiliteService;

    @GetMapping("")
    public List<Vehicule> getVehicules() {
        return vehiculeService.getAllVehicles();
    }

    @GetMapping("/disponible")
    public ResponseEntity getDisponibleVehicules(
            @RequestParam(name = "dateDepart") LocalDate dateDepart,
            @RequestParam(name = "dateArrive") LocalDate dateArrive) {
        try {
            return ResponseEntity
                    .ok()
                    .body(disponibiliteService.getAvailableVehicules(dateDepart, dateArrive));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{vehiculeId}")
    public ResponseEntity getVehiculeById(@PathVariable Long vehiculeId) {
        try {
            return ResponseEntity
                    .ok()
                    .body(vehiculeService.getVehicleById(vehiculeId));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity createVehicule(@RequestBody Vehicule vehicule) {
        try {
            return ResponseEntity
                    .ok()
                    .body(vehiculeService.saveVehicle(vehicule));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{vehiculeId}")
    public ResponseEntity updateVehicule(@PathVariable Long vehiculeId, @RequestBody Vehicule vehicule) {
        try {
            vehicule.setIdVehicule(vehiculeId);
            return ResponseEntity
                    .ok()
                    .body(vehiculeService.saveVehicle(vehicule));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping("/{vehiculeId}")
    public ResponseEntity deleteVehicule(@PathVariable Long vehiculeId) {
        try {
            vehiculeService.removeVehicle(vehiculeId);
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

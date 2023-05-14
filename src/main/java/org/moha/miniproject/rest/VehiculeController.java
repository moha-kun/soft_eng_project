package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.moha.miniproject.services.vehicule.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Vehicule> getDisponibleVehicules(
            @RequestParam(name = "dateDepart") LocalDate dateDepart,
            @RequestParam(name = "dateArrive") LocalDate dateArrive) {
        return disponibiliteService.getAvailableVehicules(dateDepart, dateArrive);
    }

    @GetMapping("/{vehiculeId}")
    public Vehicule getVehiculeById(@PathVariable Long vehiculeId) {
        return vehiculeService.getVehicleById(vehiculeId);
    }

    @PostMapping("")
    public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.saveVehicle(vehicule);
    }

    @PutMapping("/{vehiculeId}")
    public Vehicule updateVehicule(@PathVariable Long vehiculeId, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(vehiculeId);
        return vehiculeService.saveVehicle(vehicule);
    }

    @DeleteMapping("/{vehiculeId}")
    public void deleteVehicule(@PathVariable Long vehiculeId) {
        vehiculeService.removeVehicle(vehiculeId);
    }
}

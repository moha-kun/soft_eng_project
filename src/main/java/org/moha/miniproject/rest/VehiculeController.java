package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.services.vehicule.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping("/vehicules")
    public List<Vehicule> getVehicules(){
        return vehiculeService.getAllVehicles();
    }

    @GetMapping("/vehicules/{vehiculeId}")
    public Vehicule getVehiculeById(@PathVariable Long vehiculeId){
        return vehiculeService.getVehicleById(vehiculeId);
    }

    @PostMapping("/vehicules")
    public Vehicule createVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.saveVehicle(vehicule);
    }

    @PutMapping("/vehicules/{vehiculeId}")
    public Vehicule updateVehicule(@PathVariable Long vehiculeId, @RequestBody Vehicule vehicule){
        vehicule.setIdVehicule(vehiculeId);
        return vehiculeService.saveVehicle(vehicule);
    }

    @DeleteMapping("/vehicules/{vehiculeId}")
    public void deleteVehicule(@PathVariable Long vehiculeId){
        vehiculeService.removeVehicle(vehiculeId);
    }
}

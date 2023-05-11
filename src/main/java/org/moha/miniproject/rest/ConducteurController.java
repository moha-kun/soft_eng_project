package org.moha.miniproject.rest;

import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.services.conducteur.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    @GetMapping("/conducteurs")
    public List<Conducteur> getConducteurs() {
        return conducteurService.getAllDrivers();
    }

    @PostMapping("/conducteurs")
    public Conducteur createConducteur(@RequestBody Conducteur cond){
        return conducteurService.saveDriver(cond);
    }

    @GetMapping("/conducteurs/{idCond}")
    public Conducteur getConducteur(@PathVariable Long idCond){return conducteurService.getDriverById(idCond);}

    @PutMapping("/conducteurs/{idCond}")
    public Conducteur updateConducteur(@PathVariable Long idCond, @RequestBody Conducteur cond){
        cond.setId(idCond);
        return conducteurService.updateDriver(cond);
    }

    @PutMapping("/conducteurs/{idCond}/password")
    public Conducteur updateConducteurPassword(@PathVariable Long idCond, @RequestBody PasswordUpdateDTO passwordUpdateDTO){
        return conducteurService.updateDriverPassword(idCond, passwordUpdateDTO);
    }

    @DeleteMapping("/conducteurs/{idCond}")
    public void deleteConducteur(@PathVariable Long idCond){conducteurService.removeDriver(idCond);}

}

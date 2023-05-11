package org.moha.miniproject.rest;

import org.moha.miniproject.Repositories.UserRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.services.conducteur.ConducteurService;
import org.moha.miniproject.services.verification.UserVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConducteurController {

    @Autowired
    private UserVerification userVerification;

    @Autowired
    private ConducteurService conducteurService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/conducteurs")
    public List<Conducteur> getConducteurs() {
        return conducteurService.getAllDrivers();
    }

    @PostMapping("/conducteurs")
    public Conducteur createConducteur(@RequestBody Conducteur cond){ return conducteurService.saveDriver(cond);}

    @GetMapping("/conducteurs/{idCond}")
    public Conducteur getConducteur(@PathVariable Long idCond){return conducteurService.getDriverById(idCond);}

    @PutMapping("/conducteurs")
    @PreAuthorize("@userVerification.checkUser(#cond.getId())")
    public Conducteur updateConducteur(@RequestBody Conducteur cond){
        return conducteurService.saveDriver(cond);
    }

    @DeleteMapping("/conducteurs/{idCond}")
    @PreAuthorize("@userVerification.checkUser(#idCond)")
    public void deleteConducteur(@PathVariable Long idCond){
        conducteurService.removeDriver(idCond);
    }

}

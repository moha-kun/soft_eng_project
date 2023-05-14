package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.services.conducteur.ConducteurService;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/conducteurs")
@RestController
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    @Autowired
    private DisponibiliteService disponibiliteService;

    @GetMapping("")
    public List<Conducteur> getConducteurs() {
        return conducteurService.getAllDrivers();
    }

    @GetMapping("/disponible")
    public List<Conducteur> getDisponibleConducteurs(
            @RequestParam(name = "dateDepart") LocalDate dateDepart,
            @RequestParam(name = "dateArrive") LocalDate dateArrive) {
        return disponibiliteService.getAvailableConducteurs(dateDepart, dateArrive);
    }

    @PostMapping("")
    public Conducteur createConducteur(@RequestBody Conducteur cond) {
        return conducteurService.saveDriver(cond);
    }

    @GetMapping("/{idCond}")
    public Conducteur getConducteur(@PathVariable Long idCond) {
        return conducteurService.getDriverById(idCond);
    }

    @PutMapping("/{idCond}")
    @PreAuthorize("@userVerification.checkUser(#idCond)")
    public Conducteur updateConducteur(@PathVariable Long idCond, @RequestBody Conducteur cond) {
        cond.setId(idCond);
        return conducteurService.updateDriver(cond);
    }

    @PutMapping("/{idCond}/password")
    @PreAuthorize("@userVerification.checkUser(#idCond)")
    public Conducteur updateConducteurPassword(@PathVariable Long idCond,
            @RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        return conducteurService.updateDriverPassword(idCond, passwordUpdateDTO);
    }

    @DeleteMapping("/{idCond}")
    @PreAuthorize("@userVerification.checkUser(#idCond) or hasAnyRole('MANAGER')")
    public void deleteConducteur(@PathVariable Long idCond) {
        conducteurService.removeDriver(idCond);
    }
}

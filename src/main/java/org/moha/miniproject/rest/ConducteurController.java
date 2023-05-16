package org.moha.miniproject.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Permis;
import org.moha.miniproject.services.conducteur.ConducteurService;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/conducteurs")
@RestController
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    @Autowired
    private DisponibiliteService disponibiliteService;

    @Autowired
    private ObjectMapper objectMapper;

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
    public Conducteur createConducteur(@RequestParam("conducteur") String cond,
                                       @RequestParam("recto") MultipartFile recto,
                                       @RequestParam("verso") MultipartFile verso) throws IOException {
        Conducteur conducteur = objectMapper.readValue(cond, Conducteur.class);
        return conducteurService.saveDriver(conducteur, recto, verso);
    }

    @GetMapping("/{idCond}")
    public Conducteur getConducteur(@PathVariable Long idCond) {
        return conducteurService.getDriverById(idCond);
    }

    @PutMapping("/{idCond}")
    @PreAuthorize("@userVerification.checkUser(#idCond) or hasAnyRole('MANAGER')")
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

    @PostMapping("/{idCond}/permis")
    public Conducteur addPermis(@PathVariable("idCond") Long idCond,
                                @RequestParam("recto") MultipartFile recto,
                                @RequestParam("verso") MultipartFile verso,
                                @RequestParam("permis") String permis) throws IOException {
        Permis prmis = objectMapper.readValue(permis, Permis.class);
        return conducteurService.addPermis(idCond, prmis, recto, verso);
    }
}

package org.moha.miniproject.rest;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.moha.miniproject.enteties.Voyage;
import org.moha.miniproject.services.voyage.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoyageController {
    @Autowired
    private VoyageService voyageService;

    @GetMapping("/voyages")
    public List<Voyage> getVoyages(){
        List<Voyage> voyageList = voyageService.getVoyages();
        return voyageList;
    }
    @GetMapping("/voyages/{voyageId}")
    public Voyage getVoyage(@PathVariable("voyageId") Long voyageId){
        Voyage v = voyageService.getVoyageById(voyageId);
        return v;
    }
    @PostMapping("/voyages")
    public Voyage createVoyage(@RequestBody Voyage voyage){
        return voyageService.createVoyage(voyage);
    }

    @DeleteMapping("/voyages/{voyageId}")
    public void deleteVoyage(@PathVariable("voyageId") Long voyageId){
        voyageService.deleteVoyage(voyageId);
    }
    @PutMapping("/voyages/{voyageId}")
    public Voyage updateVoyage(@PathVariable("voyageId") Long voyageId, @RequestBody Voyage voyage){
        voyage.setIdVoyage(voyageId);
        return voyageService.updateVoyage(voyage);
    }
}

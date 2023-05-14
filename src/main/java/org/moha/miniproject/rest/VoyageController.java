package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Voyage;
import org.moha.miniproject.services.voyage.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voyages")
public class VoyageController {
    @Autowired
    private VoyageService voyageService;

    @GetMapping("")
    public List<Voyage> getVoyages() {
        return voyageService.getVoyages();
    }

    @GetMapping("/{voyageId}")
    public Voyage getVoyage(@PathVariable("voyageId") Long voyageId) {
        return voyageService.getVoyageById(voyageId);
    }

    @PostMapping("")
    public Voyage createVoyage(@RequestBody Voyage voyage) {
        return voyageService.createVoyage(voyage);
    }

    @DeleteMapping("/{voyageId}")
    public void deleteVoyage(@PathVariable("voyageId") Long voyageId) {
        voyageService.deleteVoyage(voyageId);
    }

    @PutMapping("/{voyageId}")
    public Voyage updateVoyage(
            @PathVariable("voyageId") Long voyageId,
            @RequestBody Voyage voyage) {
        voyage.setIdVoyage(voyageId);
        return voyageService.updateVoyage(voyage);
    }
}

package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Conducteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    @GetMapping("/conducteurs")
    public List<Conducteur> getConducteurs() {
        return conducteurService.getConducteurs();
    }

}

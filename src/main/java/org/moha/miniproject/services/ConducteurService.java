package org.moha.miniproject.services;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    public List<Conducteur> getConducteurs() {
        return conducteurRepository.findAll();
    }

}

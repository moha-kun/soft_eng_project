package org.moha.miniproject.services.conducteur;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConducteurServiceImp implements ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;
    @Override
    public List<Conducteur> getAllDrivers() {
        return this.conducteurRepository.findAll();
    }

    @Override
    public Conducteur getDriverById(Long driverId) {
        Conducteur conducteur = this.conducteurRepository.findById(driverId).orElse(null);
        if (conducteur == null) {
            throw new RuntimeException("No driver with such id");
        }
        return conducteur;
    }

    @Override
    public Conducteur saveDriver(Conducteur conducteur) {
        return this.conducteurRepository.save(conducteur);
    }

    @Override
    public void removeDriver(Long driverId) {
        this.conducteurRepository.deleteById(driverId);
    }


    private boolean checkUser(Long idConducteur) {
        return true;
    }

}

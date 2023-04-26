package org.moha.miniproject.services;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.Repositories.VehiculeRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class DisponibiliteService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public boolean isConducteurDisponible(Long idConducteur, LocalDate dateDepart, LocalDate dateArrive) {
        List<Conducteur> conducteurs = conducteurRepository.getDisponibleConducteur(dateDepart, dateArrive);
        for(Conducteur cond : conducteurs) {
            if (cond.getId() == idConducteur)
                return true;
        }
        return false;
    }


    public boolean isVehiculeDisponible(Long idVehicule, LocalDate dateDepart, LocalDate dateArrive) {
        List<Vehicule> vehicules = vehiculeRepository.getDiponibleVehicule(dateDepart, dateArrive);
        for(Vehicule veh : vehicules) {
            if(veh.getIdVehicule() == idVehicule)
                return true;
        }
        return false;
    }
}

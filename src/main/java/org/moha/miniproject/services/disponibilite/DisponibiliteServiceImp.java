package org.moha.miniproject.services.disponibilite;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.Repositories.VehiculeRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DisponibiliteServiceImp implements DisponibiliteService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public boolean isConducteurDisponible(
            Long idConducteur,
            LocalDate dateDepart,
            LocalDate dateArrive) {
        return isConducteurDisponible(idConducteur, dateDepart, dateArrive, null);
    }

    public boolean isConducteurDisponible(
            Long idConducteur,
            LocalDate dateDepart,
            LocalDate dateArrive,
            Long idVoyage) {

        List<Conducteur> conducteurs = null;
        if (idVoyage == null) {
            conducteurs = conducteurRepository
                    .getDisponibleConducteur(dateDepart, dateArrive);
        } else {
            conducteurs = conducteurRepository
                    .getDisponibleConducteurAndIgnoreVoyage(dateDepart, dateArrive, idVoyage);
        }

        for (Conducteur cond : conducteurs) {
            if (cond.getId() == idConducteur)
                return true;
        }

        return false;
    }

    @Override
    public boolean isVehiculeDisponible(
            Long idVehicule,
            LocalDate dateDepart,
            LocalDate dateArrive
    ) {
        return isVehiculeDisponible(idVehicule, dateDepart, dateArrive);
    }

    @Override
    public boolean isVehiculeDisponible(Long idVehicule, LocalDate dateDepart, LocalDate dateArrive, Long idVoyage) {
        List<Vehicule> vehicules = null;

        if (idVoyage == null) {
            vehicules = vehiculeRepository
                    .getDiponibleVehicule(dateDepart, dateArrive);
        } else {
            vehicules = vehiculeRepository
                    .getDiponibleVehiculeAndIgnoreVoyage(dateDepart, dateArrive, idVoyage);
        }

        for (Vehicule veh : vehicules) {
            if (veh.getIdVehicule() == idVehicule)
                return true;
        }
        return false;
    }
}

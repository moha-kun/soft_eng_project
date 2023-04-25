package org.moha.miniproject.services;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.Repositories.VehiculeRepository;
import org.moha.miniproject.Repositories.VoyageRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.enteties.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AffectationService {

    @Autowired
    private ConformiteService conformiteService;

    @Autowired
    private DisponibiliteService disponibiliteService;

    @Autowired
    private VoyageRepository voyageRepository;

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public String affecterConducteur(Long idConducteur, Long idVoyage) {
        Voyage voyage = voyageRepository.findById(idVoyage).get();
        Conducteur conducteur = conducteurRepository.findById(idConducteur).get();
        boolean isDispo = disponibiliteService.isConducteurDisponible(idConducteur, voyage.getDateDepart(), voyage.getDateArrivee());
        boolean isConfo = conformiteService.isConducteurConforme(idConducteur, voyage.getTypeVehicule());

        if(isConfo && isDispo) {
            voyage.setConducteur(conducteur);
            voyageRepository.save(voyage);
            return "Done Successfully!";
        }
        return "Successful ERROR!";
    }

    public String affecterVehicule(Long idVehicule, Long idVoyage) {
        Voyage voyage = voyageRepository.findById(idVoyage).get();
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        boolean isDispo = disponibiliteService.isVehiculeDisponible(idVehicule, voyage.getDateDepart(), voyage.getDateArrivee());
        boolean isConfo = conformiteService.isVehiculeConforme(idVehicule, voyage.getTypeVehicule());

        if(isConfo && isDispo) {
            voyage.setVehicule(vehicule);
            voyageRepository.save(voyage);
            return "Done Successfully!";
        }
        return "Successful ERROR!";
    }

}

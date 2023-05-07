package org.moha.miniproject.services.affectation;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.Repositories.VehiculeRepository;
import org.moha.miniproject.Repositories.VoyageRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.enteties.Voyage;
import org.moha.miniproject.services.conformite.ConformiteService;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImp implements AffectationService {

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

    @Override
    public String affecterConducteur(Long idConducteur, Long idVoyage) {
        Voyage voyage = voyageRepository.findById(idVoyage).get();

        Conducteur conducteur = conducteurRepository.findById(idConducteur).get();

        boolean isDispo = disponibiliteService.isConducteurDisponible(
                idConducteur, voyage.getDateDepart(),
                voyage.getDateArrivee());

        boolean isConfo = conformiteService.isConducteurConforme(
                idConducteur, voyage.getTypeVehicule());

        if (isConfo && isDispo) {
            voyage.setConducteur(conducteur);
            voyageRepository.save(voyage);
            return "Done Successfully!";
        }

        return "Successful ERROR!";
    }

    @Override
    public String affecterVehicule(Long idVehicule, Long idVoyage) {
        Voyage voyage = voyageRepository.findById(idVoyage).get();

        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();

        boolean isDispo = disponibiliteService.isVehiculeDisponible(
                idVehicule, voyage.getDateDepart(),
                voyage.getDateArrivee());

        boolean isConfo = conformiteService.isVehiculeConforme(
                idVehicule, voyage.getTypeVehicule());

        if (isConfo && isDispo) {
            voyage.setVehicule(vehicule);
            voyageRepository.save(voyage);
            return "Done Successfully!";
        }

        return "Successful ERROR!";
    }

}

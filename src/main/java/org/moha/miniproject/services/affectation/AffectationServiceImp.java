package org.moha.miniproject.services.affectation;

import org.moha.miniproject.Repositories.VoyageRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.enteties.Voyage;
import org.moha.miniproject.services.conducteur.ConducteurService;
import org.moha.miniproject.services.conformite.ConformiteService;
import org.moha.miniproject.services.correspondance.CorrespondanceService;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.moha.miniproject.services.vehicule.VehiculeService;
import org.moha.miniproject.services.voyage.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImp implements AffectationService {

    @Autowired
    private ConformiteService conformiteService;
    @Autowired
    private DisponibiliteService disponibiliteService;
    @Autowired
    private VoyageService voyageService;
    @Autowired
    private ConducteurService conducteurService;
    @Autowired
    private VehiculeService vehiculeService;
    @Autowired
    private VoyageRepository voyageRepository;
    @Autowired
    private CorrespondanceService correspondanceService;

    @Override
    public String affecterConducteur(Long idConducteur, Long idVoyage) throws Exception {
        Voyage voyage = voyageService.getVoyageById(idVoyage);
        Conducteur conducteur = conducteurService.getDriverById(idConducteur);

        boolean isDispo = disponibiliteService.isConducteurDisponible(
                idConducteur, voyage.getDateDepart(),
                voyage.getDateArrivee());

        boolean isConfo = conformiteService.isConducteurConforme(
                idConducteur,
                correspondanceService.correspondanceTypeVehicule(voyage.getTypeVehicule())
        );

        if (isConfo) {
            if (isDispo) {
                voyage.setConducteur(conducteur);
                voyageRepository.save(voyage);
                return "Conductor with Id " + idConducteur + " is affected to voyage with Id " + idVoyage + " Successfully!";
            }
            throw new Exception("Conductor with Id " + idConducteur + " is not available");
        }
        throw new Exception("Conductor with Id " + idConducteur + " is not conform");
    }

    @Override
    public String affecterVehicule(Long idVehicule, Long idVoyage) throws Exception {
        Voyage voyage = voyageService.getVoyageById(idVoyage);

        Vehicule vehicule = vehiculeService.getVehicleById(idVehicule);

        boolean isDispo = disponibiliteService.isVehiculeDisponible(
                idVehicule, voyage.getDateDepart(),
                voyage.getDateArrivee());

        boolean isConfo = conformiteService.isVehiculeConforme(
                idVehicule,
                correspondanceService.correspondanceTypeVehicule(voyage.getTypeVehicule())
        );

        if (isConfo) {
            if (isDispo) {
                voyage.setVehicule(vehicule);
                voyageRepository.save(voyage);
                return "Conductor with Id " + idVehicule + " is affected to voyage with Id " + idVoyage + " Successfully!";
            }
            throw new Exception("Vehicule with Id " + idVehicule + " is not available");
        }
        throw new Exception("Vehicule with Id " + idVehicule + " is not conform");
    }

}

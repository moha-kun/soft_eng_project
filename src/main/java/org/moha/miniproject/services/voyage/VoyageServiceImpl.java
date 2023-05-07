package org.moha.miniproject.services.voyage;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.Repositories.VoyageRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.enteties.Voyage;
import org.moha.miniproject.services.conformite.ConformiteService;
import org.moha.miniproject.services.disponibilite.DisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService{
    @Autowired
    private VoyageRepository voyageRepository;

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private DisponibiliteService disponibiliteService;

    @Autowired
    private ConformiteService conformiteService;

    public List<Voyage> getVoyages(){
      List<Voyage> voyageList = voyageRepository.findAll();
      return voyageList;
    };

    public Voyage createVoyage(Voyage voyage){
        Voyage v = voyageRepository.save(voyage);
        return v;
    }

    @Override
    public Voyage getVoyageById(Long voyageId) {
        Voyage v = voyageRepository.findById(voyageId).get();
        if(v == null){
            throw new RuntimeException("Voyage with id " + voyageId + " not found!");
        }
        return v;
    }

    @Override
    public Voyage updateVoyage(Voyage voyage) {

        Voyage v = voyageRepository.findById(voyage.getIdVoyage()).get();
        if(v == null) throw new RuntimeException("Voyage with id " + voyage.getIdVoyage() + " not found");

        voyage.setConducteur(v.getConducteur());
        voyage.setVehicule(v.getVehicule());

        //Check if Conducteur is available && conform for modified dates and vehicule types
        Conducteur c = v.getConducteur();
        Vehicule vehicule = v.getVehicule();

        boolean isCondDispo = true;
        boolean isCondConform = true;

        boolean isVehiculeDispo = true;
        boolean isVehiculeConform = true;

        if(c != null){
            isCondDispo = disponibiliteService.isConducteurDisponible(c.getId(), voyage.getDateDepart(), voyage.getDateArrivee(), voyage.getIdVoyage());
            isCondConform = conformiteService.isConducteurConforme(c.getId(), voyage.getTypeVehicule());
        }

        if(vehicule != null){
            isVehiculeConform = conformiteService.isVehiculeConforme(vehicule.getIdVehicule(), voyage.getTypeVehicule());
            isVehiculeDispo = disponibiliteService.isVehiculeDisponible(vehicule.getIdVehicule(), voyage.getDateDepart(), voyage.getDateArrivee(), voyage.getIdVoyage());
        }

        if( isCondConform && isCondDispo && isVehiculeConform && isVehiculeDispo){
            voyageRepository.save(voyage);
        }else{
            throw new RuntimeException("Conducteur is not available or doesnt conform with new trip.");
        }

        return voyage;
    }

    @Override
    public void deleteVoyage(Long voyageId) {
        voyageRepository.deleteById(voyageId);
    }
}

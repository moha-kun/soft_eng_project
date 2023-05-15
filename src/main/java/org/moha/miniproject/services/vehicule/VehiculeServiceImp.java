package org.moha.miniproject.services.vehicule;

import java.util.List;

import org.moha.miniproject.Repositories.*;
import org.moha.miniproject.enteties.*;
import org.moha.miniproject.services.correspondance.CorrespondanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeServiceImp implements VehiculeService {
  @Autowired
  private VehiculeRepository vehiculeRepository;
  @Autowired
  private VoyageRepository voyageRepository;
  @Autowired
  private AssuranceRepository assuranceRepository;
  @Autowired
  private CarteGriseRepository carteGriseRepository;
  @Autowired
  private VisiteTechniqueRepository visiteTechniqueRepository;
  @Autowired
  private CorrespondanceService correspondanceService;

  @Override
  public List<Vehicule> getAllVehicles() {
    return vehiculeRepository.findAll();
  }

  @Override
  public Vehicule getVehicleById(Long vehicleId) {
    Vehicule vehicule = vehiculeRepository.findById(vehicleId).orElse(null);
    if (vehicule == null)
      throw new RuntimeException("No vehicle with the given ID");
    return vehicule;
  }

  @Override
  public Vehicule saveVehicle(Vehicule vehicule) {
    if(!correspondanceService.isVehiculeType(vehicule.getModel())){
      throw new RuntimeException("Invalid vehicule model: "+vehicule.getModel()
              +", must be one of :" + correspondanceService.getVehiculeTypes());
    }
    List<CarteGrise> cgList = vehicule.getCarteGrises();
    List<Assurance> assurances = vehicule.getAssurances();
    List<VisiteTechnique> visiteTechniques = vehicule.getVisiteTechniques();

    if(cgList != null)
      carteGriseRepository.saveAll(cgList);
    if(assurances != null)
      assuranceRepository.saveAll(assurances);
    if(visiteTechniques != null)
      visiteTechniqueRepository.saveAll(visiteTechniques);

    return vehiculeRepository.save(vehicule);
  }

  @Override
  public void removeVehicle(Long vehicleId) {
    Vehicule vehicule = getVehicleById(vehicleId);
      List<Voyage> voyages = voyageRepository.findVoyagesByVehicule(vehicule);
      if (voyages.size() > 0)
        voyages.forEach(voyage -> {
          voyage.setVehicule(null);
          voyageRepository.save(voyage);
        });
      vehiculeRepository.deleteById(vehicleId);
  }
}

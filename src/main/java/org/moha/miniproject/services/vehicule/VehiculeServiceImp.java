package org.moha.miniproject.services.vehicule;

import java.util.List;
import org.moha.miniproject.Repositories.VehiculeRepository;
import org.moha.miniproject.Repositories.VoyageRepository;
import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.enteties.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeServiceImp implements VehiculeService {
  @Autowired
  private VehiculeRepository vehiculeRepository;

  @Autowired
  private VoyageRepository voyageRepository;

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

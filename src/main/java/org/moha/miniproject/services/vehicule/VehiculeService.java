package org.moha.miniproject.services.vehicule;

import java.util.List;
import org.moha.miniproject.enteties.Vehicule;

public interface VehiculeService {
  List<Vehicule> getAllVehicles();

  Vehicule getVehicleById(Long vehicleId);

  Vehicule saveVehicle(Vehicule vehicule);

  void removeVehicle(Long vehicleId);
}

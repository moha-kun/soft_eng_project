package org.moha.miniproject.services.conducteur;

import java.util.List;
import org.moha.miniproject.enteties.Conducteur;

public interface ConducteurService {
  List<Conducteur> getAllDrivers();

  Conducteur getDriverById(Long driverId);

  Conducteur saveDriver(Conducteur conducteur);

  void removeDriver(Long driverId);
}

package org.moha.miniproject.services.conducteur;

import java.util.List;
import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Conducteur;

public interface ConducteurService {
  List<Conducteur> getAllDrivers();

  Conducteur getDriverById(Long driverId) throws Exception;

  Conducteur saveDriver(Conducteur conducteur);

  Conducteur updateDriver(Conducteur conducteur) throws Exception;

  Conducteur updateDriverPassword(Long driverId, PasswordUpdateDTO passwordUpdateDTO) throws Exception;

  void removeDriver(Long driverId) throws Exception;
}

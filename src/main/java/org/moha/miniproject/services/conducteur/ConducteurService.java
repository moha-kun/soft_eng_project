package org.moha.miniproject.services.conducteur;

import java.io.IOException;
import java.util.List;
import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Permis;
import org.springframework.web.multipart.MultipartFile;

public interface ConducteurService {
  List<Conducteur> getAllDrivers();

  Conducteur getDriverById(Long driverId);

  Conducteur saveDriver(Conducteur conducteur, MultipartFile recto, MultipartFile verso) throws IOException;

  Conducteur updateDriver(Conducteur conducteur);

  Conducteur updateDriverPassword(Long driverId, PasswordUpdateDTO passwordUpdateDTO);

  void removeDriver(Long driverId);

    Conducteur addPermis(Long driverId, Permis permis, MultipartFile recto, MultipartFile verso) throws IOException;
}

package org.moha.miniproject.services.disponibilite;

import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface DisponibiliteService {
  boolean isConducteurDisponible(Long idConducteur,
      LocalDate dateDepart, LocalDate dateArrive);
  boolean isConducteurDisponible(Long idConducteur,
                                 LocalDate dateDepart, LocalDate dateArrive, Long idVoyage);

  boolean isVehiculeDisponible(Long idVehicule,
      LocalDate dateDepart, LocalDate dateArrive);
  boolean isVehiculeDisponible(Long idVehicule,
                               LocalDate dateDepart, LocalDate dateArrive, Long idVoyage);
  List<Conducteur> getAvailableConducteurs(LocalDate dateDepart, LocalDate dateArrive);
  List<Vehicule> getAvailableVehicules(LocalDate dateDepart, LocalDate dateArrive);
}

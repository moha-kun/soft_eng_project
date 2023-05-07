package org.moha.miniproject.services.affectation;

public interface AffectationService {
  String affecterConducteur(Long idConducteur, Long idVoyage);

  String affecterVehicule(Long idVehicule, Long idVoyage);
}
package org.moha.miniproject.services.affectation;

public interface AffectationService {
  String affecterConducteur(Long idConducteur, Long idVoyage) throws Exception;

  String affecterVehicule(Long idVehicule, Long idVoyage) throws Exception;
}
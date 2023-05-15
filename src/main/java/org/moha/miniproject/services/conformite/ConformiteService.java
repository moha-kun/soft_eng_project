package org.moha.miniproject.services.conformite;

public interface ConformiteService {
  boolean isVehiculeConforme(Long idVehicule, char type);

  boolean isConducteurConforme(Long idConducteur, char typePermis) throws Exception;
}

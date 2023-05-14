package org.moha.miniproject.services.disponibilite;

import java.time.LocalDate;

public interface DisponibiliteService {
    boolean isConducteurDisponible(Long idConducteur,
            LocalDate dateDepart, LocalDate dateArrive);

    boolean isConducteurDisponible(Long idConducteur,
            LocalDate dateDepart, LocalDate dateArrive, Long idVoyage);

    boolean isVehiculeDisponible(Long idVehicule,
            LocalDate dateDepart, LocalDate dateArrive);

    boolean isVehiculeDisponible(Long idVehicule,
            LocalDate dateDepart, LocalDate dateArrive, Long idVoyage);
}

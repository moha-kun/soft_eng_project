package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {

        @Query("SELECT c FROM Conducteur c " +
                        "WHERE c NOT IN (SELECT vo.conducteur FROM Voyage vo WHERE :dateD <= vo.dateArrivee AND :dateA >= vo.dateDepart AND vo.conducteur != null)")
        List<Conducteur> getDisponibleConducteur(LocalDate dateD, LocalDate dateA);

        @Query("SELECT c FROM Conducteur c " +
                        "WHERE c NOT IN (SELECT vo.conducteur FROM Voyage vo WHERE :dateD <= vo.dateArrivee AND :dateA >= vo.dateDepart AND vo.conducteur != null AND vo.idVoyage <> :idVoyage)")
        List<Conducteur> getDisponibleConducteurAndIgnoreVoyage(LocalDate dateD, LocalDate dateA, Long idVoyage);

        Conducteur findConducteurByEmail(String email);
}

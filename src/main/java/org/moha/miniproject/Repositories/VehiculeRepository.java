package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

        // TODO: This should be removed i think
        /*
         * @Query("FROM Vehicule vh WHERE vh IN (" +
         * "SELECT vo.vehicule FROM Voyage vo " +
         * "WHERE :dateD >= vo.dateArrivee " +
         * "OR :dateA <= vo.dateDepart) " +
         * "OR vh NOT IN (SELECT vo.vehicule FROM Voyage vo)")
         */
        @Query("SELECT vh FROM Vehicule vh " +
                "WHERE vh NOT IN (SELECT vo.vehicule FROM Voyage vo WHERE :dateD <= vo.dateArrivee AND :dateA >= vo.dateDepart AND vo.vehicule != null)")
        List<Vehicule> getDiponibleVehicule(LocalDate dateD, LocalDate dateA);

        @Query("SELECT vh FROM Vehicule vh " +
                        "WHERE vh NOT IN (SELECT vo.vehicule FROM Voyage vo WHERE :dateD <= vo.dateArrivee AND :dateA >= vo.dateDepart AND vo.vehicule != null AND vo.idVoyage <> :idVoyage) ")
        List<Vehicule> getDiponibleVehiculeAndIgnoreVoyage(LocalDate dateD, LocalDate dateA, Long idVoyage);

}

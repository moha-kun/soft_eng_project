package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long>, CrudRepository<Vehicule, Long> {

        /*
         * @Query("FROM Vehicule vh WHERE vh IN (" +
         * "SELECT vo.vehicule FROM Voyage vo " +
         * "WHERE :dateD >= vo.dateArrivee " +
         * "OR :dateA <= vo.dateDepart) " +
         * "OR vh NOT IN (SELECT vo.vehicule FROM Voyage vo)")
         */
        @Query("SELECT vh FROM Vehicule vh " +
                        "WHERE NOT EXISTS (SELECT vo.vehicule FROM Voyage vo WHERE vo.vehicule = vh) " +
                        "OR EXISTS (SELECT vo.vehicule FROM Voyage vo WHERE vo.vehicule = vh AND (:dateD >= vo.dateArrivee OR :dateA <= vo.dateDepart))")
        public List<Vehicule> getDiponibleVehicule(LocalDate dateD, LocalDate dateA);

        @Query("SELECT vh FROM Vehicule vh " +
                "WHERE NOT EXISTS (SELECT vo.vehicule FROM Voyage vo WHERE vo.vehicule = vh AND vo.idVoyage <> :idVoyage) " +
                "OR EXISTS (SELECT vo.vehicule FROM Voyage vo WHERE vo.vehicule = vh AND (:dateD >= vo.dateArrivee OR :dateA <= vo.dateDepart))")
        public List<Vehicule> getDiponibleVehiculeAndIgnoreVoyage(LocalDate dateD, LocalDate dateA, Long idVoyage);

}

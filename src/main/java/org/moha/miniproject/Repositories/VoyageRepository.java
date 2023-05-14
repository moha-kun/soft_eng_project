package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    public List<Voyage> findVoyagesByConducteur(Long conducteurId);

    public List<Voyage> findVoyagesByVehicule(Long vehiculeId);

}

package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.enteties.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    public List<Voyage> findVoyagesByConducteur(Conducteur conducteur);
    public List<Voyage> findVoyagesByVehicule(Vehicule vehicule);

}

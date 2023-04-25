package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {

}

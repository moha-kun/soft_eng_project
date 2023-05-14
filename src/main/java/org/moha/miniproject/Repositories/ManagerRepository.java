package org.moha.miniproject.Repositories;

import org.moha.miniproject.enteties.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager getManagersByEmail(String email);
}

package org.moha.miniproject.services.manager;

import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {
    List<Manager> getAllManagers();

    Manager getManagerById(Long managerId);

    Manager saveManager(Manager manager);

    Manager updateManager(Manager manager);

    Manager updateManagerPassword(Long managerId, PasswordUpdateDTO passwordUpdateDTO);

    void removeManager(Long managerId);
}

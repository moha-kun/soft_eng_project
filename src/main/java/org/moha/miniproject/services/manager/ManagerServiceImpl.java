package org.moha.miniproject.services.manager;

import org.moha.miniproject.Repositories.ManagerRepository;
import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Manager;
import org.moha.miniproject.enteties.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Manager> getAllManagers(){
        return managerRepository.findAll();
    }
    @Override
    public Manager getManagerById(Long managerId){
        Manager manager = managerRepository.findById(managerId).orElse(null);
        if(manager == null)
            throw new RuntimeException("Manager with id " + managerId + " not found.");

        return manager;
    }

    @Override
    public Manager saveManager(Manager manager){
        Manager manager1 = managerRepository.getManagersByEmail(manager.getEmail());
        if(manager1 != null)
            throw new RuntimeException("Email" + manager.getEmail() +" is already taken.");
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));

        manager.setRole(Role.ROLE_MANAGER);
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(Manager manager){
        Manager oldManager = getManagerById(manager.getId());

        manager.setPassword(oldManager.getPassword());
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManagerPassword(Long managerId, PasswordUpdateDTO passwordUpdateDTO){
        Manager oldMan = getManagerById(managerId);

        boolean passCheck = passwordEncoder.matches(passwordUpdateDTO.getOldPassword(), oldMan.getPassword());
        if(!passCheck)
            throw new RuntimeException("Old password is incorrect");

        oldMan.setPassword(passwordUpdateDTO.getNewPassword());
        return managerRepository.save(oldMan);
    }

    @Override
    public void removeManager(Long managerId){
        managerRepository.deleteById(managerId);
    }
}

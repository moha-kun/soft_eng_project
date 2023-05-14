package org.moha.miniproject.rest;

import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Manager;
import org.moha.miniproject.services.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/managers")
    public List<Manager> getManagers() {
        return managerService.getAllManagers();
    }

    @PostMapping("/managers")
    public Manager createManager(@RequestBody Manager man){
        return managerService.saveManager(man);
    }

    @GetMapping("/managers/{managerId}")
    public Manager getManager(@PathVariable Long managerId){return managerService.getManagerById(managerId);}

    @PutMapping("/managers/{managerId}")
    public Manager updateManager(@PathVariable Long managerId, @RequestBody Manager man){
        man.setId(managerId);
        return managerService.updateManager(man);
    }

    @PutMapping("/managers/{managerId}/password")
    public Manager updateManagerPassword(@PathVariable Long managerId, @RequestBody PasswordUpdateDTO passwordUpdateDTO){
        return managerService.updateManagerPassword(managerId, passwordUpdateDTO);
    }

    @DeleteMapping("/managers/{managerId}")
    public void deleteManager(@PathVariable Long managerId){
        managerService.removeManager(managerId);
    }

}

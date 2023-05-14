package org.moha.miniproject.rest;

import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Manager;
import org.moha.miniproject.services.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("")
    public List<Manager> getManagers() {
        return managerService.getAllManagers();
    }

    @PostMapping("")
    public Manager createManager(@RequestBody Manager man) {
        return managerService.saveManager(man);
    }

    @GetMapping("/{managerId}")
    public Manager getManager(@PathVariable Long managerId) {
        return managerService.getManagerById(managerId);
    }

    @PutMapping("/{managerId}")
    public Manager updateManager(@PathVariable Long managerId, @RequestBody Manager man) {
        man.setId(managerId);
        return managerService.updateManager(man);
    }

    @PutMapping("/{managerId}/password")
    public Manager updateManagerPassword(@PathVariable Long managerId,
            @RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        return managerService.updateManagerPassword(managerId, passwordUpdateDTO);
    }

    @DeleteMapping("/{managerId}")
    public void deleteManager(@PathVariable Long managerId) {
        managerService.removeManager(managerId);
    }

}

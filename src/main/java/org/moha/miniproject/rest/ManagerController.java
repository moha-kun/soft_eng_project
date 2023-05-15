package org.moha.miniproject.rest;

import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Manager;
import org.moha.miniproject.services.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("")
    public ResponseEntity getManagers() {
        try {
            return ResponseEntity
                    .ok()
                    .body(managerService.getAllManagers());
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity createManager(@RequestBody Manager man) {
        try {
            return ResponseEntity
                    .ok()
                    .body(managerService.saveManager(man));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{managerId}")
    public ResponseEntity getManager(@PathVariable Long managerId) {
        try {
            return ResponseEntity
                    .ok()
                    .body(managerService.getManagerById(managerId));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{managerId}")
    public ResponseEntity updateManager(@PathVariable Long managerId, @RequestBody Manager man) {
        try {
            man.setId(managerId);
            return ResponseEntity
                    .ok()
                    .body(managerService.updateManager(man));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{managerId}/password")
    public ResponseEntity updateManagerPassword(@PathVariable Long managerId,
            @RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        try {
            return ResponseEntity
                    .ok()
                    .body(managerService.updateManagerPassword(managerId, passwordUpdateDTO));
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping("/{managerId}")
    public ResponseEntity deleteManager(@PathVariable Long managerId) {
        try {
            managerService.removeManager(managerId);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }

}

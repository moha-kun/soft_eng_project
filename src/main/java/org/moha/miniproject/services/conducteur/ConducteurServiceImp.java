package org.moha.miniproject.services.conducteur;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.Repositories.VoyageRepository;
import org.moha.miniproject.dto.PasswordUpdateDTO;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Permis;
import org.moha.miniproject.enteties.Role;
import org.moha.miniproject.enteties.Voyage;
import org.moha.miniproject.services.permis.PermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConducteurServiceImp implements ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VoyageRepository voyageRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermisService permisService;

    @Override
    public List<Conducteur> getAllDrivers() {
        return this.conducteurRepository.findAll();
    }

    @Override
    public Conducteur getDriverById(Long driverId) {
        Conducteur conducteur = this.conducteurRepository.findById(driverId).orElse(null);
        if (conducteur == null) {
            throw new RuntimeException("No driver with such id");
        }
        return conducteur;
    }

    @Override
    public Conducteur saveDriver(Conducteur conducteur) {
        Conducteur cond = conducteurRepository.findConducteurByEmail(conducteur.getEmail());
        if (cond != null) {
            throw new RuntimeException("Email is already taken");
        }
        // Encrypt password
        conducteur.setPassword(passwordEncoder.encode(conducteur.getPassword()));

        if(conducteur.getPermis() != null){
            for (Permis p : conducteur.getPermis())
                permisService.savePermis(p);
        }
        // For security reasons we need to reset role
        conducteur.setRole(Role.ROLE_CONDUCTOR);

        return this.conducteurRepository.save(conducteur);
    }

    @Override
    public Conducteur updateDriver(Conducteur conducteur) {
        Conducteur oldCond = getDriverById(conducteur.getId());
        // We don't want to input the password everytime we want to update
        conducteur.setPassword(oldCond.getPassword());

        if(conducteur.getPermis() != null){
            for (Permis p : conducteur.getPermis())
                permisService.savePermis(p);
        }
        return conducteurRepository.save(conducteur);
    }

    @Override
    public Conducteur updateDriverPassword(Long driverId, PasswordUpdateDTO passwordUpdateDTO) {
        Conducteur oldCond = getDriverById(driverId);

        boolean passCheck = passwordEncoder.matches(passwordUpdateDTO.getOldPassword(), oldCond.getPassword());
        if (!passCheck) {
            throw new RuntimeException("Old password is incorrect");
        }

        oldCond.setPassword(
                passwordEncoder.encode(passwordUpdateDTO.getNewPassword()));
        return conducteurRepository.save(oldCond);
    }

    @Override
    public void removeDriver(Long driverId) {
        Conducteur conducteur = getDriverById(driverId);
        List<Voyage> voyages = voyageRepository.findVoyagesByConducteur(conducteur);
        if(voyages.size() > 0)
            voyages.forEach(voyage -> {
                voyage.setConducteur(null);
                voyageRepository.save(voyage);
            });
        this.conducteurRepository.deleteById(driverId);
    }

}

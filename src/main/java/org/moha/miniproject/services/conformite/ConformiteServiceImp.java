package org.moha.miniproject.services.conformite;

import org.moha.miniproject.Repositories.ConducteurRepository;
import org.moha.miniproject.Repositories.VehiculeRepository;
import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Permis;
import org.moha.miniproject.enteties.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConformiteServiceImp implements ConformiteService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public boolean isVehiculeConforme(Long idVehicule, char type) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);

        if(vehicule != null) {
            return vehicule.getCategorie() == type;
        }

        return false;
    }

    @Override
    public boolean isConducteurConforme(Long idConducteur, char typePermis) {
        Conducteur conducteur = conducteurRepository.findById(idConducteur).orElse(null);

        if(conducteur != null) {
            List<Permis> permisList = conducteur.getPermis();

            for (Permis permis : permisList) {
                if (permis.getType() == typePermis)
                    return true;
            }
        }

        return false;
    }
}

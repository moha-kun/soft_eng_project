package org.moha.miniproject.services.conformite;

import org.moha.miniproject.enteties.Conducteur;
import org.moha.miniproject.enteties.Permis;
import org.moha.miniproject.enteties.Vehicule;
import org.moha.miniproject.services.conducteur.ConducteurService;
import org.moha.miniproject.services.correspondance.CorrespondanceService;
import org.moha.miniproject.services.vehicule.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConformiteServiceImp implements ConformiteService {
    @Autowired
    private CorrespondanceService correspondanceService;

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private ConducteurService conducteurService;

    @Override
    public boolean isVehiculeConforme(Long idVehicule, char type) {
        Vehicule vehicule = vehiculeService.getVehicleById(idVehicule);

//        if (vehicule.getCategorie() == type)
//            return true;
//        return false;
        return correspondanceService.correspondanceTypeVehicule(vehicule.getModel()) == type;
    }

    @Override
    public boolean isConducteurConforme(Long idConducteur, char typePermis) {
        Conducteur conducteur = conducteurService.getDriverById(idConducteur);

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

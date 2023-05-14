package org.moha.miniproject.services.correspondance;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CorrespondanceServiceImpl implements CorrespondanceService {

    // This shouldn't be hardcoded 🤫
    private Map<String, Character> vehiculeToPermisMap;

    public CorrespondanceServiceImpl() {
        vehiculeToPermisMap = new HashMap<>();

        // Src = https://www.ornikar.com/code/cours/usagers/types-vehicules
        vehiculeToPermisMap.put("Berline", 'B');
        vehiculeToPermisMap.put("Hayon", 'B');
        vehiculeToPermisMap.put("Break", 'B');
        vehiculeToPermisMap.put("Pick-up", 'B');
        vehiculeToPermisMap.put("SUV", 'B');
        vehiculeToPermisMap.put("Mini-fourgonnette", 'B');
        vehiculeToPermisMap.put("Liftback", 'B');

        vehiculeToPermisMap.put("Fourgonnette", 'C'); // transport de marchandise

        vehiculeToPermisMap.put("Transport personnel", 'D');
        vehiculeToPermisMap.put("Minibus", 'D');
        vehiculeToPermisMap.put("Autobus", 'D');
    }

    @Override
    public char correspondanceTypeVehicule(String typeVehicule) {
        Character permis = vehiculeToPermisMap.get(typeVehicule);
        if (permis == null)
            throw new IllegalArgumentException("Wrong vehicule type: " + typeVehicule);
        return permis;
    }
}

package org.moha.miniproject.services.permis;

import org.moha.miniproject.Repositories.PermisRepository;
import org.moha.miniproject.enteties.Permis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermisServiceImpl implements PermisService {
    @Autowired
    private PermisRepository permisRepository;

    @Override
    public Permis savePermis(Permis permis) {
        return permisRepository.save(permis);
    }

    @Override
    public void removePermis(Long idPermis) {
        permisRepository.deleteById(idPermis);
    }
}

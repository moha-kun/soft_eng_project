package org.moha.miniproject.services.permis;

import org.moha.miniproject.enteties.Permis;

public interface PermisService {
    Permis savePermis(Permis permis);

    void removePermis(Long idPermis);
}

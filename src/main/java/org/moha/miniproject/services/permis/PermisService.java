package org.moha.miniproject.services.permis;

import org.moha.miniproject.enteties.Permis;

public interface PermisService {
    public Permis savePermis(Permis permis);
    public void removePermis(Long idPermis);
}

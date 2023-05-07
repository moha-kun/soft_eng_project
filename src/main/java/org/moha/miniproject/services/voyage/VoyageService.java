package org.moha.miniproject.services.voyage;

import org.moha.miniproject.enteties.Voyage;

import java.util.List;

public interface VoyageService {
    public List<Voyage> getVoyages();
    public Voyage createVoyage(Voyage voyage);
    public Voyage getVoyageById(Long voyageId);

    public Voyage updateVoyage(Voyage voyage);

    public void deleteVoyage(Long voyageId);

}

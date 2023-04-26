package org.moha.miniproject.services.voyage;

import java.util.List;

import org.moha.miniproject.Repositories.VoyageRepository;
import org.moha.miniproject.enteties.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoyageServiceImp implements VoyageService {
  @Autowired
  private VoyageRepository voyageRepository;

  @Override
  public List<Voyage> getAllTrips() {
    return voyageRepository.findAll();
  }

  @Override
  public Voyage getTripById(Long tripId) {
    Voyage voyage = voyageRepository.findById(tripId).orElse(null);
    if (voyage == null)
      throw new RuntimeException("No trip with the given Id");
    return voyage;
  }

  @Override
  public Voyage saveTrip(Voyage voyage) {
    return voyageRepository.save(voyage);
  }

  @Override
  public void deleteTrip(Long tripId) {
    voyageRepository.deleteById(tripId);
  }
}

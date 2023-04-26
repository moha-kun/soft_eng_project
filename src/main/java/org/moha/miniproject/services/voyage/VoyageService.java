package org.moha.miniproject.services.voyage;

import java.util.List;

import org.moha.miniproject.enteties.Voyage;

public interface VoyageService {
  List<Voyage> getAllTrips();

  Voyage getTripById(Long tripId);

  Voyage saveTrip(Voyage voyage);

  void deleteTrip(Long tripId);
}

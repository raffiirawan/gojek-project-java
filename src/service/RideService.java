package service;

import model.User;
import model.Vehicle;

public class RideService {

    public double estimateFare(Vehicle vehicle, double distanceKm) {
        if (vehicle == null || distanceKm <= 0) {
            throw new IllegalArgumentException("Vehicle and distance must be provided");
        }
        return vehicle.calculateFare(distanceKm);
    }

    public boolean canAffordRide(User user, double fare) {
        return user != null && user.getSaldo() >= fare;
    }
}

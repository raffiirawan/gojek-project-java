package model;

public abstract class Vehicle {
    private final String name;
    private final double baseFare;
    private final double perKmRate;

    public Vehicle(String name, double baseFare, double perKmRate) {
        this.name = name;
        this.baseFare = baseFare;
        this.perKmRate = perKmRate;
    }

    public String getName() {
        return name;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double getPerKmRate() {
        return perKmRate;
    }

    public double calculateFare(double distanceKm) {
        return baseFare + (perKmRate * distanceKm);
    }
}

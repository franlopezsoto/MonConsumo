package com.example.monitoreoconsumodelhogar;

public class Device {
    private String name;
    private double powerConsumption; // Consumo en kW

    public Device(String name, double powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }

    public String getName() {
        return name;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }
}

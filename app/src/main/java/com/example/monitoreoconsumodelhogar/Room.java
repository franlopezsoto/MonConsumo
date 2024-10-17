package com.example.monitoreoconsumodelhogar;

import java.util.Random;

public class Room {
    private String name;
    private String type;
    private double totalConsumption;

    // Constructor que acepta tres parámetros
    public Room(String name, String type, double totalConsumption) {
        this.name = name;
        this.type = type;
        this.totalConsumption = totalConsumption;
    }
    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }
    private double generateRandomConsumption() {
        Random random = new Random();
        return 10 + (100 - 10) * random.nextDouble();  // Genera un valor entre 10 y 100 kWh
    }

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }
}

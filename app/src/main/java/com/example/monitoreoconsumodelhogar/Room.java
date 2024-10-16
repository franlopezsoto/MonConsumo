package com.example.monitoreoconsumodelhogar;

public class Room {
    private String name;
    private String type;
    private double totalConsumption;

    public Room(String name, String type, double totalConsumption) {
        this.name = name;
        this.type = type;
        this.totalConsumption = totalConsumption;
    }

    public String getName() {
        return name;
    }
    public double getConsumption() {
        return totalConsumption; // Devuelve el consumo total de la habitación
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

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }
}



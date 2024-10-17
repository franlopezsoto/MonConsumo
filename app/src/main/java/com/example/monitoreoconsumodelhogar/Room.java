package com.example.monitoreoconsumodelhogar;

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

    // Si quieres también un constructor que solo acepte dos parámetros
    public Room(String name, String type) {
        this.name = name;
        this.type = type;
        this.totalConsumption = 0.0; // Puedes inicializar el consumo a un valor por defecto
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

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }
}

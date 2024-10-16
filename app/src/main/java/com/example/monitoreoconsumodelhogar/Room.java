package com.example.monitoreoconsumodelhogar;

public class Room {
    private String name;
    private String type;
    private int consumption;

    public Room(String name, String type, int consumption) {
        this.name = name;
        this.type = type;
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getConsumption() {
        return consumption;
    }
}


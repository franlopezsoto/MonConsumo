package com.example.monitoreoconsumodelhogar;
import java.util.ArrayList;

public class Household {
    private ArrayList<Room> rooms;

    public Household() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public double getTotalConsumption() {
        double total = 0;
        for (Room room : rooms) {
            total += room.getTotalConsumption();
        }
        return total;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}

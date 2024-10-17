package com.example.monitoreoconsumodelhogar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class RoomListAdapter extends ArrayAdapter<Room> {

    private Context context;
    private int resource;
    private List<Room> roomList;

    public RoomListAdapter(Context context, int resource, List<Room> roomList) {
        super(context, resource, roomList);
        this.context = context;
        this.resource = resource;
        this.roomList = roomList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, null);

        Room room = roomList.get(position);

        // Nombre de la habitación
        TextView roomNameTextView = view.findViewById(R.id.roomNameTextView);
        roomNameTextView.setText(room.getName());

        // Tipo de habitación
        TextView roomTypeTextView = view.findViewById(R.id.roomTypeTextView);
        roomTypeTextView.setText(room.getType());

        // Consumo aleatorio para cada tipo de habitación
        double randomConsumption = generateRandomConsumption(room.getType());
        room.setTotalConsumption(randomConsumption);

        // Mostrar el consumo de la habitación
        TextView roomConsumptionTextView = view.findViewById(R.id.roomConsumptionTextView);
        roomConsumptionTextView.setText(String.format("%.2f kWh", randomConsumption));

        return view;
    }

    // Método para generar un consumo aleatorio según el tipo de habitación
    private double generateRandomConsumption(String roomType) {
        switch (roomType) {
            case "Cocina":
                return Math.random() * (5 - 3) + 3; // Rango de 3 a 5 kWh
            case "Sala de estar":
                return Math.random() * (4 - 2) + 2; // Rango de 2 a 4 kWh
            case "Dormitorio":
                return Math.random() * (2 - 1) + 1; // Rango de 1 a 2 kWh
            case "Baño":
                return Math.random() * (1 - 0.5) + 0.5; // Rango de 0.5 a 1 kWh
            default:
                return Math.random() * (3 - 1) + 1; // Rango de 1 a 3 kWh para otros
        }
    }
}

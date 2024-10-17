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
        // Obtener el layout inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, null);

        // Obtener los datos de la habitación actual
        Room room = roomList.get(position);

        // Asignar el nombre y tipo de la habitación al TextView
        TextView roomNameTextView = view.findViewById(R.id.roomNameTextView);
        roomNameTextView.setText(room.getName() + " - " + room.getType());

        // Asignar el consumo de la habitación al TextView
        TextView roomConsumptionTextView = view.findViewById(R.id.roomConsumptionTextView);
        roomConsumptionTextView.setText("Consumo: " + room.getTotalConsumption() + " kWh");

        // Devolver la vista para la fila actual
        return view;
    }
}

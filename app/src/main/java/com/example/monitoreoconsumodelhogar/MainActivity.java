package com.example.monitoreoconsumodelhogar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView roomListView;
    private DatabaseHelper databaseHelper;
    private TextView totalConsumptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa la base de datos
        databaseHelper = new DatabaseHelper(this);
        List<Room> roomList = databaseHelper.getAllRooms();

        // Inicializa las vistas
        roomListView = findViewById(R.id.roomListView);
        totalConsumptionView = findViewById(R.id.totalConsumptionView); // Muestra el consumo total

        // Si la lista no está vacía, asigna el adaptador al ListView
        if (roomList != null && !roomList.isEmpty()) {
            RoomListAdapter adapter = new RoomListAdapter(this, R.layout.room_item, roomList);
            roomListView.setAdapter(adapter);

            // Calcula y muestra el consumo total
            double totalConsumption = 0;
            for (Room room : roomList) {
                totalConsumption += room.getTotalConsumption();
            }
            totalConsumptionView.setText("Consumo Total: " + totalConsumption + " kWh");

        } else {
            // Si no hay datos, muestra un mensaje en el TextView
            totalConsumptionView.setText("No hay habitaciones guardadas.");
        }

        // Configura el botón para agregar una nueva habitación
        Button addRoomButton = findViewById(R.id.addRoomButton);
        addRoomButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RoomActivity.class);
            startActivity(intent);
        });
    }
}


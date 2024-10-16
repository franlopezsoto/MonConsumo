package com.example.monitoreoconsumodelhogar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class RoomActivity extends AppCompatActivity {

    private EditText roomNameEditText;
    private Spinner roomTypeSpinner;
    private Button saveButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        roomNameEditText = findViewById(R.id.roomNameEditText);
        roomTypeSpinner = findViewById(R.id.roomTypeSpinner);
        saveButton = findViewById(R.id.saveButton);
        databaseHelper = new DatabaseHelper(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.room_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomTypeSpinner.setAdapter(adapter);

        saveButton.setOnClickListener(v -> {
            String roomName = roomNameEditText.getText().toString();
            String roomType = roomTypeSpinner.getSelectedItem().toString();

            Room room = new Room(roomName, roomType, 0);
            databaseHelper.addRoom(room);
            finish();
        });
    }
}

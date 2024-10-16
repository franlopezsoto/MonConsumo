package com.example.monitoreoconsumodelhogar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "rooms.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ROOMS = "rooms";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_ROOMS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT, consumption INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        onCreate(db);
    }

    public void addRoom(Room room) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", room.getName());
        values.put("type", room.getType());
        values.put("consumption", room.getConsumption());
        db.insert(TABLE_ROOMS, null, values);
        db.close();
    }

    public List<Room> getAllRooms() {
        List<Room> roomList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ROOMS, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String type = cursor.getString(2);
                int consumption = cursor.getInt(3);
                roomList.add(new Room(name, type, consumption));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return roomList;
    }
}

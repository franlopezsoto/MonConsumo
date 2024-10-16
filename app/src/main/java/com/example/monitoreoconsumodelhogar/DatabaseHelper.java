package com.example.monitoreoconsumodelhogar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "household.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ROOMS = "rooms";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_CONSUMPTION = "totalConsumption";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ROOMS_TABLE = "CREATE TABLE " + TABLE_ROOMS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_TYPE + " TEXT,"
                + COLUMN_CONSUMPTION + " REAL" + ")";
        db.execSQL(CREATE_ROOMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        onCreate(db);
    }

    public void addRoom(Room room) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, room.getName());
        values.put(COLUMN_TYPE, room.getType());
        values.put(COLUMN_CONSUMPTION, room.getTotalConsumption());

        db.insert(TABLE_ROOMS, null, values);
        db.close();
    }

    public List<Room> getAllRooms() {
        List<Room> roomList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ROOMS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Room room = new Room(
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE)),
                        cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_CONSUMPTION))
                );

                roomList.add(room);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return roomList;
    }
}


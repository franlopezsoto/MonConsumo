package com.example.monitoreoconsumodelhogar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class EnergyMonitoringService extends Service {
    private Household household;
    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        household = new Household();
        handler = new Handler(Looper.getMainLooper());
        runnable = new Runnable() {
            @Override
            public void run() {
                // Simula la actualización del consumo energético cada 5 segundos
                double totalConsumption = household.getTotalConsumption();
                Toast.makeText(getApplicationContext(), "Consumo total: " + totalConsumption + " kW", Toast.LENGTH_SHORT).show();
                handler.postDelayed(this, 5000); // 5 segundos de retardo
            }
        };
        handler.post(runnable);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable); // Detener la simulación cuando el servicio se detenga
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

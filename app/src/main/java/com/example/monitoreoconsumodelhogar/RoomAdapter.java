package com.example.monitoreoconsumodelhogar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private List<Room> roomList;

    public RoomAdapter(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.roomNameTextView.setText(room.getName());
        holder.roomTypeTextView.setText("Tipo: " + room.getType());
        holder.roomConsumptionTextView.setText("Consumo: " + room.getTotalConsumption() + "W"); // Usa getTotalConsumption()
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView roomNameTextView;
        TextView roomTypeTextView;
        TextView roomConsumptionTextView;

        public RoomViewHolder(View itemView) {
            super(itemView);
            roomNameTextView = itemView.findViewById(R.id.roomNameTextView);
            roomTypeTextView = itemView.findViewById(R.id.roomTypeTextView);
            roomConsumptionTextView = itemView.findViewById(R.id.roomConsumptionTextView);
        }
    }
}

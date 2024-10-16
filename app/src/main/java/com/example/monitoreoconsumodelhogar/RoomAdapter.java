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

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.roomNameTextView.setText(room.getName());
        holder.roomConsumptionTextView.setText(String.format("Consumo: %s kWh", room.getConsumption()));
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView roomNameTextView;
        TextView roomConsumptionTextView;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            roomNameTextView = itemView.findViewById(R.id.roomNameTextView);
            roomConsumptionTextView = itemView.findViewById(R.id.roomConsumptionTextView);
        }
    }
}

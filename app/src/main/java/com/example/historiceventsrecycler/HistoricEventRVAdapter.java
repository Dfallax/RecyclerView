package com.example.historiceventsrecycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoricEventRVAdapter extends RecyclerView.Adapter<HistoricEventRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<HistoricEventModel> divisaEventModels;
    public static int posicionMarcada = -1;

    public HistoricEventRVAdapter(Context context, ArrayList<HistoricEventModel> historicEventModels) {
        this.context = context;
        this.divisaEventModels = historicEventModels;
    }

    @NonNull
    @Override
    public HistoricEventRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return new HistoricEventRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricEventRVAdapter.MyViewHolder holder, int position) {
    holder.tvName.setText(divisaEventModels.get(position).getEventName());
    holder.tvValor.setText(divisaEventModels.get(position).getEventValor());
    holder.tvIcon.setImageDrawable(divisaEventModels.get(position).getEventIcon());

    final int cardPosicion = position;
    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            posicionMarcada = cardPosicion;
            notifyDataSetChanged();

        }
    });
        if(posicionMarcada == position){
            holder.barra.setVisibility(View.VISIBLE);

        }else {
            holder.barra.setVisibility(View.INVISIBLE);

        }

    }

    @Override
    public int getItemCount() {
        return divisaEventModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvValor, barra;
        ImageView tvIcon;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cvDivisa);
            tvName = itemView.findViewById(R.id.tvEventName);
            tvValor = itemView.findViewById(R.id.tvEventPrecio);
            tvIcon = itemView.findViewById(R.id.tvEventIcon);
            barra = itemView.findViewById(R.id.barraSeleccion);
        }
    }
}

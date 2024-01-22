package com.example.divisasrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DivisaRVAdapter extends RecyclerView.Adapter<DivisaRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<DivisaModel> divisaModels;
    public static int posicionMarcada = -1;

    public DivisaRVAdapter(Context context, ArrayList<DivisaModel> divisaModels) {
        this.context = context;
        this.divisaModels = divisaModels;
    }

    @NonNull
    @Override
    public DivisaRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return new DivisaRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DivisaRVAdapter.MyViewHolder holder, int position) {
    holder.tvName.setText(divisaModels.get(position).getEventName());
    holder.tvValor.setText(divisaModels.get(position).getEventValor());
    holder.tvIcon.setImageDrawable(divisaModels.get(position).getEventIcon());

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
        return divisaModels.size();
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

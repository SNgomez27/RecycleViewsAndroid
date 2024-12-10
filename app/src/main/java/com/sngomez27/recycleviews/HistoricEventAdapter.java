package com.sngomez27.recycleviews;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class HistoricEventAdapter extends RecyclerView.Adapter<HistoricEventAdapter.MyViewHolder> {

    Context context;
    ArrayList<HistoricEventModel> historicEventModels;

    public HistoricEventAdapter(Context context, ArrayList<HistoricEventModel> historicEventModels ){
        this.historicEventModels = historicEventModels;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoricEventAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return  new  HistoricEventAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricEventAdapter.MyViewHolder holder, int position) {

    String eventName = historicEventModels.get(position).getEventName();
    String eventDate = historicEventModels.get(position).getEventDate();
    String eventLocation = historicEventModels.get(position).getEventLocation();





        holder.tvEventname.setText(historicEventModels.get(position).getEventName());
        holder.tvEventDate.setText(historicEventModels.get(position).getEventDate());
        holder.tvEventLocation.setText(historicEventModels.get(position).getEventLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                .setIcon(R.drawable.book_logo)
                        .setTitle(eventName)
                        .setMessage("estes evento sucedio en el año " + eventDate +".\n ¿Es correcto?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        ;
                materialAlertDialogBuilder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return historicEventModels.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tvEventname, tvEventDate, tvEventLocation;
        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            tvEventname = itemView.findViewById(R.id.EventName);
            tvEventDate = itemView.findViewById(R.id.EventDate);
            tvEventLocation = itemView.findViewById(R.id.EventLocation);
        }
    }
}

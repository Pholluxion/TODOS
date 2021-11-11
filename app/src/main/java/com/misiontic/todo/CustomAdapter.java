package com.misiontic.todo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList id,des,nombre;

    public CustomAdapter(Context context, ArrayList id, ArrayList des, ArrayList nombre) {

        this.context = context;
        this.id = id;
        this.des = des;
        this.nombre = nombre;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        holder.id_txt.setText(String.valueOf(this.id.get(position)));
        holder.des_txt.setText(String.valueOf(this.des.get(position)));
        holder.nombre_txt.setText(String.valueOf(this.nombre.get(position)));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("id",String.valueOf(id.get(position)));
                intent.putExtra("descripcion",String.valueOf(des.get(position)));
                intent.putExtra("precio",String.valueOf(precio.get(position)));
                context.startActivity(intent);*/

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.id.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt,nombre_txt,des_txt;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.id_txt = itemView.findViewById(R.id.id_txt);
            this.des_txt = itemView.findViewById(R.id.descripcion_txt);
            this.nombre_txt = itemView.findViewById(R.id.nombre_txt);
            this.linearLayout=itemView.findViewById(R.id.mainLayout);
        }
    }

}

package com.example.vasyerp_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_for_showData extends RecyclerView.Adapter<Adapter_for_showData.Myviewholder> {

    Context context;
    List<Datum>datumList;

    public Adapter_for_showData(Context context, List<Datum> datumList) {
        this.context = context;
        this.datumList = datumList;
    }

    @Override
    public Myviewholder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.layout_show_data,null,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder( Adapter_for_showData.Myviewholder holder, int position) {
    holder.First.setText(""+datumList.get(position).getFirst_name());
        Picasso.get().load(datumList.get(position).getAvatar()).into(holder.circularImageView);
        holder.last.setText(""+datumList.get(position).getLast_name());
        holder.id.setText(""+datumList.get(position).getId());
        holder.email.setText(""+datumList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        TextView First,last,id,email;
        CircularImageView circularImageView;
        public Myviewholder(View itemView) {
            super(itemView);
            First=itemView.findViewById(R.id.firstname);
            last=itemView.findViewById(R.id.lastname);
            id=itemView.findViewById(R.id.Id);
            email=itemView.findViewById(R.id.email);
            circularImageView=itemView.findViewById(R.id.avatar);
        }
    }
}

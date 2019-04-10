package com.kotrots.example.menus_example;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<List> lists;

    public ListAdapter(Context context, ArrayList<List> lists){
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row  = inflater.inflate(R.layout.lists_item_layout, viewGroup, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        ((Item)viewHolder).txtVw_id.setText(String.valueOf(lists.get(i).getId()));
        ((Item)viewHolder).txtVw_title.setText(lists.get(i).getTitle());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ((Item)viewHolder).txtVw_id.getText().toString();
                Intent intent = new Intent(context, ItemListAct.class);
                intent.putExtra("id", id);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class Item extends RecyclerView.ViewHolder {
        TextView txtVw_title;
        TextView txtVw_id;
        public Item(View itemView) {
            super(itemView);
            txtVw_title = itemView.findViewById(R.id.txtVw_title);
            txtVw_id = itemView.findViewById(R.id.txtVw_id);
        }
    }
}

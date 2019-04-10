package com.kotrots.example.menus_example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<ItemList> itemsls;


    public ItemAdapter(Context context, ArrayList<ItemList> itemsls){
        this.context = context;
        this.itemsls = itemsls;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row  = inflater.inflate(R.layout.items_layout, viewGroup, false);
        ItemAdapter.Item itemsls = new ItemAdapter.Item(row);
        return itemsls;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Item {
        public Item(View view) {

        }
    }
}

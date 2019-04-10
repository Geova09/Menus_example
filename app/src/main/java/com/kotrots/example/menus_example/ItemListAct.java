package com.kotrots.example.menus_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemListAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);


        TextView textView = findViewById(R.id.txtVw_idList);
        String id = getIntent().getExtras().getString("id");
        textView.setText(id);

    }
}

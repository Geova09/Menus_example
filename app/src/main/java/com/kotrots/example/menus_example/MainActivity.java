package com.kotrots.example.menus_example;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcl_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Shopping Lists");
        setSupportActionBar(toolbar);

        rcl_view = findViewById(R.id.rcl_view);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.dialog_layout);

                final EditText edTxt_dialog = dialog.findViewById(R.id.editTextList);
                Button btn_dialog = dialog.findViewById(R.id.btn_addList);

                btn_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title = edTxt_dialog.getText().toString();
                        DataSource dataSource = new DataSource(MainActivity.this);
                        dataSource.open();
                        dataSource.insertList(title);
                        dataSource.close();

                        dialog.cancel();
                        updateList();

                    }
                });


                Snackbar.make(view, "Create new list", Snackbar.LENGTH_LONG)
                        .setAction("Click here", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.create();
                                dialog.show();
                            }
                        }).show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:

                Intent intent = new Intent(MainActivity.this, AboutAct.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_about:

                break;

            case R.id.item_edit:
                Log.d("CONTEXT", "edit");
                break;
        }
        return super.onContextItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();


    }
    private void updateList() {
        DataSource dataSource = new DataSource(MainActivity.this);
        dataSource.open();
        ArrayList<List> lists = dataSource.selectAllLists();
        dataSource.close();

        rcl_view.setLayoutManager(new LinearLayoutManager(this));

        rcl_view.setAdapter(new ListAdapter(MainActivity.this, lists));
    }
}

package com.hermawan.heri.training2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hermawan.heri.training2.databinding.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddDialogListener, Toolbar.OnMenuItemClickListener {

    Adapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initList();
    }

    private void initList() {
        adapter = new Adapter(new ArrayList<Todo>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.binding.recyclerviewTask.setLayoutManager(layoutManager);
        this.binding.recyclerviewTask.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.action_add:
                add();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override
    public void onAdd(String name, boolean isDone) {
        adapter.add(new Todo(name, isDone));
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.action_add:
                add();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void add() {
        AddDialog dialog = new AddDialog(this);
        dialog.show();
    }

}

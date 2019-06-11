package com.hermawan.heri.training2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hermawan.heri.training2.databinding.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Adapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.addBtn.setOnClickListener(this);
        initList();
    }

    private void initList() {
        adapter = new Adapter(new ArrayList<Todo>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        this.binding.recyclerviewTask.setLayoutManager(layoutManager);
        this.binding.recyclerviewTask.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_btn){
            adapter.add(new Todo(binding.taskEdit.getText().toString(), binding.done.isChecked()));
            binding.taskEdit.setText("");
        }
    }
}

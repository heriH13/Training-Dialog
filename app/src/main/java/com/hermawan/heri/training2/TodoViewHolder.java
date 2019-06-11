package com.hermawan.heri.training2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.hermawan.heri.training2.databinding.*;

public class TodoViewHolder extends RecyclerView.ViewHolder {

    private ItemTodoBinding binding;

    public TodoViewHolder(@NonNull ItemTodoBinding binding){
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bind(Todo todo){
        binding.setTodo(todo);
    }
}

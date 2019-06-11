package com.hermawan.heri.training2;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.hermawan.heri.training2.databinding.*;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Todo> todos;

    public Adapter(List<Todo> todos){
        this.todos = todos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == 1){
            ItemTodoDoneBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                    R.layout.item_todo_done, viewGroup, false);
            return new DoneViewHolder(binding);
        }else{
            ItemTodoBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                    R.layout.item_todo, viewGroup, false);
            return new TodoViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()){
            case 1:
                DoneViewHolder doneViewHolder = (DoneViewHolder) viewHolder;
                doneViewHolder.bind(todos.get(position));
                break;
            default:
                TodoViewHolder todoViewHolder = (TodoViewHolder) viewHolder;
                todoViewHolder.bind(todos.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    @Override
    public int getItemViewType(int position){
        return todos.get(position).isDone() ? 1 : 0;
    }

    public void add(Todo todo){
        todos.add(todo);
        notifyItemInserted(todos.size()-1);
    }
}

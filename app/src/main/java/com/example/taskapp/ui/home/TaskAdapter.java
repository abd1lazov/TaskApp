package com.example.taskapp.ui.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.taskapp.R;
import com.example.taskapp.ui.models.Task;

import java.util.LinkedList;
import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> list = new LinkedList<>();

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext(),R.style.MyDialogTheme);
                builder.setMessage("Вы точно хотите удалить?");
                builder.setPositiveButton("Да точно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        list.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Нет, я прередумал", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addItem(Task task){
        list.add(task);
        notifyItemInserted(list.indexOf(task));
    }
    public void addItems(List<Task>list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
        }

        public void bind(Task task) {
            textTitle.setText(task.getTitle());
        }
    }
}

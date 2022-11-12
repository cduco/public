package com.android.roomdbinjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.roomdbinjava.db.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        //Toast.makeText(context.getApplicationContext(), fnameList.get(2), Toast.LENGTH_LONG).show();
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        holder.tvFirstName.setText(this.userList.get(position).itemName);
        Integer cat = this.userList.get(position).amount;
        holder.tvLastName.setText(cat.toString());
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;

        public MyViewHolder(View view) {
            super(view);
             tvFirstName = view.findViewById(R.id.tvFirstName);
             tvLastName = view.findViewById(R.id.tvLastName);

        }
    }
}

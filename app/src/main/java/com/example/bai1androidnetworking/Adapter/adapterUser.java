package com.example.bai1androidnetworking.Adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bai1androidnetworking.Class.User;
import com.example.bai1androidnetworking.R;

import java.util.List;

public class adapterUser extends RecyclerView.Adapter<adapterUser.UserViewHolder> {
    private List<User> userList;

    public adapterUser(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView phoneTextView;
        private TextView ageTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
        }

        public void bind(User user) {
            nameTextView.setText(user.getName());
            phoneTextView.setText(user.getPhone());
            ageTextView.setText(String.valueOf(user.getAge() + ""));
        }
    }
}


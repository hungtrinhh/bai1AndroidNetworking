package com.example.bai1androidnetworking.Adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bai1androidnetworking.APICaller;
import com.example.bai1androidnetworking.Class.User;
import com.example.bai1androidnetworking.Interface.Callapi;
import com.example.bai1androidnetworking.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adapterUser extends RecyclerView.Adapter<adapterUser.UserViewHolder> {
    private List<User> userList;
    private OnBtnDeleteClick onBtnDeleteClick;

    public adapterUser(List<User> userList) {
        this.userList = userList;
    }

    public void setBtnDeleteClick(OnBtnDeleteClick onBtnDeleteClick) {
        this.onBtnDeleteClick = onBtnDeleteClick;

    }


    public void setList(List<User> userList) {
        this.userList = userList;
        notifyAll();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view, onBtnDeleteClick);
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

        private Button editButton;
        private Button deleteButton;
        OnBtnDeleteClick onBtnDeleteClick;

        public UserViewHolder(@NonNull View itemView, final OnBtnDeleteClick onBtnDeleteClick) {
            super(itemView);
            this.onBtnDeleteClick = onBtnDeleteClick;
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
            editButton = (Button) itemView.findViewById(R.id.editButton);
            deleteButton = (Button) itemView.findViewById(R.id.deleteButton);
        }

        public void bind(User user) {
            nameTextView.setText("Name : " + user.getName());
            phoneTextView.setText("Phone :" + user.getPhone());
            ageTextView.setText(String.valueOf("Age :" + user.getAge() + ""));

            deleteButton.setOnClickListener(v -> {


                AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                builder.setTitle("Confirm Delete");
                builder.setMessage("Are you sure you want to delete this item?");
                builder.setPositiveButton("Delete", (dialog, which) -> {
                    onBtnDeleteClick.onclick(user.getId());

                });
                builder.setNegativeButton("Cancel", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            });

        }
    }

    public interface OnBtnDeleteClick {
        void onclick(String id);

    }

    public interface OnBtnEditClick {
        void onclick(User user);

    }
}


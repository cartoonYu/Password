package com.example.cartoon.passwordmanager.util.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cartoon.passwordmanager.Password.Details.PasswordDetails;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.data.TablePassword.Password;

import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    private List<Password> passwords;
    private Context context;
    public MainAdapter(Context context,List<Password> passwords){
        this.context=context;
        this.passwords = passwords;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(View convertView) {
            super(convertView);
            name = (TextView) convertView.findViewById(R.id.mainPasswordDescription);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mainpassword_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Activity activity=(Activity)parent.getContext();
                Intent intent=new Intent(parent.getContext(), PasswordDetails.class);
                intent.putExtra("data",passwords.get(position));
                activity.startActivity(intent);
                activity.finish();
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Password password = passwords.get(position);
        holder.name.setText(password.getName());
    }
    @Override
    public int getItemCount(){
        return passwords.size();
    }
}

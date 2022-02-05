package com.example.m2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.m2.DBHelper.TABLE_NAME;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<RecyclerItem> listItems;
    private Context mContext;

    public MyAdapter(List<RecyclerItem> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        //        return null;
        return  new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final RecyclerItem item = listItems.get(position);
        holder.txtWorkName.setText(item.getName_work());
        holder.txtFio.setText(item.getFio());
        holder.txtEmail.setText(item.getEmail());
        holder.txtPhone.setText(item.getPhone());
        holder.txtStatus.setText(getStatusRu(item.getStatus()));
        holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, holder.txtOptionDigit);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mnu_item_save:
                                Toast.makeText(mContext,"Saved", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.mnu_item_dell:
                                //delete item;
                                // ListActivity.
                                listItems.remove(position);

//Lideleted
                                notifyDataSetChanged();
                                Toast.makeText(mContext,"Deleted", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.mnu_item_open:
                                //open item;

                                Toast.makeText(mContext,"OPEN", Toast.LENGTH_SHORT).show();
                                //Intent intent = new Intent(ListActivity, UpdateRquest.class);
                                //startActivity(intent);
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private String getStatusRu(String stengl) {
        String res= "Ошибка статуса 1";//s1.equals(s2)
        if (stengl.equals("shipped")) res="Отправлено";
        else if (stengl.equals("draft")) res="Черновик";
        return res;

    }
    @Override
    public int getItemCount() {
        return listItems.size();
        //return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtWorkName;
        public TextView txtFio;
        public TextView txtPhone;
        public TextView txtEmail;
        public TextView txtUrlFile;
        public  TextView txtOptionDigit;
        public TextView txtStatus;


        public ViewHolder(View itemView) {
            super(itemView);
            txtWorkName = (TextView) itemView.findViewById(R.id.tw_work_name);
            txtFio = (TextView) itemView.findViewById(R.id.tw_fio);
            txtPhone = (TextView) itemView.findViewById(R.id.tw_tel);
            txtEmail = (TextView) itemView.findViewById(R.id.tw_email);
            txtOptionDigit= (TextView) itemView.findViewById(R.id.tw_optionDigit);
            txtStatus = (TextView) itemView.findViewById(R.id.tw_status);
            // txtUrlFile = itemView.findViewById(R.id.tw_);


        }
    }
}

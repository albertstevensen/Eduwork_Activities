package com.example.a2301961632;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class manageAdapter extends ArrayAdapter<imagesManage> {
    Context mcTx;
    int resourcesM;
    List<imagesManage> manageList;
    public manageAdapter(Context mcTx, int resoucesM, List<imagesManage> manageList){
        super(mcTx, resoucesM, manageList);

        this.mcTx = mcTx;
        this.resourcesM = resoucesM;
        this.manageList = manageList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup Parent){
        LayoutInflater inflater = LayoutInflater.from(mcTx);
        View manageRows = inflater.inflate(resourcesM, null);

        TextView manageTitle = manageRows.findViewById(R.id.judulManage);
        TextView manageDescription = manageRows.findViewById(R.id.deskripsiManage);
        ImageView imagesManages = manageRows.findViewById(R.id.imageViewMana);

        imagesManage imageSS = manageList.get(position);

        manageTitle.setText(imageSS.getTitleManage());
        manageDescription.setText(imageSS.getDescriptionManage());
        imagesManages.setImageDrawable(mcTx.getResources().getDrawable(imageSS.getImageManage()));

        manageRows.findViewById(R.id.deleteManage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manageList.remove(position);
                notifyDataSetChanged();
            }
        });
        manageRows.findViewById(R.id.updateManage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), update_activity.class);
                String titleUpdate = manageTitle.getText().toString();
                intent.putExtra("title", titleUpdate);
                mcTx.startActivity(intent);
            }
        });

    return manageRows;
    }

}

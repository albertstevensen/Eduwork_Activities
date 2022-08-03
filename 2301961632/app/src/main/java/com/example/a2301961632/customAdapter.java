package com.example.a2301961632;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class customAdapter extends ArrayAdapter<imageData> {

    Context mCtx;
    int resource;
    List<imageData> arrayList;

    public customAdapter(Context mCtx, int resource, List<imageData> arrayList){
        super(mCtx, resource, arrayList);

        this.mCtx = mCtx;
        this.resource = resource;
        this.arrayList = arrayList;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View imageRows = inflater.inflate(resource, null);

        TextView imageTitle = imageRows.findViewById(R.id.imagetitleHome);
        TextView imageDescription = imageRows.findViewById(R.id.descriptionHome);
        ImageView imageHome =imageRows.findViewById(R.id.imageviewHome);

        imageData imageS = arrayList.get(position);

        imageTitle.setText(imageS.getTitle());
        imageDescription.setText(imageS.getDescription());
        imageHome.setImageDrawable(mCtx.getResources().getDrawable(imageS.getImages()));

        return imageRows;
    }
}

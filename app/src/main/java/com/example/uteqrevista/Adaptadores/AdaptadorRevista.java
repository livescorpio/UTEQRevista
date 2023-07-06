package com.example.uteqrevista.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.uteqrevista.Modelos.Revista;
import com.example.uteqrevista.R;

import java.util.ArrayList;

public class AdaptadorRevista extends ArrayAdapter<Revista> {
    public AdaptadorRevista(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.lyitemrevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);

        TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombres());
        TextView lblabreviacion = (TextView) item.findViewById(R.id.lblEmail);
        lblabreviacion.setText(getItem(position).getAbreviacion());
        ImageView imageView = (ImageView) item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);


        return (item);
    }

    }

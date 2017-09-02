package com.example.choche.guia3;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Choche on 2/9/2017.
 */

public class AdaptadorContacto extends ArrayAdapter<Contacto> {
    public AdaptadorContacto(@NonNull Context context, @NonNull List<Contacto> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obteniendo el dato
        Contacto contacto = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contacto, parent, false);
        }
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblNumero = (TextView) convertView.findViewById(R.id.lblNumero);
        // mostrar los datos
        lblNombre.setText(contacto.nombre);
        lblNumero.setText(contacto.numero);
        // Return la convertView ya con los datos

        return convertView;
    }
}

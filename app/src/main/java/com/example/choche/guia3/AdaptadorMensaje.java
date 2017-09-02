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

public class AdaptadorMensaje extends ArrayAdapter<Mensaje> {
    public AdaptadorMensaje(@NonNull Context context, @NonNull List<Mensaje> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obteniendo el dato
        Mensaje mensaje = getItem(position);

        //TODO inicializando el layout correspondiente al item (Mensaje)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView lblContenido = (TextView) convertView.findViewById(R.id.lblMensaje);
        TextView lblFechaHora = (TextView) convertView.findViewById(R.id.lblFechaHora);
        // mostrar los datos
        lblContenido.setText(mensaje.getContenido());
        lblFechaHora.setText(mensaje.getFecha());

        return convertView;
    }
}

package com.example.choche.guia3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MensajeActivity extends AppCompatActivity {

    private AdaptadorMensaje adaptadorMensaje;
    private Button btnEnviar;
    private ArrayList<Mensaje> mensajesArrayList;
    private EditText txbMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        btnEnviar=(Button) findViewById(R.id.btnEnviar);
        txbMensaje=(EditText) findViewById(R.id.txtEntrada);

        mensajesArrayList=new ArrayList<>();
        //Inicializando el adaptador
        adaptadorMensaje = new AdaptadorMensaje(this,  mensajesArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txbMensaje.getText().length()>0){
                    Calendar cal=new GregorianCalendar();
                    Date fecha=cal.getTime();
                    SimpleDateFormat df=new SimpleDateFormat("EE, d MMM yyyy, HH:mm");
                    String fecha_=df.format(fecha);
                    Mensaje mensaje=new Mensaje(fecha_,txbMensaje.getText().toString());
                    mensajesArrayList.add(mensaje);
                    adaptadorMensaje.notifyDataSetChanged();
                    txbMensaje.setText(" ");
                }else{
                    Toast.makeText(MensajeActivity.this,"Escriba un mensaje",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

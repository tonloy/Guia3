package com.example.choche.guia3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    //variable que me dice el estado
    public static int GUARDADO=47;//puede ser un numero cualquiera

    private AdaptadorContacto adaptadorContacto;
    private FloatingActionButton btnAgregar;
    private ArrayList<Contacto> contactosArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnAgregar  = (FloatingActionButton) findViewById(R.id.btnAgregar);

        contactosArrayList = new ArrayList<>();
        //Inicializando el adaptador
        adaptadorContacto = new AdaptadorContacto(this,  contactosArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstContactos);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorContacto);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //preparo el activity
                Intent intent = new Intent(Principal.this,ContactoActivity.class);
                //inicio el activitiy y quiero como mensaje un RESULT_OK
                startActivityForResult(intent,GUARDADO);
            }
        });

        //cuando de click sobre un item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO cuando toco un contacto muestro un mensaje
                Intent mensajes=new Intent(Principal.this,MensajeActivity.class);
                startActivity(mensajes);
                //startActivity(new Intent(MainActivity.this,MensajeActivity.class));
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GUARDADO){
            if(data==null) return;
            //recibo los datos
            Contacto c = new Contacto(
                    data.getStringExtra("NOMBRE"),
                    data.getStringExtra("NUMERO")
            );
            //TODO agrego a la lista y luego actualizo el adaptador, de lo contrario no se mostraria el cambio
            contactosArrayList.add(c);
            adaptadorContacto.notifyDataSetChanged();
        }
    }
}

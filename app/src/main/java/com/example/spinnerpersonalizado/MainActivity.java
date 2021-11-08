package com.example.spinnerpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String [] nombre = {"Real Valladolid", "Real Madrid", "Villarreal"};
    int [] escudos = {R.drawable.valladolid, R.drawable.madrid, R.drawable.villareal};
    EditText txtUsuario;
    EditText txtContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner sp = (Spinner) findViewById(R.id.spinner);

        AdaptadorPerso a = new AdaptadorPerso(this, R.layout.linea, nombre);

        sp.setAdapter(a);

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContra = (EditText) findViewById(R.id.txtPass);

        Button boton = (Button) findViewById(R.id.boton);


    }

    @Override
    public void onClick(View v) {

    }


    public class AdaptadorPerso extends ArrayAdapter<String> {

            public AdaptadorPerso(Context contexto, int txtViewResourceId, String[] objects) {
                super(contexto, txtViewResourceId, objects);
            }

            @Override
            public View getDropDownView(int posicion, View ViewConvertida, ViewGroup padre) {
                return crearFilaPersonalizada(posicion, ViewConvertida, padre);
            }

            @Override
            public View getView(int posicion, View ViewConvertida, ViewGroup padre) {
                return crearFilaPersonalizada(posicion, ViewConvertida, padre);
            }

            public View crearFilaPersonalizada(int posicion, View viewConvertida, ViewGroup padre) {
                LayoutInflater inflador = getLayoutInflater();

                View miFila = inflador.inflate(R.layout.linea, padre, false);

                TextView tnombre = (TextView) findViewById(R.id.nombretxt);
                tnombre.setText(nombre[posicion]);

                ImageView escudo = (ImageView) findViewById(R.id.imageView);
                escudo.setImageResource(escudos[posicion]);

                return miFila;

            }

        }


}
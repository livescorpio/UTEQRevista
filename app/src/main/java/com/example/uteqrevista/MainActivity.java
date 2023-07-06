package com.example.uteqrevista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.uteqrevista.Adaptadores.AdaptadorRevista;
import com.example.uteqrevista.Modelos.Revista;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {
ListView listaOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaOpciones= (ListView) findViewById(R.id.lvLista);
        View header = getLayoutInflater().inflate(R.layout.lyheaderrevista, null);
        listaOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");


    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray= new JSONArray(result);
        ArrayList<Revista> lstUsuarios = Revista.JsonObjectsBuild(jsonArray);
        AdaptadorRevista adaptadorRevista = new AdaptadorRevista(this, lstUsuarios);
        listaOpciones.setAdapter(adaptadorRevista);
    }
}
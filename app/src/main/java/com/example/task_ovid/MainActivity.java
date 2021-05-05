package com.example.task_ovid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task_ovid.menu.MenuNavigation;
import com.example.task_ovid.stats.Monedas;
import com.example.task_ovid.stats.Nivel;
import com.example.task_ovid.stats.Resistencia;
import com.example.task_ovid.stats.Vida;

import java.util.ArrayList;

/*
Esta clase se esncarga de mostrar la pantalla principal del juego, mostrar y gestionar la lista de tareas y gestionar los medidores de vida,
resistencia y experiencia. Además, gestiona el contador de monedas.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    private ArrayList<String> tareas;
    private ArrayAdapter<String> tareasAdapter;
    public  ImageView fotoPerfil;

    public MainActivity() {

    }

    public  ImageView getFotoPerfil() {
        return fotoPerfil;
    }

    public  void setFotoPerfil(ImageView fotoPerfil) {
       this.fotoPerfil=fotoPerfil;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Monedas.init(this);
        Nivel.init(this);
        Resistencia.init();
        Vida.init(this);

        setContentView(R.layout.activity_pantallaprincipal);
        lista = findViewById(R.id.lista);
        this.tareas = new ArrayList<>();
        llenarTareas();
        tareasAdapter = new ArrayAdapter(this, R.layout.rowtext, tareas);
        lista.setAdapter(tareasAdapter);
        lista.setOnItemClickListener(this);
        fotoPerfil=(ImageView) findViewById(R.id.imageView);;
        int valor=0 ;
        try {
             valor = getIntent().getExtras().getInt("fotoPerfil");
             fotoPerfil.setImageResource(valor);
        } catch (Exception e){

        }
    }

    private void llenarTareas(){ //este método es para rellenar las listas, el 0 simboliza el contador
        tareas.add("*** Ponerse la segunda dosis 0");
        tareas.add("** Ponerse la vacuna 0");
        tareas.add("* Hacer PCR 0");
        tareas.add("+ salir con mascarilla 0");
        tareas.add("+ lavarse las manos 0");
        tareas.add("+ desinfectarse 0");
        tareas.add("+ evitar aglomeraciones 0");
        tareas.add("+ quedarse en casa 0");
        tareas.add("- olvidarse la mascarilla 0");
        tareas.add("- Llegar a casa y no lavarme las manos 0");
        tareas.add("- Frotarme los ojos o llevarme las manos a la boca en la calle 0");
        tareas.add("- Estar con mis amigos sin mascarilla 0");
        tareas.add("- Salir de fiesta 0");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String t = parent.getItemAtPosition(position).toString();
        //divide el string para poder cambiar el contador
        String[] parts = t.split(" ");
        //incrementar el contador y actualizar el string
        int cont = Integer.parseInt(parts[parts.length-1]) + 1;
        parts[parts.length-1] = String.valueOf(cont);
        //une el string de nuevo para colocarlo en la lista
        String string = "";
        for (int i = 0; i <= parts.length-1; i++){
            if (i == 0){
                string = parts[i];
            }else{
                string = string + " "+parts[i];
            }
        }
        //actualiza la lista
        tareas.set(position,string);
        tareasAdapter.notifyDataSetChanged();

        if (t.contains("-")){
            Vida.decrementarVida();
            if (Vida.getVidaActual()<=0){
                Toast.makeText(this.getApplicationContext(), "Con estos habitos te vas a contagiar ;(", Toast.LENGTH_LONG).show();
            }
        }else{
            if(Nivel.incrementarExperiencia(t.contains("*"),t.contains("**"),t.contains("***")))
                Monedas.incrementarMonedas(100);
        }
    }

    public TextView getVistaMonedas(){
        return  (TextView)findViewById(R.id.monedasActuales);
    }

    public TextView getVistaNivel(){
        return  (TextView)findViewById(R.id.NombreNivel);
    }

    public ProgressBar getBarraExperiencia(){
        return (ProgressBar)findViewById(R.id.Experiencia);
    }

    public ProgressBar getBarraVida(){
        return (ProgressBar)findViewById(R.id.Vida);
    }

    //Método que permite abrir(inflar) el menú desplegable de la parte superior
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //Método que controla la navegación entre páginas usando el menú superior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuNavigation.navigate(item, this);
        return super.onOptionsItemSelected(item);
    }
}
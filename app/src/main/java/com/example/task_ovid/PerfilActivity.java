package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
/*
Esta clase se encarga de mostrar la pantalla de perfil y de permitirnos cambiar de avatar.
 */
public class PerfilActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

private ImageView imagenPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        /*
        Seteando el adaptador al GridView
        El GridView muestra por pantalla los diferentes personajes/avatares a elegir mediante
        la clase ImageAdapter.
         */
        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter(this));

        /*
        Creando una nueva escucha para los elementos del Grid
         */
        gridview.setOnItemClickListener(this);


            };

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
            int id = item.getItemId();
            if(R.id.main==id) {
                Intent intent= new Intent(this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }else if (R.id.Perfil==id) {
                Intent intent = new Intent(this, PerfilActivity.class);
                startActivity(intent);
            }else if (R.id.Tienda== id) {
                Intent intent= new Intent(this,TiendaBeta.class);
                startActivity(intent);
            }else if (R.id.menuAyuda == id) {
                Intent intent= new Intent(this,menuAyuda.class);
                startActivity(intent);
            }else if(R.id.Salir==id) {
                finishAffinity();
            }

            return super.onOptionsItemSelected(item);

        }


    //Método que se encarga de establecer el avatar que vamos a usar al pulsar sobre él
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      ImageAdapter adapter = new ImageAdapter(this);
      MainActivity x= new MainActivity();
      Integer iden= adapter.getThumbId(position);
      Intent i = new Intent(this,MainActivity.class);
      i.putExtra("fotoPerfil", iden);
      startActivity(i);
    }
}
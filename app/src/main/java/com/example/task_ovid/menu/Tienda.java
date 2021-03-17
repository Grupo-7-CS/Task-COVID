package com.example.task_ovid.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.task_ovid.MainActivity;
import com.example.task_ovid.R;
import com.example.task_ovid.TiendaBeta;

public class Tienda implements Option {

    @Override
    public boolean selectOption(MenuItem item) {
        return item.getItemId() == R.id.Tienda;
    }

    @Override
    public void executeOption(Activity context) {
        Intent intent= new Intent(context, TiendaBeta.class);
        context.startActivity(intent);
    }
}

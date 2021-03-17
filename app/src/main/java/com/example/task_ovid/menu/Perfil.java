package com.example.task_ovid.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.task_ovid.MainActivity;
import com.example.task_ovid.PerfilActivity;
import com.example.task_ovid.R;

public class Perfil implements Option {

    @Override
    public boolean selectOption(MenuItem item) {
        return item.getItemId() == R.id.Perfil;
    }

    @Override
    public void executeOption(Activity context) {
        Intent intent= new Intent(context, PerfilActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivityIfNeeded(intent, 0);
    }
}

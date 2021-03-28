package com.example.task_ovid.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.task_ovid.MainActivity;
import com.example.task_ovid.R;

public class Salir implements Option {

    @Override
    public boolean selectOption(MenuItem item) {
        return item.getItemId() == R.id.Salir;
    }

    @Override
    public void executeOption(Activity context) {
        context.finishAffinity();
    }
}

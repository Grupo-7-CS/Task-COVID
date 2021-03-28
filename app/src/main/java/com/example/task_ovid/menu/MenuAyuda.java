package com.example.task_ovid.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.task_ovid.MainActivity;
import com.example.task_ovid.R;
import com.example.task_ovid.menuAyuda;

public class MenuAyuda implements Option {

    @Override
    public boolean selectOption(MenuItem item) {
        return item.getItemId() == R.id.menuAyuda;
    }

    @Override
    public void executeOption(Activity context) {
        Intent intent= new Intent(context, menuAyuda.class);
        context.startActivity(intent);
    }
}

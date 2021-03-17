package com.example.task_ovid.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.task_ovid.MainActivity;
import com.example.task_ovid.R;

public class Main implements Option {

    @Override
    public boolean selectOption(MenuItem item) {
        return item.getItemId() == R.id.main;
    }

    @Override
    public void executeOption(Activity context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivityIfNeeded(intent, 0);
    }
}

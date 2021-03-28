package com.example.task_ovid.menu;

import android.app.Activity;
import android.view.MenuItem;

public interface Option {

    void executeOption(Activity context);

    boolean selectOption(MenuItem item);

}

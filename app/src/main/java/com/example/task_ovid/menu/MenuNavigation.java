package com.example.task_ovid.menu;

import android.app.Activity;
import android.view.MenuItem;

public class MenuNavigation {

    private Option[] options;

    public MenuNavigation() {
        this.options = new Option[]{new Main(), new MenuAyuda(), new Perfil(), new Salir(), new Tienda()};
    }

    public void navigate(MenuItem item, Activity context) {
        for (Option option: options) {
            if (option.selectOption(item))
                option.executeOption(context);
        }
    }

}

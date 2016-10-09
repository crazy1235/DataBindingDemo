package com.jacksen.databindingdemo;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Admin on 2016/10/9.
 */

public class MyHandlers {

    public void onClick(View view) {
        Toast.makeText(view.getContext(), "clicked", Toast.LENGTH_SHORT).show();
    }
}

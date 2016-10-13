package com.jacksen.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jacksen.databindingdemo.databinding.MainBinding;
import com.jacksen.databindingdemo.gallery.GalleryActivity;


public class MainActivity extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        binding.setIsShow(flag);
//        flag = !flag;

        binding.testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.setIsShow(flag);
                flag = !flag;

                //
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });

        binding.setText("");

    }
}

package com.jacksen.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jacksen.databindingdemo.chat.ChatActivity;
import com.jacksen.databindingdemo.databinding.MainBinding;
import com.jacksen.databindingdemo.gallery.GalleryActivity;

/**
 * @author jacksen
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setOnClick(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.base_config_btn:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.include_config_btn:
                startActivity(new Intent(MainActivity.this, IncludeActivity.class));
                break;
            case R.id.expression_btn:
                startActivity(new Intent(MainActivity.this, CollectionActivity.class));
                break;
            case R.id.list_view_btn:
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;
            case R.id.recycler_view1_btn:
                startActivity(new Intent(MainActivity.this, ChatActivity.class));
                break;
            case R.id.recycler_view2_btn:
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
                break;
            default:
                break;
        }
    }
}

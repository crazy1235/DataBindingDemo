package com.jacksen.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jacksen.databindingdemo.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.textView.setText("请填写登录信息");

        User user = new User("18601013413", "yansen", "12345");
        binding.setUser(user);

        binding.setHandlers(new MyHandlers());


        binding.setMyClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "reset button has been clicked", Toast.LENGTH_SHORT).show();
            }
        });

        binding.exitBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(LoginActivity.this, "长按exit Button", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        binding.setMyClick(this);

        //自定义属性
        binding.setGender("male");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first_btn:
                startActivity(new Intent(LoginActivity.this, CollectionActivity.class));
                break;
            case R.id.second_btn:
                startActivity(new Intent(LoginActivity.this, ListViewActivity.class));
                break;
            case R.id.third_btn:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}

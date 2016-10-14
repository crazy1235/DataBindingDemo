package com.jacksen.databindingdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jacksen.databindingdemo.databinding.ActivityLoginBinding;

/**
 * 基本应用
 *
 * @author jacksen
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
//        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());

        User user = new User("1234567890", "jacksen", "12345");
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
                Toast.makeText(LoginActivity.this, "长按了exit Button", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        binding.setLoginTitle("请填写登录信息");
    }

}

package com.jacksen.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jacksen.databindingdemo.databinding.ActivityListViewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * ListView的使用
 *
 * @author jacksen
 */
public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_view);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("用户" + i);
            user.setIconUrl("http://avatar.csdn.net/0/1/6/1_crazy1235.jpg");
            user.setVip(true);
            users.add(user);
        }

        CommonAdapter<User> adapter = new CommonAdapter<>(this, users, R.layout.item_list_view, BR.user);
        binding.setAdapter(adapter);
    }
}

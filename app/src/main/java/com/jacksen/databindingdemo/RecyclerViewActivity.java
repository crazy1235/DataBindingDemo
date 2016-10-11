package com.jacksen.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jacksen.databindingdemo.chat.Message;
import com.jacksen.databindingdemo.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * recyclerView
 *
 * @author jacksen
 */
public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        List<Message> messages = new ArrayList<>();

        messages.add(new Message("你好", Message.Direct.SEND));

        messages.add(new Message("你也好", Message.Direct.RECEIVE));

        messages.add(new Message("你是谁啊", Message.Direct.SEND));

        messages.add(new Message("我也不知道", Message.Direct.RECEIVE));

        RecyclerAdapter adapter = new RecyclerAdapter(this, messages);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.setAdapter(adapter);

    }
}

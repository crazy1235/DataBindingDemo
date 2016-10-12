package com.jacksen.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jacksen.databindingdemo.chat.Message;
import com.jacksen.databindingdemo.chat.RecyclerAdapter;
import com.jacksen.databindingdemo.databinding.ActivityRecyclerViewBinding;
import com.jacksen.databindingdemo.utils.KeyBoardUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * recyclerView
 *
 * @author jacksen
 */
public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRecyclerViewBinding binding;
    private List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        messages = new ArrayList<>();

        messages.add(new Message("你好", Message.Direct.SEND));

        messages.add(new Message("你也好", Message.Direct.RECEIVE));

        messages.add(new Message("你是谁啊", Message.Direct.SEND));

        messages.add(new Message("我也不知道", Message.Direct.RECEIVE));

        RecyclerAdapter adapter = new RecyclerAdapter(this, messages);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.setAdapter(adapter);


        binding.setOnClick(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_msg:
                String content = binding.inputMsgEt.getText().toString();
                messages.add(new Message(content, Message.Direct.SEND));
                messages.add(new Message("自动回复", Message.Direct.RECEIVE));
                binding.notifyPropertyChanged(BR.adapter);

//                binding.executePendingBindings();

                // 此处如果不做视图改变，添加的内容不显示。？？？？？

                // 清空内容，隐藏键盘
                binding.inputMsgEt.setText("");
                KeyBoardUtil.closeKeyboard(binding.inputMsgEt, RecyclerViewActivity.this);

                break;
            default:
                break;
        }
    }
}

package com.jacksen.databindingdemo.chat;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksen.databindingdemo.BR;
import com.jacksen.databindingdemo.R;

import java.util.List;

/**
 * Created by Admin on 2016/10/11.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BindingHolder> {

    private List<Message> messages;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(Context context, List<Message> messages) {
        this.messages = messages;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (1 == viewType) {
            ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_sent_message, parent, false);
            BindingHolder holder = new BindingHolder(binding.getRoot());
            holder.setDataBinding(binding);
            return holder;
        } else if (2 == viewType) {
            ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_receive_message, parent, false);
            BindingHolder holder = new BindingHolder(binding.getRoot());
            holder.setDataBinding(binding);
            return holder;
        } else {
            ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_sent_message, parent, false);
            BindingHolder holder = new BindingHolder(binding.getRoot());
            holder.setDataBinding(binding);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.getDataBinding().setVariable(BR.message, messages.get(position));
        // ???
        holder.getDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return messages == null ? 0 : messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (messages == null) {
            return super.getItemViewType(position);
        }
        if (messages.get(position).getDirect() == Message.Direct.SEND) { // send
            return 1;
        } else if (messages.get(position).getDirect() == Message.Direct.RECEIVE) { // receive
            return 2;
        }
        return super.getItemViewType(position);
    }

    static class BindingHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding dataBinding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getDataBinding() {
            return dataBinding;
        }

        public void setDataBinding(ViewDataBinding dataBinding) {
            this.dataBinding = dataBinding;
        }
    }
}

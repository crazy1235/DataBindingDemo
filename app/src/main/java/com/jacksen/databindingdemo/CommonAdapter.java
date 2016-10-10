package com.jacksen.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Admin on 2016/10/10.
 */

public class CommonAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> list;
    private
    @LayoutRes
    int layoutId;
    private int variableId;

    /**
     * @param context
     * @param list
     * @param layoutId
     * @param variableId
     */
    public CommonAdapter(Context context, List<T> list, int layoutId, int variableId) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding = null;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false);
        }else{
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(variableId, list.get(position));
        return binding.getRoot();
    }
}

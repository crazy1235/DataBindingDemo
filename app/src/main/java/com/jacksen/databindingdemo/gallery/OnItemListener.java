package com.jacksen.databindingdemo.gallery;

import android.view.View;

/**
 * Created by Admin on 2016/10/13.
 */

public interface OnItemListener {

    void onItemClick(View view, int position);

    void onItemLongClick(int position);
}

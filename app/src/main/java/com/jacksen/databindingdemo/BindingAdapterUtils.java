package com.jacksen.databindingdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

/**
 * Created by Admin on 2016/10/10.
 */

public class BindingAdapterUtils {


    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (url != null) {
            Glide.with(imageView.getContext()).load(url).into(imageView);
        }
    }

    @BindingAdapter(value = {"android:src", "placeHolder"}, requireAll = false)
    public static void setImageSrc(ImageView view, String url, int placeHolder) {
        DrawableTypeRequest<String> request = Glide.with(view.getContext()).load(url);
        if (placeHolder != 0) {
            request.placeholder(placeHolder);
        }
        request.into(view);
    }

}

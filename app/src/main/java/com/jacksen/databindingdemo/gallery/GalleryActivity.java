package com.jacksen.databindingdemo.gallery;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.jacksen.databindingdemo.R;
import com.jacksen.databindingdemo.databinding.ActivityGalleryBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * recycler view + grid manager
 *
 * @author jacksen
 */
public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGalleryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery);

        binding.galleryRv.setLayoutManager(new GridLayoutManager(this, 2));


        List<Pic> pics = new ArrayList<>();
        for (int i = 0; i < Pic.urls.size(); i++) {
            pics.add(new Pic(Pic.urls.get(i)));
        }

        binding.setAdapter(new GalleryAdapter(this, binding.galleryRv, pics));
    }
}

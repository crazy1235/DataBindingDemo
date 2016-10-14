package com.jacksen.databindingdemo.gallery;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.jacksen.databindingdemo.BaseActivity;
import com.jacksen.databindingdemo.R;
import com.jacksen.databindingdemo.databinding.GalleryDetailBinding;

/**
 * single item recycler view
 *
 * @author jacksen
 */
public class GalleryDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GalleryDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery_detail);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            binding.setImageUrl(bundle.getString(GalleryActivity.IMAGE_URL, ""));
        }
    }
}

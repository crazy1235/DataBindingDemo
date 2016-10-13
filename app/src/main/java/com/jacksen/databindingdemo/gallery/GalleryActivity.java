package com.jacksen.databindingdemo.gallery;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jacksen.databindingdemo.BaseActivity;
import com.jacksen.databindingdemo.R;
import com.jacksen.databindingdemo.databinding.ActivityGalleryBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * recycler view + grid manager
 *
 * @author jacksen
 */
public class GalleryActivity extends BaseActivity {

    public static final String IMAGE_URL = "image_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityGalleryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery);

        binding.galleryRv.setLayoutManager(new GridLayoutManager(this, 2));


        final List<Pic> pics = new ArrayList<>();
        for (int i = 0; i < Pic.urls.size(); i++) {
            pics.add(new Pic(Pic.urls.get(i)));
        }
        final GalleryAdapter adapter = new GalleryAdapter(this, binding.galleryRv, pics);
        binding.setAdapter(adapter);

        adapter.setOnItemListener(new OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(GalleryActivity.this, GalleryDetailActivity.class);
                intent.putExtra(IMAGE_URL, pics.get(position).getImageUrl());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String transitionName = getString(R.string.transition_name_gallery);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(GalleryActivity.this, view, transitionName);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }

            @Override
            public void onItemLongClick(int position) {
                pics.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // TODO 添加item

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

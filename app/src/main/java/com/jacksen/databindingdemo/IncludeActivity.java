package com.jacksen.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.jacksen.databindingdemo.databinding.ActivityIncludeBinding;

/**
 * include标签的使用
 *
 * @author jacksen
 */
public class IncludeActivity extends BaseActivity {

    private final String BLOG_URL = "http://blog.csdn.net/crazy1235";

    private final String GITHUB_URL = "https://crazy1235.github.io";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);

        //
        binding.included.blogSite.setText(BLOG_URL);
        binding.included.gotoBlotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BLOG_URL));
                startActivity(intent);
            }
        });

        //
        binding.includedOther.blogSite.setText(GITHUB_URL);
        binding.includedOther.gotoBlotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL));
                startActivity(intent);
            }
        });

        //
        binding.setUser(User.user);

    }
}

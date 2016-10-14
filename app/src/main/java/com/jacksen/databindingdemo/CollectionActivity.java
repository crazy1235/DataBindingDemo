package com.jacksen.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.SparseArray;

import com.jacksen.databindingdemo.databinding.ActivityCollectionBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 集合 & 资源文件 & 集合 的使用
 *
 * @author jacksen
 */
public class CollectionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_collection);

        ArrayList<String> list = new ArrayList<>();
        list.add("jacksen");
        list.add("sololo");
        list.add("summerjing");

        binding.setList(list);

        //
        String[] array = new String[]{"123", "456"};
        binding.setArray(array);

        //
        Map<String, String> map = new HashMap<>();
        map.put("name", "jack.sen");
        map.put("age", "24 years old");
        map.put("phone", "1234565789");
        map.put("height", "175cm");
        binding.setMap(map);

        // SparseArray
        SparseArray<User> sparseArray = new SparseArray<>();
        sparseArray.put(1, new User("110", "jacksen", "123"));
        binding.setSparse(sparseArray);

        //
        binding.setIsShow(true);

        //
        binding.setAppName("");
    }
}

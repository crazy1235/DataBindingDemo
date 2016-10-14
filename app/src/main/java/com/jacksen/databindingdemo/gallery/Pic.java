package com.jacksen.databindingdemo.gallery;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 2016/10/13.
 */

public class Pic extends BaseObservable {

    static List<String> urls = new ArrayList<>();

    static {
        urls.add("http://img1.3lian.com/2016/gif/w/4/22.jpg");
        urls.add("http://img1.3lian.com/2016/gif/w/4/35.jpg");
        urls.add("http://upload.qqbody.com/ns/20160915/132727641u31afttfs0g.jpg");
        urls.add("http://upload.qqbody.com/ns/20160915/132727462vd1tsf3fv1u.jpg");
        urls.add("http://upload.qqbody.com/ns/20160915/1327263515gjjfuf4rmu.jpg");
        urls.add("http://img.jgzyw.com:8000/d/img/touxiang/2015/01/08/2015010800463730244.jpg");
        urls.add("http://tupian.qqjay.com/tou3/2016/0614/105e4a5b4eef29a3d2dcfa69b2b33da0.jpg");
        urls.add("http://tupian.qqjay.com/tou3/2016/0725/cb00091099ffbf09f4861f2bbb5dd993.jpg");
        urls.add("http://img.lanrentuku.com/img/allimg/1411/14173588028744.jpg");
        urls.add("http://tupian.qqjay.com/tou3/2016/0803/87a8b262a5edeff0e11f5f0ba24fb22f.jpg");
        urls.add("http://www.th7.cn/d/file/p/2016/09/18/a717bc87413be686f1a27aa45bc25fdb.jpg");
        urls.add("http://www.ucicq.com/uploads/allimg/161013/0524095X8_0.jpg");
        urls.add("http://www.ucicq.com/uploads/allimg/161013/05263L264_0.jpg");
        urls.add("http://www.th7.cn/d/file/p/2016/09/20/d89f3de7bb70bb407907f12af1d8325b.jpg");
        urls.add("http://www.th7.cn/d/file/p/2016/09/12/384441ac9444cc474069e9dce1c7c1bf.jpg");
    }

    static Pic getRandomPic() {
        Random random = new Random();
        int index = random.nextInt(urls.size());
        return new Pic(urls.get(index));
    }

    private String date = "2016-10-13";
    private
    @DrawableRes
    int drawable;

    private String imageUrl;

    public Pic(int drawable) {
        this.drawable = drawable;
    }

    public Pic(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Pic(String date, int drawable) {
        this.date = date;
        this.drawable = drawable;
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Bindable
    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

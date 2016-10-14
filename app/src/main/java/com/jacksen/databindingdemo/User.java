package com.jacksen.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Admin on 2016/10/9.
 */

public class User extends BaseObservable {

    static User user = new User("1234567890", "jack", "sen", 0);

    private String phone;
    private String name;
    private String password;
    private String iconUrl;
    private int sex; // 0->male  1->female

    private String firstName;
    private String lastName;

    private boolean vip;

    /**
     * 返回拼接好的名称
     *
     * @return
     */
    @Bindable
    public String getFullName() {
        return firstName.substring(0, 1).toUpperCase() + "." + lastName;
    }


    public User() {
    }

    public User(String phone, String name, String password) {
        this.phone = phone;
        this.name = name;
        this.password = password;
    }

    public User(String phone, String name, int sex) {
        this.phone = phone;
        this.name = name;
        this.sex = sex;
    }

    public User(String phone, String firstName, String lastName, int sex) {
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public User(String phone, String name, String password, String iconUrl, boolean vip) {
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.iconUrl = iconUrl;
        this.vip = vip;
    }

    public void onItemClick(View view) {
        Toast.makeText(view.getContext(), "view clicked", Toast.LENGTH_SHORT).show();
        this.vip = !vip;
        notifyPropertyChanged(BR.vip);
        notifyPropertyChanged(BR.name);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Bindable
    public String getName() {
        return name + (vip ? "（VIP用户）" : "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Bindable
    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

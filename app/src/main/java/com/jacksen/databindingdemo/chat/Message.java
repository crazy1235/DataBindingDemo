package com.jacksen.databindingdemo.chat;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Admin on 2016/10/11.
 */
public class Message extends BaseObservable {

    public enum Direct {
        SEND,
        RECEIVE;
    }

    private String content;

    private String time;

    private Direct direct;

    public Message() {
    }

    public Message(String content, Direct direct) {
        this.content = content;
        this.direct = direct;
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Bindable
    public Direct getDirect() {
        return direct;
    }

    public void setDirect(Direct direct) {
        this.direct = direct;
    }
}

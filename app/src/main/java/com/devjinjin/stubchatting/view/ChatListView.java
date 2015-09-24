package com.devjinjin.stubchatting.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devjinjin.stubchatting.R;

/**
 * Created by JYLEE on 2015-09-24.
 */
public class ChatListView extends ListView {

    public ChatListView(Context context) {
        super(context);
    }

    public ChatListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChatListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(VERSION_CODES.LOLLIPOP)
    public ChatListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, 0);
    }


}

package com.devjinjin.stubchatting.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.devjinjin.stubchatting.R;
import com.devjinjin.stubchatting.chat.ChatMessage;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JYLEE on 2015-09-24.
 */
public class ChatContainer extends LinearLayout {
    private ArrayList<ChatMessage> mChatHistory;
    private ChatListView mListView;
    private ChatAdapter adapter;
    private Context mContext;
    private Button mSendBtn;
    private EditText mSendEdt;

    public ChatContainer(Context context) {
        super(context);
        initView(context);
    }

    public ChatContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ChatContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChatContainer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private final void initView(Context context) {
        mContext = context;

        mChatHistory = new ArrayList<ChatMessage>();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chat_main, null, false);


        mListView = (ChatListView) view.findViewById(R.id.csChatList);
        mSendBtn = (Button) view.findViewById(R.id.btSend);
        mSendEdt = (EditText) view.findViewById(R.id.etSend);
        adapter = new ChatAdapter(context, new ArrayList<ChatMessage>());
        mListView.setAdapter(adapter);

        mSendBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSendEdt != null) {
                    Editable editText = mSendEdt.getText();
                    if (editText != null && editText.toString().length() > 0) {
                        ChatMessage msg = new ChatMessage();
                        msg.setId(1);
                        msg.setMe(true);
                        msg.setMessage(editText.toString());
                        msg.setDate(DateFormat.getDateTimeInstance().format(new Date()));
                        displayMessage(msg);
                        mSendEdt.setText("");
                    }
                }
            }
        });

        this.addView(view);

    }

    public void displayMessage(ChatMessage message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        mListView.setSelection(mListView.getCount() - 1);
    }

    public void setReceiveMessage(ChatMessage pMessage) {
        displayMessage(pMessage);
    }

    public void testSendMessage(String pText){
        ChatMessage msg = new ChatMessage();
        msg.setId(1);
        msg.setMe(false);
        msg.setMessage(pText);
        msg.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        setReceiveMessage(msg);
    }
}

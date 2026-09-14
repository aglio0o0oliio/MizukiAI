package com.mizuki.ai;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LinearLayout chat;
    private EditText input;
    private ScrollView scroll;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.activity_main);

        chat = findViewById(R.id.chatContainer);
        input = findViewById(R.id.messageInput);
        scroll = findViewById(R.id.chatScroll);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(v -> send());

        add("美月");
        add("おかえりなさい😊");
    }

    private void send() {
        String message = input.getText().toString().trim();

        if (message.isEmpty()) {
            return;
        }

        add("あなた");
        add(message);

        input.setText("");

        add("美月");
        add("うん、ちゃんと聞いてるよ😊");
    }

    private void add(String text) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(18);
        t.setPadding(16, 14, 16, 14);

        chat.addView(t);

        scroll.post(() -> scroll.fullScroll(ScrollView.FOCUS_DOWN));
    }
}

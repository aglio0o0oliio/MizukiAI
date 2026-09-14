package com.mizuki.ai;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
 LinearLayout chat; EditText input; ScrollView scroll;
 public void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_main); chat=findViewById(R.id.chatContainer);input=findViewById(R.id.messageInput);scroll=findViewById(R.id.chatScroll);findViewById(R.id.sendButton).setOnClickListener(v->send());}
 void send(){String s=input.getText().toString().trim();if(s.isEmpty())return; add("あなた「"+s+"」");input.setText("");add("美月「うん、聞いてるよ😊」");scroll.post(()->scroll.fullScroll(ScrollView.FOCUS_DOWN));}
 void add(String s){TextView t=new TextView(this);t.setText(s);t.setTextSize(18);t.setPadding(16,14,16,14);chat.addView(t);}
}
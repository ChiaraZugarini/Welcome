package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Intent intent = getIntent(); //
        Bundle b = intent.getExtras(); //insieme di tutti i pacchetti dentro all'intent
        String str = b.getString("chiave"); //ricavo stringa da intent
        TextView t = findViewById(R.id.messaggio);
        t.setText(str); //aggiungo la stringa come parametro di t

    }
}
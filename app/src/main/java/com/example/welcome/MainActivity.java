package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=findViewById(R.id.test); //trovo id importo da xml
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //creo ascoltatore per bottone
                EditText e = findViewById(R.id.messaggio);
                String str= e.getText().toString(); //contenuto dell'editText in una stringa
                Toast t= Toast.makeText(getApplicationContext(), "Ciao "+str, Toast.LENGTH_LONG); //creo toast e mostro stringa
                t.show();

            }
        });
    }
    public void SendMessage(View view){
        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);  //va all'activity che passo
        EditText edit = findViewById(R.id.messaggio);
        intent.putExtra("chiave", edit.getText().toString()); //aggiungo parametri all'intent
        startActivity(intent); //passa all'activity MessageActivity
    }

    public void Reset(View view){
        String str = "";
        EditText edit = findViewById(R.id.messaggio);
        edit.setText(str); //aggiungo la stringa vuota come parametro di edit


    }

    public void openResultActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        {
            if (requestCode == REQUEST_CODE) {

                String message = data.getStringExtra("chiave");
                TextView text = findViewById(R.id.text);
                text.setText(message.toString());
            }

        }

    }

}

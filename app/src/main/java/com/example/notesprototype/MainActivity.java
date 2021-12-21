package com.example.notesprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    // variables
    private SharedPreferences sharedPreferences;
    private String languageName;

    // widgets
    private TextView mSelectedLanguageText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.english:
                // change to English
                return true;
            case R.id.spanish:
                //change to Spanish
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSelectedLanguageText = findViewById(R.id.tvLanguage);
        sharedPreferences = this.getSharedPreferences("com.example.notesprototype", MODE_PRIVATE);

        if (!sharedPreferences.getString("language", "").isEmpty()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setTitle("Select Languages")
                    .setMessage("Which language you want to choose?")
                    .setPositiveButton("English", (dialog, which) -> {
                        languageName = "English";
                        mSelectedLanguageText.setText(languageName);
                        sharedPreferences.edit().putString("language", languageName).apply();
                    })
                    .setNegativeButton("Spanish", (dialog, which) -> {
                        languageName = "Spanish";
                        mSelectedLanguageText.setText(languageName);
                        sharedPreferences.edit().putString("language", languageName).apply();
                    });
        }


    }
}
package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;
import android.widget.Button;
import android.view.*;

import com.stephentuso.welcome.*;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    WelcomeHelper welcomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        welcomeScreen = new WelcomeHelper(this, TutorialActivity.class);
        welcomeScreen.show(savedInstanceState);

        // QRコードリーダ関連
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.setOrientationLocked(false);
//        integrator.initiateScan();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = findViewById(R.id.button1);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if(result != null) {
//            Toast.makeText(this, "Scanned: " + result.getContents(),Toast.LENGTH_LONG).show();
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }

}

package com.example.aidlserver;

import static android.content.ContentValues.TAG;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    TextView textTitle, textAnswer;
//    Button seeZodiac;
//    EditText editDay, editMonth;
    ServiceConnection serviceCon;
    IAIDLCalculateInterface iaidlCalculateService;
    int day, month;
////    IAIDLCalculateInterface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceCon = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                iaidlCalculateService = IAIDLCalculateInterface.Stub.asInterface(iBinder);
                Log.i(TAG, "onServiceConnected: Connected");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(TAG, "onServiceConnected: Disconnected");
            }
        };
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.aidlserver","com.example.aidlserver.AIDLCalculateService"));
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            startForegroundService(intent);
        }else{
            startService(intent);
        }
        bindService(intent,serviceCon,BIND_AUTO_CREATE);
//        initiate();
//        buttonOnClick();
    }

//    private void buttonOnClick() {
//        seeZodiac.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                day =  Integer.parseInt(editDay.getText().toString());
//                month = Integer.parseInt(editMonth.getText().toString());
//                try {
//                    textAnswer.setText(iaidlCalculateService.zodiak(day, month));
//                    textAnswer.setVisibility(View.VISIBLE);
//                } catch (RemoteException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//    }

//    private void initiate() {
//        textTitle = findViewById(R.id.text_title);
//        textAnswer = findViewById(R.id.text_answer);
//        seeZodiac = findViewById(R.id.button_see_my_zodiac);
//        editDay = findViewById(R.id.edit_day);
//        editMonth = findViewById(R.id.edit_month);
//    }
}
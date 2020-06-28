package com.novostack.cp_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    //SetupComplete

    private EditText mPhoneNUmberEditText;
    private LinearLayout mBottomSheetLayout;
    private BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorWhite));// set status background white
        setContentView(R.layout.activity_main);
//        mBottomSheetLayout = findViewById(R.id.bottom_sheet);
//        mPhoneNUmberEditText = mBottomSheetLayout.findViewById(R.id.editText_phoneNumber);
//        sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout);

    }
}

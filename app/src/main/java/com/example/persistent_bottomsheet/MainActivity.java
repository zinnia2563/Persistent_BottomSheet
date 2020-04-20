package com.example.persistent_bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    private TextView mTextViewState;
    private View bottomsheet;
    Button expand,collapse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomsheet=findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior=BottomSheetBehavior.from(bottomsheet);
        mTextViewState=findViewById(R.id.state_tv);
        expand=findViewById(R.id.expand_btn);
        collapse=findViewById(R.id.collapse_btn);
        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }
        });
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mTextViewState.setText("Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        mTextViewState.setText("tanatani");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mTextViewState.setText("horlicks khao height barao");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        mTextViewState.setText("luku churi luko churi golpo");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        mTextViewState.setText("set hou");
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                mTextViewState.setText("side side ");

            }
        });
    }
}



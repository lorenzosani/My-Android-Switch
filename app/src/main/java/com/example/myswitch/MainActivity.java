package com.example.myswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup my_switch = findViewById(R.id.switch_modified);
        final RadioButton on = findViewById(R.id.on_switch);
        final RadioButton off = findViewById(R.id.off_switch);
        off.setChecked(true);

        final TransitionDrawable transition = (TransitionDrawable) my_switch.getBackground();

        my_switch.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == on.getId()) {
                    transition.startTransition(300);
                    off.setText("");
                    on.setText("O");
                } else if (checkedId == off.getId()) {
                    transition.reverseTransition(300);
                    off.setText("I");
                    on.setText("");
                }
            }
        });
    }
}

package com.example.customview.view.constraint;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.customview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * @author zhouchao
 * @date 2020/8/4
 */
public class ConstrainSetActivity extends AppCompatActivity {

    ConstraintSet firstSet = new ConstraintSet();
    ConstraintSet second = new ConstraintSet();
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_set);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        second.clone(this, R.layout.second_view);
        firstSet.clone(this, R.layout.content_main);
        constraintLayout = (ConstraintLayout) findViewById(R.id.first_view);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TransitionManager.beginDelayedTransition(constraintLayout);
                second.applyTo(constraintLayout);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
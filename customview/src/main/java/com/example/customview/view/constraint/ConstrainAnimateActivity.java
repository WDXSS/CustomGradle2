package com.example.customview.view.constraint;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;
import androidx.transition.TransitionManager;

import com.example.customview.R;

/**
 * https://www.jianshu.com/p/f86f800964d2
 * https://www.hellsoft.se/animations-with-constraintlayout-and-constraintset/
 * 如何结合ConstraintSet和TransitionManager做出一些很酷炫的动画
 * @author zhouchao
 * @date 2020/8/3
 */
public class ConstrainAnimateActivity extends AppCompatActivity {
    Placeholder mainAction;
    ConstraintLayout constraintLayout;

    ImageButton save, delete, cancel, edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout_animate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainAction = (Placeholder) findViewById(R.id.template_action);
        constraintLayout = (ConstraintLayout) findViewById(R.id.root);

        save = (ImageButton) findViewById(R.id.save);
        delete = (ImageButton) findViewById(R.id.delete);
        cancel = (ImageButton) findViewById(R.id.cancel);
        edit = (ImageButton) findViewById(R.id.edit);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_constrain_animate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_constraintSet) {
            Intent intent=new Intent(this, ConstrainSetActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }}


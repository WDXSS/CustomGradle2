package gradle.custom.com.customgradle;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import gradle.custom.com.androidlibrary.LibActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startALib(View view) {
        Intent intent = new Intent();
        intent.setClass(this, LibActivity.class);
        startActivity(intent);
    }
}

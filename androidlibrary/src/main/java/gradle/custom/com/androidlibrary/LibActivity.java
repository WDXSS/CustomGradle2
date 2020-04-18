package gradle.custom.com.androidlibrary;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import gradle.com.example.customview.book.custom.com.androidlibrary.R;

/**
 * Created by zc on 2019/1/4
 */
public class LibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alib_activity_main);

    }
}

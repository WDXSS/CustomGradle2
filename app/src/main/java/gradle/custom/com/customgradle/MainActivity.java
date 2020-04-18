package gradle.custom.com.customgradle;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import gradle.com.example.customview.book.custom.com.customgradle.R;
import gradle.custom.com.androidlibrary.LibActivity;


//那就是 support-annotations 库的 RestrictTo 注解，配合 lint 使用。
// 比如 MainActivity.java 要禁止外部使用
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String str = BuildConfig.baidu;
    }

    public void startALib(View view) {
        Intent intent = new Intent();
        intent.setClass(this, LibActivity.class);
        startActivity(intent);
    }
}

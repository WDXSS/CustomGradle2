package gradle.custom.com.androidlibrary;

import android.content.res.Configuration;

import androidx.annotation.NonNull;

public class BaseApplicationLogic {
    protected MaApplication mApplication;
    public BaseApplicationLogic() {
    }

    public void setApplication(@NonNull MaApplication application) {
        mApplication = application;
    }

    public void onCreate() {
    }

    public void onTerminate() {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int level) {
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }
}
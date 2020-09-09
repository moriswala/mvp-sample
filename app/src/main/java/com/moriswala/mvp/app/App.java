package com.moriswala.mvp.app;

import android.app.Application;

import com.moriswala.mvp.R;
import com.moriswala.mvp.api.ApiModule;

/**
 * Created by Yakub on 25/02/2019.
 */

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(getString(R.string.base_url), ""))
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(Application application) {
        return ((App) application).getAppComponent();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}


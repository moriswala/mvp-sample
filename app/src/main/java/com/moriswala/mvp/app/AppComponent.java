package com.moriswala.mvp.app;

import android.app.Application;

import com.moriswala.mvp.api.ApiModule;
import com.moriswala.mvp.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Yakub on 25/02/2019.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)
public interface AppComponent {

    Application application();

    ApiService apiService();

    void inject(App app);

}


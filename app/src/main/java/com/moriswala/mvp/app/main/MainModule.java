package com.moriswala.mvp.app.main;

import com.moriswala.mvp.app.ActivityScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Yakub on 25/02/2019.
 */

@Module
public class MainModule {
    private final MainContract.View mainView;

    MainModule(MainContract.View mainView) {
        this.mainView = mainView;
    }

    @Provides
    @ActivityScope
    MainContract.View provideMainView() {
        return mainView;
    }


}


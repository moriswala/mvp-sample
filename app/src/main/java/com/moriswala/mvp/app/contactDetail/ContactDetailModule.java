package com.moriswala.mvp.app.contactDetail;

import com.moriswala.mvp.app.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yakub on 25/02/2019.
 */

@Module
public class ContactDetailModule {
    private final ContactDetailContract.View contactDetailView;

    ContactDetailModule(ContactDetailContract.View contactDetailView) {
        this.contactDetailView = contactDetailView;
    }

    @Provides
    @ActivityScope
    ContactDetailContract.View provideContactDetailView() {
        return contactDetailView;
    }

}


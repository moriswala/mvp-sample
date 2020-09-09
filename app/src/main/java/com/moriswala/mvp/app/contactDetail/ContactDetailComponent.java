package com.moriswala.mvp.app.contactDetail;

import com.moriswala.mvp.app.ActivityScope;
import com.moriswala.mvp.app.AppComponent;


import dagger.Component;

/**
 * Created by Yakub on 25/02/2019.
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = ContactDetailModule.class
)
interface ContactDetailComponent {

    void inject(ContactDetailActivity contactDetailActivity);

}


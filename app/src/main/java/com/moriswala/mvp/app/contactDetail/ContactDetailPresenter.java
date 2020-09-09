package com.moriswala.mvp.app.contactDetail;

import com.moriswala.mvp.api.ApiService;
import com.moriswala.mvp.api.model.Contact;


import javax.inject.Inject;


/**
 * Created by Yakub on 25/02/2019.
 */

public class ContactDetailPresenter implements ContactDetailContract.Presenter {
    private ContactDetailContract.View view;
    private ApiService apiService;

    @Inject
    public ContactDetailPresenter(ContactDetailContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void start(Contact contact) {

    }

    @Override
    public void finish() {
        view = null;
    }

}

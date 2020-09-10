package com.moriswala.mvp.app.contactDetail;

import com.moriswala.mvp.api.ApiService;
import com.moriswala.mvp.api.model.Contact;


import javax.inject.Inject;


/**
 * Created by Yakub on 25/02/2019.
 *
 * Presenter for the Contact detail View. It's the only way to communicate with data repositoy.
 * It will take the input from View and fetch the data from data repository.
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

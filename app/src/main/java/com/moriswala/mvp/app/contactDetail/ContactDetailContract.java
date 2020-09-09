package com.moriswala.mvp.app.contactDetail;

import com.moriswala.mvp.api.model.Contact;

/**
 * Created by Yakub on 25/02/2019.
 */

public interface ContactDetailContract {

    interface View {

        void showLoading();

        void showContact(Contact contact);

        void showError();

    }

    interface Presenter {

        void start(Contact contact);

        void finish();

    }

}

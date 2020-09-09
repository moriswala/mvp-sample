package com.moriswala.mvp.app.main;

import com.moriswala.mvp.api.model.Contact;

import java.util.List;

/**
 * Created by Yakub on 25/02/2019.
 */

public interface MainContract {

    interface View {

        void showLoading(boolean isRefresh);

        void showContacts(List<Contact> contacts, boolean isRefresh);

        void showError();
    }

    interface Presenter {

        void start();

        void onPullToRefresh();

        void onScrollToBottom();

        void finish();

    }

}

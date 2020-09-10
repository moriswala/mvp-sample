package com.moriswala.mvp.app.main;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;

import com.moriswala.mvp.api.ApiService;
import com.moriswala.mvp.api.model.Contact;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yakub on 25/02/2019.
 *
 * Main Activity(launcher activity) presenter. Presenter is only way to communicate with data repository.
 * It will take the request from View and route it to appropriate method to fetch the data.
 */

public class MainPresenter implements MainContract.Presenter {
    private final CompositeDisposable disposable = new CompositeDisposable();
    private MainContract.View view;
    private ApiService apiService;
    private int page = 1;


    @Inject
    MainPresenter(MainContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void start() {
        view.showLoading(false);
        getContactsRx(true);
    }

    @Override
    public void onPullToRefresh() {
        page = 1; // reset
        view.showLoading(true);
        getContactsRx(true);
    }

    @Override
    public void onScrollToBottom() {
        //handle pagination if needed
//        page++;
//        view.showLoading(true);
//        getContacts(false, page);
    }

    /**
     * Reactive call to fetch the contacts data from server in first Observable,
     * then chiaining it with Sorting Observable. Finally getContactssRx() will
     * return a list of contacts sorted by last name.
     * @param isRefresh
     */
    private void getContactsRx(final boolean isRefresh) {
        disposable.add(apiService.getContactsRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(resp -> {
                    List<Contact> sortedList = new ArrayList<Contact>(resp.getContacts());
                    Collections.sort(sortedList, new ContactLastNameComparator.LastNameComparator());
                    return sortedList;
                })
                .subscribe((contacts, throwable) -> {
                    if(throwable!=null){
                        view.showError();
                    }else{
                        view.showContacts(contacts, isRefresh);
                    }
                }));
    }

    public static class ContactLastNameComparator {

        public static class LastNameComparator implements Comparator<Contact> {

            @Override
            public int compare(Contact contact1, Contact contact2) {
                final char field1 = contact1.getPerson().getLastname().charAt(0);
                final char field2 = contact2.getPerson().getLastname().charAt(0);
                return Character.valueOf(field1).compareTo(Character.valueOf(field2));
            }
        }
    }


    @Override
    public void finish() {
        view = null;
        if(disposable!=null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}

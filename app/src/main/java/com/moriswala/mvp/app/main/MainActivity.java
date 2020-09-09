package com.moriswala.mvp.app.main;

import android.content.Intent;
import android.os.Handler;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.moriswala.mvp.R;
import com.moriswala.mvp.api.model.Contact;
import com.moriswala.mvp.app.App;
import com.moriswala.mvp.app.contactDetail.ContactDetailActivity;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.moriswala.mvp.app.contactDetail.ContactDetailActivity.CONTACT;


public class MainActivity extends AppCompatActivity implements
        MainContract.View,
        SwipeRefreshLayout.OnRefreshListener, EndlessScrollListener.ScrollToBottomListener, com.polbins.thecontactdb.app.main.ContactsAdapter.ItemClickListener {
    private static final String TAG = "Main";

    @Inject
    MainPresenter presenter;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView contentView;
    @BindView(R.id.textView)
    View errorView;
    @BindView(R.id.progressBar)
    View loadingView;

    private com.polbins.thecontactdb.app.main.ContactsAdapter contactsAdapter;
    private EndlessScrollListener endlessScrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupContentView();
        DaggerMainComponent.builder()
                .appComponent(App.getAppComponent(getApplication()))
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    private void setupContentView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        endlessScrollListener = new EndlessScrollListener(linearLayoutManager, this);
        contentView.setLayoutManager(linearLayoutManager);
        contentView.addOnScrollListener(endlessScrollListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.finish();
    }

    @Override
    public void onRefresh() {
        endlessScrollListener.onRefresh();
        presenter.onPullToRefresh();
    }

    @Override
    public void onScrollToBottom() {
        presenter.onScrollToBottom();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void showLoading(boolean isRefresh) {
        if (isRefresh) {
            if (!swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(true);
            }
        } else {
            loadingView.setVisibility(View.VISIBLE);
            contentView.setVisibility(View.GONE);
            errorView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showContacts(List<Contact> contacts, boolean isRefresh) {
        if (contactsAdapter == null) {
            contactsAdapter = new com.polbins.thecontactdb.app.main.ContactsAdapter(contacts, this, this);
            contentView.setAdapter(contactsAdapter);
        } else {
            if (isRefresh) {
                contactsAdapter.clear();
            }
            contactsAdapter.addAll(contacts);
            contactsAdapter.notifyDataSetChanged();
        }

        // Delay SwipeRefreshLayout animation by 1.5 seconds
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1500);

        loadingView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        swipeRefreshLayout.setRefreshing(false);
        loadingView.setVisibility(View.GONE);
        contentView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onContactlick(Contact contact) {
        Intent i = new Intent(this, ContactDetailActivity.class);
        i.putExtra(CONTACT, contact);
        startActivity(i);
    }

    @OnClick(R.id.textView)
    void onClickErrorView() {
        presenter.start();
    }

}

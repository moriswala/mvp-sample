package com.moriswala.mvp.app.contactDetail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moriswala.mvp.R;
import com.moriswala.mvp.api.model.Contact;
import com.moriswala.mvp.app.App;
import com.moriswala.mvp.app.common.Utils;



import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ContactDetailActivity extends AppCompatActivity implements ContactDetailContract.View {
    public static final String CONTACT = "contact";

    @Inject
    ContactDetailPresenter contactDetailPresenter;

    @BindView(R.id.container)
    View contentView;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.textLink)
    TextView textLink;
    @BindView(R.id.textRole)
    TextView textRole;
    @BindView(R.id.textParty)
    TextView textAdmin;
    @BindView(R.id.textProduct)
    TextView textProduct;
    @BindView(R.id.buttonCall)
    Button buttonCall;
    @BindView(R.id.buttonSMS)
    Button buttonSMS;
    @BindView(R.id.buttonEmail)
    Button buttonEmail;
    @BindView(R.id.textView)
    View errorView;
    @BindView(R.id.progressBar)
    View loadingView;

    @BindView(R.id.textAddress)
    TextView textAddress;

    @BindView(R.id.textOffice)
    TextView textOffice;

    @BindView(R.id.textPersonName)
    TextView textPersonName;

    @BindView(R.id.textBirthday)
    TextView textBirthday;

    @BindView(R.id.textEndDate)
    TextView textEndDate;

    @BindView(R.id.textGender)
    TextView textGender;

    @BindView(R.id.textSortName)
    TextView textSortName;

    @BindView(R.id.textWebsite)
    TextView textWebsite;

    @BindView(R.id.textPhone)
    TextView textPhone;

    @BindView(R.id.bottomButtonLayout)
    View bottomButtonLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        DaggerContactDetailComponent.builder()
                .appComponent(App.getAppComponent(getApplication()))
                .contactDetailModule(new ContactDetailModule(this))
                .build()
                .inject(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Contact contact = (Contact) extras.getSerializable(CONTACT);
            showContact(contact);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contactDetailPresenter.finish();
    }



    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
        showContent(false);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showContact(Contact contact) {
        setTitle(contact.getPerson().getBioguideid());
        int resourceId = Utils.getImageResourceId(contact);

        if (resourceId != -1) {
            imageView.setImageResource(resourceId);
        }
        textName.setText(Utils.formateFullName(contact));
        textLink.setText(contact.getPerson().getLink());
        textWebsite.setText(contact.getWebsite());
        textPersonName.setText(contact.getParty());
        textRole.setText(getString(R.string.bioguidId));
        textAdmin.setText(contact.getPerson().getBioguideid());
        textAddress.setText(contact.getExtra().getAddress());
        textOffice.setText(contact.getExtra().getOffice());
        textPersonName.setText(contact.getPerson().getName());
        textBirthday.setText(contact.getPerson().getBirthday());
        textEndDate.setText(contact.getEnddate());
        textGender.setText(contact.getPerson().getGender());
        textSortName.setText(contact.getPerson().getSortname());
        textWebsite.setText(contact.getWebsite());
        textPhone.setText(contact.getPhone());
        loadingView.setVisibility(View.GONE);
        showContent(true);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        loadingView.setVisibility(View.GONE);
        showContent(false);
        errorView.setVisibility(View.VISIBLE);
    }

    private void showContent(boolean show) {
        int visibility = show ? View.VISIBLE : View.INVISIBLE;

        contentView.setVisibility(visibility);
        bottomButtonLayout.setVisibility(visibility);
    }

    @OnClick(R.id.buttonCall)
    void onCallClick() {

    }

    @OnClick(R.id.buttonSMS)
    void onSMSClick() {

    }

    @OnClick(R.id.buttonEmail)
    void ononEmailClick() {

    }

}

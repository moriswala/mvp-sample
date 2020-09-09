package com.moriswala.mvp.api;

import com.moriswala.mvp.api.model.Contact;
import com.moriswala.mvp.api.model.ContactResp;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Yakub on 25/02/2019.
 */

public interface ApiService {

//    @GET("CivilServiceUSA/us-senate/master/us-senate/data/us-senate.json")
//    Call<List<Contact>> getContacts();

    @GET("/moriswala/moriswala.github.io/master/contacts.json")
    Single<ContactResp> getContactsRx();

}

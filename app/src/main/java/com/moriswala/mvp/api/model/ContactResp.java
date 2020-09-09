package com.moriswala.mvp.api.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactResp implements Serializable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("objects")
    @Expose
    private List<Contact> contacts = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}


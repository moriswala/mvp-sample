package com.moriswala.mvp.api.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Extra implements Serializable {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("contact_form")
    @Expose
    private String contactForm;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("office")
    @Expose
    private String office;
    @SerializedName("rss_url")
    @Expose
    private String rssUrl;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactForm() {
        return contactForm;
    }

    public void setContactForm(String contactForm) {
        this.contactForm = contactForm;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getRssUrl() {
        return rssUrl;
    }

    public void setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl;
    }

}
package com.moriswala.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("bioguideid")
    @Expose
    private String bioguideid;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("cspanid")
    @Expose
    private Integer cspanid;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("gender_label")
    @Expose
    private String genderLabel;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("middlename")
    @Expose
    private String middlename;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("namemod")
    @Expose
    private String namemod;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("osid")
    @Expose
    private String osid;
    @SerializedName("pvsid")
    @Expose
    private String pvsid;
    @SerializedName("sortname")
    @Expose
    private String sortname;
    @SerializedName("twitterid")
    @Expose
    private String twitterid;
    @SerializedName("youtubeid")
    @Expose
    private String youtubeid;

    public String getBioguideid() {
        return bioguideid;
    }

    public void setBioguideid(String bioguideid) {
        this.bioguideid = bioguideid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getCspanid() {
        return cspanid;
    }

    public void setCspanid(Integer cspanid) {
        this.cspanid = cspanid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderLabel() {
        return genderLabel;
    }

    public void setGenderLabel(String genderLabel) {
        this.genderLabel = genderLabel;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamemod() {
        return namemod;
    }

    public void setNamemod(String namemod) {
        this.namemod = namemod;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOsid() {
        return osid;
    }

    public void setOsid(String osid) {
        this.osid = osid;
    }

    public String getPvsid() {
        return pvsid;
    }

    public void setPvsid(String pvsid) {
        this.pvsid = pvsid;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getTwitterid() {
        return twitterid;
    }

    public void setTwitterid(String twitterid) {
        this.twitterid = twitterid;
    }

    public String getYoutubeid() {
        return youtubeid;
    }

    public void setYoutubeid(String youtubeid) {
        this.youtubeid = youtubeid;
    }

}
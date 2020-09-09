package com.moriswala.mvp.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {

    @SerializedName("congress_numbers")
    @Expose
    private List<Integer> congressNumbers = null;
    @SerializedName("current")
    @Expose
    private Boolean current;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("enddate")
    @Expose
    private String enddate;
    @SerializedName("extra")
    @Expose
    private Extra extra;
    @SerializedName("party")
    @Expose
    private String party;
    @SerializedName("person")
    @Expose
    private Person person;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("role_type")
    @Expose
    private String roleType;
    @SerializedName("role_type_label")
    @Expose
    private String roleTypeLabel;
    @SerializedName("senator_class")
    @Expose
    private String senatorClass;
    @SerializedName("senator_class_label")
    @Expose
    private String senatorClassLabel;
    @SerializedName("senator_rank")
    @Expose
    private String senatorRank;
    @SerializedName("senator_rank_label")
    @Expose
    private String senatorRankLabel;
    @SerializedName("startdate")
    @Expose
    private String startdate;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_long")
    @Expose
    private String titleLong;
    @SerializedName("website")
    @Expose
    private String website;

    public List<Integer> getCongressNumbers() {
        return congressNumbers;
    }

    public void setCongressNumbers(List<Integer> congressNumbers) {
        this.congressNumbers = congressNumbers;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.lang.Object getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleTypeLabel() {
        return roleTypeLabel;
    }

    public void setRoleTypeLabel(String roleTypeLabel) {
        this.roleTypeLabel = roleTypeLabel;
    }

    public String getSenatorClass() {
        return senatorClass;
    }

    public void setSenatorClass(String senatorClass) {
        this.senatorClass = senatorClass;
    }

    public String getSenatorClassLabel() {
        return senatorClassLabel;
    }

    public void setSenatorClassLabel(String senatorClassLabel) {
        this.senatorClassLabel = senatorClassLabel;
    }

    public String getSenatorRank() {
        return senatorRank;
    }

    public void setSenatorRank(String senatorRank) {
        this.senatorRank = senatorRank;
    }

    public String getSenatorRankLabel() {
        return senatorRankLabel;
    }

    public void setSenatorRankLabel(String senatorRankLabel) {
        this.senatorRankLabel = senatorRankLabel;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLong() {
        return titleLong;
    }

    public void setTitleLong(String titleLong) {
        this.titleLong = titleLong;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}

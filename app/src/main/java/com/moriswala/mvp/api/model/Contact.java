package com.moriswala.mvp.api.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact implements Serializable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("objects")
    @Expose
    private List<Object> objects = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

}


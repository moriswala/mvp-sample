package com.moriswala.mvp.app.common;

import androidx.annotation.NonNull;

import com.moriswala.mvp.R;
import com.moriswala.mvp.api.model.Contact;

public class Utils {

    public static int getImageResourceId(Contact contact) {
        String imagePath;

        if (contact.getParty() != null && !contact.getParty().isEmpty()) {
            if(contact.getParty().equals("republican")){
                return R.drawable.img_republican;
            }else{
                return R.drawable.img_democrat;
            }
        }
        return -1;
    }
}

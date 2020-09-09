package com.moriswala.mvp.app.common;

import androidx.annotation.NonNull;

import com.moriswala.mvp.R;
import com.moriswala.mvp.api.model.Contact;

public class Utils {

    public static int getImageResourceId(Contact contact) {
        String imagePath;

        if (contact.getParty() != null && !contact.getParty().isEmpty()) {
            if(contact.getParty().equals("republican")){
                return R.drawable.republican_logo;
            }else{
                return R.drawable.democrat_logo;
            }
        }
        return -1;
    }

    public static String formateFullName(Contact contact) {
        return contact.getPerson().getFirstname() + " "+ contact.getPerson().getLastname();
    }


}

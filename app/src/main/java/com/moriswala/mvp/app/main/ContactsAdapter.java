package com.moriswala.mvp.app.main;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moriswala.mvp.R;
import com.moriswala.mvp.api.model.Contact;
import com.moriswala.mvp.app.common.Utils;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by Yakub on 25/02/2019.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contact> contacts;
    private Activity activity;
    private ItemClickListener itemClickListener;

    public ContactsAdapter(List<Contact> contacts, Activity activity, ItemClickListener itemClickListener) {
        this.contacts = contacts;
        this.activity = activity;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Contact contact = contacts.get(position);

        int resourceId = Utils.getImageResourceId(contact);
        if (resourceId != -1) {
//            Glide.with(activity)
//                    .load(fullImageUrl)
//                    .apply(RequestOptions.centerCropTransform())
//                    .transition(withCrossFade())
//                    .into(holder.imageView);
            holder.imageView.setImageResource(resourceId);
        }

        holder.popularityTextView.setText(contact.getName());
        holder.titleTextView.setText(contact.getParty());
        holder.textParty.setText(contact.getParty());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onContactlick(contact);
            }
        });
    }



    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void clear() {
        contacts.clear();
    }

    public void addAll(List<Contact> contacts) {
        this.contacts.addAll(contacts);
    }

//    public void setImages(Images images) {
//        this.images = images;
//    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.popularityTextView)
        TextView popularityTextView;
        @BindView(R.id.titleTextView)
        TextView titleTextView;
        @BindView(R.id.party)
        TextView textParty;

        ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }

    }



    public interface ItemClickListener {

        void onContactlick(Contact contact);

    }

}

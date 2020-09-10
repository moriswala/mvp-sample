package com.moriswala.mvp.app.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Yakub on 25/02/2019.
 *
 * It's useful for fetching data in pagination, This listener will fetch the next
 * page once it reaches to the end of current page.
 *
 */

public class EndlessScrollListener extends RecyclerView.OnScrollListener {
    private LinearLayoutManager linearLayoutManager;
    private ScrollToBottomListener listener;

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 3;
    private int firstVisibleItem, visibleItemCount, totalItemCount;

    public EndlessScrollListener(LinearLayoutManager linearLayoutManager,
                                 ScrollToBottomListener listener) {
        this.linearLayoutManager = linearLayoutManager;
        this.listener = listener;
    }

    public void onRefresh () {
        previousTotal = 0;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = linearLayoutManager.getItemCount();
        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold)) {
            this.listener.onScrollToBottom();
            loading = true;
        }
    }

    interface ScrollToBottomListener {

        void onScrollToBottom();

    }
}

package org.greenfroyo.baseapp_mvp_bind.view.recyclerview;

/**
 * Created by fchristysen on 6/22/16.
 */

public interface OnRecyclerItemClickListener<T> {
    void onItemClick(int position, T item);
}

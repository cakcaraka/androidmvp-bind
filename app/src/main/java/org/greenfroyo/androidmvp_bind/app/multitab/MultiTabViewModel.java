package org.greenfroyo.androidmvp_bind.app.multitab;

import android.databinding.Bindable;
import android.support.v4.view.PagerAdapter;

import org.greenfroyo.androidmvp_bind.BR;
import org.greenfroyo.baseapp_mvp_bind.app.BaseViewModel;

/**
 * Created by fchristysen on 6/30/16.
 */

public class MultiTabViewModel extends BaseViewModel {
    private PagerAdapter mAdapter;

    @Bindable
    public PagerAdapter getAdapter(){
        return mAdapter;
    }

    public void setAdapter(PagerAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }
}

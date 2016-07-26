package org.greenfroyo.androidmvp_bind.app.twoway;

import android.databinding.ObservableField;

import org.greenfroyo.baseapp_mvp_bind.app.toolbar.BaseToolbarViewModel;

/**
 * Created by fchristysen on 6/23/16.
 */

public class TwoWayViewModel extends BaseToolbarViewModel {
    public ObservableField<String> mText;

    public TwoWayViewModel(){
        this.mText = new ObservableField<>("Default Text");
    }
}

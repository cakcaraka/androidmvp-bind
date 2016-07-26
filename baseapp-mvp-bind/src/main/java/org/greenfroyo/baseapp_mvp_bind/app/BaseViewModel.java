package org.greenfroyo.baseapp_mvp_bind.app;

import android.databinding.Bindable;


import org.greenfroyo.baseapp_mvp_bind.BR;
import org.greenfroyo.mvp_bind.base.BaseMvpViewModel;

/**
 * Created by fchristysen on 6/7/16.
 * <p>
 * !IMPORTANT, subclass of this view model required to use @Parcel annotation for enabling
 * automatic save and restore of view model
 * This class expands the number of attachable OnPropertyChangeCallbacks
 */

public abstract class BaseViewModel extends BaseMvpViewModel {
    private String mToastMessage;

    public BaseViewModel() {

    }

    @Bindable
    public String getToastMessage() {
        String r = mToastMessage;
        mToastMessage = null;
        return r;
    }

    public void setToastMessage(String toastMessage) {
        mToastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public boolean needToShowToast() {
        return mToastMessage != null;
    }
}

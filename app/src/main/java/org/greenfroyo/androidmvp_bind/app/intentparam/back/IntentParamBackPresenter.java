package org.greenfroyo.androidmvp_bind.app.intentparam.back;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.greenfroyo.baseapp_mvp_bind.app.toolbar.BaseToolbarPresenter;


/**
 * Created by fchristysen on 6/7/16.
 */

public class IntentParamBackPresenter extends BaseToolbarPresenter<IntentParamBackViewModel> {
    private int mValue;

    public IntentParamBackPresenter(int value){
        mValue = value;
    }

    @Override
    public void onCreate(@Nullable Bundle presenterState) {
    }

    @Override
    public IntentParamBackViewModel onInitViewModel() {
        IntentParamBackViewModel model = new IntentParamBackViewModel();
        model.setValue(mValue);
        return model;
    }


}

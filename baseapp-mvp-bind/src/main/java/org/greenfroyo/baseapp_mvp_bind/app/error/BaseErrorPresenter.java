package org.greenfroyo.baseapp_mvp_bind.app.error;

import android.os.Bundle;

import org.greenfroyo.baseapp_mvp_bind.app.toolbar.BaseToolbarPresenter;


/**
 * Created by fchristysen on 7/20/16.
 */

public abstract class BaseErrorPresenter<VM extends BaseErrorViewModel> extends BaseToolbarPresenter<VM> {

    @Override
    public void onCreate(Bundle presenterState) {
        super.onCreate(presenterState);
        hideError();
    }

    public void showError(int errorCode) {
        getViewModel().setErrorCode(errorCode);
        getViewModel().showError();
    }

    public void hideError(){
        getViewModel().hideError();
    }
}

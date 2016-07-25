package org.greenfroyo.androidmvp_bind.app.multitab;


import org.greenfroyo.baseapp_mvp_bind.app.BasePresenter;

/**
 * Created by fchristysen on 6/30/16.
 */

public class MultiTabPresenter extends BasePresenter<MultiTabViewModel> {

    @Override
    public MultiTabViewModel onInitViewModel() {
        return new MultiTabViewModel();
    }
}

package org.greenfroyo.androidmvp_bind.app.twoway;


import org.greenfroyo.baseapp_mvp_bind.app.toolbar.BaseToolbarPresenter;

/**
 * Created by fchristysen on 6/23/16.
 */

public class TwoWayPresenter extends BaseToolbarPresenter<TwoWayViewModel> {


    @Override
    public TwoWayViewModel onInitViewModel() {
        return new TwoWayViewModel();
    }
}

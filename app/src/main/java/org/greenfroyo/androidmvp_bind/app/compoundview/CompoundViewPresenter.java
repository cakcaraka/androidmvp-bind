package org.greenfroyo.androidmvp_bind.app.compoundview;


import org.greenfroyo.baseapp_mvp_bind.app.toolbar.BaseToolbarPresenter;

/**
 * Created by fchristysen on 6/27/16.
 */

public class CompoundViewPresenter extends BaseToolbarPresenter<CompoundViewViewModel> {
    @Override
    public CompoundViewViewModel onInitViewModel() {
        CompoundViewViewModel model = new CompoundViewViewModel();
        return model;
    }
}

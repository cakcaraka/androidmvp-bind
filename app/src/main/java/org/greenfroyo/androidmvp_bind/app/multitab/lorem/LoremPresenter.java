package org.greenfroyo.androidmvp_bind.app.multitab.lorem;


import org.greenfroyo.baseapp_mvp_bind.app.BasePresenter;

/**
 * Created by fchristysen on 6/30/16.
 */

public class LoremPresenter extends BasePresenter<LoremViewModel> {


    @Override
    public LoremViewModel onInitViewModel() {
        return new LoremViewModel();
    }
}

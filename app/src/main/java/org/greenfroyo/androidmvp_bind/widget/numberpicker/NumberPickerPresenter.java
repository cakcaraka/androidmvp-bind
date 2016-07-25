package org.greenfroyo.androidmvp_bind.widget.numberpicker;


import org.greenfroyo.baseapp_mvp_bind.app.BasePresenter;

/**
 * Created by fchristysen on 6/28/16.
 */

public class NumberPickerPresenter extends BasePresenter<NumberPickerViewModel> {
    @Override
    public NumberPickerViewModel onInitViewModel() {
        return new NumberPickerViewModel();
    }

    public void substractValue(){
        getViewModel().substractValue();
    }

    public void addValue(){
        getViewModel().addValue();
    }
}

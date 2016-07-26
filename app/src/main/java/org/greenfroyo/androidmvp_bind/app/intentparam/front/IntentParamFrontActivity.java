package org.greenfroyo.androidmvp_bind.app.intentparam.front;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import org.greenfroyo.androidmvp_bind.R;
import org.greenfroyo.androidmvp_bind.databinding.IntentParamFrontActivityBinding;
import org.greenfroyo.baseapp_mvp_bind.app.toolbar.BaseToolbarActivity;

/**
 * Created by fchristysen on 6/7/16.
 */

public class IntentParamFrontActivity extends BaseToolbarActivity<IntentParamFrontPresenter, IntentParamFrontViewModel> implements View.OnClickListener {
    private IntentParamFrontActivityBinding mBinding;

    @Override
    public IntentParamFrontPresenter createPresenter() {
        return new IntentParamFrontPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ViewDataBinding onInitView(IntentParamFrontViewModel viewModel) {
        mBinding = setBindView(R.layout.intent_param_front_activity);
        mBinding.setViewModel(getPresenter().getViewModel());
        mBinding.setOnClickListener(this);
        return mBinding;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(mBinding.btnAdd)){
            getPresenter().onIncrementValue();
        }else if(v.equals(mBinding.btnNext)){
            getPresenter().openIntentParamBack(this);
        }
    }
}

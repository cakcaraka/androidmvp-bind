package org.greenfroyo.androidmvp_bind.app.compoundview;

import android.databinding.ViewDataBinding;

import org.greenfroyo.androidmvp_bind.R;
import org.greenfroyo.androidmvp_bind.databinding.CompoundViewActivityBinding;
import org.greenfroyo.baseapp_mvp_bind.app.toolbar.BaseToolbarActivity;

/**
 * Created by fchristysen on 6/27/16.
 */

public class CompoundViewActivity extends BaseToolbarActivity<CompoundViewPresenter, CompoundViewViewModel> {
    private CompoundViewActivityBinding mBinding;

    @Override
    protected ViewDataBinding onInitView(CompoundViewViewModel viewModel) {
        mBinding = setBindView(R.layout.compound_view_activity);
        mBinding.setViewModel(viewModel);
        return mBinding;
    }

    @Override
    public CompoundViewPresenter createPresenter() {
        return new CompoundViewPresenter();
    }
}

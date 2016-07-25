package org.greenfroyo.androidmvp_bind.app.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.greenfroyo.androidmvp_bind.R;
import org.greenfroyo.androidmvp_bind.app.App;
import org.greenfroyo.androidmvp_bind.bridge.HomeBridge;
import org.greenfroyo.androidmvp_bind.domain.Home;
import org.greenfroyo.androidmvp_bind.provider.home.HomeProvider;
import org.greenfroyo.baseapp_mvp_bind.app.error.BaseErrorPresenter;
import org.greenfroyo.baseapp_mvp_bind.app.error.BaseErrorViewModel;

/**
 * Created by fchristysen on 6/7/16.
 */

public class HomePresenter extends BaseErrorPresenter<HomeViewModel> {

    //Provider
    private HomeProvider mHomeProvider;

    @Override
    public void onCreate(@Nullable Bundle presenterState) {
        mHomeProvider = new HomeProvider(App.context());
    }

    @Override
    public HomeViewModel onInitViewModel() {
        HomeViewModel model = new HomeViewModel();
        return model;
    }

    //region actionable
    public void refreshList() {
        getViewModel().setPageState(HomeViewModel.STATE_LOADING);

        if (Home.isAllowedToShow()) {
            getViewModel().clearContent();
            mHomeProvider.getMenuItems().map(HomeBridge::getHomeItem).subscribe(next -> {
                getViewModel().addContent(next);
            }, error -> {
                showError(BaseErrorViewModel.ERROR_500);
                getViewModel().setToastMessage(App.resources().getString(R.string.home_title_error_message));
            }, () -> {
                hideError();
                getViewModel().setPageState(HomeViewModel.STATE_SHOW);
            });
        } else {
            showError(BaseErrorViewModel.ERROR_500);
            getViewModel().setToastMessage(App.resources().getString(R.string.home_title_error_message));
        }
    }

    public void openPage(Context context, Class pageClass) {
        Intent intent = new Intent(context, pageClass);
        context.startActivity(intent);
    }
    //region end
}

package org.greenfroyo.mvp_bind.view;

import android.content.Context;

import org.greenfroyo.mvp_bind.model.MvpViewModel;
import org.greenfroyo.mvp_bind.presenter.MvpPresenter;

/**
 * Created by fchristysen on 1/21/16.
 */
public interface MvpView<P extends MvpPresenter, VM extends MvpViewModel> {

    /**
     * Returns the context the view is running in, through which it can
     * access the current theme, resources, etc.
     *
     * @return The view's Context.
     */
    Context getContext();

    /**
     * Returns a current attached presenter.
     * This method is guaranteed to return a non-null value between
     * onCreate/onDetachedView and onAttachedToWindow/onDetachedFromWindow calls
     *
     * @return a currently attached presenter or null.
     */
    P getPresenter();

}

package org.greenfroyo.mvp_bind.base;

import android.os.Bundle;
import android.util.Log;

import org.greenfroyo.mvp_bind.presenter.Presenter;
import org.parceler.ParcelerRuntimeException;
import org.parceler.Parcels;

/**
 * Created by fchristysen on 7/17/16.
 */
public abstract class BaseMvpPresenter<VM extends BaseMvpViewModel> extends Presenter<VM> {
    private VM mViewModel;

    @Override
    public final void create(Bundle savedPresenterState) {
        if (savedPresenterState != null && savedPresenterState.containsKey(KEY_VIEW_MODEL)) {
            try {
                mViewModel = Parcels.unwrap(savedPresenterState.getParcelable(KEY_VIEW_MODEL));
            } catch (ParcelerRuntimeException e) {
                Log.e("ParcelerRuntimeError", mViewModel.getClass() + " does not have @Parcel annotation. the view model cannot be parceled.");
                Log.w("ParcelerRuntimeError", e.getMessage());
            }
        }
        if (mViewModel == null) {
            mViewModel = onInitViewModel();
        }
        super.create(savedPresenterState);
        getViewModel().attachOnPropertyChangeCallback();
    }

    @Override
    protected VM onRestoredViewModel() {
        return mViewModel;
    }

    @Override
    public final void saveInstanceState(Bundle outPresenterState) {
        try {
            outPresenterState.putParcelable(KEY_VIEW_MODEL, Parcels.wrap(getViewModel()));
        } catch (ParcelerRuntimeException e) {
            Log.e("ParcelerRuntimeError", mViewModel.getClass() + " does not have @Parcel annotation. the view model cannot be parceled.");
            Log.w("ParcelerRuntimeError", e.getMessage());
        }
        super.saveInstanceState(outPresenterState);
    }

    @Override
    public final void destroy() {
        super.destroy();
        getViewModel().detachOnPropertyChangeCallback();
    }
}

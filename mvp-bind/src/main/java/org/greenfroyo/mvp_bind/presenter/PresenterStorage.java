package org.greenfroyo.mvp_bind.presenter;

import android.support.v4.util.LruCache;

import com.google.common.cache.CacheBuilder;
import com.google.repacked.antlr.v4.runtime.misc.Nullable;

import org.greenfroyo.mvp_bind.util.AppUtil;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by fchristysen on 5/20/16.
 */
public class PresenterStorage {
    private static final String TAG = PresenterStorage.class.getSimpleName();
    private static final int MAX_ENTRY = 2;

    private static PresenterStorage instance;

    private final LruCache<String, MvpPresenter<?>> mPresenters;

    private PresenterStorage(int maxEntry){
        mPresenters = new LruCache<>(maxEntry);
    }

    public static PresenterStorage getInstance(){
        if(instance == null){
            instance = new PresenterStorage(MAX_ENTRY);
        }
        return instance;
    }

    @Nullable
    public <P extends MvpPresenter<?>> P get(String presenterId){
        P presenter = null;
        try {
            presenter = (P)mPresenters.get(presenterId);
        }catch(ClassCastException e){
            e.printStackTrace();
        }
        return presenter;
    }

    public void add(final MvpPresenter<?> presenter) {
        mPresenters.put(presenter.getID(), presenter);
        presenter.addOnDestroyListener(new MvpPresenter.OnDestroyListener() {
            @Override
            public void onDestroy(String presenterId) {
                mPresenters.remove(presenterId);
                logPresenterList();
            }
        });
        logPresenterList();
    }

    public void logPresenterList(){
        AppUtil.log("Presenter list : " );
        Map<String, MvpPresenter<?>> content = mPresenters.snapshot();
        for(String item : content.keySet()){
            AppUtil.log("list : " + item);
        }
    }
}

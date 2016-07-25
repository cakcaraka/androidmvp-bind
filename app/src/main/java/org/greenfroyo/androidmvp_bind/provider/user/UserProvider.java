package org.greenfroyo.androidmvp_bind.provider.user;

import android.content.Context;


import org.greenfroyo.baseapp_mvp_bind.app.BaseProvider;
import org.greenfroyo.baseapp_mvp_bind.view.recyclerview.CommonTransformer;

import java.util.Random;

import rx.Observable;

/**
 * Created by fchristysen on 6/30/16.
 */

public class UserProvider extends BaseProvider {

    public static final int LOGIN_SUCCESS = 0;
    public static final int LOGIN_ERROR_NO_ACCOUNT = 1;

    public UserProvider(Context context) {
        super(context);
    }

    public Observable<Integer> login(String username, String password){
        Integer results;
        if(username.equals(password)) {
            results = new Integer(LOGIN_SUCCESS);
        }else{
            results = new Integer(LOGIN_ERROR_NO_ACCOUNT);
        }
        return Observable.just(results).map(next -> {
            try{
                Thread.sleep(new Random().nextInt(2000) + 1000);
            }catch (InterruptedException e){}
            return next;
        }).compose(CommonTransformer.toIOThread());
    }
}

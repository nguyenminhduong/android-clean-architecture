package com.hieupham.cleanarchitecture.data.source.local.api;

import com.hieupham.cleanarchitecture.data.source.local.api.dao.TaskDao;
import com.hieupham.cleanarchitecture.data.source.local.api.dao.UserDao;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.schedulers.Schedulers;

/**
 * Created by hieupham on 1/13/18.
 */

public class RoomApiImpl implements RoomApi {

    private DatabaseManager databaseManager;

    public RoomApiImpl(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public UserDao userDao() {
        return databaseManager.userDao();
    }

    @Override
    public TaskDao taskDao() {
        return databaseManager.taskDao();
    }

    @Override
    public <T> Observable<T> execute(final Action2<Subscriber<? super T>, RoomApi> action) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    action.call(subscriber, RoomApiImpl.this);
                    subscriber.onCompleted();
                } catch (Exception ex) {
                    subscriber.onError(ex);
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    @Override
    public <T> Observable<T> query(Action2<Subscriber<? super T>, RoomApi> action) {
        return execute(action).observeOn(AndroidSchedulers.mainThread());
    }
}

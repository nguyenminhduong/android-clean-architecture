package com.hieupham.cleanarchitecture.data.source.local.api;

import com.hieupham.cleanarchitecture.data.source.local.api.dao.TaskDao;
import com.hieupham.cleanarchitecture.data.source.local.api.dao.UserDao;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action2;

/**
 * Created by hieupham on 1/13/18.
 */

public interface RoomApi {

    UserDao userDao();

    TaskDao taskDao();

    <T> Observable<T> execute(Action2<Subscriber<? super T>, RoomApi> action);

    <T> Observable<T> query(Action2<Subscriber<? super T>, RoomApi> action);
}

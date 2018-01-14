package com.hieupham.cleanarchitecture.data.source.local;

import com.hieupham.cleanarchitecture.data.source.local.api.RoomApi;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action2;

/**
 * Created by hieupham on 1/13/18.
 */

public abstract class LocalDataSource {

    private RoomApi roomApi;

    LocalDataSource(RoomApi roomApi) {
        this.roomApi = roomApi;
    }

    public <T> Observable<T> execute(final Action2<Subscriber<? super T>, RoomApi> action) {
        return roomApi.execute(action);
    }

    public <T> Observable<T> query(Action2<Subscriber<? super T>, RoomApi> action) {
        return roomApi.query(action);
    }
}

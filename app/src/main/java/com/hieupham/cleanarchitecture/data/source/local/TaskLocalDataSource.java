package com.hieupham.cleanarchitecture.data.source.local;

import com.hieupham.cleanarchitecture.data.model.Task;
import com.hieupham.cleanarchitecture.data.source.local.api.RoomApi;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action2;

/**
 * Created by hieupham on 1/13/18.
 */

public class TaskLocalDataSource extends LocalDataSource {

    @Inject
    TaskLocalDataSource(RoomApi roomApi) {
        super(roomApi);
    }

    public Observable<Task> getById(final String uid) {
        return query(new Action2<Subscriber<? super Task>, RoomApi>() {
            @Override
            public void call(Subscriber<? super Task> subscriber, RoomApi roomApi) {
                subscriber.onNext(roomApi.taskDao().getById(uid));
            }
        });
    }

    public Observable<Task> saveTask(final Task task) {
        return execute(new Action2<Subscriber<? super Task>, RoomApi>() {
            @Override
            public void call(Subscriber<? super Task> subscriber, RoomApi roomApi) {
                roomApi.taskDao().save(task);
                subscriber.onNext(task);
            }
        });
    }

    public Observable<List<Task>> saveTasks(final List<Task> tasks) {
        return execute(new Action2<Subscriber<? super List<Task>>, RoomApi>() {
            @Override
            public void call(Subscriber<? super List<Task>> subscriber, RoomApi roomApi) {
                roomApi.taskDao().save(tasks);
                subscriber.onNext(tasks);
            }
        });
    }
}

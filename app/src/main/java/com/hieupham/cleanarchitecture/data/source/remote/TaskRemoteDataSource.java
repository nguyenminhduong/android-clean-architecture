package com.hieupham.cleanarchitecture.data.source.remote;

import com.hieupham.cleanarchitecture.data.model.Task;
import com.hieupham.cleanarchitecture.data.source.remote.api.request.CreateTaskRequest;
import com.hieupham.cleanarchitecture.data.source.remote.api.service.AuthApi;
import com.hieupham.cleanarchitecture.data.source.remote.api.service.NonAuthApi;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by hieupham on 1/13/18.
 */

public class TaskRemoteDataSource extends RemoteDataSource {

    @Inject
    public TaskRemoteDataSource(AuthApi authApi, NonAuthApi nonAuthApi) {
        super(authApi, nonAuthApi);
    }

    public Observable<List<Task>> getTasksByOwner(String uid) {
        return authApi.getTasks(uid).subscribeOn(Schedulers.io());
    }

    public Observable<Task> createTask(Task task) {
        return authApi.createTask(new CreateTaskRequest(task)).subscribeOn(Schedulers.io());
    }

    public Observable<Task> updateTaskStatus(String uid, String status) {
        return authApi.updateTaskStatus(uid, status).subscribeOn(Schedulers.io());
    }
}

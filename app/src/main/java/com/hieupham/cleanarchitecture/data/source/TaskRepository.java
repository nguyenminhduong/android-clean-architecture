package com.hieupham.cleanarchitecture.data.source;

import com.hieupham.cleanarchitecture.data.model.Task;
import com.hieupham.cleanarchitecture.data.source.local.TaskLocalDataSource;
import com.hieupham.cleanarchitecture.data.source.remote.TaskRemoteDataSource;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hieupham on 1/13/18.
 */

public class TaskRepository implements Repository {

    private TaskLocalDataSource localDataSource;
    private TaskRemoteDataSource remoteDataSource;

    public TaskRepository(TaskRemoteDataSource remoteDataSource,
            TaskLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public Observable<List<Task>> getTasksByOwner(String uid) {
        return remoteDataSource.getTasksByOwner(uid)
                .flatMap(new Func1<List<Task>, Observable<List<Task>>>() {
                    @Override
                    public Observable<List<Task>> call(List<Task> tasks) {
                        return localDataSource.saveTasks(tasks);
                    }
                });
    }

    public Observable<Task> getById(String uid) {
        return localDataSource.getById(uid);
    }

    public Observable<Task> createTask(Task task) {
        return remoteDataSource.createTask(task).flatMap(new Func1<Task, Observable<Task>>() {
            @Override
            public Observable<Task> call(Task task) {
                return localDataSource.saveTask(task);
            }
        });
    }

    public Observable<Task> updateTaskStatus(String uid, String status) {
        return remoteDataSource.updateTaskStatus(uid, status)
                .flatMap(new Func1<Task, Observable<Task>>() {
                    @Override
                    public Observable<Task> call(Task task) {
                        return localDataSource.saveTask(task);
                    }
                });
    }
}

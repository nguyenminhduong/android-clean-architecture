package com.hieupham.cleanarchitecture.feature.tasklist;

import com.hieupham.cleanarchitecture.data.model.Task;
import com.hieupham.cleanarchitecture.data.source.TaskRepository;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by jollyjoker992 on 13/01/2018.
 */

public class TaskListPresenter implements TaskListContract.Presenter {

    private TaskRepository taskRepo;
    private TaskListContract.View view;

    TaskListPresenter(TaskListContract.View view, TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void getTasks(String uid) {
        taskRepo.getTasksByOwner(uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Task>>() {
                    @Override
                    public void call(List<Task> tasks) {
                        view.showTasks(tasks);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        view.showError(throwable);
                    }
                });
    }
}

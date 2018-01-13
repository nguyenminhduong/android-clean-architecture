package com.hieupham.cleanarchitecture.feature.tasklist;

import com.hieupham.cleanarchitecture.ActivityScope;
import com.hieupham.cleanarchitecture.data.source.TaskRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jollyjoker992 on 13/01/2018.
 */

@Module
public class TaskListModule {

    private TaskListContract.View view;

    TaskListModule(TaskListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TaskListContract.Presenter providePresenter(TaskRepository taskRepo) {
        return new TaskListPresenter(view, taskRepo);
    }
}

package com.hieupham.cleanarchitecture.feature.tasklist;

import com.hieupham.cleanarchitecture.ActivityScope;
import com.hieupham.cleanarchitecture.AppComponent;
import dagger.Component;

/**
 * Created by jollyjoker992 on 13/01/2018.
 */

@Component(dependencies = AppComponent.class, modules = TaskListModule.class)
@ActivityScope
public interface TaskListComponent {

    void inject(TaskListActivity activity);
}

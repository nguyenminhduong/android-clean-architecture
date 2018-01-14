package com.hieupham.cleanarchitecture.feature.tasklist;

import com.hieupham.cleanarchitecture.data.model.Task;
import com.hieupham.cleanarchitecture.feature.BasePresenter;
import com.hieupham.cleanarchitecture.feature.BaseView;
import java.util.List;

/**
 * Created by jollyjoker992 on 13/01/2018.
 */

public interface TaskListContract {

    interface View extends BaseView {

        void showTasks(List<Task> tasks);

        void showError(Throwable throwable);
    }

    interface Presenter extends BasePresenter {

        void getTasks(String uid);
    }
}

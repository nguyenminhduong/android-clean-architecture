package com.hieupham.cleanarchitecture.feature.tasklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hieupham.cleanarchitecture.MvpCleanApplication;
import com.hieupham.cleanarchitecture.R;
import com.hieupham.cleanarchitecture.data.model.Task;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by jollyjoker992 on 13/01/2018.
 */

public class TaskListActivity extends AppCompatActivity implements TaskListContract.View {

    @Inject
    TaskListContract.Presenter presenter;

    @BindView(R.id.recycler_task)
    RecyclerView recyclerTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerTaskListComponent.builder()
                .appComponent(((MvpCleanApplication) getApplication()).getComponent())
                .taskListModule(new TaskListModule(this))
                .build()
                .inject(this);
        setContentView(R.layout.activity_task_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getTasks("my-uid");
    }

    @Override
    public void showTasks(List<Task> tasks) {
        // Show tasks in RecyclerView
    }

    @Override
    public void showError(Throwable throwable) {
        // Show error alert
    }
}

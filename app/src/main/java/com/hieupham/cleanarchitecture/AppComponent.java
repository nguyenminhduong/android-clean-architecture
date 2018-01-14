package com.hieupham.cleanarchitecture;

import android.content.Context;
import com.google.gson.Gson;
import com.hieupham.cleanarchitecture.data.source.RepositoryModule;
import com.hieupham.cleanarchitecture.data.source.TaskRepository;
import com.hieupham.cleanarchitecture.data.source.UserRepository;
import com.hieupham.cleanarchitecture.data.source.local.api.DatabaseManager;
import com.hieupham.cleanarchitecture.data.source.remote.api.NetworkModule;
import dagger.Component;

/**
 * Created by hieupham on 1/13/18.
 */

@AppScope
@Component(modules = { RepositoryModule.class, NetworkModule.class, ApplicationModule.class})
public interface AppComponent {

    Context context();

    TaskRepository taskRepo();

    UserRepository userRepo();

    Gson gson();

    DatabaseManager databaseManager();

}

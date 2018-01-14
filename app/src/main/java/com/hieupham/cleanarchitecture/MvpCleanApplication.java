package com.hieupham.cleanarchitecture;

import android.app.Application;
import com.hieupham.cleanarchitecture.data.source.RepositoryModule;
import com.hieupham.cleanarchitecture.data.source.remote.api.NetworkModule;

/**
 * Created by hieupham on 1/13/18.
 */

public class MvpCleanApplication extends Application {

    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}

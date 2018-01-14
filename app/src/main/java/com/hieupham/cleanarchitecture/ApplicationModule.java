package com.hieupham.cleanarchitecture;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * Created by hieupham on 1/13/18.
 */

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context){
        this.context = context;
    }

    @Provides
    @AppScope
    Context provideContext(){
        return context;
    }

}

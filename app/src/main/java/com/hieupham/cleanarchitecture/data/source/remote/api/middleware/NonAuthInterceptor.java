package com.hieupham.cleanarchitecture.data.source.remote.api.middleware;

import android.content.Context;

/**
 * Created by hieupham on 1/13/18.
 */

public class NonAuthInterceptor extends Interceptor {

    public NonAuthInterceptor(Context context) {
        super(context);
    }
}

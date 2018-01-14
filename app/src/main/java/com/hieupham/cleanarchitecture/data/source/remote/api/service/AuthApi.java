package com.hieupham.cleanarchitecture.data.source.remote.api.service;

import com.hieupham.cleanarchitecture.data.model.Task;
import com.hieupham.cleanarchitecture.data.source.remote.api.request.CreateTaskRequest;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hieupham on 1/13/18.
 */

public interface AuthApi {

    @POST("api/task/create")
    Observable<Task> createTask(@Body CreateTaskRequest request);

    @PUT("api/task/update")
    @FormUrlEncoded
    Observable<Task> updateTaskStatus(@Path("uid") String uid, @Path("status") String status);
}

package ru.scorocode.android.api.service;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import ru.scorocode.android.api.request.ScriptRequestEntity;
import ru.scorocode.android.api.request.StatRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.response.StatsResponse;

public interface ScriptService {

    @POST("scripts")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> scripts(@Body ScriptRequestEntity entity);

    @POST("stat")
    @Headers({"Content-Type: application/json"})
    Call<StatsResponse> stat(@Body StatRequestEntity entity);
}

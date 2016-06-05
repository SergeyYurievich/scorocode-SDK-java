package ru.scorocode.android.api.service;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import ru.scorocode.android.api.request.MessagingRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;

public interface MessageService {

    @POST("sendemail")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> sendEmail(@Body MessagingRequestEntity entity);

    @POST("sendpush")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> sendPush(@Body MessagingRequestEntity entity);

    @POST("sendsms")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> sendSms(@Body MessagingRequestEntity entity);
}

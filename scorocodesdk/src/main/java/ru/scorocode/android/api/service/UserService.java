package ru.scorocode.android.api.service;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import ru.scorocode.android.api.request.LoginRequestEntity;
import ru.scorocode.android.api.request.LogoutRequestEntity;
import ru.scorocode.android.api.request.RegistrationRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.response.LoginResponse;
import ru.scorocode.android.api.response.RegistrationResponse;

public interface UserService {

    @POST("register")
    @Headers({"Content-Type: application/json"})
    Call<RegistrationResponse> signup(@Body RegistrationRequestEntity entity);

    @POST("login")
    @Headers({"Content-Type: application/json"})
    Call<LoginResponse> login(@Body LoginRequestEntity entity);

    @POST("logout")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> logout(@Body LogoutRequestEntity entity);

}

package ru.scorocode.android.manager;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.service.SCServiceFactory;
import ru.scorocode.android.api.response.entity.LoginResponseEntity;
import ru.scorocode.android.api.response.entity.RegistrationResponseEntity;
import ru.scorocode.android.api.request.LoginRequestEntity;
import ru.scorocode.android.api.request.LogoutRequestEntity;
import ru.scorocode.android.api.request.RegistrationRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.response.LoginResponse;
import ru.scorocode.android.api.response.RegistrationResponse;
import ru.scorocode.android.api.service.UserService;
import ru.scorocode.android.main.SC;
import ru.scorocode.android.main.Session;

public class UserManager {

    public void signup(final SCCallback<RegistrationResponseEntity> callback, String username, String email, String password) {

        UserService service = SCServiceFactory.create(UserService.class);
        final RegistrationRequestEntity registrationRequestEntity = new RegistrationRequestEntity(username, email, password);
        SC.initRequest(registrationRequestEntity);

        Call<RegistrationResponse> call = service.signup(registrationRequestEntity);
        call.enqueue(new Callback<RegistrationResponse>() {

            @Override
            public void onResponse(Response<RegistrationResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(response.body().getResult());
                } else {
                    callback.onError(response.body().getErrMsg());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void login(final SCCallback<LoginResponseEntity> callback, String email, String password) {

        UserService service = SCServiceFactory.create(UserService.class);
        final LoginRequestEntity loginRequestEntity = new LoginRequestEntity(email, password);
        SC.initRequest(loginRequestEntity);

        Call<LoginResponse> call = service.login(loginRequestEntity);
        call.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Response<LoginResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    LoginResponseEntity loginResponse = response.body().getResult();
                    Session.setSessionKey(loginResponse.getSessionId());
                    callback.onSuccess(loginResponse);
                } else {
                    callback.onError(response.body().getErrMsg());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    public void logout(final SCCallback<Boolean> callback) {
        UserService service = SCServiceFactory.create(UserService.class);
        final LogoutRequestEntity loginRequestEntity = new LogoutRequestEntity();
        SC.initRequest(loginRequestEntity);

        Call<BaseResponse> call = service.logout(loginRequestEntity);
        call.enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(true);
                } else {
                    callback.onError("Logout failed");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}

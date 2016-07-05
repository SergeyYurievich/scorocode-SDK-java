package ru.scorocode.android.manager;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.scorocode.android.api.request.StatRequestEntity;
import ru.scorocode.android.api.response.StatsResponse;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.service.SCServiceFactory;
import ru.scorocode.android.api.request.ScriptRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.service.ScriptService;
import ru.scorocode.android.main.SC;

public class ScriptManager {

    public void scripts(final SCCallback<Boolean> callback, String scriptId, String[] pool) {
        ScriptService service = SCServiceFactory.create(ScriptService.class);
        final ScriptRequestEntity scriptRequestEntity = new ScriptRequestEntity(scriptId, pool);
        SC.initRequest(scriptRequestEntity);

        Call<BaseResponse> call = service.scripts(scriptRequestEntity);
        call.enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(true);
                } else {
                    callback.onError("Failed to send script");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void stats(final SCCallback<Boolean> callback) {
        ScriptService service = SCServiceFactory.create(ScriptService.class);
        final StatRequestEntity statRequestEntity = new StatRequestEntity();
        SC.initRequest(statRequestEntity);

        Call<StatsResponse> call = service.stat(statRequestEntity);
        call.enqueue(new Callback<StatsResponse>() {

            @Override
            public void onResponse(Response<StatsResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(true);
                } else {
                    callback.onError("Failed to get stats");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}

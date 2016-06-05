package ru.scorocode.android.manager;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.service.SCServiceFactory;
import ru.scorocode.android.api.response.entity.DataResponseEntity;
import ru.scorocode.android.api.response.entity.UpdateDataResponseEntity;
import ru.scorocode.android.api.request.CountRequestEntity;
import ru.scorocode.android.api.request.FindRequestEntity;
import ru.scorocode.android.api.request.InsertFileRequestEntity;
import ru.scorocode.android.api.request.RemoveFileRequestEntity;
import ru.scorocode.android.api.request.UpdateFileRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.response.CountResponse;
import ru.scorocode.android.api.response.DataResponse;
import ru.scorocode.android.api.response.UpdateDataResponse;
import ru.scorocode.android.api.service.DataService;
import ru.scorocode.android.main.SC;
import ru.scorocode.android.model.Object;
import ru.scorocode.android.model.Query;

public class DataManager {

    public void insert(final SCCallback<DataResponseEntity> callback, String sess, String coll, Object doc) {

        DataService service = SCServiceFactory.create(DataService.class);
        final InsertFileRequestEntity insertFileRequestEntity = new InsertFileRequestEntity(sess, coll, doc);
        SC.initRequest(insertFileRequestEntity);

        Call<DataResponse> call = service.insert(insertFileRequestEntity);
        call.enqueue(new Callback<DataResponse>() {

            @Override
            public void onResponse(Response<DataResponse> response, Retrofit retrofit) {
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

    public void remove(final SCCallback<UpdateDataResponseEntity> callback, String sess, String coll, Query query) {

        DataService service = SCServiceFactory.create(DataService.class);
        final RemoveFileRequestEntity removeFileRequestEntity = new RemoveFileRequestEntity(sess, coll, query);
        SC.initRequest(removeFileRequestEntity);

        Call<UpdateDataResponse> call = service.remove(removeFileRequestEntity);
        call.enqueue(new Callback<UpdateDataResponse>() {

            @Override
            public void onResponse(Response<UpdateDataResponse> response, Retrofit retrofit) {
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

    public void update(final SCCallback<UpdateDataResponseEntity> callback, String sess, String acc, String coll, Query query, Object doc, int limit) {

        DataService service = SCServiceFactory.create(DataService.class);
        final UpdateFileRequestEntity updateFileRequestEntity = new UpdateFileRequestEntity(sess, acc, coll, query, doc, limit);
        SC.initRequest(updateFileRequestEntity);

        Call<UpdateDataResponse> call = service.update(updateFileRequestEntity);
        call.enqueue(new Callback<UpdateDataResponse>() {

            @Override
            public void onResponse(Response<UpdateDataResponse> response, Retrofit retrofit) {
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

    public void updateById(final SCCallback<UpdateDataResponseEntity> callback, String sess, String acc, String coll, Query query, Object doc, int limit) {

        DataService service = SCServiceFactory.create(DataService.class);
        final UpdateFileRequestEntity updateFileRequestEntity = new UpdateFileRequestEntity(sess, acc, coll, query, doc, limit);
        SC.initRequest(updateFileRequestEntity);

        Call<UpdateDataResponse> call = service.updatebyid(updateFileRequestEntity);
        call.enqueue(new Callback<UpdateDataResponse>() {

            @Override
            public void onResponse(Response<UpdateDataResponse> response, Retrofit retrofit) {
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

    public void find(final SCCallback<String> callback, String sess, String coll, Query query) {

        DataService service = SCServiceFactory.create(DataService.class);
        final FindRequestEntity findRequestEntity = new FindRequestEntity(sess, coll, query);
        SC.initRequest(findRequestEntity);

        Call<BaseResponse> call = service.find(findRequestEntity);
        call.enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(response.body().getResult().toString());
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

    public void count(final SCCallback<Integer> callback, String sess, String coll, Query query) {

        DataService service = SCServiceFactory.create(DataService.class);
        final CountRequestEntity countRequestEntity = new CountRequestEntity(sess, coll, query);
        SC.initRequest(countRequestEntity);

        Call<CountResponse> call = service.count(countRequestEntity);
        call.enqueue(new Callback<CountResponse>() {

            @Override
            public void onResponse(Response<CountResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(response.body().getResult().getCount());
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

}

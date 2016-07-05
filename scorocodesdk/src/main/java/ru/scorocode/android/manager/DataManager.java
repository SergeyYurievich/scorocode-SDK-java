package ru.scorocode.android.manager;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.scorocode.android.api.request.CountRequestEntity;
import ru.scorocode.android.api.request.FindRequestEntity;
import ru.scorocode.android.api.request.InsertFileRequestEntity;
import ru.scorocode.android.api.request.RemoveFileRequestEntity;
import ru.scorocode.android.api.request.UpdateFileRequestEntity;
import ru.scorocode.android.api.response.CountResponse;
import ru.scorocode.android.api.response.DataResponse;
import ru.scorocode.android.api.response.FindResponse;
import ru.scorocode.android.api.response.UpdateDataResponse;
import ru.scorocode.android.api.response.entity.DataResponseEntity;
import ru.scorocode.android.api.response.entity.UpdateDataResponseEntity;
import ru.scorocode.android.api.service.DataService;
import ru.scorocode.android.api.service.SCServiceFactory;
import ru.scorocode.android.main.SC;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.model.Object;
import ru.scorocode.android.model.Query;

public class DataManager {

    public void insert(final SCCallback<DataResponseEntity> callback, String coll, Object doc) {

        DataService service = SCServiceFactory.create(DataService.class);
        final InsertFileRequestEntity insertFileRequestEntity = new InsertFileRequestEntity(coll, doc);
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

    public void remove(final SCCallback<UpdateDataResponseEntity> callback, String coll, String id) {

        DataService service = SCServiceFactory.create(DataService.class);
        final RemoveFileRequestEntity removeFileRequestEntity = new RemoveFileRequestEntity(coll, id);
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

    public void update(final SCCallback<UpdateDataResponseEntity> callback, String coll, Object doc, String id) {

        DataService service = SCServiceFactory.create(DataService.class);
        final UpdateFileRequestEntity updateFileRequestEntity = new UpdateFileRequestEntity(coll, doc, id);
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

    public void updateById(final SCCallback<UpdateDataResponseEntity> callback, String coll, Object doc, String id) {

        DataService service = SCServiceFactory.create(DataService.class);
        final UpdateFileRequestEntity updateFileRequestEntity = new UpdateFileRequestEntity(coll, doc, id);
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

    public void find(final SCCallback<List<Object>> callback, String coll, String id) {

        DataService service = SCServiceFactory.create(DataService.class);
        final FindRequestEntity findRequestEntity = new FindRequestEntity(coll, id);
        SC.initRequest(findRequestEntity);

        Call<FindResponse> call = service.find(findRequestEntity);
        call.enqueue(new Callback<FindResponse>() {

            @Override
            public void onResponse(Response<FindResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(response.body().getResult().getList());
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

    public void count(final SCCallback<Integer> callback, String coll, Query query) {

        DataService service = SCServiceFactory.create(DataService.class);
        final CountRequestEntity countRequestEntity = new CountRequestEntity(coll, query);
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

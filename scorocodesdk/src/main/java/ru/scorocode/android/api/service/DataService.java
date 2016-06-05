package ru.scorocode.android.api.service;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import ru.scorocode.android.api.request.CountRequestEntity;
import ru.scorocode.android.api.request.FindRequestEntity;
import ru.scorocode.android.api.request.InsertFileRequestEntity;
import ru.scorocode.android.api.request.RemoveFileRequestEntity;
import ru.scorocode.android.api.request.UpdateFileRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.response.CountResponse;
import ru.scorocode.android.api.response.DataResponse;
import ru.scorocode.android.api.response.UpdateDataResponse;

public interface DataService {

    @POST("data/insert")
    @Headers({"Content-Type: application/json"})
    Call<DataResponse> insert(@Body InsertFileRequestEntity entity);

    @POST("data/remove")
    @Headers({"Content-Type: application/json"})
    Call<UpdateDataResponse> remove(@Body RemoveFileRequestEntity entity);

    @POST("data/update")
    @Headers({"Content-Type: application/json"})
    Call<UpdateDataResponse> update(@Body UpdateFileRequestEntity entity);

    @POST("data/updatebyid")
    @Headers({"Content-Type: application/json"})
    Call<UpdateDataResponse> updatebyid(@Body UpdateFileRequestEntity entity);

    @POST("data/find")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> find(@Body FindRequestEntity entity);

    @POST("data/count")
    @Headers({"Content-Type: application/json"})
    Call<CountResponse> count(@Body CountRequestEntity entity);

}

package ru.scorocode.android.api.service;

import okhttp3.ResponseBody;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import ru.scorocode.android.api.request.DeleteFileRequestEntity;
import ru.scorocode.android.api.request.FileUploadRequestEntity;
import ru.scorocode.android.api.request.GetFileLinkRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;

public interface FileService {

    @POST("upload")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> upload(@Body FileUploadRequestEntity entity);

    @GET("getfile/{app}/{coll}/{field}/{file}")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> getfile(@Path("app") String app, @Path("coll") String coll, @Path("field") String field, @Path("file") String file);

    @POST("getfilelink")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> getfilelink(@Body GetFileLinkRequestEntity entity);

    @POST("deletefile")
    @Headers({"Content-Type: application/json"})
    Call<BaseResponse> deletefile(@Body DeleteFileRequestEntity entity);
}

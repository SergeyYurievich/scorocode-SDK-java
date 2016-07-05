package ru.scorocode.android.manager;

import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.scorocode.android.api.request.DeleteFileRequestEntity;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.service.SCServiceFactory;
import ru.scorocode.android.api.request.FileUploadRequestEntity;
import ru.scorocode.android.api.request.GetFileLinkRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.service.FileService;
import ru.scorocode.android.main.SC;

public class FileManager {

    public void upload(final SCCallback<String> callback, String fileName, String coll, String doc, String field, String content) {

        FileService service = SCServiceFactory.create(FileService.class);
        final FileUploadRequestEntity fileUploadRequestEntity = new FileUploadRequestEntity(coll, fileName, doc, field, content);
        SC.initRequest(fileUploadRequestEntity);

        Call<BaseResponse> call = service.upload(fileUploadRequestEntity);
        call.enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess((String) response.body().getResult());
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

    public void getFile(final SCCallback<InputStream> callback, String coll, String field, String file) {

        FileService service = SCServiceFactory.create(FileService.class);

        Call<ResponseBody> call = service.getfile(SC.getAppId(), coll, field, file);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    InputStream input = response.body().byteStream();
                    callback.onSuccess(input);
                } else {
                    callback.onError("Failed to get file from server");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void getFileLink(final SCCallback<String> callback, String coll, String doc, String file) {

        FileService service = SCServiceFactory.create(FileService.class);
        final GetFileLinkRequestEntity getFileLinkRequestEntity = new GetFileLinkRequestEntity(coll, doc, file);
        SC.initRequest(getFileLinkRequestEntity);

        Call<BaseResponse> call = service.getfilelink(getFileLinkRequestEntity);
        call.enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess((String) response.body().getResult());
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

    public void deleteFile(final SCCallback<String> callback, String coll, String doc, String file) {

        FileService service = SCServiceFactory.create(FileService.class);
        final DeleteFileRequestEntity getFileLinkRequestEntity = new DeleteFileRequestEntity(coll, doc, file);
        SC.initRequest(getFileLinkRequestEntity);

        Call<BaseResponse> call = service.deletefile(getFileLinkRequestEntity);
        call.enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess((String) response.body().getResult());
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

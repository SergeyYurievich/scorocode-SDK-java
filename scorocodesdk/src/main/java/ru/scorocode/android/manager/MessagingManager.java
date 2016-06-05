package ru.scorocode.android.manager;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.service.SCServiceFactory;
import ru.scorocode.android.api.request.MessagingRequestEntity;
import ru.scorocode.android.api.response.BaseResponse;
import ru.scorocode.android.api.service.MessageService;
import ru.scorocode.android.main.SC;
import ru.scorocode.android.main.SCException;
import ru.scorocode.android.model.Message;

public class MessagingManager {

    public enum MessageType {EMAIL, PUSH, SMS}

    public void send(final SCCallback<Boolean> callback, String sessionId, String accessKey, Message msg, MessageType type) {
        MessageService service = SCServiceFactory.create(MessageService.class);
        final MessagingRequestEntity messagingRequestEntity = new MessagingRequestEntity(sessionId, accessKey, msg);
        SC.initRequest(messagingRequestEntity);

        Call<BaseResponse> call;
        switch (type) {
            case EMAIL:
                call = service.sendEmail(messagingRequestEntity);
                break;
            case PUSH:
                call = service.sendPush(messagingRequestEntity);
                break;
            case SMS:
                call = service.sendSms(messagingRequestEntity);
                break;
            default:
                throw new SCException("Invalid message type");
        }

        call.enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                if (response.isSuccess() && !response.body().hasError()) {
                    callback.onSuccess(true);
                } else {
                    callback.onError("Failed to send message");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}

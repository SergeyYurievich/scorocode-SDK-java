package ru.scorocode.android.api.service;

import retrofit.GsonConverterFactory;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.Retrofit;
import ru.scorocode.android.main.SCConfig;

public class SCServiceFactory {

    public static final String BASE_URL = SCConfig.API_URL;

    private SCServiceFactory() {
    }

    public static <ServiceType> ServiceType create(Class<ServiceType> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SCServiceFactory.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

}
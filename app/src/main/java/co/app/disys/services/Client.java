package co.app.disys.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private String BASE_URL="https://api.qa.mrhe.gov.ae/mrhecloud/v1.4/api/";
    private Retrofit mRetrofit;
    public APIService getInsance(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return mRetrofit.create(APIService.class);
    }
}

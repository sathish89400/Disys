package co.app.disys.services;

import com.google.gson.JsonElement;

import co.app.disys.Listview.model.Items;
import co.app.disys.form.data.model.reqEmp;
import co.app.disys.form.data.model.resultEmp;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIService {
    @GET("public/v1/news?local=en")
    Call<Items> getList(@Header("consumer-secret") String cons, @Header("consumer-key") String consmekey);

    @POST("iskan/v1/certificates/towhomitmayconcern")
    Call<resultEmp> sendFormData(@Header("consumer-secret") String cons, @Body reqEmp reqEmp);
}

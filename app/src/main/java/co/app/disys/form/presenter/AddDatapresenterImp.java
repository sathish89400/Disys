package co.app.disys.form.presenter;

import co.app.disys.form.data.model.reqEmp;
import co.app.disys.form.data.model.resultEmp;
import co.app.disys.form.ui.AddDataView;
import co.app.disys.services.APIService;
import co.app.disys.services.Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDatapresenterImp implements AddDataPresenter {

    APIService apiService;
    AddDataView addDataView;

    public AddDatapresenterImp(AddDataView addDataView) {
        if(apiService == null){
            apiService = new Client().getInsance();
        }

        this.addDataView = addDataView;
    }

    @Override
    public void sendAddDataResponse(reqEmp request) {
        apiService.sendFormData("20891a1b4504ddc33d42501f9c8d2215fbe85008",request).enqueue(new Callback<resultEmp>() {
            @Override
            public void onResponse(Call<resultEmp> call, Response<resultEmp> response) {
                if(response.code() == 200) {
                    addDataView.sendEmpData(response.body());
                }else{
                    addDataView.errorMsg(response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<resultEmp> call, Throwable t) {
                addDataView.errorMsg(t.getMessage());
            }
        });
    }
}

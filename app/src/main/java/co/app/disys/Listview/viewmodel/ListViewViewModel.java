package co.app.disys.Listview.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.widget.Toast;

import java.util.List;

import co.app.disys.Listview.model.Item;
import co.app.disys.Listview.model.Items;
import co.app.disys.services.APIService;
import co.app.disys.services.Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewViewModel extends ViewModel {
    private MutableLiveData<List<Item>> listviewData;
    private APIService apiService;

    public LiveData<List<Item>> getItems() {
        if (listviewData == null) {
            listviewData = new MutableLiveData<>();
            loaddata();
        }

        return listviewData;
    }

    public void loaddata() {
        if (apiService == null) {
            apiService = new Client().getInsance();
        }
        apiService.getList("20891a1b4504ddc33d42501f9c8d2215fbe85008","mobile_dev").enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                if (response.code() == 200) {
                    listviewData.setValue(response.body().getList());
                }
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {

            }
        });
    }

}

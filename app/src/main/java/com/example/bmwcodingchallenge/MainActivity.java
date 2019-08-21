package com.example.bmwcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.bmwcodingchallenge.data.LocationPojo;
import com.example.bmwcodingchallenge.data.remote.ApiClient;
import com.example.bmwcodingchallenge.data.remote.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getSimpleName();
RecyclerView recyclerView;
LocationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    protected void onStart(){
        super.onStart();
        getJson();
    }

    private void getJson(){
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);

        service.getLocations();

        Call<List<LocationPojo>> call = service.getLocations();
        call.enqueue(new Callback<List<LocationPojo>>() {
            @Override
            public void onResponse(Call<List<LocationPojo>> call, Response<List<LocationPojo>> response) {
                Log.i(TAG, response.body().get(0).getName());
                adapter = new LocationAdapter(MainActivity.this,response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LocationPojo>> call, Throwable t) {

            }
        });
    }
}

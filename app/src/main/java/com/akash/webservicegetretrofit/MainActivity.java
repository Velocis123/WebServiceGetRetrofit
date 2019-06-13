package com.akash.webservicegetretrofit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    final ArrayList arrayList = new ArrayList<List<Movies>>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);

        final Call<List<Movies>> call = service.getaAllMovies();

        call.enqueue(new Callback<List<Movies>>() {
            @Override
            public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {
              //arrayList.add(response);

                List<Movies> list=response.body();
               setadapter(list);
            }

            @Override
            public void onFailure(Call<List<Movies>> call, Throwable t) {

            }
        });



    }
    public void setadapter (List<Movies> arrayList){

        RVadapter adapter = new RVadapter(this,arrayList);
        RecyclerView recyclerView =findViewById(R.id.rec) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayout.VERTICAL,false));
        recyclerView.setAdapter(adapter);


    }




}

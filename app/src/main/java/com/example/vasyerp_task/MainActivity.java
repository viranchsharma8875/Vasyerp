package com.example.vasyerp_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    List<Root>list=new ArrayList<>();
    List<Datum>AllData=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Service service= Service.retrofit.create(Service.class);
        Call<Root>ClassOBj=service.getList();


        ClassOBj.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.isSuccessful())
                {

                    list.add(response.body());
                    for (Root root : list)
                    {
                    AllData.addAll(root.data);
                    }

                    Adapter_for_showData adapter=new Adapter_for_showData(MainActivity.this,AllData);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Occur Exception"+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("exception","Occur Exception"+t.getMessage());
            }
        });
    }
}
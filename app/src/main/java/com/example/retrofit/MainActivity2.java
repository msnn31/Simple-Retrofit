package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyler;
    private RecyclerAdapter adapter;
    ArrayList<PostModel> postModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
    }

    private void  initViews(){
        postModels = new ArrayList<>() ;
        recyler = findViewById(R.id.recyler);
        recyler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyler.setLayoutManager(layoutManager);
        getPostResponse();
    }

    private void getPostResponse(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface inteface = retrofit.create(RequestInterface.class);

        Call<List<PostModel>> listCall = inteface.getAllPost();

        listCall.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                postModels = new ArrayList<>(response.body());
                adapter = new RecyclerAdapter(MainActivity2.this, postModels);
                recyler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

                Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStop() {
        System.exit(0);
        super.onStop();
    }
}
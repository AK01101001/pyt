package com.example.pytania;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pytania.databinding.ActivityMainBinding;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Pytanie> pytania;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.dalej.setOnClickListener(view1 -> getData());
        binding.odp1.setOnClickListener(view1 -> answear(1));
        binding.odp2.setOnClickListener(view1 -> answear(2));
        binding.odp3.setOnClickListener(view1 -> answear(3));
    }

    private void answear(int i) {
        if (i==pytania.get(index).getOk())
        {
            Toast.makeText(this, "dobrze", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "źle", Toast.LENGTH_SHORT).show();
        }
    }

    private void getData() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait");
        progressDialog.show();


        Call<List<Pytanie>> call = RetrofitInstance.getApiInterface().getData();
        call.enqueue(new Callback<List<Pytanie>>() {
            @Override
            public void onResponse(Call<List<Pytanie>> call, Response<List<Pytanie>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "cos", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
                else{
                    pytania = response.body();
                    progressDialog.dismiss();
                    wyswietl();
                }
            }

            @Override
            public void onFailure(Call<List<Pytanie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "łukasz", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void wyswietl()
    {
        binding.pytanie.setText(pytania.get(index).getPytanie());
        binding.odp1.setText(pytania.get(index).getOdpowiedz1());
        binding.odp2.setText(pytania.get(index).getOdpowiedz2());
        binding.odp3.setText(pytania.get(index).getOdpowiedz3());
    }
}
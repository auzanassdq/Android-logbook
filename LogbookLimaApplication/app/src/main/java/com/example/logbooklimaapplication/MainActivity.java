package com.example.logbooklimaapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logbooklimaapplication.model.Sprint;
import com.example.logbooklimaapplication.model.SprintList;
import com.example.logbooklimaapplication.network.GetDataService;
import com.example.logbooklimaapplication.network.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    GetDataService service;
    Spinner spinnerSprint, spinnerTask;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        service = UtilsApi.getAPIService();

        spinnerSprint = findViewById(R.id.spinner_sprint);
        spinnerTask = findViewById(R.id.spinner_task);

        ambilldata();

        spinnerSprint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = parent.getItemAtPosition(position).toString();
                Toast.makeText(context, "Kamu memilih sprint " + selectedName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = parent.getItemAtPosition(position).toString();
                Toast.makeText(context, "Kamu memilih task " + selectedName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    void ambilldata(){
        service.getAllSprint().enqueue(new Callback<SprintList>() {
            @Override
            public void onResponse(Call<SprintList> call, Response<SprintList> response) {
                if (response.isSuccessful()) {
                    ArrayList<Sprint> sprints = response.body().getResults();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < sprints.size(); i++){
                        listSpinner.add(sprints.get(i).getTitle());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerSprint.setAdapter(adapter);
                } else {
                    Toast.makeText(context, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SprintList> call, Throwable t) {
                Toast.makeText(context, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

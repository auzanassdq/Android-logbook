package com.example.logbooklimaapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.logbooklimaapplication.model.Sprint;
import com.example.logbooklimaapplication.model.SprintList;
import com.example.logbooklimaapplication.network.GetDataService;
import com.example.logbooklimaapplication.network.UtilsApi;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


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
        String link = String.format("%slogbook/%s", getResources().getString((R.string.link)));
        StringRequest respon = new StringRequest(
                Request.Method.GET,
                link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            ArrayList<Sprint> list_data;
                            list_data = new ArrayList<>();
                            for(int i=0; i < list_data.size(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                int id = Integer.parseInt(object.getString("id"));
                                String nama_sprint = object.getString("nama_sprint");
                                String desc_sprint = "";
                                if(!object.isNull("desc_sprint")){
                                    desc_sprint = object.getString("desc_sprint");
                                }
                                String tgl_mulai = object.getString("tgl_mulai");
                                String tgl_selesai = object.getString("tgl_selesai");

                                list_data.add(new Sprint(
                                        id,
                                        nama_sprint,
                                        desc_sprint,
                                        tgl_mulai,
                                        tgl_selesai
                                ));
                            }

                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }

}

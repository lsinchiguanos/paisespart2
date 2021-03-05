package uteq.student.project.paisespart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uteq.student.project.paisespart2.adaptador.ListAdapter;
import uteq.student.project.paisespart2.entidad.Pais;
import uteq.student.project.paisespart2.entidad.Pais2;

public class MainActivity extends AppCompatActivity {

    private List<Pais2> paisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        String url = "http://www.geognos.com/api/en/countries/info/all.json";
        RequestQueue rque = Volley.newRequestQueue(this);
        paisList = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        String cabecera_pais;
                        String nombre_pais;
                        String nombre_capital;
                        String iso;
                        JSONObject jsonObjectResultado = response.getJSONObject("Results");
                        JSONArray jsonArrayObject = jsonObjectResultado.names();
                        for (int i = 0; i < jsonArrayObject.length(); i++) {
                            cabecera_pais = jsonArrayObject.getString(i);

                            /* INFORMACION PRINCIPAL */
                            JSONObject informacion = jsonObjectResultado.getJSONObject(cabecera_pais);
                            nombre_pais = informacion.getString("Name");

                            /* CAPITAL */
                            JSONObject jsonObjectCapital = informacion.getJSONObject("Capital");
                            nombre_capital = jsonObjectCapital.getString("Name");

                            /* CODECOUNTRY */
                            JSONObject jsonObjectCountryCodes = informacion.getJSONObject("CountryCodes");
                            iso = jsonObjectCountryCodes.getString("iso2");
                            paisList.add(new Pais2(nombre_pais, nombre_capital, iso));
                        }
                        ListAdapter listAdapter = new ListAdapter(paisList, this);
                        RecyclerView recyclerView = findViewById(R.id.list_item);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                        recyclerView.setAdapter(listAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.e("HttpClient", "error: " + error.toString())
        );
        rque.add(request);
    }

}
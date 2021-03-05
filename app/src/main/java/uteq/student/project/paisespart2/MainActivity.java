package uteq.student.project.paisespart2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uteq.student.project.paisespart2.entidad.Pais;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.text_iniciales_paises);
        button = findViewById(R.id.btnEnviar);
        init();
        enviarDatosMap();
    }

    private void enviarDatosMap() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pais pais = (Pais) spinner.getSelectedItem();
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("iso2",pais.getIso2());
                startActivity(intent);
            }
        });
    }

    public void init() {
        String url = "http://www.geognos.com/api/en/countries/info/all.json";
        RequestQueue rque = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        String cabecera_pais;
                        String nombre_pais;
                        ArrayList<Pais> paisList = new ArrayList<>();
                        String iso;
                        JSONObject jsonObjectResultado = response.getJSONObject("Results");
                        JSONArray jsonArrayObject = jsonObjectResultado.names();
                        for (int i = 0; i < jsonArrayObject.length(); i++) {
                            cabecera_pais = jsonArrayObject.getString(i);
                            /* INFORMACION PRINCIPAL */
                            JSONObject informacion = jsonObjectResultado.getJSONObject(cabecera_pais);
                            nombre_pais = informacion.getString("Name");
                            /* CODECOUNTRY */
                            JSONObject jsonObjectCountryCodes = informacion.getJSONObject("CountryCodes");
                            iso = jsonObjectCountryCodes.getString("iso2");
                            paisList.add(new Pais(nombre_pais, iso));
                            Toast.makeText(this, "Wait...", Toast.LENGTH_SHORT).show();
                        }
                        ArrayAdapter<Pais> listAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, paisList);
                        spinner.setAdapter(listAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.e("HttpClient", "error: " + error.toString())
        );
        rque.add(request);
    }

}
package uteq.student.project.paisespart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import uteq.student.project.paisespart2.adaptador.ListAdapter;
import uteq.student.project.paisespart2.entidad.Pais;

public class MainActivity extends AppCompatActivity {

    private List<Pais> paisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        paisList = new ArrayList<>();
        paisList.add(new Pais("ECUADOR", "QUITO", "EC"));
        paisList.add(new Pais("BRAZIL", "RIO DE JANEIRO", "BR"));
        paisList.add(new Pais("PERU", "LIMA", "PE"));
        ListAdapter listAdapter = new ListAdapter(paisList, this);
        RecyclerView recyclerView = findViewById(R.id.list_item);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

}
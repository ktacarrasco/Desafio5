package com.desafios.desafio5;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;

        import com.desafios.desafio5.model.Animales;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private AnimalAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        initializeAnimales();
        mAdapter = new AnimalAdapter(initializeAnimales(),this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Animales> initializeAnimales(){
        Animales animales1 = new Animales("https://images.unsplash.com/photo-1504208434309-cb69f4fe52b0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Bird");
        Animales animales2 = new Animales("https://images.unsplash.com/photo-1534759846116-5799c33ce22a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60ps://unsplash.com/photos/7_TTPznVIQI","que vista");
        Animales animales3 = new Animales("https://images.unsplash.com/photo-1516934024742-b461fba47600?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Orange Fox");
        List<Animales> animalesList= new ArrayList<>();
        animalesList.add(animales1);
        animalesList.add(animales2);
        animalesList.add(animales3);
        return animalesList;
    }
}

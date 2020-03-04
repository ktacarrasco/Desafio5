package com.desafios.desafio5;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.widget.Toast;

        import com.desafios.desafio5.model.Animales;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private AnimalAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        //initializeAnimales();
        mAdapter = new AnimalAdapter(initializeAnimales(),this,this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GridLayoutManager gridLayoutManager;
        gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private List<Animales> initializeAnimales(){
        Animales animales1 = new Animales("https://images.unsplash.com/photo-1552056711-84ca09c0a8cd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","brownie banana");
        Animales animales2 = new Animales("https://i.pinimg.com/originals/dd/67/fc/dd67fcc2fb323e506be97b68313811c9.png","galletas_rapidas_de_auyama_y_banano");
        Animales animales3 = new Animales("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSTsLlEJvszBiqDGZbqW9JNM5APX_2QvIG3VLp6i1wKLbMtavlQ","mandocas_hormenadas");
        Animales animales4 = new Animales("https://i.blogs.es/dfe7e9/muffins-zanahoria1/1366_2000.jpg","muffins_de_pan_con_zanahoria");
        Animales animales5 = new Animales("https://i.blogs.es/7ce482/muffins-calabaza/1366_2000.jpg","muffins_integrales");
        Animales animales6 = new Animales("https://do.emedemujer.com/wp-content/uploads/sites/10/2017/03/Palmeritas-de-banana.jpg","palmeritas_de_banana");
        Animales animales7 = new Animales("https://media.metrolatam.com/2018/10/02/pancalabacin-e262ae0f85fe9f5122186a01d77496eb-1200x600.jpg","pan de calabacin");
        Animales animales8 = new Animales("https://i.pinimg.com/originals/a7/4f/3a/a74f3a4938c37430fc814be1f9e89c07.png","panquecas_de_cacao_con_topping_de_banana");
        List<Animales> animalesList= new ArrayList<>();
        animalesList.add(animales1);
        animalesList.add(animales2);
        animalesList.add(animales3);
        animalesList.add(animales4);
        animalesList.add(animales5);
        animalesList.add(animales6);
        animalesList.add(animales7);
        animalesList.add(animales8);
        return animalesList;
    }


    private void instanceDetailFragment(String name, String url){
        DetailFragment detailFragment = DetailFragment.newInstance(name,url);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,detailFragment,"DETAILFRAGMENT").commit();

    }

    @Override
    public void OnClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String URL) {

        Toast.makeText(this,nameAnimal,Toast.LENGTH_SHORT).show();
        instanceDetailFragment(nameAnimal,URL);
    }
}

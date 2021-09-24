package com.example.pruebalab;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pruebalab.databinding.ActivityCategoriaBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityCategoria extends AppCompatActivity {

    List<Categoria> listaCategorias;

    protected RecyclerView recyclerView;
    protected CategoriaAdapter categoriaAdapter;
    protected RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        recyclerView = (RecyclerView) findViewById(R.id.categoriaRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listaCategorias = new ArrayList<Categoria>();
       // listaCategorias.add(new Categoria("MLA1500","salame","#FFFFFFFF"));
        listaCategorias.add(new Categoria("MLA5725", getString(R.string.accesoriosVehiculos), getString(R.color.accesoriosVehiculos)));
        listaCategorias.add(new Categoria("MLA1512", getString(R.string.agro), getString(R.color.agro)));
        listaCategorias.add(new Categoria("MLA1403", getString(R.string.alimentos), getString(R.color.alimentos)));
        listaCategorias.add(new Categoria("MLA1071", getString(R.string.animales), getString(R.color.animales)));
        listaCategorias.add(new Categoria("MLA1367", getString(R.string.antiguedades), getString(R.color.antiguedades)));
        listaCategorias.add(new Categoria("MLA1368", getString(R.string.arte), getString(R.color.arte)));
        listaCategorias.add(new Categoria("MLA1743", getString(R.string.autos), getString(R.color.autos)));
        listaCategorias.add(new Categoria("MLA1384", getString(R.string.bebes), getString(R.color.bebes)));
        listaCategorias.add(new Categoria("MLA1246", getString(R.string.belleza), getString(R.color.belleza)));
        listaCategorias.add(new Categoria("MLA1039", getString(R.string.camaras), getString(R.color.camaras)));
        listaCategorias.add(new Categoria("MLA1051", getString(R.string.celulares), getString(R.color.celulares)));
        listaCategorias.add(new Categoria("MLA1648", getString(R.string.computacion), getString(R.color.computacion)));
        listaCategorias.add(new Categoria("MLA1144", getString(R.string.consolas), getString(R.color.consolas)));
        listaCategorias.add(new Categoria("MLA1500", getString(R.string.construccion), getString(R.color.construccion)));
        listaCategorias.add(new Categoria("MLA1276", getString(R.string.deportes), getString(R.color.deportes)));
        listaCategorias.add(new Categoria("MLA5726", getString(R.string.electrodomesticos), getString(R.color.electrodomesticos)));
        listaCategorias.add(new Categoria("MLA1000", getString(R.string.electronica), getString(R.color.electronica)));
        listaCategorias.add(new Categoria("MLA2547", getString(R.string.entradas), getString(R.color.entradas)));
        listaCategorias.add(new Categoria("MLA407134", getString(R.string.herramientas), getString(R.color.herramientas)));
        listaCategorias.add(new Categoria("MLA1574", getString(R.string.hogar), getString(R.color.hogar)));
        listaCategorias.add(new Categoria("MLA1499", getString(R.string.industrias), getString(R.color.industrias)));
        listaCategorias.add(new Categoria("MLA1459", getString(R.string.inmuebles), getString(R.color.inmuebles)));
        listaCategorias.add(new Categoria("MLA1182", getString(R.string.instrumentos), getString(R.color.instrumentos)));
        listaCategorias.add(new Categoria("MLA3937", getString(R.string.joyas), getString(R.color.joyas)));
        listaCategorias.add(new Categoria("MLA1132", getString(R.string.juegos), getString(R.color.juegos)));
        listaCategorias.add(new Categoria("MLA3025", getString(R.string.libros), getString(R.color.libros)));
        listaCategorias.add(new Categoria("MLA1168", getString(R.string.musica), getString(R.color.musica)));
        listaCategorias.add(new Categoria("MLA1430", getString(R.string.ropa), getString(R.color.ropa)));
        listaCategorias.add(new Categoria("MLA409431", getString(R.string.salud), getString(R.color.salud)));
        listaCategorias.add(new Categoria("MLA1540", getString(R.string.servicios), getString(R.color.servicios)));
        listaCategorias.add(new Categoria("MLA9304", getString(R.string.souvenirs), getString(R.color.souvenirs)));
        listaCategorias.add(new Categoria("MLA1953", getString(R.string.otrasCategorias), getString(R.color.otrasCategorias)));


        //   listaCategorias.add(new Categoria("MLA5725", getString(R.string.accesoriosVehiculos), R.color.accesoriosVehiculos));
        categoriaAdapter= new CategoriaAdapter(listaCategorias, this);
        recyclerView.setAdapter(categoriaAdapter);
    }

//    private AppBarConfiguration appBarConfiguration;
//    private ActivityCategoriaBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityCategoriaBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_categoria);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_categoria);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}
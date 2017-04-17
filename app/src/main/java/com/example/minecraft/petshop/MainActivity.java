package com.example.minecraft.petshop;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.minecraft.petshop.Activities.ConfigurarCuenta;
import com.example.minecraft.petshop.Activities.Contacto;
import com.example.minecraft.petshop.Adaptadores.PageAdapter;
import com.example.minecraft.petshop.vista.fragments.Fragment_listado_mascotas;
import com.example.minecraft.petshop.vista.fragments.Fragment_perfil_mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Animes

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

    }



    private ArrayList<android.support.v4.app.Fragment> agregarFragments (){

        ArrayList<android.support.v4.app.Fragment> fragments = new ArrayList<>();

        fragments.add(new Fragment_listado_mascotas());
        fragments.add(new Fragment_perfil_mascota());


        return fragments;

    }


    private void setUpViewPager (){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Lista Mascotas");
        tabLayout.getTabAt(1).setText("Perfil Mascota");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.acerca:

                Intent i = new Intent(this,Contacto.class);
                startActivity(i);

            break;

            case R.id.contacto:

                Intent in = new Intent(this,Contacto.class);
                startActivity(in);

                break;

            case R.id.configurarCuenta:

                Intent in2 = new Intent(this,ConfigurarCuenta.class);
                startActivity(in2);

                break;


        }

        return super.onOptionsItemSelected(item);
    }
}

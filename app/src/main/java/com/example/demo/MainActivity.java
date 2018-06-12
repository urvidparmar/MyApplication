package com.example.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jaychang.srv.SimpleRecyclerView;
import com.jaychang.srv.decoration.SectionHeaderProvider;
import com.jaychang.srv.decoration.SimpleSectionHeaderProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class
MainActivity extends AppCompatActivity {

    SimpleRecyclerView simpleRecyclerView;

    /*
    - When activity is created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleRecyclerView = findViewById(R.id.recyclerView);
        this.addRecyclerHeaders();
        this.bindData();
    }

    /*
    - Create RecyclerViewHeaders
     */
    private void addRecyclerHeaders() {
        SectionHeaderProvider<Galaxy> sh = new SimpleSectionHeaderProvider<Galaxy>() {
            @NonNull
            @Override
            public View getSectionHeaderView(@NonNull Galaxy Galaxy, int i) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.header, null, false);
                TextView textView = view.findViewById(R.id.headerTxt);
                textView.setText(Galaxy.getCategoryName());
                return view;
            }

            @Override
            public boolean isSameSection(@NonNull Galaxy Galaxy, @NonNull Galaxy nextGalaxy) {
                return Galaxy.getCategoryId() == nextGalaxy.getCategoryId();
            }

            // Optional, whether the header is sticky, default false
            @Override
            public boolean isSticky() {
                return true;
            }
        };
        simpleRecyclerView.setSectionHeader(sh);
    }

    /*
    - Bind data to our RecyclerView
     */
    private void bindData() {
        List<Galaxy> Galaxys = getData();
        //CUSTOM SORT ACCORDING TO CATEGORIES
        Collections.sort(Galaxys, new Comparator<Galaxy>() {
            public int compare(Galaxy Galaxy, Galaxy nextGalaxy) {
                return Galaxy.getCategoryId() - nextGalaxy.getCategoryId();
            }
        });
        List<GalaxyCell> cells = new ArrayList<>();

        //LOOP THROUGH GALAXIES INSTANTIATING THEIR CELLS AND ADDING TO CELLS COLLECTION
        for (Galaxy galaxy : Galaxys) {
            GalaxyCell cell = new GalaxyCell(galaxy);
            // There are two default cell listeners: OnCellClickListener<CELL, VH, T> and OnCellLongClickListener<CELL, VH, T>
//            cell.setOnCellClickListener2(new SimpleCell.OnCellClickListener2<GalaxyCell, GalaxyCell.ViewHolder, Galaxy>() {
//                @Override
//                public void onCellClicked(GalaxyCell GalaxyCell, GalaxyCell.ViewHolder viewHolder, Galaxy item) {
//                    Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
//                }
//            });
//            cell.setOnCellLongClickListener2(new SimpleCell.OnCellLongClickListener2<GalaxyCell, GalaxyCell.ViewHolder, Galaxy>() {
//                @Override
//                public void onCellLongClicked(GalaxyCell GalaxyCell, GalaxyCell.ViewHolder viewHolder, Galaxy item) {
//                    Toast.makeText(MainActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
            cells.add(cell);
        }
        simpleRecyclerView.addCells(cells);
    }

    /*
    - Data Source
    - Returns an arraylist of galaxies.
     */
    private ArrayList<Galaxy> getData() {
        ArrayList<Galaxy> galaxies = new ArrayList<>();

        //CREATE CATEGORIES
        Category size = new Category(0, "Size");
        Category color = new Category(1, "Color");
        Category material = new Category(2, "Material");

        //INSTANTIATE GALAXY OBJECTS AND ADD THEM TO GALAXY LIST
        Galaxy g = new Galaxy("X", size);
        galaxies.add(g);

        g = new Galaxy("XL", size);
        galaxies.add(g);

        g = new Galaxy("XXL", size);
        galaxies.add(g);

        g = new Galaxy("XXXL", size);
        galaxies.add(g);

        g = new Galaxy("M", size);
        galaxies.add(g);

        g = new Galaxy("S", size);
        galaxies.add(g);


        g = new Galaxy("Red", color);
        galaxies.add(g);

        g = new Galaxy("Blue", color);
        galaxies.add(g);

        g = new Galaxy("Black", color);
        galaxies.add(g);

        g = new Galaxy("Yellow", color);
        galaxies.add(g);

        g = new Galaxy("Pink", color);
        galaxies.add(g);

        g = new Galaxy("gray", color);
        galaxies.add(g);

        g = new Galaxy("purple", color);
        galaxies.add(g);

        g = new Galaxy("Green", color);
        galaxies.add(g);


        g = new Galaxy("Fabric", material);
        galaxies.add(g);

        g = new Galaxy("Cotton", material);
        galaxies.add(g);
        return galaxies;
    }

}
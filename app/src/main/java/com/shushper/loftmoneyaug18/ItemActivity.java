package com.shushper.loftmoneyaug18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);


        List<Item> items = new ArrayList<>();
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));


        ItemsAdapter adapter = new ItemsAdapter();
        adapter.setItems(items);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));


    }
}

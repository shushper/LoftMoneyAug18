package com.shushper.loftmoneyaug18;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

//    private static final int REQUEST_CODE = 100;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainPagesAdapter adapter;
    private Toolbar toolbar;
//    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: ");

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
//        fab = findViewById(R.id.fab);


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, AddActivity.class);
//                intent.putExtra(AddActivity.KEY_TYPE, Item.TYPE_EXPENSE);
//                startActivityForResult(intent, REQUEST_CODE);
//            }
//        });

        setSupportActionBar(toolbar);

        adapter = new MainPagesAdapter(getSupportFragmentManager(), this);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
//            String name = data.getStringExtra(AddActivity.KEY_NAME);
//            String price = data.getStringExtra(AddActivity.KEY_PRICE);
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}

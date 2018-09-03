package com.shushper.loftmoneyaug18;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    private static final String TAG = "ItemsFragment";

    private static final String KEY_TYPE = "type";


    public static ItemsFragment newInstance(String type) {
        ItemsFragment fragment = new ItemsFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ItemsFragment.KEY_TYPE, type);

        fragment.setArguments(bundle);

        return fragment;
    }


    public ItemsFragment() {
    }


    private RecyclerView recycler;
    private ItemsAdapter adapter;
    private Api api;

    private String type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");

        Bundle args = getArguments();
        type = args.getString(KEY_TYPE);

        api = ((App) getActivity().getApplication()).getApi();

        adapter = new ItemsAdapter();
        loadItems();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated: ");
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    private void loadItems() {

        Call call = api.getItems(type);

        call.enqueue(new Callback<List<Item>>() {

            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item> items = response.body();
                adapter.setItems(items);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });

    }

//    private void loadItems() {
//
//        @SuppressLint("StaticFieldLeak")
//        AsyncTask<Void, Void, List<Item>> asyncTask = new AsyncTask<Void, Void, List<Item>>() {
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//            }
//
//            @Override
//            protected List<Item> doInBackground(Void... voids) {
//                Call call = api.getItems(type);
//
//                try {
//                    Response<List<Item>> response = call.execute();
//                    List<Item> items = response.body();
//                    return items;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(List<Item> items) {
//                if (items != null) {
//                    adapter.setItems(items);
//                }
//
//            }
//        };
//
//        asyncTask.execute();
//    }

//    private void loadItems() {
//        Call call = api.getItems(type);
//
//        try {
//            Response<List<Item>> response =  call.execute();
//            List<Item> items = response.body();
//            adapter.setItems(items);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void loadItems() {
//        new LoadItemsTask().start();
//    }
//
//    private class LoadItemsTask implements Runnable, Handler.Callback {
//
//        private Thread thread;
//        private Handler handler;
//
//        public LoadItemsTask() {
//            thread = new Thread(this);
//            handler = new Handler(this);
//        }
//
//        public void start() {
//            thread.start();
//        }
//
//        @Override
//        public void run() {
//            Call call = api.getItems(type);
//
//            try {
//                Response<List<Item>> response = call.execute();
//                List<Item> items = response.body();
//
//                Message message = handler.obtainMessage(111, items);
//                message.sendToTarget();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public boolean handleMessage(Message msg) {
//            if (msg.what == 111) {
//                List<Item> items = (List<Item>) msg.obj;
//                adapter.setItems(items);
//                return true;
//            }
//            return false;
//        }
//    }
}

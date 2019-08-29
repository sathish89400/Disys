package co.app.disys.Listview.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import co.app.disys.Listview.model.Item;
import co.app.disys.Listview.viewmodel.ListViewViewModel;
import co.app.disys.form.ui.AddDataActivity;
import co.app.disys.R;

public class ListViewActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mProgressBar = findViewById(R.id.progress_circular);
        fab = findViewById(R.id.fbut);
        fab.setOnClickListener(this);
        progressShow();
        ListViewViewModel listViewViewModel = ViewModelProviders.of(this).get(ListViewViewModel.class);
        listViewViewModel.getItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                progressHide();
                ListViewAdapter adapter = new ListViewAdapter(ListViewActivity.this,items);
                mRecyclerView.setAdapter(adapter);
            }
        });


    }


    private void progressShow(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void progressHide(){
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, AddDataActivity.class);
        startActivity(i);
    }
}



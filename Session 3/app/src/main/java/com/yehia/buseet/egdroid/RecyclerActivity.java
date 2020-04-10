package com.yehia.buseet.egdroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Data> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initList();


        recyclerView = findViewById(R.id.recycler);

        RecyclerAdapter adapter = new RecyclerAdapter(myList, this, new OnItemClickListener() {
            @Override
            public void onClick(Data data) {
                createDialog(data.getName());
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);


    }

    private void createDialog(String name) {
        new AlertDialog.Builder(this)
                .setTitle(name)
                .setCancelable(false)
                .setMessage("Hello from the other side!")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(RecyclerActivity.this, "Okay", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    private void initList() {
        myList = new ArrayList<>();
        myList.add(new Data(R.mipmap.ic_launcher, "Yehia"));
        myList.add(new Data(R.mipmap.ic_launcher, "Mohamed"));
        myList.add(new Data(R.mipmap.ic_launcher, "Ahmed"));
        myList.add(new Data(R.mipmap.ic_launcher, "Yehia"));
        myList.add(new Data(R.mipmap.ic_launcher, "Yehia"));
        myList.add(new Data(R.mipmap.ic_launcher, "Yehia"));
        myList.add(new Data(R.mipmap.ic_launcher, "Zizo"));
        myList.add(new Data(R.mipmap.ic_launcher, "Yehia"));
    }
}

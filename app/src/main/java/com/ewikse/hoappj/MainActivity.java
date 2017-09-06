package com.ewikse.hoappj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareCourseData();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mAdapter = new MyAdapter(courses);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

    }

    private void prepareCourseData() {
        Course c = new Course();
        c.setNameCourse("HOla");
        Course c1 = new Course();
        c1.setNameCourse("HOla111");
        Course c2 = new Course();
        c2.setNameCourse("HOla2222");
        Course c3 = new Course();
        c3.setNameCourse("HOla44444");
        courses.add(c);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }
}

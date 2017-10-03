package com.ewikse.hoappj;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ewikse.hoappj.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer{

    private ActivityMainBinding courseActivityBinding;
    private CourseViewModel courseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupListCourseView(courseActivityBinding.listCourse);
        setupObserver(courseViewModel);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    private void setupListCourseView(RecyclerView listCourse) {
        MyAdapter adapter = new MyAdapter();
        listCourse.setAdapter(adapter);
        listCourse.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDataBinding() {
        courseActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        courseViewModel = new CourseViewModel(this);
        courseActivityBinding.setCoursesViewModel(courseViewModel);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof CourseViewModel) {
            MyAdapter adapter = (MyAdapter) courseActivityBinding.listCourse.getAdapter();
            CourseViewModel courseViewModel = (CourseViewModel) observable;
            adapter.setCourseList(courseViewModel.getCourseList());
        }
    }
}

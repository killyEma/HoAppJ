package com.ewikse.hoappj;

import android.content.Context;
import android.databinding.BaseObservable;

public class ItemCourseViewModel extends BaseObservable{

    private Course course;
    private Context context;

    public ItemCourseViewModel(Course course, Context context) {
        this.course = course;
        this.context = context;
    }

    public String getNameCourse(){
        return course.getNameCourse();
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

package com.ewikse.hoappj;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ewikse.hoappj.databinding.CourseRowBinding;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Course> courses;

    public MyAdapter() {
        courses = Collections.emptyList();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CourseRowBinding courseRowBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.course_row, parent, false);
        return new MyViewHolder(courseRowBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindCourse(courses.get(position));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void setCourseList(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CourseRowBinding courseRowBinding;

        public MyViewHolder(CourseRowBinding courseRowBinding) {
            super(courseRowBinding.itemCourse);
            this.courseRowBinding = courseRowBinding;
        }

        public void bindCourse(Course course) {
            if (courseRowBinding.getCourseViewModel() == null) {
                courseRowBinding.setCourseViewModel(
                        new ItemCourseViewModel(course, itemView.getContext()));
            } else {
                courseRowBinding.getCourseViewModel().setCourse(course);
            }
        }
    }
}

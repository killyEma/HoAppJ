package com.ewikse.hoappj;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CourseViewModel extends Observable {
    public ObservableInt courseRecycler;
    public ObservableInt courseProgress;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    private Context context;
    private List<Course> courses;

    public CourseViewModel(@NonNull Context context) {
        this.context = context;
        courses = new ArrayList<>();
        courseRecycler = new ObservableInt(View.GONE);
        courseProgress = new ObservableInt(View.VISIBLE);
        fetchCourseList();
    }

    private void fetchCourseList() {
        Disposable disposable = new CourseService().fetchCourse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CourseListObserver());

        compositeDisposable.add(disposable);
    }

    private void changeCourseDataSet(List<Course> courses) {
        this.courses = courses;
        setChanged();
        notifyObservers();
    }

    public List<Course> getCourseList() {
        return courses;
    }

    private class CourseListObserver extends DisposableObserver<List<Course>>{

        @Override
        public void onNext(@io.reactivex.annotations.NonNull List<Course> courses) {
            changeCourseDataSet(courses);
        }

        @Override
        public void onError(@io.reactivex.annotations.NonNull Throwable e) {

        }
        @Override
        public void onComplete() {
            courseRecycler.set(View.VISIBLE);
            courseProgress.set(View.GONE);
        }

    }
}

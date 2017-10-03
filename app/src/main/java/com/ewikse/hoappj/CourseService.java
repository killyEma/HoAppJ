package com.ewikse.hoappj;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class CourseService {
    public Observable<List<Course>> fetchCourse() {

        return Observable.create(new ObservableOnSubscribe<List<Course>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Course>> emitter) throws Exception {
                List<Course> coursesList = new ArrayList<>();
                Course c = new Course();
                c.setNameCourse("HOla");
                Course c1 = new Course();
                c1.setNameCourse("HOla111");
                Course c2 = new Course();
                c2.setNameCourse("HOla2222");
                Course c3 = new Course();
                c3.setNameCourse("HOla44444");
                coursesList.add(c);
                coursesList.add(c1);
                coursesList.add(c2);
                coursesList.add(c3);
                Thread.sleep(5000);

                emitter.onNext(coursesList);
                emitter.onComplete();
            }
        });
    }
}

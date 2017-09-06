package com.ewikse.hoappj;

public class Course {
    private int idCourse;

    private String nameCourse;
    private int type;//p-t-b
    private String description;
    private String dateCreated;
    private long idCareer;
    private int yearCourse;
    private int monthInit;
    private int monthFinish;
    private int division;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }




    public int getYearCourse() {
        return yearCourse;
    }

    public void setYearCourse(int yearCourse) {
        this.yearCourse = yearCourse;
    }


    public int getMonthInit() {
        return monthInit;
    }

    public void setMonthInit(int monthInit) {
        this.monthInit = monthInit;
    }

    public int getMonthFinish() {
        return monthFinish;
    }

    public void setMonthFinish(int monthFinish) {
        this.monthFinish = monthFinish;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(long idCareer) {
        this.idCareer = idCareer;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Override
    public String toString() {
        return ""+getNameCourse()+" "+getDescription();
    }

}

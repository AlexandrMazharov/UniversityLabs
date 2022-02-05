package lab3.strategy36;

import java.util.ArrayList;
import java.util.List;

public class Student {

    public Student() {

        this.name = null;
        this.cources = new ArrayList<Cource>();
        this.average = 0;
    }

    public String getCourseName(int i) {
        return
                this.cources.get(i).name;
    }
    public Double getCourseRes(int i) {
        return
                this.cources.get(i).res;
    }

    void addCource(String nameCource, double res) {

        this.cources.add(new Cource(nameCource, res));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    private String name;
    private ArrayList<Cource> cources;
    private double average;

    public List<Cource> getCources() {
        return cources;
    }

    private class Cource {
        private String name;
        private double res;

        public Cource(String nameCource, double res) {
            this.res = res;
            this.name = nameCource;
        }


    }

}

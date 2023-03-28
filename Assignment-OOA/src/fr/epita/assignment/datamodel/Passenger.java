package fr.epita.assignment.datamodel;

import java.util.Comparator;
import java.util.List;
public class Passenger {
    private String name;
    private String passengerClass;
    private String sex;
    private Double age;
    private Boolean survived;

    public Passenger(String name, String passengerClass, String sex, Double age, Boolean survived) {
        this.name = name;
        this.passengerClass = passengerClass;
        this.sex = sex;
        this.age = age;
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassengerClass() {
        return passengerClass;
    }

    public void setPassengerClass(String passengerClass) {
        this.passengerClass = passengerClass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Boolean getSurvived() {
        return survived;
    }

    public void setSurvived(Boolean survived) {
        this.survived = survived;
    }

    @Override
    public String toString() {
        return "Passenger [name=\"" + this.name + " , survived=\"" + this.survived + "\"]";
    }

    public static class orderByAge implements Comparator<Passenger> {
        @Override
        public int compare(Passenger p1, Passenger p2) {
            return p1.getAge() > p2.getAge() ? 1 : (p1.getAge() < p2.getAge() ? -1 : 0);
        }
    }
}

package com.example.ege.bmi;


public class HealthProfile {

    private double height;
    private double weight;



    public HealthProfile(double height, double weight) {
        super();

        this.height = height;
        this.weight = weight;}


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public double findBMI(double height, double weight)
    {
        return  weight/ Math.pow(height, 2);
    }
}

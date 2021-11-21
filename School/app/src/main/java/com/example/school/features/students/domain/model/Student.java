package com.example.school.features.students.domain.model;

public class Student {
    private final String registration;
    private final String name;
    private final float[] notes;
    private final Float average;

    public Student(String name, float[] notes, String registration, Float average) {
        this.name = name;
        this.notes = notes;
        this.registration = registration;
        this.average = average;
    }

    public String getRegistration() {
        return registration;
    }

    public float[] getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    public Float getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Student) {
            Student other = (Student) object;
            return registration.equals(other.registration);
        }
        return false;
    }

}

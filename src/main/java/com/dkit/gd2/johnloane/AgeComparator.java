package com.dkit.gd2.johnloane;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getAge()>s2.getAge()){
            return (int) s1.getAge();
        }
        else {
            return s2.getAge();
        }
    }
}

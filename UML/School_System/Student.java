package UML.School_System;

import java.util.*;

// Student subclass inherits from Person class
public class Student extends Person{
    private String studentId;
    private String gradeLevel;
    private List<Course> courses;
    private Map<Course, Double> grades;
    private double communityInvolvementHours;


    public Student(String name, int age, String address, String studentId, String gradeLevel){
        super(name, age, address);
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
        this.courses = new ArrayList<Course>();
        this.grades = new HashMap<Course, Double>();
        this.communityInvolvementHours = 0.0;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void removeCourse(Course course){
        courses.remove(course);
    }

    public void addGrade(Course course, double grade){
        grades.put(course, grade);
    }

    public double getAverage(){
        if (grades.isEmpty()){
            return 0.0;
        }
        double sum = 0.0;
        for(double grade : grades.values()){
            sum+=grade;
        }
        return sum/grades.size();
    }

    public List<String> getAwards() {
        List<String> awards = new ArrayList<String>();
        if (getHonorRoll()) {
            awards.add("Honor Roll");
        }
        return awards;
    }

    public boolean getHonorRoll(){
        return getAverage()>=90.0;
    }

    public double getCommunityInvolvementHours(){
        return communityInvolvementHours;
    }

    public void setCommunityInvolvementHours(double hours){
        communityInvolvementHours = hours;
    }
    @Override
    public void printInfo() {
        super.printInfo(); // Calls the superclass' printInfo()
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Community Involvement Hours: " + communityInvolvementHours);
        System.out.println("Average: " + getAverage());
        System.out.println("Awards: " + getAwards());
    }

    @Override
    public String toString(){
        return "Student: " + getName()+", Grade Level: " + gradeLevel;
    }

    public void printInfo(String message){
        System.out.println(message);
        printInfo();
    }
}
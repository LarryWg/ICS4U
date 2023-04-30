package UML.School_System;

public class Course implements Printable {
    private String name;


    public Course(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void printInfo(){
        System.out.println("Course Name: "+ name);
    }

    @Override
    public String toString(){
        return "Course: "+name;
    }


}

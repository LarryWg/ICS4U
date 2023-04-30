package UML.School_System;

public class Main{
    public static void main(String[] args){
        Student student1 = new Student("Larry", 17, "123 LDH st", "613-123-3210","11th");
        Course math = new Course("Math");
        Course computer = new Course("Computer Science");

        student1.addCourse(math);
        student1.addCourse(computer);
        student1.addGrade(math,97.0);
        student1.addGrade(computer, 88.0);
        student1.setCommunityInvolvementHours(109.0);

        student1.printInfo("Student Info:");

        math.printInfo();
        computer.printInfo();

        
    }
}
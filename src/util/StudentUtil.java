package util;

import bean.Student;
import main.Config;

public class StudentUtil {

    public static Student fillStudent(){
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requiresurName();
        int age = MenuUtil.requireAge();
        String className = MenuUtil.requireClassName();

        Student st = new Student(name, surname, age, className);

        return st;
    }

    public static void printAllStudents(){
        if(Config.students == null){
            return;
        }
        for (int i = 0; i < Config.students.length; i++){
            Student st = Config.students[i];
            System.out.println();
            System.out.println((i+1)+"."+st.getFullInfo());
        }
    }

    public static void registerStudents(){
        int count = InputUtil.requireNumber("How many students will you enroll?");

        //create students array
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i+1)+".Register");
            Config.students[i] = StudentUtil.fillStudent();
        }

        MenuUtil.showSuccessMessage();
        StudentUtil.printAllStudents();
    }

    public static void findStudentsAndPrint(){
        String text = InputUtil.requireText("Type name,surname,className:");
        Student[] findedStudents = findStudents(text);
        for (int i = 0; i < findedStudents.length;i++){
            System.out.println(findedStudents[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text){
        int count = 0;
        for (int i = 0; i < Config.students.length;i++){
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)){
                count++;
            }
        }

        Student[] result = new Student[count];

        int found = 0;
        for (int i = 0; i < Config.students.length;i++){
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)){
                result[found++] = st;
            }
        }
        return result;


    }

    public static void updateStudentWithNewObject(){
        StudentUtil.printAllStudents();
        int i = InputUtil.requireNumber("Which index of people do you want change?");

        System.out.println("Add new informations");
        Student s = StudentUtil.fillStudent();
        Config.students[i-1] = s;
    }

    public static void updateStudentWithSameObject(){
        StudentUtil.printAllStudents();
        int i = InputUtil.requireNumber("Which index of people do you want change?");

        System.out.println("Add new informations");
        Student selectedStudent = Config.students[i-1];

        String changeParameters = InputUtil.requireText("What do you want to change? (for ex: 'name','surname'");

        if (changeParameters.contains("'name'")){
            selectedStudent.setName(MenuUtil.requireName());
        }
        if (changeParameters.contains("'surname'")){
            selectedStudent.setSurname(MenuUtil.requiresurName());
        }
        if (changeParameters.contains("'age'")){
            selectedStudent.setAge(MenuUtil.requireAge());
        }
        if (changeParameters.contains("'className'")){
            selectedStudent.setClassName(MenuUtil.requireClassName());
        }

    }

    public static void updateStudentWithSplit(){
        StudentUtil.printAllStudents();
        int index = InputUtil.requireNumber("Which index of people do you want change?");

        System.out.println("Add new informations");
        Student selectedStudent = Config.students[index-1];

        String changeParameters = InputUtil.requireText("What do you want to change? (for ex: name,surname");

        String[] parameters = changeParameters.split(",");

        for ( int i = 0; i < parameters.length; i++) {

            String param = parameters[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            }
            else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requiresurName());
            }
            else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            }
            else if (param.equalsIgnoreCase("className")) {
                selectedStudent.setClassName(MenuUtil.requireClassName());
            }
        }

    }
}

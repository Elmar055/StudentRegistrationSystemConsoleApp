package util;

public class MenuUtil {
    public static void processMenu(int menu){

        switch (menu) {
            case 1 -> StudentUtil.registerStudents();
            case 2 -> StudentUtil.printAllStudents();
            case 3 -> StudentUtil.findStudentsAndPrint();
            case 4 -> StudentUtil.updateStudentWithSplit();
            case 5 -> System.exit(0);
        }
    }
    public static String requireName(){
        return InputUtil.requireText("Enter name:");
    }

    public static String requiresurName(){
        return InputUtil.requireText("Enter surname:");
    }

    public static String requireClassName(){
        return InputUtil.requireText("Enter classname:");
    }

    public static int requireAge(){
        return InputUtil.requireNumber("Enter age:");
    }

    public static void showSuccessMessage(){
        System.out.println("Operation completed successfully!");
    }
}

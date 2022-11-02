package DepartmentClasses;
import java.util.*;
import java.io.*;

public class design extends Employee {
    String DesignRole;
    public design(){
        super();
    }

    public design(String name, int age, String DesignRole,String empcode) {
        super(name,age,empcode);
        this.DesignRole = DesignRole;
    }

    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nDesign Role-" + this.DesignRole + "\n");
    }
    public void getEmployeesData(ArrayList<design> employeeList,String code){
        try{
                    String intValue=code.substring(2, 5);                                
                try{
                    Integer.valueOf(intValue);                                  
                    System.out.println(employeeList.get(Integer.valueOf(intValue)));
                } 
                catch(NumberFormatException e){
                    System.out.println("\n**The entered code is of invalid format");
                }
                catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
                catch (Exception g) {
                    System.out.println(g);
                }
            }catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
    }
    public void addNewEmployees(ArrayList<design> employeeList,String name,int age,String designrole){
            String empcode;                                               
            if(employeeList.size()<10){empcode="ed00"+String.valueOf(employeeList.size());}
            else{empcode="ed0" +String.valueOf(employeeList.size());}                                                   
            design newDesignEmployee = new design(name, age, designrole,empcode);
            employeeList.add(newDesignEmployee);
    }
    public void modifyEmployeeData(ArrayList<design> employeeList,int field,String intValue){
        Scanner sc=new Scanner(System.in);
    if (field == 1) {
        String newname;
        System.out.println("\nEnter new field");
        newname = sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).name = newname;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    } else if (field == 2) {
        int newage;
        System.out.println("\nEnter new field");
        newage=sc.nextInt();
        sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).age=newage;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    } else if (field == 3) {
        String newdesignRole;
        System.out.println("\nEnter new field");
        newdesignRole = sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).DesignRole = newdesignRole;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    }
    
}

}
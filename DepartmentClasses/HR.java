package DepartmentClasses;
import java.util.*;
import java.io.*;
public class HR extends Employee {
    String Designation;
    public HR(){
        super();
    }
    HR(String name, int age, String Designation,String empcode) {
        super(name,age,empcode);
        this.Designation = Designation;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nDesignation-" + this.Designation + "\n");
    }
    public void getEmployeesData(ArrayList<HR> employeeList,String code){
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
    public void addNewEmployees(ArrayList<HR> employeeList ,String name,int age,String designation){
        String empcode;                                               
        if(employeeList.size()<10){empcode="eh00"+String.valueOf(employeeList.size());}
        else{empcode="eh0" +String.valueOf(employeeList.size());}                                                   
        HR newDesignEmployee = new HR(name, age, designation,empcode);
        employeeList.add(newDesignEmployee);
}
public void modifyEmployeeData(ArrayList<HR> employeeList,int field,String intValue){
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
        newage = sc.nextInt();
        sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).age = newage;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    } else if (field == 3) {
        String newDesignation;
        System.out.println("\nEnter new field");
        newDesignation = sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).Designation = newDesignation;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    }
    
}
}
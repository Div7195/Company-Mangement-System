package DepartmentClasses;
import java.util.*;
import java.io.*;
public class softwareDev extends Employee {
    String SoftwareRole;
    public softwareDev(){
        super();
    }
    softwareDev(String name, int age, String SoftwareRole,String empcode) {
        super(name,age,empcode);
        this.SoftwareRole = SoftwareRole;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nSoftware Role-" + this.SoftwareRole + "\n");
    }
    public void getEmployeesData(ArrayList<softwareDev> employeeList,String code){
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
    public void addNewEmployees(ArrayList<softwareDev> employeeList ,String name,int age,String softwareRole){
        String empcode;                                               
        if(employeeList.size()<10){empcode="es00"+String.valueOf(employeeList.size());}
        else{empcode="es0" +String.valueOf(employeeList.size());}                                                   
        softwareDev newDesignEmployee = new softwareDev(name, age, softwareRole,empcode);
        employeeList.add(newDesignEmployee);
}
public void modifyEmployeeData(ArrayList<softwareDev> employeeList,int field,String intValue){
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
    String newSoftwarerole;
        
    newSoftwarerole = sc.nextLine();
    employeeList.get(Integer.valueOf(intValue)).SoftwareRole = newSoftwarerole;
    System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    }

}
}
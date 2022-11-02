
package DepartmentClasses;
import java.util.*;
import java.io.*;
public class marketing extends Employee {
    String medium;
    String area;
    public marketing(){
        super();
    }
    marketing(String name, int age, String medium, String area,String empcode) {
        super(name,age,empcode);
        this.medium = medium;
        this.area = area;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nMedium-" + this.medium + "\nArea covering-"+this.area);
    }
    public void getEmployeesData(ArrayList<marketing> employeeList,String code){
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
    public void addNewEmployees(ArrayList<marketing> employeeList ,String name,int age,String medium,String area){
        String empcode;                                               
        if(employeeList.size()<10){empcode="em00"+String.valueOf(employeeList.size());}
        else{empcode="em0" +String.valueOf(employeeList.size());}                                                   
        marketing newDesignEmployee = new marketing(name, age, medium,area,empcode);
        employeeList.add(newDesignEmployee);
}
public void modifyEmployeeData(ArrayList<marketing> employeeList,int field,String intValue){
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
        String newmedium;
        System.out.println("\nEnter new field");
        newmedium = sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).medium = newmedium;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    } else if (field == 4) {
        String newmedium;
        System.out.println("\nEnter new field");
        newmedium = sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).area = newmedium;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    }

    
}

}
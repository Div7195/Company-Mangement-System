package DepartmentClasses;
import java.util.*;
import java.io.*;
public class PdtManagement extends Employee {
    String product;
    public PdtManagement(){
        super();
    }
    PdtManagement(String name, int age, String product,String empcode) {
        super(name,age,empcode);
        this.product = product;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nProduct Managing-" + this.product + "\n");
    }
    public void getEmployeesData(ArrayList<PdtManagement> employeeList,String code){
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
    public void addNewEmployees(ArrayList<PdtManagement> employeeList ,String name,int age,String product){
        String empcode;                                               
        if(employeeList.size()<10){empcode="ep00"+String.valueOf(employeeList.size());}
        else{empcode="ep0" +String.valueOf(employeeList.size());}                                                   
        PdtManagement newDesignEmployee = new PdtManagement(name, age, product,empcode);
        employeeList.add(newDesignEmployee);
}   
public void modifyEmployeeData(ArrayList<PdtManagement> employeeList,int field,String intValue){
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
        String newproduct;
    System.out.println("\nEnter new field");
        newproduct = sc.nextLine();
        employeeList.get(Integer.valueOf(intValue)).product = newproduct;
        System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
    }
    

}
}
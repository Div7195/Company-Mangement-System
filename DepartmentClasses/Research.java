package DepartmentClasses;
import java.util.*;
import java.io.*;
public class Research extends Employee {
    String topic;
    public Research(){
        super();
    }
    Research(String name, int age, String topic,String empcode) {
        super(name,age,empcode);
        this.topic = topic;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nTopic of Research" + this.topic + "\n");
    }
    public void getEmployeesData(ArrayList<Research> employeeList,String code){
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
    public void addNewEmployees(ArrayList<Research> employeeList ,String name,int age,String topic){
        String empcode;                                               
        if(employeeList.size()<10){empcode="er00"+String.valueOf(employeeList.size());}
        else{empcode="er0" +String.valueOf(employeeList.size());}                                                   
        Research newDesignEmployee = new Research(name, age, topic,empcode);
        employeeList.add(newDesignEmployee);
}
public void modifyEmployeeData(ArrayList<Research> employeeList,int field,String intValue){
    Scanner sc=new Scanner(System.in);
    if (field == 1) {
            System.out.println("\nEnter new field");
            String newname;            
            newname = sc.nextLine();
            employeeList.get(Integer.valueOf(intValue)).name = newname;
            System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
        } else if (field == 2) {
            int newage;            
            newage = sc.nextInt();
            sc.nextLine();
            System.out.println("\nEnter new field");
            employeeList.get(Integer.valueOf(intValue)).age = newage;
            System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
        } else if (field == 3) {
            String newtopic;
            System.out.println("\nEnter new field");
            newtopic = sc.nextLine();
            employeeList.get(Integer.valueOf(intValue)).topic = newtopic;
            System.out.println("\nModified data of the employee\n"+employeeList.get(Integer.valueOf(intValue)));
        }

}


}
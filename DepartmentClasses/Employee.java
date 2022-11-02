package DepartmentClasses;
import java.util.*;
import java.io.*;

public class Employee implements Serializable {
    String empcode;
    String name;
    int age;
    public Employee(){};
    public Employee(String name, int age,String empcode) {
        this.name = name;
        this.age = age;
        this.empcode=empcode;
    }
}
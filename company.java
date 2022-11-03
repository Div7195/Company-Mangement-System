import java.util.*;
import java.io.*;

class Employee implements Serializable {
    String empcode;
    String name;
    int age;

    public Employee(String name, int age,String empcode) {
        this.name = name;
        this.age = age;
        this.empcode=empcode;
    }

}

class AppendableObjectOutputStream extends ObjectOutputStream {

    public AppendableObjectOutputStream(OutputStream out)
            throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        
    }
}

class AppendableObjectInputStream extends ObjectInputStream {

    public AppendableObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        
    }
}

class design extends Employee {
    String DesignRole;

    public design(String name, int age, String DesignRole,String empcode) {
        super(name,age,empcode);
        this.DesignRole = DesignRole;
    }

    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nDesign Role-" + this.DesignRole + "\n");
    }

}

class softwareDev extends Employee {
    String SoftwareRole;

    softwareDev(String name, int age, String SoftwareRole,String empcode) {
        super(name,age,empcode);
        this.SoftwareRole = SoftwareRole;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nSoftware Role-" + this.SoftwareRole + "\n");
    }
}

class Research extends Employee {
    String topic;

    Research(String name, int age, String topic,String empcode) {
        super(name,age,empcode);
        this.topic = topic;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nTopic of Research" + this.topic + "\n");
    }

}

class HR extends Employee {
    String Designation;

    HR(String name, int age, String Designation,String empcode) {
        super(name,age,empcode);
        this.Designation = Designation;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nDesignation-" + this.Designation + "\n");
    }
}

class PdtManagement extends Employee {
    String product;

    PdtManagement(String name, int age, String product,String empcode) {
        super(name,age,empcode);
        this.product = product;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nProduct Managing-" + this.product + "\n");
    }
}

class marketing extends Employee {
    String medium;
    String area;

    marketing(String name, int age, String medium, String area,String empcode) {
        super(name,age,empcode);
        this.medium = medium;
        this.area = area;
    }
    public String toString() {
        return ("\nName-" + this.name + "\nAge-" + this.age + "\nEmployee code-"+this.empcode+"\nMedium-" + this.medium + "\nArea covering-"+this.area);
    }
}

class service implements Serializable{
    String customerID;
    String Enterprise;
    String softwaresPurchased;
    int billAmount;
    service(String customerID,String Enterprise,String softwarsPurchased,int billAmount){
        this.Enterprise=Enterprise;this.customerID=customerID;this.billAmount=billAmount;this.softwaresPurchased=softwarsPurchased;
    }
    public String toString(){
        return("\nCustomer ID-"+this.customerID+"\nEnterprise name-"+this.Enterprise+"\nSoftwares Purchased-"+this.softwaresPurchased+"\nBill Amount-"+this.billAmount);
    }
}

public class company {
    public static void main(String[] args) {
        //*************
        // ARRAY OF OBJECTS OF ALL CLASSES ,THESE DO NOT SAVE DATA,THESE ARE JUST TO PREVENT SIMILAR NAMES OF OBJECTS,ALL DATA IS STORED IN FILES
        Employee employeeArr[] = new Employee[600];
        design[] designArr = new design[100];
        softwareDev[] softwareDevArr = new softwareDev[100];
        Research[] ResearchArr = new Research[100];
        HR[] HRArr = new HR[100];
        PdtManagement[] PdtManagementArr = new PdtManagement[100];
        marketing[] marketingArr = new marketing[100];
        int employeeCount = 0;
        int designCount = 0;
        int softwareDevCount = 0;
        int reaserchCount = 0;
        int hrCount = 0;
        int pdtmanageCount = 0;
        int marketingCount = 0;
        int keepAddingEmployee = 1;
        
        System.out.println("********COMPANY MANAEGMENT SYSTEM*******");
        System.out.println("\nPLEASE ENTER YOUR ADMIN ID TO GET ACCESS");

        int choice1;
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();

        while (!login.equals("access")) {
            System.out.println("\nACCESS DENIED,PLEASE ENTER VALID ID");
            login = sc.nextLine();
        }
        System.out.println("\nACCESS GRANTED,PRESS 1 TO CONTINUE");
        int cont, choice2, choice3, choice4, choice5, choice6, choice7, choice8;
        cont = sc.nextInt();
        sc.nextLine();
        while (cont == 1) {
            System.out.println(
                    "\n1.Press 1 to get details of employees.\n2.Press 2 to modify data of employees.\n3.Press 3 for to manage record of customers and services.\n4.Press any other integer key to exit");
            choice2 = sc.nextInt();
            sc.nextLine();
            switch (choice2) {
                case 1:
                    System.out.println(
                            "\n1.Press 1 to get details of a specefic employee.\n2.Press 2 to get data of employees of specific department.");
                    choice4 = sc.nextInt();
                    sc.nextLine();
                    switch (choice4) {
                        case 1:
                            System.out.println("\nEnter the employee code");
                            String code;
                            
                            code = sc.nextLine();
                            if(code.length()>5){System.out.println("\n**The entered code is of invalid format");}
                            else{
                            if (code.charAt(1) == 'D' || code.charAt(1) == 'd') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);                                
                                try{
                                    Integer.valueOf(intValue);
                               
                                    FileInputStream fis = new FileInputStream("D:\\employeesData\\Design_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<design> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            design obj = ((design) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    System.out.println(objectsList.get(Integer.valueOf(intValue)));
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
                            else if (code.charAt(1) == 'S' || code.charAt(1) == 's') {
                                
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\SoftwareDev_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<softwareDev> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            softwareDev obj = ((softwareDev) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    System.out.println(objectsList.get(Integer.valueOf(intValue)));
                                }
                                catch(NumberFormatException e){
                                    System.out.println("\n**The entered code is in invalid format");
                                }catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");} 
                                catch (Exception g) {
                                    System.out.println(g);}
                                }catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
                                }
                             else if (code.charAt(1) == 'R' || code.charAt(1) == 'r') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\Research_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<Research> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            Research obj = ((Research) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    System.out.println(objectsList.get(Integer.valueOf(intValue)));
                                }
                                catch(NumberFormatException e){
                                    System.out.println("\n**The entered code is in invalid format");
                                } catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
                                catch (Exception g) {
                                    System.out.println(g);
                                }}catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
                            } 
                            else if (code.charAt(1) == 'H' || code.charAt(1) == 'h') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream("D:\\employeesData\\HR_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<HR> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            HR obj = ((HR) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    }
                                   catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    System.out.println(objectsList.get(Integer.valueOf(intValue)));
                                }
                                catch(NumberFormatException e){
                                    System.out.println("\n**The entered code is in invalid format");
                                }  catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
                                catch (Exception g) {
                                    System.out.println(g);
                                }}catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
                            } else if (code.charAt(1) == 'P' || code.charAt(1) == 'p') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\ProductManagement_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<PdtManagement> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            PdtManagement obj = ((PdtManagement) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    }
                                    catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    System.out.println(objectsList.get(Integer.valueOf(intValue)));
                                }
                                catch(NumberFormatException e){
                                    System.out.println("\n**The entered code is in invalid format");
                                } catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
                                catch (Exception g) {
                                    System.out.println(g);
                                }}catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
                            } else if (code.charAt(1) == 'M' || code.charAt(1) == 'm') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try {
                                    try{
                                        String intValue=code.substring(2, 5);
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\Marketing_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<marketing> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            marketing obj = ((marketing) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    }
                                     catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    System.out.println(objectsList.get(Integer.valueOf(intValue)));
                                } 
                                catch(NumberFormatException e){
                                    System.out.println("\n**The entered code is in invalid format");
                                }catch(IndexOutOfBoundsException h){System.out.println("\n**The entered code does not exist");}
                                catch (Exception g) {
                                    System.out.println(g);
                                }}catch(Exception e){System.out.println("\n**The entered code is of invalid format");}
                            }
                            else System.out.println("\n**The entered code is in invalid format");
                        }
                            break;

                        case 2:
                            System.out.println(
                                    "\n1.Press 1 to get details of DESIGN TEAM.\n2.Press 2 to get details of Software Developers TEAM.\n3.Press 3 to get details of Reaserch Team.\n4.Press 4 to get details of HR TEAM.\n5.Press 5 to get details of Product TEAM.\n6.Press 6 to get details of Marketing TEAM");
                            choice3 = sc.nextInt();
                            sc.nextLine();


                            switch (choice3) {
                                case 1:
                                    try {
                                        FileInputStream fis = new FileInputStream(
                                                "D:\\employeesData\\Design_Encoded.txt");
                                        AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                        ArrayList<design> objectsList = new ArrayList<>();
                                        boolean co = true;
                                        try {
                                            while (co) {
                                                design obj = ((design) input.readObject());
                                                if (obj != null) {
                                                    objectsList.add(obj);
                                                } else {
                                                    co = false;

                                                }
                                            }
                                        } catch (Exception g) {
                                            System.out.println(g);
                                        }
                                        input.close();
                                        System.out.println(objectsList);
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }

                                    break;

                                case 2:
                                    try {
                                        FileInputStream fis = new FileInputStream(
                                                "D:\\employeesData\\SoftwareDev_Encoded.txt");
                                        AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                        ArrayList<softwareDev> objectsList = new ArrayList<>();
                                        boolean co = true;
                                        try {
                                            while (co) {
                                                softwareDev obj = ((softwareDev) input.readObject());
                                                if (obj != null) {
                                                    objectsList.add(obj);
                                                } else {
                                                    co = false;

                                                }
                                            }
                                        } catch (Exception g) {
                                            System.out.println(g);
                                        }
                                        input.close();
                                        System.out.println(objectsList);
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }

                                    break;

                                case 3:
                                    try {
                                        FileInputStream fis = new FileInputStream(
                                                "D:\\employeesData\\Research_Encoded.txt");
                                        AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                        ArrayList<Research> objectsList = new ArrayList<>();
                                        boolean co = true;
                                        try {
                                            while (co) {
                                                Research obj = ((Research) input.readObject());
                                                if (obj != null) {
                                                    objectsList.add(obj);
                                                } else {
                                                    co = false;

                                                }
                                            }
                                        } catch (Exception g) {
                                            System.out.println(g);
                                        }
                                        input.close();
                                        System.out.println(objectsList);
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }

                                    break;

                                case 4:
                                    try {
                                        FileInputStream fis = new FileInputStream("D:\\employeesData\\HR_Encoded.txt");
                                        AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                        ArrayList<HR> objectsList = new ArrayList<>();
                                        boolean co = true;
                                        try {
                                            while (co) {
                                                HR obj = ((HR) input.readObject());
                                                if (obj != null) {
                                                    objectsList.add(obj);
                                                } else {
                                                    co = false;

                                                }
                                            }
                                        } catch (Exception g) {
                                            System.out.println(g);
                                        }
                                        input.close();
                                        System.out.println(objectsList);
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }

                                    break;

                                case 5:
                                    try {
                                        FileInputStream fis = new FileInputStream(
                                                "D:\\employeesData\\ProductManagement_Encoded.txt");
                                        AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                        ArrayList<PdtManagement> objectsList = new ArrayList<>();
                                        boolean co = true;
                                        try {
                                            while (co) {
                                                PdtManagement obj = ((PdtManagement) input.readObject());
                                                if (obj != null) {
                                                    objectsList.add(obj);
                                                } else {
                                                    co = false;

                                                }
                                            }
                                        } catch (Exception g) {
                                            System.out.println(g);
                                        }
                                        input.close();
                                        System.out.println(objectsList);
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }

                                    break;

                                case 6:
                                    try {
                                        FileInputStream fis = new FileInputStream(
                                                "D:\\employeesData\\Marketing_Encoded.txt");
                                        AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                        ArrayList<marketing> objectsList = new ArrayList<>();
                                        boolean co = true;
                                        try {
                                            while (co) {
                                                marketing obj = ((marketing) input.readObject());
                                                if (obj != null) {
                                                    objectsList.add(obj);
                                                } else {
                                                    co = false;

                                                }
                                            }
                                        } catch (Exception g) {
                                            System.out.println(g);
                                        }
                                        input.close();
                                        System.out.println(objectsList);
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }

                                    break;

                            }
                            break;
                    }
                    break;

                case 2:
                    System.out.println(
                            "\n1.Press 1 to add a new employee to database.\n2.Press 2 to modify data of existing employees.");
                    choice3 = sc.nextInt();
                    sc.nextLine();
                    switch (choice3) {
                        case 1:
                            while (keepAddingEmployee == 1) {
                                System.out.println("\n1.Tech.\n2.Non Tech");

                                choice4 = sc.nextInt();
                                sc.nextLine();
                                switch (choice4) {
                                    case 1:
                                        System.out.println("\n1.Design.\n2.Software Dev.\n3.Reasearch");
                                        choice5 = sc.nextInt();
                                        sc.nextLine();
                                        switch (choice5) {
                                            case 1:
                                                String name, designrole,empcode;
                                                int age;
                                                
                                                System.out.println("\nEnter empcode");
                                                
                                                empcode=sc.nextLine();
                                                
                                                System.out.println("\n#Enter Name");
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Design Role");
                                                designrole = sc.nextLine();

                                                designArr[designCount] = new design(name, age, designrole,empcode);
                                                employeeArr[employeeCount] = new Employee(name, age,empcode);
                                               

                                                // serializing object to a text file using objectOutputStream
                                                try {
                                                    FileOutputStream fout = new FileOutputStream(
                                                            "D:\\employeesData\\Design_Encoded.txt", true);
                                                    AppendableObjectOutputStream out = new AppendableObjectOutputStream(
                                                            fout);
                                                    out.writeObject(designArr[designCount]);
                                                    out.flush();
                                                    out.close();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }

                                                try {
                                                    FileInputStream fis = new FileInputStream(
                                                            "D:\\employeesData\\Design_Encoded.txt");
                                                    AppendableObjectInputStream input = new AppendableObjectInputStream(
                                                            fis);

                                                    ArrayList<design> objectsList = new ArrayList<>();
                                                    boolean co = true;
                                                    try {
                                                        while (co) {
                                                            design obj = ((design) input.readObject());
                                                            if (obj != null) {
                                                                objectsList.add(obj);
                                                            } else {
                                                                co = false;

                                                            }
                                                        }
                                                    } catch (Exception g) {
                                                        System.out.println(g);
                                                    }
                                                    input.close();
                                                    System.out.println(objectsList);
                                                } catch (Exception g) {
                                                    System.out.println(g);
                                                }
                                                // incrementing count of employees
                                                designCount++;
                                                employeeCount++;
                                                // data adding completes here
                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");
                                                break;

                                            case 2:
                                                String softwareRole;
                                                
                                                System.out.println("\nEnter empcode");
                                                
                                                empcode=sc.nextLine();
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Software Role");
                                                softwareRole = sc.nextLine();

                                                softwareDevArr[softwareDevCount] = new softwareDev(name, age,
                                                        softwareRole,empcode);
                                                employeeArr[employeeCount] = new Employee(name, age,empcode);
                                                
                                                try {
                                                    FileOutputStream fout = new FileOutputStream(
                                                            "D:\\employeesData\\SoftwareDev_Encoded.txt", true);
                                                    AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                                    out.writeObject(softwareDevArr[softwareDevCount]);
                                                    out.flush();
                                                    out.close();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }
                                                softwareDevCount++;
                                                employeeCount++;
                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");
                                                break;

                                            case 3:
                                                String topic;
                                                
                                                System.out.println("\nEnter empcode");
                                                
                                                empcode=sc.nextLine();
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Topic Of Research");
                                                topic = sc.nextLine();

                                                ResearchArr[reaserchCount] = new Research(name, age, topic,empcode);
                                                employeeArr[employeeCount] = new Employee(name, age,empcode);

                                                try {
                                                    FileOutputStream fout = new FileOutputStream(
                                                            "D:\\employeesData\\Research_Encoded.txt", true);
                                                    AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                                    out.writeObject(ResearchArr[reaserchCount]);
                                                    out.flush();
                                                    out.close();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }
                                                reaserchCount++;
                                                employeeCount++;

                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");

                                                break;

                                        }
                                        break;

                                    case 2:

                                        System.out.println("\n1.HR.\n2.Pdt Management.\n3.Marketing");
                                        choice6 = sc.nextInt();
                                        sc.nextLine();
                                        switch (choice6) {
                                            case 1:
                                                String name, designation,empcode;
                                                int age;
                                                
                                                System.out.println("\nEnter empcode");
                                                
                                                empcode=sc.nextLine();
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Designation in HR Team");
                                                designation = sc.nextLine();

                                                HRArr[hrCount] = new HR(name, age, designation,empcode);
                                                employeeArr[employeeCount] = new Employee(name, age,empcode);
                                            
                                                try {
                                                    FileOutputStream fout = new FileOutputStream(
                                                            "D:\\employeesData\\HR_Encoded.txt", true);
                                                    AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                                    out.writeObject(HRArr[hrCount]);
                                                    out.flush();
                                                    out.close();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }
                                                hrCount++;
                                                employeeCount++;
                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");

                                                break;

                                            case 2:
                                                String product;
                                                
                                                System.out.println("\nEnter empcode");
                                                
                                                empcode=sc.nextLine();
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Product");
                                                product = sc.nextLine();

                                                PdtManagementArr[pdtmanageCount] = new PdtManagement(name, age,
                                                        product,empcode);
                                                employeeArr[employeeCount] = new Employee(name, age,empcode);
                                                try {
                                                    FileOutputStream fout = new FileOutputStream(
                                                            "D:\\employeesData\\ProductManagement_Encoded.txt", true);
                                                    AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                                    out.writeObject(PdtManagementArr[pdtmanageCount]);
                                                    out.flush();
                                                    out.close();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }
                                                pdtmanageCount++;
                                                employeeCount++;

                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");

                                                break;

                                            case 3:
                                                String medium, area;
                                                
                                                System.out.println("\nEnter empcode");
                                                
                                                empcode=sc.nextLine();
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Medium");
                                                medium = sc.nextLine();
                                                System.out.println("#Enter Area of Marketing");
                                                area = sc.nextLine();

                                                marketingArr[marketingCount] = new marketing(name, age, medium, area,empcode);
                                                employeeArr[employeeCount] = new Employee(name, age,empcode);
                                                try {
                                                    FileOutputStream fout = new FileOutputStream(
                                                            "D:\\employeesData\\Marketing_Encoded.txt", true);
                                                    AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                                    out.writeObject(marketingArr[marketingCount]);
                                                    out.flush();
                                                    out.close();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                }
                                                hrCount++;
                                                employeeCount++;
                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");
                                                break;
                                        }
                                        break;
                                }
                                keepAddingEmployee = sc.nextInt();
                            }
                            break;

                        case 2:
                            System.out.println("\nEnter the employee code whose data you want to modify");
                            
                            String code = sc.nextLine();
                            if(code.length()>5){System.out.println("\n**The entered code is of invalid format");}
                            else{
                            if (code.charAt(1) == 'D' || code.charAt(1) == 'd') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    
                                    FileInputStream fis = new FileInputStream("D:\\employeesData\\Design_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<design> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            design obj = ((design) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    try{
                                    if(objectsList.size()<=Integer.valueOf(intValue)){
                                        throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                    }                           
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Design Role");
                                    int field; 
                                    System.out.println("\nChoose field");                                   
                                    field = sc.nextInt();
                                    sc.nextLine();
                                    if (field == 1) {
                                        String newname;
                                        System.out.println("\nEnter new field");
                                        newname = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).name = newname;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Design_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                       
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Design_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 2) {
                                        int newage;
                                        System.out.println("\nEnter new field");
                                        newage=sc.nextInt();
                                        sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).age=newage;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Design_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                       
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Design_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println( objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 3) {
                                        String newdesignRole;
                                        System.out.println("\nEnter new field");
                                        newdesignRole = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).DesignRole = newdesignRole;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Design_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Design_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));

                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    }
                                }catch(IndexOutOfBoundsException e){System.out.println("\n**The entered code does not exist");}
                                }catch(NumberFormatException e){
                                    System.out.println("\n**The entered code is in invalid format");
                                } catch (Exception g) {
                                    System.out.println(g);
                                }}catch(Exception g){System.out.println("\n**The entered code is in invalid format");}
                            }

                            else if (code.charAt(1) == 'S' || code.charAt(1) == 's') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\SoftwareDev_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<softwareDev> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            softwareDev obj = ((softwareDev) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    try{
                                        if(objectsList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.SoftwareRole");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                    if (field == 1) {
                                        String newname;
                                        System.out.println("\nEnter new field");
                                        
                                        newname = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).name = newname;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\SoftwareDev_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                       
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\SoftwareDev_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 2) {
                                        int newage;
                                        System.out.println("\nEnter new field");
                                        newage = sc.nextInt();
                                        sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).age = newage;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\SoftwareDev_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                       
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\SoftwareDev_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 3) {
                                        String newSoftwarerole;
                                        
                                        newSoftwarerole = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).SoftwareRole = newSoftwarerole;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\SoftwareDev_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\SoftwareDev_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    }
                                }catch(IndexOutOfBoundsException e){System.out.println("\n**The entered code does not exist");}
                            }catch(NumberFormatException e){
                                System.out.println("\n**The entered code is in invalid format");
                            } catch (Exception g) {
                                System.out.println(g);
                            }}catch(Exception g){System.out.println("\n**The entered code is in invalid format");}
                        }

                            else if (code.charAt(1) == 'R' || code.charAt(1) == 'r') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\Research_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<Research> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            Research obj = ((Research) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    try{
                                        if(objectsList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Design Role");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                    if (field == 1) {
                                        System.out.println("\nEnter new field");
                                        String newname;
                                        
                                        newname = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).name = newname;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Research_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Research_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 2) {
                                        int newage;
                                        
                                        newage = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("\nEnter new field");
                                        objectsList.get(Integer.valueOf(intValue)).age = newage;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Research_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                       
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Research_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 3) {
                                        String newtopic;
                                        System.out.println("\nEnter new field");
                                        newtopic = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).topic = newtopic;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Research_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Research_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    }
                                }catch(IndexOutOfBoundsException e){System.out.println("\n**The entered code does not exist");}
                            }catch(NumberFormatException e){
                                System.out.println("\n**The entered code is in invalid format");
                            } catch (Exception g) {
                                System.out.println(g);
                            }}catch(Exception g){System.out.println("\n**The entered code is in invalid format");}
                        }
                            else if (code.charAt(1) == 'H' || code.charAt(1) == 'h') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream("D:\\employeesData\\HR_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<HR> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            HR obj = ((HR) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    try{
                                        if(objectsList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Designation");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                    if (field == 1) {
                                        String newname;
                                        System.out.println("\nEnter new field");
                                        newname = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).name = newname;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\HR_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\HR_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 2) {
                                        int newage;
                                        System.out.println("\nEnter new field");
                                        newage = sc.nextInt();
                                        sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).age = newage;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\HR_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                    
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\HR_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 0; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 3) {
                                        String newDesignation;
                                        System.out.println("\nEnter new field");
                                        newDesignation = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).Designation = newDesignation;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\HR_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\HR_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    }
                                }catch(IndexOutOfBoundsException e){System.out.println("\n**The entered code does not exist");}
                            }catch(NumberFormatException e){
                                System.out.println("\n**The entered code is in invalid format");
                            } catch (Exception g) {
                                System.out.println(g);
                            }}catch(Exception g){System.out.println("\n**The entered code is in invalid format");}
                        }

                            else if (code.charAt(1) == 'P' || code.charAt(1) == 'p') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\ProductManagement_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<PdtManagement> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            PdtManagement obj = ((PdtManagement) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    try{
                                        if(objectsList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out
                                            .println("\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Product");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                    if (field == 1) {
                                        String newname;
                                        System.out.println("\nEnter new field");
                                        newname = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).name = newname;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\ProductManagement_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\ProductManagement_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 2) {
                                        int newage;
                                        System.out.println("\nEnter new field");
                                        newage = sc.nextInt();
                                        sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).age = newage;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\ProductManagement_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                       
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\ProductManagement_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 3) {
                                        String newproduct;
                                        System.out.println("\nEnter new field");
                                        newproduct = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).product = newproduct;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\ProductManagement_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\ProductManagement_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    }
                               }catch(IndexOutOfBoundsException e){System.out.println("\n**The entered code does not exist");}
                                }catch(NumberFormatException e){
                                    System.out.println("\n**The entered code is in invalid format");
                                } catch (Exception g) {
                                    System.out.println(g);
                                }}catch(Exception g){System.out.println("\n**The entered code is in invalid format");}
                            }

                            else if (code.charAt(1) == 'M' || code.charAt(1) == 'm') {
                                // String intValue = code.replaceAll("[^0-9]", "");
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    FileInputStream fis = new FileInputStream(
                                            "D:\\employeesData\\Marketing_Encoded.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<marketing> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            marketing obj = ((marketing) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    try{
                                    if(objectsList.size()<=Integer.valueOf(intValue)){
                                        throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                    } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Medium.\n4.Area");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                    if (field == 1) {
                                        String newname;
                                        System.out.println("\nEnter new field");
                                        newname = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).name = newname;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Marketing_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                       
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Marketing_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 2) {
                                        int newage;
                                        System.out.println("\nEnter new field");
                                        newage = sc.nextInt();
                                        sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).age = newage;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Marketing_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Marketing_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 3) {
                                        String newmedium;
                                        System.out.println("\nEnter new field");
                                        newmedium = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).medium = newmedium;
                                        try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Marketing_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                        
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Marketing_Encoded.txt", true);
                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    } else if (field == 4) {
                                        String newmedium;
                                        System.out.println("\nEnter new field");
                                        newmedium = sc.nextLine();
                                        objectsList.get(Integer.valueOf(intValue)).area = newmedium;
    try {FileOutputStream ffout = new FileOutputStream("D:\\employeesData\\Marketing_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(objectsList.get(0));
    oout.flush();
    oout.close();
                                            FileOutputStream fout = new FileOutputStream(
                                                    "D:\\employeesData\\Marketing_Encoded.txt", true);
                                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                                            for (int i = 1; i < objectsList.size(); i++) {
                                                out.writeObject(objectsList.get(i));
                                            }
                                            out.flush();
                                            out.close();
                                            System.out.println("\nModified data of the employee\n"+objectsList.get(Integer.valueOf(intValue)));
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    }
                                }catch(IndexOutOfBoundsException e){System.out.println("\n**The entered code does not exist");}
                            }catch(NumberFormatException e){
                                System.out.println("\n**The entered code is in invalid format");
                            } catch (Exception g) {
                                System.out.println(g);
                            }}catch(Exception g){System.out.println("\n**The entered code is in invalid format");}
                            
                        }

                    }
                }
                    
                    break;
                    case 3:
                    System.out.println("1.Press 1 to add a new Service Record.\n2.Press 2 to get details of previous records");
                    choice7=sc.nextInt();
                    sc.nextLine();
                        String p1="Account Manager Software,";
                        String p2="Students Records Manager,";
                        String p3="Website Hosting Software,";
                        String p4="Data Protection Software,";
                        String p5="Antivirus Software,";
                        int b1=1000;int b2=2000;int b3=1500;int b4=4000;int b5=3000;
                    switch(choice7){                       
                        case 1:
                        String cid,enterprise;
                        String softwares="";
                        int billamount=0;
                        System.out.println("\n#Enter CustomerID");
                        cid=sc.nextLine();
                        System.out.println("\n#Enter Enterprise Name");
                        enterprise=sc.nextLine();
                        int keepAddingSoftware=1;
                        while(keepAddingSoftware==1){
                        System.out.println("\nSelect products purchased\n1.Accounts Manager software.\n2.Students Records Manager.\n3.Website Hosting software.\n4.Data Protection Software.\n5.Antivirus Software");
                        int chooseSoftware;
                        chooseSoftware=sc.nextInt();
                        sc.nextLine();                       
                        if(chooseSoftware==1){
                            softwares+=p1;
                            billamount+=b1;
                            System.out.println("\npress 1 to add more products else press any integer");
                        }
                        else if(chooseSoftware==2){
                            softwares+=p2;
                            billamount+=b2;
                            System.out.println("\npress 1 to add more products else press any integer");
                        }
                        else if(chooseSoftware==3){
                            softwares+=p3;
                            billamount+=b3;
                            System.out.println("\npress 1 to add more products else press any integer");
                        }
                        else if(chooseSoftware==4){
                            softwares+=p4;
                            billamount+=b4;
                            System.out.println("\npress 1 to add more products else press any integer");
                        }
                        else if(chooseSoftware==5){
                            softwares+=p5;
                            billamount+=b5;
                            System.out.println("\npress 1 to add more products else press any integer");
                        }
                        keepAddingSoftware=sc.nextInt();
                        sc.nextLine();
                    }       
                    service s=new service(cid, enterprise, softwares, billamount);
                       
                        try {
    FileOutputStream fout = new FileOutputStream( "D:\\ServicesData\\SerivceRecord.txt", true);
                            AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
                            out.writeObject(s);
                            out.flush();
                            out.close();
                        } catch(Exception e){System.out.println(e);}
                        break;

                        case 2:
                        System.out.println("\nEnter the CustomerID");
                            String code;
                            code = sc.nextLine();
                                String intValue = code.replaceAll("[^0-9]", "");
                                try {
                                    FileInputStream fis = new FileInputStream("D:\\ServicesData\\SerivceRecord.txt");
                                    AppendableObjectInputStream input = new AppendableObjectInputStream(fis);

                                    ArrayList<service> objectsList = new ArrayList<>();
                                    boolean co = true;
                                    try {
                                        while (co) {
                                            service obj = ((service) input.readObject());
                                            if (obj != null) {
                                                objectsList.add(obj);
                                            } else {
                                                co = false;

                                            }
                                        }
                                    } catch (Exception g) {
                                        System.out.println(g);
                                    }
                                    input.close();
                                    System.out.println(objectsList.get(Integer.valueOf(intValue)));
                                } catch (Exception g) {
                                    System.out.println(g);
                                }
                    
                    break;
                            }
                            break;
                    
                    default:
                    cont=0;


            }
        }
        System.out.println("********Session Ended********");

        sc.close();
    }
}

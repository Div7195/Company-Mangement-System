import DepartmentClasses.*;
import UtilityClasses.*;
import java.util.*;
import java.io.*;
public class company_alternate {
    public static void main(String[] args) {
        int keepAddingEmployee = 1;      
        ArrayList<design> designList = new ArrayList<>();
        ArrayList<Research> researchList = new ArrayList<>();
        ArrayList<softwareDev> softwareList = new ArrayList<>();
        ArrayList<HR> hrList = new ArrayList<>();
        ArrayList<PdtManagement> productList = new ArrayList<>();
        ArrayList<marketing> marketingList = new ArrayList<>();
        ArrayList<service> serviceList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("D:\\employeesDataAlternate\\Design_Encoded.txt");
                AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                     boolean co = true;
                     try {
                        while (co) {
                     design obj = ((design) input.readObject());
                          if (obj != null) {
                             designList.add(obj);
                        } else {
                         co = false;

                      }
                 }
                } catch (Exception g) {
                    System.out.println("\n\n***DATA LOADED!***");
                }
             input.close();
          }catch(Exception e){System.out.println(e);}

          try{
            FileInputStream fis = new FileInputStream("D:\\employeesDataAlternate\\SoftwareDev_Encoded.txt");
                AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                     boolean co = true;
                     try {
                        while (co) {
                     softwareDev obj = ((softwareDev) input.readObject());
                          if (obj != null) {
                             softwareList.add(obj);
                        } else {
                         co = false;

                      }
                 }
                } catch (Exception g) {
            
                }
             input.close();
          }catch(Exception e){System.out.println(e);}

          try{
            FileInputStream fis = new FileInputStream("D:\\employeesDataAlternate\\Research_Encoded.txt");
                AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                     boolean co = true;
                     try {
                        while (co) {
                     Research obj = ((Research) input.readObject());
                          if (obj != null) {
                             researchList.add(obj);
                        } else {
                         co = false;

                      }
                 }
                } catch (Exception g) {
            
                }
             input.close();
          }catch(Exception e){System.out.println(e);}

          try{
            FileInputStream fis = new FileInputStream("D:\\employeesDataAlternate\\HR_Encoded.txt");
                AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                     boolean co = true;
                     try {
                        while (co) {
                     HR obj = ((HR) input.readObject());
                          if (obj != null) {
                             hrList.add(obj);
                        } else {
                         co = false;

                      }
                 }
                } catch (Exception g) {
            
                }
             input.close();
          }catch(Exception e){System.out.println(e);}

          try{
            FileInputStream fis = new FileInputStream("D:\\employeesDataAlternate\\ProductManagement_Encoded.txt");
                AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                     boolean co = true;
                     try {
                        while (co) {
                     PdtManagement obj = ((PdtManagement) input.readObject());
                          if (obj != null) {
                             productList.add(obj);
                        } else {
                         co = false;

                      }
                 }
                } catch (Exception g) {
            
                }
             input.close();
          }catch(Exception e){System.out.println(e);}
          try{
            FileInputStream fis = new FileInputStream("D:\\employeesDataAlternate\\Marketing_Encoded.txt");
                AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                     boolean co = true;
                     try {
                        while (co) {
                     marketing obj = ((marketing) input.readObject());
                          if (obj != null) {
                             marketingList.add(obj);
                        } else {
                         co = false;

                      }
                 }
                } catch (Exception g) {
            
                }
             input.close();
          }catch(Exception e){System.out.println(e);}

          try{
            FileInputStream fis = new FileInputStream("D:\\employeesDataAlternate\\CustomerRecord.txt");
                AppendableObjectInputStream input = new AppendableObjectInputStream(fis);                                  
                     boolean co = true;
                     try {
                        while (co) {
                     service obj = ((service) input.readObject());
                          if (obj != null) {
                             serviceList.add(obj);
                        } else {
                         co = false;

                      }
                 }
                } catch (Exception g) {
                }
             input.close();
          }catch(Exception e){System.out.println(e);}

       
                                                                
                                                                            
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
                    "\n1.Press 1 to get details of employees.\n2.Press 2 to modify data of employees.\n3.Press 3 to manage record of customers and services.\n4.Press any other integer key to save changes and exit");
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
                                design use=new design();
                                use.getEmployeesData(designList,code);
                               
                            } 
                            else if (code.charAt(1) == 'S' || code.charAt(1) == 's') {
                                softwareDev use=new softwareDev();
                                use.getEmployeesData(softwareList,code);
                                
                                 }
                             else if (code.charAt(1) == 'R' || code.charAt(1) == 'r') {
                                Research use=new Research();
                                use.getEmployeesData(researchList,code);
                               
                            } 
                            else if (code.charAt(1) == 'H' || code.charAt(1) == 'h') {
                                HR use=new HR();
                                use.getEmployeesData(hrList,code);
                                
                            } else if (code.charAt(1) == 'P' || code.charAt(1) == 'p') {
                                PdtManagement use=new PdtManagement();
                                use.getEmployeesData(productList,code);
                                
                            } else if (code.charAt(1) == 'M' || code.charAt(1) == 'm') {
                                marketing use=new marketing();
                                use.getEmployeesData(marketingList,code);
                               
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
                                System.out.println(designList);

                                    break;

                                case 2:
                                    System.out.println(softwareList);

                                    break;

                                case 3:
                                    System.out.println(researchList);

                                    break;

                                case 4:
                                    System.out.println(hrList);

                                    break;

                                case 5:
                                    System.out.println(productList);

                                    break;

                                case 6:
                                    System.out.println(marketingList);

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
                                                design use1=new design();
                                                String name, designrole;
                                                int age;                                                
                                                System.out.println("\n#Enter Name");
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Design Role");
                                                designrole = sc.nextLine();
                                                use1.addNewEmployees(designList,name,age,designrole);
                                             
                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");
                                                break;

                                            case 2:
                                                String softwareRole;
                                                softwareDev use2=new softwareDev();
                                                                                   
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Software Role");
                                                softwareRole = sc.nextLine();
                                                use2.addNewEmployees(softwareList, name, age, softwareRole);
                                                
                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");
                                                break;

                                            case 3:
                                                String topic;
                                                Research use3=new Research();
                                                
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Topic Of Research");
                                                topic = sc.nextLine();
                                                use3.addNewEmployees(researchList, name, age, topic);
                                                

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
                                                String name, designation;
                                                int age;
                                                HR use4=new HR();
                                                
                                                
                                                System.out.println("\n#Enter Name");                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Designation in HR Team");
                                                designation = sc.nextLine();
                                                use4.addNewEmployees(hrList, name, age, designation);
                                                
                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");

                                                break;

                                            case 2:
                                                String product;
                                                PdtManagement use5=new PdtManagement();
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Product");
                                                product = sc.nextLine();
                                                use5.addNewEmployees(productList, name,age, product);
                                                

                                                System.out.println(
                                                        "\nSuccessfully added the data!!\nIf you want to add more employees,press 1,else press any other key");

                                                break;

                                            case 3:
                                                String medium, area;
                                                marketing use6=new marketing();
                                                
                                                System.out.println("\n#Enter Name");
                                                
                                                name = sc.nextLine();
                                                System.out.println("#Enter Age");
                                                age = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("#Enter Medium");
                                                medium = sc.nextLine();
                                                System.out.println("#Enter Area of Marketing");
                                                area = sc.nextLine();
                                                use6.addNewEmployees(marketingList, name, age, medium, area);
                                                
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
                             
                                try{
                                    String intValue=code.substring(2, 5);
                                try {
                                    
                                    try{
                                    if(designList.size()<=Integer.valueOf(intValue)){
                                        throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                    }                           
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Design Role");
                                    int field; 
                                    System.out.println("\nChoose field");                                   
                                    field = sc.nextInt();
                                    sc.nextLine();
                                    design mod1=new design();
                                    mod1.modifyEmployeeData(designList,field,intValue);
                                    
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
                                    try{
                                        if(softwareList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.SoftwareRole");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                            softwareDev mod2=new softwareDev();
                                    mod2.modifyEmployeeData(softwareList,field,intValue);
                                    
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
                                    try{
                                        if(researchList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Design Role");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                            Research mod3=new Research();
                                    mod3.modifyEmployeeData(researchList,field,intValue);
                                    
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
                                    try{
                                        if(hrList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Designation");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                            HR mod4=new HR();
                                    mod4.modifyEmployeeData(hrList,field,intValue);
                                    
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
                                    try{
                                        if(productList.size()<=Integer.valueOf(intValue)){
                                            throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                        } 
                                    System.out
                                            .println("\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Product");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                            PdtManagement mod5=new PdtManagement();
                                    mod5.modifyEmployeeData(productList,field,intValue);
                                    
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
                                    try{
                                    if(marketingList.size()<=Integer.valueOf(intValue)){
                                        throw new IndexOutOfBoundsException("\n**The entered code does not exist");
                                    } 
                                    System.out.println(
                                            "\nWhich field do you want to modify?\n1.Name\n2.Age\n3.Medium.\n4.Area");
                                            int field; 
                                            System.out.println("\nChoose field");                                   
                                            field = sc.nextInt();
                                            sc.nextLine();
                                            marketing mod6=new marketing();
                                    mod6.modifyEmployeeData(marketingList,field,intValue);
                                    
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
                    System.out.println("\n1.Press 1 to add a new Service Record.\n2.Press 2 to get details of previous records.");
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
                        service s=new service();
                        String enterprise;
                        String softwares="";
                        int billamount=0;
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
                        
                        System.out.println(softwares);
                        s.addNewBill(serviceList, enterprise, softwares, billamount);
                        
                        System.out.println("\nSuccesfully added data!");
                        break;

                        case 2:
                        service use=new service();
                        System.out.println("\n1.Press 1 to get details of a particular bill\n2.Press 2 to get history of a particular Enterprise customer");
                        choice8=sc.nextInt();
                        sc.nextLine();
                        switch(choice8){
                        case 1:
                        System.out.println("\nEnter the Customer ID");
                        String code;                       
                        code = sc.nextLine();
                        if(code.length()>4){System.out.println("\n**The entered id is of invalid format");}
                        else{
                        if (code.charAt(0) == 'c' || code.charAt(1) == 'C') {
                            
                            use.getBillData(serviceList, code);                          
                        } 
                        else System.out.println("\nThe entered id of invalid format");
                        }
                        break;
                            case 2:      
                                                   
                                System.out.println("\nEnter enterprise name");
                                String searchEnterprise=sc.nextLine();
                                Boolean companyFound=false;
                                for(int i=0;i<serviceList.size();i++){
                                    if(serviceList.get(i).Enterprise.equals(searchEnterprise)){
                                        System.out.println("\n"+serviceList.get(i));
                                        companyFound=true;
                                    }
                                }
                                if(!companyFound){System.out.println("\nThe entered enterprise does not exist in record file");}
                            break;
                        }


                            }
                            break;
                    
                    default:
                    cont=0;


            }
        }
        
    try {FileOutputStream ffout = new FileOutputStream("D:\\employeesDataAlternate\\Design_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(designList.get(0));
    oout.flush();
    oout.close();
                                       
FileOutputStream fout = new FileOutputStream("D:\\employeesDataAlternate\\Design_Encoded.txt", true);
        AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
    for (int i = 1; i < designList.size(); i++) {
       out.writeObject(designList.get(i));
   }
    out.flush();
    out.close();
     } catch (Exception e) {
    
      }

      try {FileOutputStream ffout = new FileOutputStream("D:\\employeesDataAlternate\\SoftwareDev_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(softwareList.get(0));
    oout.flush();
    oout.close();
                                       
FileOutputStream fout = new FileOutputStream("D:\\employeesDataAlternate\\SoftwareDev_Encoded.txt", true);
        AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
    for (int i = 1; i < softwareList.size(); i++) {
       out.writeObject(softwareList.get(i));
   }
    out.flush();
    out.close();
     } catch (Exception e) {
    
      }

      try {FileOutputStream ffout = new FileOutputStream("D:\\employeesDataAlternate\\Research_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(researchList.get(0));
    oout.flush();
    oout.close();
                                       
FileOutputStream fout = new FileOutputStream("D:\\employeesDataAlternate\\Research_Encoded.txt", true);
        AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
    for (int i = 1; i < researchList.size(); i++) {
       out.writeObject(researchList.get(i));
   }
    out.flush();
    out.close();
     } catch (Exception e) {
    
      }

      try {FileOutputStream ffout = new FileOutputStream("D:\\employeesDataAlternate\\HR_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(hrList.get(0));
    oout.flush();
    oout.close();
                                       
FileOutputStream fout = new FileOutputStream("D:\\employeesDataAlternate\\HR_Encoded.txt", true);
        AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
    for (int i = 1; i < hrList.size(); i++) {
       out.writeObject(hrList.get(i));
   }
    out.flush();
    out.close();
     } catch (Exception e) {
    
      }

      try {FileOutputStream ffout = new FileOutputStream("D:\\employeesDataAlternate\\Product_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(productList.get(0));
    oout.flush();
    oout.close();
                                       
FileOutputStream fout = new FileOutputStream("D:\\employeesDataAlternate\\Product_Encoded.txt", true);
        AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
    for (int i = 1; i < productList.size(); i++) {
       out.writeObject(productList.get(i));
   }
    out.flush();
    out.close();
     } catch (Exception e) {
    
      }

      try {FileOutputStream ffout = new FileOutputStream("D:\\employeesDataAlternate\\Marketing_Encoded.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(marketingList.get(0));
    oout.flush();
    oout.close();
                                       
FileOutputStream fout = new FileOutputStream("D:\\employeesDataAlternate\\Marketing_Encoded.txt", true);
        AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
    for (int i = 1; i < marketingList.size(); i++) {
       out.writeObject(marketingList.get(i));
   }
    out.flush();
    out.close();
     } catch (Exception e) {
    
      }

      try {FileOutputStream ffout = new FileOutputStream("D:\\employeesDataAlternate\\CustomerRecord.txt", false);
    AppendableObjectOutputStream oout = new AppendableObjectOutputStream(ffout);   
    oout.writeObject(serviceList.get(0));
    oout.flush();
    oout.close();
                                       
FileOutputStream fout = new FileOutputStream("D:\\employeesDataAlternate\\CustomerRecord.txt", true);
        AppendableObjectOutputStream out = new AppendableObjectOutputStream(fout);
    for (int i = 1; i < serviceList.size(); i++) {
       out.writeObject(serviceList.get(i));
   }
    out.flush();
    out.close();
     } catch (Exception e) {
    
      }
 System.out.println("********Saved Changes!,Session Ended********");
 sc.close();
    }
}
 public void getEmployeesData(ArrayList<design> employeeList,String code){
        try{
                    String intValue=code.substring(2, 5);                                
                try{
                    Integer.valueOf(intValue);     
                    
                    if(employeelist.get(intvalue).status==1){
                    System.out.println(employeeList.get(Integer.valueOf(intValue)));
                    }
                    else{
                        System.out.println("\n*****these employee does not work any more with us******");
                         System.out.println(employeeList.get(Integer.valueOf(intValue)));
                    }
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
public void sort1EmployeesData(ArrayList<design> employeeList,String code){
        try{
            
             ArrayList<Employee>al = employeeList;
                   Collections.sort(al,new Comparator<Employee>(){
		                  public int compare(Employee e1,Employee e2){
		                      return (e1.name).compareTo(e2.name);
		                  }
		              });
		              for(int i=0;i<al.size();i++){
		                   
		                 System.out.println(al.get(i));
		                   
		               }
		          }
		          else{
		              System.out.println("file not found");
		          }
		              
		      System.out.println("-------------------------------------------");
		          break;
    }
public void sort2EmployeesData(ArrayList<design> employeeList,String code){
        try{
            
               ArrayList<Employee>al = employeeList;
               
                   Collections.sort(al,new Comparator<Employee>(){
		                  public int compare(Employee e1,Employee e2){
		                      return (e1.salary).compareTo(e2.salary);
		                  }
		              });
		              for(int i=0;i<al.size();i++){
		                   
		                 System.out.println(al.get(i));
		                   
		               }
		          }
		          else{
		              System.out.println("file not found");
		          }
		              
		      System.out.println("-------------------------------------------");
		          break;
    }

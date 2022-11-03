case 3:
                             System.out.println("\n1.Press1 to sort on basis of name\n2.Press 2 to sort on basis of salary");
                             
                             case 1:
                                // System.out.println("\nEnter the employee code");
                                System.out.println("\nEnter the Department whose employee u wnt to sort");
                                System.out.println("\n1.Press1 for Design\n2.Press 2 for Marketting\n3.Press 3 for HR\n4.Press 4 for Product Management\n5>press 5 for software\n6.press 6 for Research\nPress any other key to exit");
                                 
                                 choice4 = sc.nextInt();
                                 sc.nextLine();
                                 
                                 switch(choice4){
                                    case 1:
                                         design use=new design();
                                         use.sort1EmployeesData(designList,code);
                                         
                                         break;
                                     case 2:
                                        marketing use=new marketing();
                                        use.sort1EmployeesData(marketingList,code);
                                         
                                         break;
                                         
                                    case 3:
                                        HR use=new HR();
                                        use.sort1EmployeesData(hrList,code);
                                        break;
                                        
                                    case 4:
                                         PdtManagement use=new PdtManagement();
                                         use.sort1EmployeesData(productList,code);
                                         break;
                                     
                                    case 5:
                                        softwareDev use=new softwareDev();
                                        use.sort1EmployeesData(softwareList,code);
                                        
                                         break;
                                         
                                    case 6:  
                                        Research use=new Research();
                                        use.sort1EmployeesData(researchList,code);
                                        break;
                                    
                                    
                                 }
                                
                                 break;
                                 
                                 
                            case 2:
                                         design use=new design();
                                         use.sort2EmployeesData(designList,code);
                                         
                                         break;
                                     case 2:
                                        marketing use=new marketing();
                                        use.sort2EmployeesData(marketingList,code);
                                         
                                         break;
                                         
                                    case 3:
                                        HR use=new HR();
                                        use.sort2EmployeesData(hrList,code);
                                        break;
                                        
                                    case 4:
                                         PdtManagement use=new PdtManagement();
                                         use.sort2EmployeesData(productList,code);
                                         break;
                                     
                                    case 5:
                                        softwareDev use=new softwareDev();
                                        use.sort2EmployeesData(softwareList,code);
                                        
                                         break;
                                         
                                    case 6:  
                                        Research use=new Research();
                                        use.sort2EmployeesData(researchList,code);
                                        break;
                                    
                                    
                                 }
                                
                                 break;     
                    }
                    break;

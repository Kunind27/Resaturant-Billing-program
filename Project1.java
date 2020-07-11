package Project;

import java.util.*;

public class Project1
{
    //master file
    int f_id[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,0,0,0,0};
    String f_categ[]={"Veg   ","Veg   ","Veg   ","Veg   ","Veg   ","Veg   ","Veg   ","Veg   ","Veg   ",
            "Veg   ","NonVeg","NonVeg","NonVeg","NonVeg","NonVeg","NonVeg","NonVeg","NonVeg",
            "NonVeg","NonVeg","","","",""};
    String f_name[]={"Paneer Tikka     ","Crispy Corn      ","Veg Seekh Kebab  ","Veg Manchurian   ",
            "Golden Coin      ","Hara Bhara Kebab ","Pav Bhaji        ","Palak Paneer     ",
            "Spicy Mushroom   ","Mix Vegetable    ","Chicken Tikka    ","Murgh Malai Tikka",
            "Tandoori Chicken ","Prawn Fry        ","Tandoori Prawns  ","Fish Malwani Tikka",
            "Pomphret         ","Chilly Chicken   ","Chicken 65       ","Murgh Kalimiri Kebab",
            "","","",""};
    int f_qty[]={20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,0,0,0,0};
    int f_cost[]={110,120,170,100,90,100,90,150,175,160,250,210,290,310,220,350,270,230,230,
            240,0,0,0,0};
    char f_remove[]={'n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n','n',
            'n','n','n','n','n','n'};

    //transaction file
    String cname="";
    String cmobile;
    int cno=100;
    int c_id[]={0,0,0,0,0,0,0,0};
    int c_m_id[]={0,0,0,0,0,0,0,0};
    String c_name[]={"","","","","","","",""};
    String c_mob[]={"","","","","","","",""};
    String c_m_categ[]={"","","","","","","",""};
    String c_m_name[]={"","","","","","","",""};
    int c_m_qty[]={0,0,0,0,0,0,0,0};
    int c_m_amt[]={0,0,0,0,0,0,0,0};

    Scanner sc=new Scanner(System.in);

    int numd=19,numc=0;
    //varaiables to use in report
    int tsales=0,nvd=0,vd=0,tvs=0,tnvs=0,dadd=0,cm=0,qc=0,drem=0,conti=1;
    //variable to check if registered
    boolean reg_check=false;

    static void main()
    {
        Project1 obj=new Project1(); 

        int ch,out=0;

        do
        {
            System.out.println("\f");
            System.out.println("\t\t\t\t********** The Urban Tadka **********");
            System.out.println();
            System.out.println("\t\t\t\t\t   Welcome!!");
            System.out.println("1.MENU");
            System.out.println("2.REGISTER");
            System.out.println("3.ORDER");
            System.out.println("4.ADD");
            System.out.println("5.DELETE");
            System.out.println("6.MODIFY");
            System.out.println("7.REPORT");
            System.out.println("8.BILL");
            System.out.println("9.EXIT");

            while(true)
            {
                try
                {
                    System.out.print("Enter your choice---->");
                    ch=obj.sc.nextInt();
                    break;
                }
                catch(Exception ob)
                {
                    System.out.println("ENTER A NUMBER ONLY!");
                    String db=obj.sc.nextLine();
                }
            }

            switch(ch)
            {
                case 1:
                obj.menu();
                break;
                case 2:
                obj.register();
                break;
                case 3:
                obj.order();
                break;
                case 4:
                obj.add();
                break;
                case 5:
                obj.delete();
                break;
                case 6:
                obj.modify();
                break;
                case 7:
                obj.report();
                break;
                case 8:
                obj.bill();
                break;
                case 9:
                {
                    System.out.println("");
                    out=1;
                    obj.conti=0;
                }
                break;
                default:
                System.out.println("**INVALID CHOICE**");

            }

            if(out==0)
            {
                while(true)
                {
                    try
                    {
                        System.out.println("Press 1 to go to Main Menu");
                        obj.conti=obj.sc.nextInt();
                        break;
                    }
                    catch(Exception ob)
                    {
                        System.out.println("ENTER A NUMBER ONLY!");
                        String db=obj.sc.nextLine();
                    }
                }

            }
        } while(obj.conti==1);

        System.out.println("\f");
        System.out.println("THANK YOU FOR VISITING US!");
        System.out.println("PLEASE VISIT AGAIN!");

    }

    void menu()
    {
        int i;
        System.out.println("\f");
        System.out.println("ID:\t\t"+"Category:\t"+"Name:\t\t\t\t"+"Quantity:\t"+"Cost:"); 

        for(i=0;i<=numd;i++)
        {
            if(f_remove[i]!='y')
            {
                System.out.println(f_id[i]+"\t\t"+f_categ[i]+"\t\t"+f_name[i]+"\t\t"+f_qty[i]+"\t\t"
                    +f_cost[i]);
            }
        }
    }

    void register()
    {  
        System.out.println("\f");
        int l,i,nod=0;

        char ch;

        numc++;
        cno++;

        System.out.println("Your customer ID is :"+cno);
        String db=sc.nextLine();
        System.out.println("Enter your name:");
        cname=sc.nextLine();

        while(true)
        {

            System.out.println("\f");
            System.out.println("Enter your mobile number:");
            cmobile=sc.next();

            l=cmobile.length();

            for(i=0;i<l;i++)
            {
                ch=cmobile.charAt(i);
                if(ch>='0'&&ch<='9')
                {
                    ++nod;
                }
            }

            if(l==10&&nod==10)
            {
                System.out.println("You have been registered successfully!");
                reg_check=true;
                break;
            }
            else 
            {
                System.out.println("Invalid Mobile no.");
                System.out.println("You have to enter again");
            }

            nod=0;
        }

    }

    void order()
    {
        int contorde=0,id,quty;
        char cho;
        int i;

        if(reg_check!=true)
        {
            System.out.println("You have not registered yourself");
            System.out.println("Please register yourself");
        }
        else
        {

            do
            {
                System.out.println("\f");
                System.out.println("You can order upto 15 dishes");
                menu();
                System.out.println("Enter the id of the dish you want to order : ");
                id=sc.nextInt();
                boolean flag = false;

                for(i=0;i<f_id.length;i++)
                {
                    if(f_id[i]==id)
                    {
                        flag = true;
                        System.out.println("Enter the quantity of the dish you want");
                        quty=sc.nextInt();

                        if(quty>f_qty[i])
                        {
                            System.out.println("Not enough quantity");  
                        }
                        else
                        {
                            //to count number of veg and non veg dishes
                            if(c_m_categ[numc].equals("Veg"))
                            {
                                vd+=quty;
                            }
                            else if(c_m_categ[numc].equals("NonVeg"))
                            {
                                nvd+=quty;
                            }
                            //to calculate sales from veg and non veg dishes    
                            if(c_m_categ[numc].equals("Veg"))
                            {
                                tvs+=f_cost[id-1]*c_m_qty[numc];
                            }
                            else if(c_m_categ[numc].equals("NonVeg"))
                            {
                                tnvs+=f_cost[id-1]*c_m_qty[numc];
                            }

                            c_id[numc] = cno;
                            c_name[numc] = cname;
                            c_mob[numc] = cmobile;

                            c_m_id[numc] = id;
                            c_m_categ[numc] = f_categ[i];
                            c_m_name[numc] = f_name[i];
                            c_m_qty[numc] = quty;
                            c_m_amt[numc] = f_cost[i] * quty;

                            f_qty[i] = f_qty[i] - quty;

                            System.out.println("Your order has been placed!");
                            numc++;
                        }
                    }
                }

                if(flag==false)
                {
                    System.out.println("Invalid customer id");
                }

                System.out.println("Do you want to order more?");
                System.out.println("\'Y\' for Yes and \'N\' for No");

                while(true)
                {
                    System.out.println("Please enter your option:");
                    cho=sc.next().charAt(0);
                    if(cho=='Y'||cho=='y')
                    {
                        contorde=1;
                        break;
                    }
                    else if(cho=='N'||cho=='n')
                    {
                        contorde=0;
                        break;
                    }
                    else
                    {
                        System.out.println("Wrong Choice");
                        System.out.println("You have to enter again");
                    }
                }
            }while(contorde==1);
        } 
    }

    void add()
    {
        System.out.println("\f");
        char categ;
        int i;
        String dish;
        numd++;

        System.out.println("\f");
        System.out.println("Enter the specifications of the dish you want to add");
        System.out.println();

        while(true)
        {
            System.out.println("Enter \'V\' for Veg and \'N\' for NonVeg");
            categ=sc.next().charAt(0);
            if(categ=='V'||categ=='v')
            {
                f_categ[numd]="Veg   ";
                break;
            }
            else if(categ=='N'||categ=='n')
            {
                f_categ[numd]="NonVeg";
                break;
            }
            else
            {
                System.out.println("WRONG INPUT!");
            }
        }

        while(true)
        {
            try
            {
                System.out.println("Enter the quantity of the dish available");
                f_qty[numd]=sc.nextInt();
                break;
            }
            catch(Exception ob)
            {
                System.out.println("ENTER A NUMBER ONLY!");
                String db=sc.nextLine();
            }
        }

        while(true)
        {
            try
            {
                System.out.println("Enter the cost of the dish:");
                f_cost[numd]=sc.nextInt();
                break;
            }
            catch(Exception ob)
            {
                System.out.println("ENTER A NUMBER ONLY");
                String db=sc.nextLine();
            }
        }

        String db=sc.nextLine();
        System.out.println("Enter the name of the dish");
        dish=sc.nextLine();

        int t=dish.length();
        int dif=17-t;

        if(dif<=17)
        {
            for(i=1;i<dif;i++)
            {
                dish+=" ";

            }
        }
        f_name[numd]=dish;

        System.out.println("The ID of the new dish is:"+(numd+1));
        f_id[numd]=numd+1;
        dadd++;

    }

    void delete()
    {
        int id;

        menu();
        System.out.println();
        while(true)
        {
            while(true)
            {
                try
                {
                    System.out.println("\f");
                    System.out.println("Enter the ID of the dish you want to remove:");
                    id=sc.nextInt();
                    break;
                }
                catch(Exception ob)
                {
                    System.out.println("ENTER A NUMBER ONLY!!");
                    String db=sc.nextLine();
                }
            }
            if(id>numd+1)
            {
                System.out.println("INVALID DISH ID!");
            }
            else
            {
                f_remove[id-1]='y';
                drem++;
                System.out.println("Dish is deleted!");
                break;
            }
        }

    }

    void modify()
    {
        int ch,id,ncost,nqty;char selec;

        while(true)
        {
            System.out.println("\f");
            System.out.println("What do you want to modify?");
            System.out.println("1.COST");
            System.out.println("2.QUANTITY");

            while(true)
            {

                try
                {
                    System.out.println("Enter your choice");
                    ch=sc.nextInt();
                    break;
                }
                catch(Exception ob)
                {
                    System.out.println("ENTER A NUMBER ONLY!");
                    String db=sc.nextLine();
                }

            }

            switch(ch)
            {
                case 1:
                {
                    menu();

                    while(true)
                    {

                        while(true)
                        {
                            try
                            {
                                System.out.println("Enter the ID of the dish whose cost you want to change:");
                                id=sc.nextInt();
                                break;
                            }
                            catch(Exception ob)
                            {
                                System.out.println("ENTER A NUMBER ONLY!!");
                                String db=sc.nextLine();
                            }

                        }

                        if(id>numd+1)
                        {
                            System.out.println("INVALID ID!");
                        }

                        else
                        {
                            System.out.println("Enter the new cost of the dish:");
                            nqty=sc.nextInt();
                            System.out.println("Are you sure you want to change the cost?");
                            System.out.println("Enter \'Y\' for YES and \'N\' for NO");
                            selec=sc.next().charAt(0);
                            if(selec=='Y'||selec=='y')
                            {
                                f_cost[id]=nqty;
                                cm++;
                                System.out.println("Your quantity has been changed");
                                break;
                            }
                            else if(selec=='N'||selec=='n')
                            {
                                System.out.println("Your quantity has not been changed");
                                break;
                            }
                            else
                            {
                                System.out.println("Wrong Input");
                            }

                        }

                    }
                }

                break;
                case 2:
                {
                    menu();
                    while(true)
                    {

                        while(true)
                        {

                            try
                            {
                                System.out.println("Enter the ID of the dish whose quantity you want to change:");
                                id=sc.nextInt();
                                break;
                            }
                            catch(Exception ob)
                            {
                                System.out.println("ENTER A NUMBER ONLY!!");
                                String db=sc.nextLine();
                            }

                        }

                        if(id>numd+1)
                        {
                            System.out.println("INVALID ID!");
                        }
                        else
                        {
                            System.out.println("Enter the new quantity of the dish:");
                            nqty=sc.nextInt();
                            System.out.println("Are you sure you want to change the quantity?");
                            System.out.println("Enter \'Y\' for YES and \'N\' for NO");
                            selec=sc.next().charAt(0);
                            if(selec=='Y'||selec=='y')
                            {
                                f_cost[id]=nqty;
                                qc++;
                                System.out.println("Your quantity has been changed");
                                break;
                            }
                            else if(selec=='N'||selec=='n')
                            {
                                System.out.println("Your quantity has not been changed");
                                break;
                            }
                            else
                            {
                                System.out.println("Wrong Input");
                            }

                        }

                    }
                }
                break;

                default:
                {
                    System.out.println("WRONG CHOICE!");
                    System.out.println("Please enter again");

                }
            }
            break;
        }
    }

    void report()
    {
        System.out.println("\f");
        System.out.println("Number of customers who visited today is: "+numc);
        System.out.println("\nTotal amount of sales today: "+tsales);
        System.out.println("Total amount of sales today from veg dishes: "+tvs);
        System.out.println("Total amount of sales today from non veg dishes: "+tnvs);
        System.out.println("\nTotal number of NonVeg dishes ordered: "+nvd);
        System.out.println("Total number of veg dishes ordered: "+vd);
        System.out.println("\nTotal number of dishes added today: "+dadd);
        System.out.println("Total number of prices modified today: "+cm);
        System.out.println("Total number of quantities of dishes changed today: "+qc);
        System.out.println("Total number of dishes removed today: "+drem);
    }

    void bill()
    { 
        int cid=0,i,cuno=0;

        char cho;

        int billconti=0;
        int billout=0;

        System.out.println("\f");
        boolean flagid = false;
        int sum = 0;

        System.out.println("\f");
        System.out.println("Bill Printing");

        while(true)
        {
            while(true)
            {
                try{
                    System.out.println("\nEnter the customer number");                
                    cid = sc.nextInt();
                    break;
                }
                catch(Exception ob)
                {
                    System.out.println("ENTER A NUMBER ONLY!");
                }
            }

            System.out.println();
            for(i=0;i<7;i++)
            {
                if(c_id[i] == cid)
                {
                    flagid = true;
                    cuno=i;
                    break;
                }
            }
            if(flagid==true)
            {
                System.out.println("\f");
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Customer ID : "+cid);
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Customer NAME : "+c_name[cuno]);
                System.out.println("Customer Mobile No. :"+c_mob[cuno]);

                System.out.println();

                System.out.println("Product Id\t Cat. \t\tProduct Name \t\tQty \t Cost");
                System.out.println("------------------------------------------------------------------------");

                for(i=0;i<c_id.length;i++)
                {
                    if(cid==c_id[i])
                    {
                        System.out.println(c_m_id[i]+"\t\t"+c_m_categ[i]+"\t\t\t"+c_m_name[i]+"\t\t"+" "+
                            c_m_qty[i]+"\t"+c_m_amt[i]);

                        sum = sum + c_m_amt[i];
                    }
                }
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\n\n\t\tTotal Bill Amount ---> "+sum);
                System.out.println("-------------------------------------------------------------------");

                break;
            } 

            else
            {
                System.out.println("CustomerID not found!");

                System.out.println("Do you want to continue?");

                while(true)
                {
                    System.out.println("Please enter your option:");
                    cho=sc.next().charAt(0);

                    if(cho=='Y'||cho=='y')
                    {
                        break;
                    }
                    else if(cho=='N'||cho=='n')
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Wrong Choice");
                        System.out.println("You have to enter again");
                    }

                }

            }
        }

    }
}

package atmInterface;
import java.util.*;
class bankaccount{
    private static Scanner sc;
	static  void register(){
        sc = new Scanner(System.in);
        System.out.println("please Enter your name :");
        ATM.name=sc.nextLine();
        System.out.println("please Enter your  username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        ATM.accnumber=sc.nextLine();
        System.out.println("REGISTRATION IS SUCCESSFULLY DONE !");
        System.out.println("THANK TOU TO VISITING MAHA BANK ");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Bad value! Enter again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transaction{
    private static Scanner sc;
	private static Scanner sc2;
	private static Scanner sc3;
    static void deposit(){
        sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter the amount you want to deposit :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"");
        System.out.println("your amount is successfully deposited");
        System.out.println("");
        ATM.prompt();
    }
    static void withdraw(){
        sc3 = new Scanner(System.in);
        System.out.println("");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc3.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
        }
        ATM.prompt();
    }
    static void transfer(){
        sc2 = new Scanner(System.in);
        System.out.println("Enter the name of receiver:");
        sc2.nextLine();
        System.out.println("Enter the account number of receiver:");
        sc2.nextInt();
        System.out.println("Enter the amount you want to transferred :");
        int tcash=sc2.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"");
            System.out.println("Your Amount is Successfully Transferred");
            System.out.println("");
        }
        else{
            System.out.println("Your balance is low  to transfer the cash");
            System.out.println("");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println("The available balance in the bank account :");
        ATM.showbalance();
        System.out.println("");
        ATM.prompt();
    }
}
class his{
    static void transactionhistory(){
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATM.prompt();
    }
}
public class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();
	private static Scanner sc;
	private static Scanner sc2;

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[2J");
        sc2 = new Scanner(System.in);
        System.out.println("----WELCOME TO MAHA BANK ATM----");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice =sc2.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("INVALID CHOICE  :");
                homepage();
            }
        }
    }
    static void prompt(){
        sc = new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. DEPOSITE");
        System.out.println("2. WITHDRAW");
        System.out.println("3. TRANSFER");
        System.out.println("4. CHECK BALANCE");
        System.out.println("5. TRANSACTION HISTORY");
        System.out.println("6. EXIT");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.deposit();
            case 2:
            	transaction.withdraw();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}
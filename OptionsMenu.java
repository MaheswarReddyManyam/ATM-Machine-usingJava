package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionsMenu extends Accounts {
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat  = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();
    int y;
    public void getLogin() throws IOException{
        int x=1;
        do{
            try{
                data.put(9876543,9876);
                data.put(8989898,1890);
                System.out.println("Welcome to ATM project!");
                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(sc.nextInt());
                System.out.print("Enter Your Pin Number: ");
                setPinNumber(sc.nextInt());
            } catch (Exception e){
                System.out.println("\n"+ "Invalid character(s). Only numbers."+"\n");
                x=2;
            }
            for(Map.Entry<Integer,Integer> entry: data.entrySet()){
                if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n"+ "Wrong Customer Number or Pin Number."+"\n");
        }while (x==1);
    }
    public void getAccountType(){
        System.out.println("Select the Account You want to access: ");
        System.out.println("Type-1 - Checking Account");
        System.out.println("Type-2 - Saving Account");
        System.out.println("Type-3 - Exit");
        System.out.print("Choice: ");
        y = sc.nextInt();
        switch (y){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Collect your card" +'\n'+"Thank you for using this ATM, Have a good day!");
                break;
            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getAccountType();
        }
    }


    private void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type-1 - View Balance");
        System.out.println("Type-2 - Withdraw Funds");
        System.out.println("Type-3 - Deposit Funds");
        System.out.println("Type-4 - Exit");
        System.out.print("Choice: ");
        y = sc.nextInt();
        switch (y){
            case 1:
                System.out.println("Checking Account Balance: "+moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Collect your card" +'\n'+"Thank you for using this ATM, Have a good day!");
                break;
            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getChecking();
        }
    }
    private void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type-1 - View Balance");
        System.out.println("Type-2 - Withdraw Funds");
        System.out.println("Type-3 - Deposit Funds");
        System.out.println("Type-4 - Exit");
        System.out.print("Choice: ");
        y = sc.nextInt();
        switch (y){
            case 1:
                System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Collect your card" +'\n'+"Thank you for using this ATM, Have a good day!");
                break;
            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getSaving();
        }
    }

}

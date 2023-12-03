package com.company;

import java.util.*;

//Adham Ayman Farouk Ibrahim                  21100782
//Pin Code: 0000
/* Vending Machine Displays 9 Default Products That Can Be Changed
The Vending Machine Has 10 Of Each Product Can Be Restocked From Maintenance
The Vending Machine Has A limited amount of Change That can Also be restored
from Maintenance Option.
Maintenance Option Can Also View Sales of Each Product and Can Change Product Names And Prices
 */
public class VendingMachine {

    static Scanner sc = new Scanner(System.in);


    public static void Line() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-_");
        }
        System.out.println();

    }

    public static void DefaultMenu(String[] Menu) {
        Menu[0] = "Water";
        Menu[1] = "Coke";
        Menu[2] = "Diet Coke";
        Menu[3] = "Iced Tea";
        Menu[4] = "Swiss Chocolate";
        Menu[5] = "Candy";
        Menu[6] = "Chips";
        Menu[7] = "Bubble Gum";
        Menu[8] = "Turkish Delight";
    }

    public static void DefaultMenuPrices(double[] MenuPrices) {
        MenuPrices[0] = 0.75;
        MenuPrices[1] = 1.20;
        MenuPrices[2] = 1.20;
        MenuPrices[3] = 1.00;
        MenuPrices[4] = 1.50;
        MenuPrices[5] = 0.95;
        MenuPrices[6] = 1.10;
        MenuPrices[7] = 0.50;
        MenuPrices[8] = 1.20;
    }

    public static void DefaultMenuStock(double[] MenuStock) {
        MenuStock[0] = 10;
        MenuStock[1] = 10;
        MenuStock[2] = 10;
        MenuStock[3] = 10;
        MenuStock[4] = 10;
        MenuStock[5] = 10;
        MenuStock[6] = 10;
        MenuStock[7] = 10;
        MenuStock[8] = 10;
    }

    public static void DefaultChangeStock(int[] Change) {
        Change[0] = 50;
        Change[1] = 100;
        Change[2] = 400;
        Change[3] = 800;
        Change[4] = 1600;
        Change[5] = 5000;

    }


    public static int ShowMenu(boolean DisplayDefault, double[] MenuPrices, String[] Menu, double[] MenuStock, int[] Change) {
        Line();
        if (DisplayDefault) {
            DefaultMenu(Menu);
            DefaultMenuPrices(MenuPrices);
            DefaultMenuStock(MenuStock);
        }
        for (int i = 0; i < 9; i++) {
            System.out.println((i + 1) + "." + Menu[i] + "\t\t\t " + MenuPrices[i] + " EGP");
        }
        System.out.println("10. End of Transaction");
        Line();
        return MakeSelection(MenuPrices, MenuStock, Change, Menu);
    }

    public static int MakeSelection(double[] MenuPrices, double[] MenuStock, int[] Change, String[] Menu) {
        System.out.print("Enter Selection : ");
        int Selection = sc.nextInt();
        Line();
        if (Selection == 10) {
            return 0;
        } else if (((Selection <= 10 && Selection >= 0) && (MenuStock[Selection - 1] > 0)) || Selection == 99) {
            if (Selection == 99) Maintenance(MenuPrices, MenuStock, Change, Menu);
            else {
                MenuStock[Selection - 1] = MenuStock[Selection - 1] - 1;
                System.out.print("Item Price : " + MenuPrices[Selection - 1] + "\nEnter Money : ");
                double MoneyEntered = sc.nextDouble();
                Line();
                if (MoneyEntered == MenuPrices[Selection - 1]) {
                    System.out.println("Done");
                    Line();
                } else if (MoneyEntered > MenuPrices[Selection - 1]) {
                    int AmountToReturn = (int) ((MoneyEntered - MenuPrices[Selection - 1]) * 100);
                    ReturnChange(AmountToReturn, Change);
                } else if (MoneyEntered < MenuPrices[Selection - 1]) {
                    double Price = MenuPrices[Selection - 1];
                    DisplayErrorMessage(1);
                    Line();
                    double MoneyEntered2 = NotEnoughMoney(MoneyEntered, Price);
                    if (MoneyEntered2 == Price) {
                        System.out.println("Done");
                        Line();
                    } else {
                        int AmountToReturn = (int) ((MoneyEntered2 - MenuPrices[Selection - 1]) * 100);
                        ReturnChange(AmountToReturn, Change);
                    }
                }
                return ShowMenu(false, MenuPrices, Menu, MenuStock, Change);
            }
        } else {
            DisplayErrorMessage(2);
            return MakeSelection(MenuPrices, MenuStock, Change, Menu);
        }
        return 0;
    }

    public static void DisplayErrorMessage(int ErrorCode) {
        if (ErrorCode == 0) System.out.println("Not Enough Change In Vending Machine");
        if (ErrorCode == 1) System.out.println("Not Enough Money");
        if (ErrorCode == 2) System.out.println("Item Selected Isn't Available\t\t\t\tTry Again");
    }

    public static double NotEnoughMoney(double MoneyEntered, double Price) {
        if (MoneyEntered >= Price)
            return MoneyEntered;
        else {
            System.out.print("Enter Money : ");
            double EnterMoney = sc.nextInt();
            double Sum = MoneyEntered + EnterMoney;
            return NotEnoughMoney(Sum, Price);

        }
    }

    public static double Maintenance(double[] MenuPrices, double[] MenuStock, int[] Change, String[] Menu) {
        System.out.println("Enter Pin Code: ");
        String PinCode = sc.next();
        if (PinCode.equals("0000")) {
            Line();
            System.out.println("1: Restock Product      2: Refill Coins       3: Change Products    4: Display Sales");
            Line();
            int MainChoice = sc.nextInt();
            Line();
            switch (MainChoice) {
                case 1:
                    DefaultMenuStock(MenuStock);
                    break;
                case 2:
                    DefaultChangeStock(Change);
                    break;
                case 3:
                    ChangeProducts(MenuPrices, MenuStock, Change, Menu);
                    break;
                case 4:
                    for (int i = 0; i < 9; i++) {
                        System.out.println((i + 1) + "." + Menu[i] + "\t\t\tNumber Sold :  " + (10 - MenuStock[i]) + " Sold");
                    }
                    break;
            }

        }
        return ShowMenu(false, MenuPrices, Menu, MenuStock, Change);
    }

    public static int ChangeProducts(double[] MenuPrices, double[] MenuStock, int[] Change, String[] Menu) {
        for (int i = 0; i < 9; i++) {
            System.out.println((i + 1) + "." + Menu[i] + "\t\t\t " + MenuPrices[i] + " EGP");
        }
        Line();
        System.out.println("Choose Number Of Product");
        Line();
        int NumberOfProduct = sc.nextInt();
        Line();
        System.out.print("Enter Product Name : ");
        Menu[NumberOfProduct - 1] = sc.next();
        System.out.print("Enter Product Price : ");
        MenuPrices[NumberOfProduct - 1] = sc.nextDouble();
        MenuStock[NumberOfProduct - 1] = 10;
        return ShowMenu(false, MenuPrices, Menu, MenuStock, Change);
    }


    //Dime 0.10         Nickel 0.05      Pennie 0.01
    public static void ReturnChange(int MoneyToReturn, int[] Change) {
        int Dollar = 0, FiftyCent = 0, TwentyCents = 0, dimes = 0, nickles = 0, pennies = 0;
        double Div = MoneyToReturn;
        double TotalChange = Div / 100;
        if (Change[0] > 0) {
            Dollar = MoneyToReturn / 100;
            MoneyToReturn = MoneyToReturn % 100;
            Change[0] -= Dollar;
        }
        if (Change[1] > 0) {
            FiftyCent = MoneyToReturn / 50;
            MoneyToReturn = MoneyToReturn % 50;
            Change[1] -= FiftyCent;
        }
        if (Change[2] > 0) {
            TwentyCents = MoneyToReturn / 20;
            MoneyToReturn = MoneyToReturn % 20;
            Change[2] -= TwentyCents;
        }
        if (Change[3] > 0) {
            dimes = MoneyToReturn / 10;
            MoneyToReturn = MoneyToReturn % 10;
            Change[3] -= dimes;
        }
        if (Change[4] > 0) {
            nickles = MoneyToReturn / 5;
            MoneyToReturn = MoneyToReturn % 5;
            Change[4] -= nickles;
        }
        if (Change[5] > 0) {
            pennies = MoneyToReturn;
            Change[5] -= pennies;
        }
        if (Change[0] <= 0 && Change[1] <= 0 && Change[2] <= 0 && Change[3] <= 0 && Change[4] <= 0 && Change[5] <= 0)
            DisplayErrorMessage(0);
        System.out.println("Total Change : " + TotalChange);
        System.out.println(Dollar + " : Dollars");
        System.out.println(FiftyCent + " : FiftyCent");
        System.out.println(TwentyCents + " : TwentyCents");
        System.out.println(dimes + " : dimes");
        System.out.println(nickles + " : nickles");
        System.out.println(pennies + " : pennies");


    }


    public static void main(String[] args) {
        boolean DisplayDefault = true;
        String[] Menu = new String[9];
        double[] MenuPrices = new double[9];
        double[] MenuStock = new double[9];
        int[] Change = {50, 100, 400, 800, 1600, 5000};
        while (ShowMenu(DisplayDefault, MenuPrices, Menu, MenuStock, Change) != 0) {
            ShowMenu(DisplayDefault, MenuPrices, Menu, MenuStock, Change);
           // DisplayDefault = false;
        }
    }
}

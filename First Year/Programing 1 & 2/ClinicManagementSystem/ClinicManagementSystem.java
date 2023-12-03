package com.company;

import java.util.*;

//Adham Ayman Farouk Ibrahim          21100782
//Ahmed Mohamed Mahdi                 21100822
//Mohamed ahmed salah                 21100806
//Mohamed Ahmed Mohamed Reda          21100914
/* Clinic Management System
But Times For Doctors Before Using Patent
Doctors can be Edited Removed Or Added
PatentLog Shows All Patent and there reservation time
Doctor Can add Reservation Times or edit them
In Doctor Names are displayed from n*10 to (n+1)*10
ex n=2        20 to 30
In Doctor Choose -1 Before Entering Doctor ID
Calendar Contains Months,Week,Day and Reservation For Each Day Every Doctor Has his Own Version Of calendar
Any Speciality can be Added
Patent Needs to Write Speciality of Doctor Needed
All Doctors in Chosen specialties will be displayed and patent can choose a Doctor by entering Number Next to Doctor Name
 */
public class ClinicManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static String[][] Docs = new String[1000][6];
    static String[][][][][] Calender = new String[11][8][5][13][1000];
    static String[][] DocWhenCalled = new String[1000][5];
    static String[][] PatentLog = new String[1000][6];
    static int Patents = 1;
    static Boolean DocOrPat;
    static Boolean Stop = false;
    static int MonthCounter = 1;

    static {
        Empty();
        SetNoReservation();
        IDInitialize();
        AddDoc1();
        AddDoc2();
        AddDoc3();
        AddDoc4();
        Month();
        Month2();
        Week();
        Day();
    }

    public static void Empty() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= 999; j++) {
                Docs[j][i] = "Empty";
            }
        }
    }

    public static void SetNoReservation() {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int z = 1; z <= 7; z++) {
                    for (int y = 1; y <= 10; y++) {
                        for (int k = 1; k <= 999; k++) {
                            Calender[y][z][j][i][k] = "No Reservations";
                        }
                    }
                }
            }
        }
    }

    public static void Month() {
        for (int i = 1; i <= 999; i++) {
            Calender[0][0][0][1][i] = "January";
            Calender[0][0][0][2][i] = "February";
            Calender[0][0][0][3][i] = "March";
            Calender[0][0][0][4][i] = "April";
            Calender[0][0][0][5][i] = "May";
            Calender[0][0][0][6][i] = "June";
        }
    }

    public static void Month2() {
        for (int i = 1; i <= 999; i++) {
            Calender[0][0][0][7][i] = "July";
            Calender[0][0][0][8][i] = "August";
            Calender[0][0][0][9][i] = "September";
            Calender[0][0][0][10][i] = "October";
            Calender[0][0][0][11][i] = "November";
            Calender[0][0][0][12][i] = "December";
        }
    }

    public static void Week() {

        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 999; j++) {
                Calender[0][0][1][i][j] = "Week 1";
                Calender[0][0][2][i][j] = "Week 2";
                Calender[0][0][3][i][j] = "Week 3";
                Calender[0][0][4][i][j] = "Week 4";
            }
        }
    }

    public static void Day() {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 999; k++) {
                    Calender[0][1][j][i][k] = "Sunday";
                    Calender[0][2][j][i][k] = "Monday";
                    Calender[0][3][j][i][k] = "Tuesday";
                    Calender[0][4][j][i][k] = "Wednesday";
                    Calender[0][5][j][i][k] = "Thursday";
                    Calender[0][6][j][i][k] = "Friday";
                    Calender[0][7][j][i][k] = "Saturday";
                }
            }
        }
    }

    public static void PrintReservation(int day, int week, int month, int id) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " : " + Calender[i][day][week][month][id]);
        }
    }


    public static void ScheduleForDoc(int id, Boolean DocOrPat) {
        System.out.println("Current Month : " + Calender[0][0][0][MonthCounter][id]);
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + " : " + Calender[0][0][i][MonthCounter][id]);
        }
        int week = sc.nextInt();
        if (week <= 0) {
            System.out.println("Try Again");
        } else {
            for (int i = 1; i <= 7; i++) {
                System.out.println(i + " : " + Calender[0][i][week][MonthCounter][id]);
            }
            int day = sc.nextInt();
            if (day <= 0) {
                System.out.println("Try Again");
            } else {
                int res;
                while (true) {
                    PrintReservation(day, week, MonthCounter, id);
                    System.out.println("0:Exit");
                    res = sc.nextInt();
                    if (res == 0) break;
                    if (DocOrPat) EditReserves(res, day, week, MonthCounter, id);
                    else {
                        BookAppointment(res, day, week, MonthCounter, id);
                        break;
                    }
                }
            }
        }
    }


    public static void EditReserves(int res, int day, int week, int month, int id) {
        System.out.print("Enter Available times : ");
        String Time1 = sc.next();
        System.out.println("To : ");
        String Time2 = sc.next();
        Calender[res][day][week][month][id] = Time1 + " to " + Time2;

    }

    public static void BookAppointment(int res, int day, int week, int month, int id) {
        if (Calender[res][day][week][month][id].equals("Reserved") || Calender[res][day][week][month][id].equals("No Reservations")) {
            System.out.println("There Is No Reservation Or Already Reserved  Please Choose Another Time");
        } else {
            PatentLog[Patents - 1][5] = Calender[res][day][week][month][id];
            Calender[res][day][week][month][id] = "Reserved";
        }

    }

    public static void Line() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-_");
        }
        System.out.println();

    }


    public static void AddDoc1() {
        Docs[1][0] = "Adham";
        Docs[1][1] = "18";
        Docs[1][2] = "Male";
        Docs[1][3] = "Dentist";
        Docs[1][5] = String.valueOf(1);
    }

    public static void AddDoc2() {
        Docs[2][0] = "Mahdi";
        Docs[2][1] = "18";
        Docs[2][2] = "Male";
        Docs[2][3] = "ophthalmologist";
    }

    public static void AddDoc3() {
        Docs[3][0] = "Reda";
        Docs[3][1] = "18";
        Docs[3][2] = "Male";
        Docs[3][3] = "otolaryngologist";
    }

    public static void AddDoc4() {
        Docs[4][0] = "Salah";
        Docs[4][1] = "18";
        Docs[4][2] = "Male";
        Docs[4][3] = "Cardiologist";
    }

    public static void IDInitialize() {
        for (int i = 1; i < 1000; i++) {
            Docs[i][4] = String.valueOf(i);
        }
    }

    public static void Menu(String Name) {
        Line();
        System.out.println(("\n Welcome to " + Name + " Clinic").indent(45) + "\t\t\t\tChoose an Option\n1:Patent   2:Doctor    3:Admin    4:Exit\n\n0:Next Month ".indent(35));
        Line();
        System.out.print("Enter Choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 0 -> MonthCounter++;
            case 1 -> DoctorDisplay();
            case 2 -> Doc();
            case 3 -> Admin();
            case 4 -> Stop = true;

        }

    }

    public static void PrintDoc(int id) {
        System.out.println("|Name|\t\t\t|Age|\t\t\t|Sex|\t\t\t|Speciality|\t|ID|");
        for (int i = 0; i <= 4; i++) {
            System.out.print("|");
            System.out.print(Docs[id][i]);
            System.out.print("|\t\t\t");
        }
    }


    public static void PrintDocName0to1000() {
        int x;
        while (true) {
            x = sc.nextInt();
            int NewCons = (x * 10);
            if (x == -1) break;
            else if (x >= 99 || x < 0) System.out.println("Choose Column from 1-98  Or  -1:To Choose Doctor");
            else {
                for (int i = 1; i <= 10; i++) {
                    NewCons++;
                    System.out.println(NewCons + " : Dr " + Docs[NewCons][0] + "   " + Docs[NewCons][3]);

                }
            }

        }
    }


    public static void Doc() {
        DocOrPat = true;
        System.out.println("Choose Column from 1-98  Or  -1:To Choose Doctor");
        PrintDocName0to1000();
        int id = sc.nextInt();
        if (id <= 0) {
            System.out.println("Choose from 1 to 1000");
            Doc();
        } else ScheduleForDoc(id, DocOrPat);


    }

    public static void PrintChoose0to1000() {
        Line();
        System.out.print("\sChoose Doctor id From 0-1000".indent(35));
        Line();
    }

    public static void Admin() {
        Line();
        System.out.println("1 : Edit / Add Doctors\t\t\t2 : Remove Doctors\t\t\t3 : View Patent Log");
        int X = sc.nextInt();
        switch (X) {
            case 1 -> AdminCase1();
            case 2 -> AdminCase2();
            case 3 -> AdminCase3();


        }
    }

    public static void AdminCase1() {
        PrintChoose0to1000();
        int id = sc.nextInt();
        Line();
        EditOrAdd(id);
    }

    public static void AdminCase2() {
        PrintChoose0to1000();
        int id = sc.nextInt();
        Line();
        RemoveDoc(id);
        IDInitialize();
    }

    public static void AdminCase3() {
        int x;
        while (true) {
            System.out.println("Choose Column from 0-98  Or  -1:Exit");
            x = sc.nextInt();
            int NewCons = (x * 10);
            if (x == -1) break;
            else if (x >= 99 || x < 0) System.out.println("Choose Column from 0-98  Or  -1:Exit");
            else {
                AdminCase301(NewCons);
            }

        }
    }

    public static void AdminCase301(int NewCons) {
        for (int i = 1; i <= 10; i++) {
            NewCons++;
            System.out.print(NewCons + " : ");
            for (int j = 0; j <= 5; j++) {
                System.out.print("|");
                System.out.print(PatentLog[NewCons][j]);
                System.out.print("|\t\t\t");
            }
            System.out.println();
        }

    }

    public static void RemoveDoc(int id) {
        for (int i = 0; i < 5; i++) {
            Docs[id][i] = "null";
        }
    }

    public static void EditOrAdd(int x) {
        while (true) {
            PrintDoc(x);
            System.out.println("\n0 : Exit\t\t1 : Edit Name\t\t2 : Edit Age\t\t3 : Edit Sex\t\t4 : Edit Speciality");
            Line();
            int edit = sc.nextInt();
            switch (edit) {
                case 0:
                    break;
                case 1:
                    EditName(x);
                    continue;
                case 2:
                    EditAge(x);
                    continue;
                case 3:
                    EditSex(x);
                    continue;
                case 4:
                    EditSpec(x);
                    continue;
            }
            break;

        }

    }

    public static void AddPatent(int id) {
        System.out.print("Enter Name : ");
        String Name = sc.next();
        System.out.print("Enter Age : ");
        String Age = sc.next();
        System.out.print("Enter Sex : ");
        String Sex = sc.next();
        System.out.print("Enter PhoneNumber : ");
        String PhoneNumber = sc.next();
        AddPatentDetails(Name, Age, Sex, PhoneNumber, id);
    }

    public static void AddPatentDetails(String Name, String Age, String Sex, String PhoneNumber, int id) {
        PatentLog[Patents][0] = Name;
        PatentLog[Patents][1] = Age;
        PatentLog[Patents][2] = Sex;
        PatentLog[Patents][3] = PhoneNumber;
        PatentLog[Patents][4] = DocWhenCalled[id - 1][0];
        Patents++;
    }

    public static void DoctorDisplay() {
        int DocCounter = 0;
        int Choice = 0;
        DocOrPat = false;
        System.out.print("Enter Speciality : ");
        String Speciality = sc.next();
        for (int i = 1; i <= 999; i++) {
            if (Speciality.equalsIgnoreCase(Docs[i][3])) {
                System.arraycopy(Docs[i], 0, DocWhenCalled[DocCounter], 0, 5);
                System.out.println(DocCounter + 1 + " : Dr." + DocWhenCalled[DocCounter][0]);
                DocCounter++;

            }
        }
        if (DocCounter == 0) System.out.println("There are no Doctors Available in Speciality Chosen");
        else {
            while (Choice == 0) {
                System.out.println("Choose Doctor");
                Choice = sc.nextInt();
            }
            if (Choice > DocCounter) System.out.println("Try Again");
            else {
                AddPatent(Choice);
                ScheduleForDoc(Integer.parseInt(DocWhenCalled[Choice - 1][4]), DocOrPat);

            }
        }

    }


    public static void EditName(int id) {
        System.out.println("Enter Name : ");
        String Name = sc.next();
        Docs[id][0] = Name;
    }

    public static void EditAge(int id) {
        System.out.println("Enter Age : ");
        String Age = sc.next();
        Docs[id][1] = Age;
    }

    public static void EditSex(int id) {
        System.out.println("Enter Sex : ");
        String Sex = sc.next();
        Docs[id][2] = Sex;
    }

    public static void EditSpec(int id) {
        System.out.println("Enter Speciality : ");
        String Speciality = sc.next();
        Docs[id][3] = Speciality;
    }


    public static void main(String[] args) {
        System.out.print("Enter Clinic Name : ");
        String ClinicName = sc.next();
        while (!Stop) {
            Menu(ClinicName);
        }


    }
}

